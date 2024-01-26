package com.salitreMagico.SM_Parque_De_Diversiones.View;


import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IClienteService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class MenuPrincipal {
    //instancio libreria para campturar datos por consola
    Scanner scanner = new Scanner(System.in);
    /*@Autowired Inyecta las dependencias de la interfaz del servicio y por medio de poliformismo
    realiza el llamado de los metodos correspondientes con su respectiva logica*/
@Autowired
private IEmpleadoService iEmpleadoService;

    @Autowired
    private IClienteService iClienteService;

    @Autowired
    private MenuLogistica menuLogistica;

    @Autowired
    private MenuOperarios menuOperarios;

    @Autowired
    private MenuAdministrativo menuAdministrativo;

    @Autowired
    private MenuMantenimiento menuMantenimiento;

    public void validarEmpleado() {
        boolean bandera = true;
        while (bandera) {

            //Menu Principal mostrado en consola
            System.out.println("\n\n\n\n\nBienvenido Al Parque Salitre Magico. \n" +
                    "*************************************************\n" +
                    "¿Que accion desea realizar?\n" +
                    "1. Ingresar al Sistema\n" +
                    "2. Salir\n" +
                    "*************************************************\n");

              //captura de datos por medio de la libreria scanner
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    bandera = false;
                    validarDocumento();
                    break;
                case 2:
                    bandera = false;
                    System.out.println("¡Hasta Pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    //metodo encargado de validar el docuento del empleado segun su rol mostrara opciones diferentes
    private void validarDocumento() {

        //este ciclo se ejecutara hasta que el usuario salga del sistema o en su defecto ingrese usuario valido
        boolean bandera = true;
        while (true) {
            System.out.println("\n\n Ingrese Su documento de identidad");
            String documento = scanner.next();

            //valido desde mi servio si el documento ingresado es valido
            Long id_rol = iEmpleadoService.consultarDocumento(documento);

            /*capturo la respuesta del servicio y si el dato es vacio retorne -1, con esto
             garantizo que el usuario no existe*/
            if (id_rol == -1) {
                System.out.println("El documento ingresado no pertenece a algun" +
                        " empleado del parque, por favor ingreselo de nuevo");
            } else {
                //Valido por id de rol, las opciones d emenu a gestionar
                switch (Integer.parseInt(String.valueOf(id_rol))) {
                    case 1:
                        bandera = false;
                        menuMantenimiento.vistaMantenimiento();
                        break;
                    case 2:
                        menuOperarios.vistaOperarios();
                        bandera = false;
                        break;
                    case 3:
                        menuAdministrativo.vistaAdministrativo();
                        bandera = false;
                        break;
                    case 4:
                        menuLogistica.vistaLogistica(documento);
                        bandera = false;
                        break;
                    case 5:

                        break;
                    default:
                        System.out.println("Opción no válida");
                        menuLogistica.vistaLogistica(documento);

                }

            }
        }

    }

}
