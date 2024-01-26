package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.PasaporteAtraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IPasaporteAtraccionRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IPasaporteAtraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class PasaporteAtraccionService implements IPasaporteAtraccionService {
@Autowired
private IPasaporteAtraccionRepository iPasaporteAtraccionRepository;
    @Override
    public String crearPasaporteAtraccion(PasaporteAtraccion pasaporteAtraccion) {
        iPasaporteAtraccionRepository.save(pasaporteAtraccion);
        return "PasaporteAtraccion creado exitosamente";
    }

    @Override
    public List<Map<String, Object>> consultarPasaporte(String documento, LocalDate fecha) {
        List<Map<String, Object>> listaDatos = iPasaporteAtraccionRepository.consultarPasaporte(documento,fecha);
        return listaDatos;
    }
}
