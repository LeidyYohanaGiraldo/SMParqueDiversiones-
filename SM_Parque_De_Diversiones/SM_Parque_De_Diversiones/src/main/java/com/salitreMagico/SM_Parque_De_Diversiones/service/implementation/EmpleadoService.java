package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IClienteRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IEmpleadoRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IPersonaRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IClienteService;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @Autowired
    private IPersonaRepository iPersonaRepository;

    @Override
    public String crearCliente(Persona persona, Empleado empleado) {
        iPersonaRepository.save(persona);
        iEmpleadoRepository.save(empleado);
        return "Empleado creado exitosamente";
    }

    @Override
    public Long consultarDocumento(String documento) {
        Object rol = iEmpleadoRepository.consultarDocumento(documento);
        return rol == null?-1:Long.parseLong(String.valueOf(rol));

    }

    @Override
    public Empleado findByNumeroDocumento(String numeroDocumento) {
        Empleado datosEmpleado = iEmpleadoRepository.findByNumeroDocumento(numeroDocumento);
        return datosEmpleado;
    }
}
