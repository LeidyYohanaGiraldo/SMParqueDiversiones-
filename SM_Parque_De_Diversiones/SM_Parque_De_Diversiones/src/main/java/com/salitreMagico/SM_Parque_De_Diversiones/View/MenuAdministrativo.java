package com.salitreMagico.SM_Parque_De_Diversiones.View;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Estacion;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IEstacionService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IHistoricoAtraccionService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class MenuAdministrativo {
    /*@Autowired Inyecta las dependencias de la interfaz del servicio y por medio de poliformismo
      realiza el llamado de los metodos correspondientes con su respectiva logica*/
    @Autowired
    private IEstacionService iEstacionService;

    @Autowired
    private IVentaService iVentaService;

    @Autowired
    private IHistoricoAtraccionService iHistoricoAtraccionService;

    @Autowired
    private GestionSistema gestionSistema;

    Scanner scanner = new Scanner(System.in);
    //Vista principal despues de validar el rol administrativo
    public void vistaAdministrativo(){
        boolean bandera = true;
        while(bandera) {

            System.out.println("Ingreso Exitoso Modulo Administrativo\n" +
                    "****************************\n" +
                    "Ingrese la opcion a realizar\n" +
                    "****************************\n" +
                    "1. Habilitar/Desabilitar Estacion\n" +
                    "2. Consultar Total Clientes en el parque\n" +
                    "3. Consultar Atracciones Mas Usadas\n" +
                    "4. Gestionar Sistema\n" +
                    "5. Salir Sistema");
            int opcion = scanner.nextInt();

            /*valido las opciones segun sea la necesidad del cliente*/
            switch (opcion) {
                case 1:
                    bandera = false;
                    GestionarEstacion();
                    break;
                case 2:
                    consultarTotalClientes();
                    break;
                case 3:
                    bandera = false;
                    consultarAtraccionesMAsUsadas();
                    break;
                case 4:
                    bandera = false;
                    GestionarEmpleadosOClientes();

                    break;
                case 5:
                    bandera = false;
                    System.out.println("Hasta Pronto");
                    ;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
/*    este metodo sera el encargado de crear nuevos clientes o empleados segun lo necesario*/
    private void GestionarEmpleadosOClientes() {
        gestionSistema.vistaPrincipal();
    }

    /* el metodo me permite ver el numero de uso de las atracciones, para esto se envia una fecha inicial digitada
     por el cliente y una fecha final, desde alli se envian los datos*/
    private void consultarAtraccionesMAsUsadas() {
        System.out.println("" +
                "Ingrese las fechas en las cuales desea consultar " +
                "las atracciones mas usadas, las fechas se debe ingresar\n en sel " +
                "siguiente formato DD/MM/AAAA ejemplo 01/01/2024\n" +
                "Ingrese la Fecha Inicial");

                String fechaInicialTexto = scanner.next();

                System.out.println("\nIngrese la Fecha Final");
                String fechaFinalTexto = scanner.next();

                //realizo formateo de fecha para el tipo de dato DateTimeFormatter
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaInicial = LocalDate.parse(fechaInicialTexto, formatter);
                LocalDate fechaFinal = LocalDate.parse(fechaFinalTexto, formatter);

                /*realizo la peticion al servicio de la consulta, me trae los datos de las atracciones mas usadas
                en orden descendente hasta la menos usada*/
                List<Map<String, Object>> listaDatos = iHistoricoAtraccionService.consultarAtraccionesMasUsadas(fechaInicial, fechaFinal);

                //si la lista es diferente a vacia mostrara la informacion
                if(!listaDatos.isEmpty()){
                    System.out.println("Las Atracciones mas usadas en las fechas proporcionadas son:\n");
                    for (Map<String, Object> datos:listaDatos) {
                        System.out.println(datos.get("nombre") + " con " + datos.get("cuenta") +
                                " Visitas");
                    }

                }else{
                    System.out.println("No Existen Datos para las fechas ingresadas");
                }
    }

    //este metodo valida la cantidad de clientes en el parque, se envia la fecha actual para consultar en la
    //tabla y traer solo registros del dia
    private void consultarTotalClientes() {
        //llamado al servicio apra la consulta
        int totalClientes = iVentaService.consultarClientesTotales(LocalDate.now());
        if(totalClientes != 0) {
            System.out.println("El numero Total De Clientes en el parque actualmente es de " + totalClientes + "\n");
        }
        else{
            System.out.println("En el momento no tenemos clientes en el parque\n");
        }
    }

    //metodo encargado de habilitar y desabilitar las estaciones
    private void GestionarEstacion() {
        boolean bandera = true;
        while (bandera) {
            System.out.println("ingresa la opcion a realiza\n" +
                    "1. Habilitar Estacion\n" +
                    "2. Desabilitar estacion");

            int opcion = scanner.nextInt();

            Long idEstacion;

            /*segun la opcion seleccionada se realizara llamado al servicio para que gestione la modificacion del
                    estado de la estacion*/
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el id de la estacion a habilitar");
                     idEstacion = scanner.nextLong();
                    Estacion estacion = new Estacion();
                    estacion.setId(idEstacion);
                    estacion.setHabilitada(true);
                    iEstacionService.crearCliente(estacion);
                    System.out.println("El Estado De La estacion cambio con exito");
                    bandera = false;
                    break;
                case 2:
                    System.out.println("Ingrese el id de la estacion a desabilitar");
                    idEstacion = scanner.nextLong();
                    Estacion estacion2 = new Estacion();
                    estacion2.setId(idEstacion);
                    estacion2.setHabilitada(false);
                    iEstacionService.crearCliente(estacion2);
                    System.out.println("El Estado De La estacion cambio con exito");
                    bandera = false;

                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
