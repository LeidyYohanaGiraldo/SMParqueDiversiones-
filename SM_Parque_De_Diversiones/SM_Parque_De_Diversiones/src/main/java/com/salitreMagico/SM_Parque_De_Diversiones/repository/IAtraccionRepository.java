package com.salitreMagico.SM_Parque_De_Diversiones.repository;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Atraccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAtraccionRepository extends JpaRepository<Atraccion, Long> {
}
