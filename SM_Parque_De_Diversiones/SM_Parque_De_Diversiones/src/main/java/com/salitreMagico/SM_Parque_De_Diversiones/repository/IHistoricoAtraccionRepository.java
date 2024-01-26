package com.salitreMagico.SM_Parque_De_Diversiones.repository;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.HistoricoAtraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IHistoricoAtraccionRepository extends JpaRepository<HistoricoAtraccion, Long> {

    @Query(value = "Select ha.atraccion_id , a.nombre, count(ha.id) as cuenta\n" +
            "FROM public.historico_atraccion ha\n" +
            "inner join atraccion a on a.id = ha.atraccion_id\n" +
            "where ha.fecha_ingreso between :fechaInicial and :fechaFinal\n" +
            "group by ha.atraccion_id, a.nombre\n" +
            "order by cuenta desc " , nativeQuery = true)
    public List<Map<String, Object>> consultarAtraccionesMasUsadas(@Param("fechaInicial") LocalDate fechaInicial,
                                                        @Param("fechaFinal") LocalDate fechaFinal);

}
