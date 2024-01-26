package com.salitreMagico.SM_Parque_De_Diversiones.View;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Atraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Estacion;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IAtraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuMantenimiento {

    @Autowired
    private IAtraccionService iAtraccionService;
    Scanner scanner = new Scanner(System.in);

    //Vista principal del empleado de mantenimiento
    public void vistaMantenimiento(){
        boolean bandera = true;
        while(bandera) {
            // docEmpleado = documentoEmpleado;
            System.out.println("¡Ingreso Exitoso! Modulo Mantenimiento\n" +
                    "****************************\n" +
                    "Ingrese la opcion a realizar\n" +
                    "****************************\n" +
                    "1. Habilitar/Desabilitar Atraccion\n" +
                    "2. Salir Sistema");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    GestionarAtraccion();
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

    //metodo que permite habilitar o desabilitar una atraccion
    private void GestionarAtraccion() {

        boolean bandera = true;
        while (bandera) {
            System.out.println("Ingresa la acción a realizar\n" +
                    "1. Habilitar atraccion\n" +
                    "2. Desabilitar atraccion");

            int opcion = scanner.nextInt();

            Long idatraccion;

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el id de la atraccion a habilitar");
                    idatraccion = scanner.nextLong();
                    Atraccion atraccion = new Atraccion();
                    atraccion.setId(idatraccion);
                    atraccion.setHabilitada(true);
                    iAtraccionService.crearAtraccion(atraccion);
                    System.out.println("El Estado de la atraccion cambio con exito");
                    bandera = false;
                    break;
                case 2:
                    System.out.println("Ingrese el id de la atraccion a deshabilitar");
                    idatraccion = scanner.nextLong();
                    Atraccion atraccion2 = new Atraccion();
                    atraccion2.setId(idatraccion);
                    atraccion2.setHabilitada(false);
                    iAtraccionService.crearAtraccion(atraccion2);
                    iAtraccionService.crearAtraccion(atraccion2);
                    System.out.println("El Estado de la atraccion cambio con exito");
                    bandera = false;

                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
