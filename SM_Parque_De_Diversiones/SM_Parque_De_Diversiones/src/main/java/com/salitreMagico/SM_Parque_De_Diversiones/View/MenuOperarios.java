package com.salitreMagico.SM_Parque_De_Diversiones.View;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Atraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.HistoricoAtraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IHistoricoAtraccionService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IPasaporteAtraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MenuOperarios {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private IPasaporteAtraccionService iPasaporteAtraccionService;

    @Autowired
    private IHistoricoAtraccionService iHistoricoAtraccionService;

    //Vista principal modulo operarios
    public void vistaOperarios() {
        boolean bandera = true;
        while (bandera) {
            // docEmpleado = documentoEmpleado;
            System.out.println("Ingreso Exitoso Modulo Operarios\n" +
                    "****************************\n" +
                    "Ingrese la opcion a realizar\n" +
                    "****************************\n" +
                    "1. Validacion pasaporte\n" +
                    "2. Salir Sistema");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    validarPasaporte();
                    break;
                case 2:
                    bandera = false;
                    System.out.println("Hasta Pronto");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }


    private void validarPasaporte() {

        System.out.println("Ingrese el Documento de Identidad\n" +
                "******************************\n");
        scanner.nextLine();
        String documentoCliente = scanner.nextLine();

        //por medio del documento valido el tipo de pasaporte y las atracciones en las que puede ingresar
        List<Map<String, Object>> listaDatos = iPasaporteAtraccionService.consultarPasaporte(documentoCliente,
                LocalDate.now());

        //si la lista es diferente a vacia es porque el usuario tiene pasaporte activo
        if (!listaDatos.isEmpty()) {
            //el operario ingresara el id de la atraccion para validar si el pasaporte la cubre
            System.out.println("Ingrese el id de la atraccion");
            int idAtraccion = scanner.nextInt();

            //realizo el filtrado de la lista por medio del id de la atraccion para que me traiga solo
            // el elemento con los datos de la atraccion que desea ingresar
            List<Map<String, Object>> elementosFiltrados = listaDatos.stream()
                    .filter(map -> idAtraccion == Integer.parseInt(String.valueOf(map.get("atraccion_id"))))
                    .collect(Collectors.toList());

            //si la lista filtrada no trae datos es prque el pasaporte no incluye la atraccion en la que va a ingresar
            if (!elementosFiltrados.isEmpty()) {

                //valido la estatura minima permitida de la atraccion, con la estatura del cliente, si no cumple
                // con la estatura, generara alerta al perario
                if (Double.parseDouble(String.valueOf(elementosFiltrados.get(0).get("estatura"))) <
                        Double.parseDouble(String.valueOf(elementosFiltrados.get(0)
                                .get("estatura_minima")))) {
                    System.out.println("No Cumple con la estatura minima requerida para ingresar a la atraccion");

                //valido que la atraccion no se encuentre desabilitada, si lo esta muestra mensaje de alerta al operario
                } else if (!Boolean.valueOf(String.valueOf(elementosFiltrados.get(0).get("habilitada")))) {
                    System.out.println("La atraccion la cual desea ingresar no se encuentra habilitada");

                    //si pasa las validaciones anteriores realiza insercion de datos en la tabla historicoAtraccion
                }else{
                    HistoricoAtraccion historicoAtraccion = new HistoricoAtraccion();
                    Atraccion atraccion = new Atraccion();
                    Cliente cliente = new Cliente();
                    atraccion.setId(Long.parseLong(String.valueOf(idAtraccion)));
                    cliente.setId(Long.parseLong(String.valueOf(elementosFiltrados.get(0).get("id"))));


                    historicoAtraccion.setAtraccion(atraccion);
                    historicoAtraccion.setCliente(cliente);
                    historicoAtraccion.setFechaIngreso(LocalDate.now());
                    iHistoricoAtraccionService.crearHistoricoAtraccion(historicoAtraccion);
                    System.out.println("Validacion Exitosa Puede hacer uso de la atraccion");
                }
            } else {
                System.out.println("El pasaporte no incluye la atraccion");
            }

        } else {
            System.out.println("El Usuario no tiene pasaportes Activos");

        }
    }


}

