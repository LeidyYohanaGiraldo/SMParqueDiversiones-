package com.salitreMagico.SM_Parque_De_Diversiones.View;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.RolEmpleado;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IClienteService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class GestionSistema {

    @Autowired
      private IClienteService iClienteService;

    @Autowired
    private IEmpleadoService iEmpleadoService;


//    vista principal del menu
    public void vistaPrincipal()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\nBienvenido Usuario Administrativo. \n" +
                "*************************************************\n" +
                "¿Que desea Hacer?\n" +
                "1. Crear Cliente Nuevo\n" +
                "2. Crear Empleado Nuevo\n" +
                "3. Crear Rol\n"+
                "*************************************************\n\n\n");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                crearCliente();
                break;
            case 2:
                crearEmpleado();
            case 3:
                crearRol();
                break;
            default:
                System.out.println("Opción no válida");
        }


    }
//    solicito datos por consola para podeer realiza la peticion al servicio y crear el cliente nuevo
    public String crearCliente(){
        Scanner scanner = new Scanner(System.in);

        //reo instancia de un cliente para poder almacenar los datos solicitados
        Cliente cliente = new Cliente();

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Ingrese su edad: ");
        Long edad = scanner.nextLong();

        //si el clinte es menor de edad se solicitara informacion d eun responsable
        if (edad < 18) {
            System.out.println("El cliente es menor de 18 años por lo que" +
                    " se requiere información de contacto de algún familiar.");


            System.out.println("Ingrese nombre de contacto de un familiar: ");
            String infContacto = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Ingrese el número de teléfono de su contacto familiar: ");
            String numContacto = scanner.nextLine();

            cliente.setInfContacto(infContacto);
            cliente.setNumContacto(numContacto);

        } else {
            System.out.println("Cliente mayor de 18 años, ");
        }

        System.out.println("Ingrese su numero de documento: ");
        String nroDocumento = scanner.next();

        System.out.println("Ingrese su telefono: ");
        String telefono = scanner.next();

        System.out.println("Ingrese su correo: ");
        String correo = scanner.next();

        System.out.println("Ingrese su estatura: ");
        Double estatura = scanner.nextDouble();

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setNroDocumento(nroDocumento);
        persona.setTelefono(telefono);
        persona.setCorreo(correo);



        cliente.setEdad(edad);
        cliente.setEstatura(estatura);
        cliente.setPersona(persona);

        //Se envian los datos al service para que interactue en repository y cree el nuevo cliente
        System.out.println(iClienteService.crearCliente(persona, cliente));

        return nroDocumento;


    }
    //    solicito datos por consola para podeer realiza la peticion al servicio y crear el empleado nuevo
    public void crearEmpleado(){
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese su nombre: ");
            String nombre = scanner.next();


            System.out.println("Ingrese su numero de documento: ");
            String nroDocumento = scanner.next();

            System.out.println("Ingrese su telefono: ");
            String telefono = scanner.next();

            System.out.println("Ingrese su correo: ");
            String correo = scanner.next();

            System.out.println("Ingrese su direccion: ");
            String direccion = scanner.next();

            //Solicito el id del rol, es importante por que dependiendo el rol, podra realizar sus funciones
            System.out.println("Seleccione el Rol del empleado:\n" +
                    "1. Administrativo\n" +
                    "2. Publicidad\n" +
                    "3. Logística\n" +
                    "4. Operador\n" +
                    "5. Mantenimiento");
            Long rol = scanner.nextLong();

            System.out.println("Ingrese el horario del empleado: ");
            String horarioLaboral = scanner.nextLine();


            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setNroDocumento(nroDocumento);
            persona.setTelefono(telefono);
            persona.setCorreo(correo);

            RolEmpleado rolEmpleado = new RolEmpleado();
            rolEmpleado.setId(rol);

            Empleado empleado = new Empleado();
            empleado.setDireccion(direccion);
            empleado.setHorarioLaboral(horarioLaboral);
            empleado.setRolEmpleado(rolEmpleado);
            empleado.setPersona(persona);

            System.out.println(iEmpleadoService.crearCliente(persona, empleado));

            System.out.println("Desea Crear un nuevo Empleado, ingrese uno si es asi?");

            int opc = scanner.nextInt();

            if(opc != 1){
                break;
            }
        }
    }

    //metodo encargado de crear los roles, se tienen 5 actualmente si se quisiera crear uno mas se haria aqui
    public void crearRol(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del rol: ");
        String nombreRol = scanner.next();

        RolEmpleado rolEmpleado = new RolEmpleado();
        rolEmpleado.setNombre(nombreRol);
    }


}
