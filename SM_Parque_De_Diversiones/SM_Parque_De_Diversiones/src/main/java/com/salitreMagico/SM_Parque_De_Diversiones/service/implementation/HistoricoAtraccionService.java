package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.HistoricoAtraccion;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IHistoricoAtraccionRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IHistoricoAtraccionService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class HistoricoAtraccionService implements IHistoricoAtraccionService {
   @Autowired
   private IHistoricoAtraccionRepository iHistoricoAtraccionRepository;

    @Override
    public String crearHistoricoAtraccion(HistoricoAtraccion historicoAtraccion) {
        iHistoricoAtraccionRepository.save(historicoAtraccion);
        return "Se Creo registro en la tabla HistoricoAtraccion con exito";
    }

    @Override
    public List<Map<String, Object>> consultarAtraccionesMasUsadas(LocalDate fechaInicial, LocalDate fechaFinal) {
        List<Map<String, Object>> listaDatos= iHistoricoAtraccionRepository.consultarAtraccionesMasUsadas(fechaInicial, fechaFinal);
        return listaDatos;
    }
}
