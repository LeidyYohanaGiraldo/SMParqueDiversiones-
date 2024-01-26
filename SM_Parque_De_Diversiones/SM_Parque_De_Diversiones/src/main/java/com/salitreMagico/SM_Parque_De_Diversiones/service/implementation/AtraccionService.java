package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Atraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IAtraccionRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IAtraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtraccionService implements IAtraccionService {

    @Autowired
    private IAtraccionRepository iAtraccionRepository;
    @Override
    public String crearAtraccion(Atraccion atraccion) {
        Optional<Atraccion> consulta = iAtraccionRepository.findById(atraccion.getId());
        if (consulta.isPresent()) {
            Atraccion atraccionEncontrada = consulta.get();
            atraccionEncontrada.setHabilitada(atraccion.isHabilitada());
            iAtraccionRepository.save(atraccionEncontrada);
            return "Atraccion modificada exitosamente";
        }else {
            iAtraccionRepository.save(atraccion);
            return "Atraccion creado exitosamente";
        }
    }
}
