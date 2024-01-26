package com.salitreMagico.SM_Parque_De_Diversiones.repository;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.PasaporteAtraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IPasaporteAtraccionRepository extends JpaRepository<PasaporteAtraccion, Long> {
    @Query(value = "SELECT c.pers_numero_documento, v.venta_id_pasaporte, pa.atraccion_id, " +
            "a.estatura_minima, c.estatura, a.habilitada, c.id\n" +
            "FROM venta v\n" +
            "inner join cliente c on c.id = v.cliente_numero_documento\n" +
            "inner join pasaporte_atraccion pa on pa.pasaporte_id = v.venta_id_pasaporte\n" +
            "inner join atraccion a on a.id = pa.atraccion_id\n" +
            "WHERE c.pers_numero_documento = :documento\n" +
            "and v.fecha = :fecha" , nativeQuery = true)
    public List<Map<String, Object>> consultarPasaporte(@Param("documento") String documento,
                                                        @Param("fecha") LocalDate fecha);

}
