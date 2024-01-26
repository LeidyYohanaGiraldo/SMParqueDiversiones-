package com.salitreMagico.SM_Parque_De_Diversiones.service.contracts;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.HistoricoAtraccion;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IHistoricoAtraccionService {

    public String crearHistoricoAtraccion(HistoricoAtraccion historicoAtraccion);

    public List<Map<String, Object>> consultarAtraccionesMasUsadas(LocalDate fechaInicial, LocalDate fechaFinal);
}
