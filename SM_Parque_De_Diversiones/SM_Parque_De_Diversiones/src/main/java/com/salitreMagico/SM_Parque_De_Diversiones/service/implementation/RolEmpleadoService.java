package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.RolEmpleado;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IRolEmpleadoRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IRolEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolEmpleadoService implements IRolEmpleadoService {

    @Autowired
    private IRolEmpleadoRepository iRolEmpleadoRepository;


    @Override
    public String CrearRol(RolEmpleado rolEmpleado) {
        iRolEmpleadoRepository.save(rolEmpleado);
            return "Rol creado exitosamente";

    }
}
