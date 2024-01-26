package com.salitreMagico.SM_Parque_De_Diversiones.service.contracts;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.PasaporteAtraccion;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IPasaporteAtraccionService {
    public String crearPasaporteAtraccion (PasaporteAtraccion pasaporteAtraccion);

    public List<Map<String, Object>> consultarPasaporte(String documento, LocalDate fecha);
}
