package com.salitreMagico.SM_Parque_De_Diversiones.repository;


import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository <Persona, String> {
}
