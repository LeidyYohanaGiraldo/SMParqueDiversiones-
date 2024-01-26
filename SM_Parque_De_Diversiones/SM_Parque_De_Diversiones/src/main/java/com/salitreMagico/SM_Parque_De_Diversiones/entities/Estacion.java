package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean habilitada;


    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}
