package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table
public class HistoricoAtraccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "Cliente_id")
    private Cliente Cliente;
    @ManyToOne
    @JoinColumn(name = "atraccion_id")
    private Atraccion Atraccion;
}
