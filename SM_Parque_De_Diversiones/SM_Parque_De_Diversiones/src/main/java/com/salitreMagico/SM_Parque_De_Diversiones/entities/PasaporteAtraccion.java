package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class PasaporteAtraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pasaporte_id")
    private Pasaporte pasaporte;

    @ManyToOne
    @JoinColumn(name = "atraccion_id")
    private Atraccion atraccion;
}
