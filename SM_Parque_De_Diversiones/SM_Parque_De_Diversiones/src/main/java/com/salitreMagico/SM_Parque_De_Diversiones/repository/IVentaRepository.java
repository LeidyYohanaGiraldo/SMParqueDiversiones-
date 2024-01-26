package com.salitreMagico.SM_Parque_De_Diversiones.repository;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IVentaRepository extends JpaRepository <Venta,Long> {

    @Query(value = "SELECT count(id)\n" +
            "FROM venta\n" +
            "where fecha = :fecha ", nativeQuery = true)
    public  int consultarClientesTotales(@Param("fecha") LocalDate fecha);
}
