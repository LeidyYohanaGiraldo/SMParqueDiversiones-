package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Dictionary;

@Data
@Entity
@NoArgsConstructor
@Table

public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long edad;
        private Double estatura;
        private String infContacto;
        private String numContacto;

        @OneToOne
        @JoinColumn(name = "pers_numero_documento")
        private Persona persona;



}
