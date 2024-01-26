package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Atraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Estacion;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IEstacionRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IPasaporteRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IEstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstacionService implements IEstacionService {

    @Autowired
    private IEstacionRepository iEstacionRepository;
    @Override
    public String crearCliente(Estacion estacion) {
        Optional<Estacion> consulta = iEstacionRepository.findById(estacion.getId());
        if (consulta.isPresent()) {
            Estacion estacionEncontrada = consulta.get();
            estacionEncontrada.setHabilitada(estacion.isHabilitada());
            iEstacionRepository.save(estacionEncontrada);
            return "Estacion modificada exitosamente";
        }else {
            iEstacionRepository.save(estacion);
            return "Estacion creado exitosamente";
        }

    }
}
