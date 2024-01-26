package com.salitreMagico.SM_Parque_De_Diversiones.View;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.*;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IClienteService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IEmpleadoService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class MenuLogistica {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    private IClienteService iClienteService;

    @Autowired
    private IVentaService iVentaService;

    @Autowired
    private GestionSistema gestionSistema;

    @Autowired
    private IEmpleadoService iEmpleadoService;

    private String docEmpleado;

    private String DocumetonCliente;

    //vista principal del empleado de logistica
    public void vistaLogistica(String documentoEmpleado) {
        boolean bandera = true;
        while(bandera) {
            docEmpleado = documentoEmpleado;
            System.out.println("Ingreso Exitoso Modulo Logistica\n" +
                    "****************************\n" +
                    "Ingrese la opcion a realizar\n" +
                    "****************************\n" +
                    "1. Registrar Venta\n" +
                    "2. Salir Sistema");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    validarDocumentoCliente();
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

    //Metodo que valida si el cliente existe en el sistema, cuando no exista lo enviara a registarlo
    private void validarDocumentoCliente() {

            System.out.println("\n\nIngrese El documento de identidad del cliente");
            String documento = scanner.next();

            //consulto si el cliente existe por medio de su documento
            String consulta = iClienteService.consultarDocumento(documento);


            //si el cliente existe lo envia al metodo registrar la entrega del pasaporte
            if (consulta != null) {
                System.out.println("El cliente con numero de documento " + consulta + " Se encuentra registrado");
                DocumetonCliente = documento;
                registrarVenta();
                DocumetonCliente = documento;

                //si el cliente no existe lo envia a registrarlo y despues registrara la entrega del pasaporte
            } else {
                System.out.println("El cliente con numero de documento " + documento + " No Se encuentra registrado" +
                        " Por Favor LLenar los datos de registro");

                DocumetonCliente = gestionSistema.crearCliente();
                registrarVenta();
            }


    }

    //este metodo asigna al cliente el pasaporte y registra los datos en la tabla venta
    public void registrarVenta() {
        System.out.println("****************************\n" +
                "Registro De Venta \n\n" +
                "****************************\n" +
                "Seleccione el numero de pasaporte que desea asignar al cliente\n" +
                "1. ORO\n" +
                "2. PLATA\n" +
                "3.BRONCE\n");

        Long idPasaporte = scanner.nextLong();

        Venta venta = new Venta();


        Cliente datosCliente = iClienteService.findByNumeroDocumento(DocumetonCliente);
        Empleado datosEmpleado = iEmpleadoService.findByNumeroDocumento(docEmpleado);

        Pasaporte pasaporte = new Pasaporte();

        pasaporte.setId(idPasaporte);

        venta.setCliente(datosCliente);
        venta.setEmpleado(datosEmpleado);
        venta.setPasaporte(pasaporte);
        venta.setFecha(LocalDate.now());

        iVentaService.registrarVenta(venta);

        System.out.println("Asignación de Pasaporte Exitosa");
        


    }



}


