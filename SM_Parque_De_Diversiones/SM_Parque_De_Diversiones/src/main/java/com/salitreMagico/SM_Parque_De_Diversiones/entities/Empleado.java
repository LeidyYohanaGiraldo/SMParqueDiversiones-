package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private String horarioLaboral;

    @OneToOne
    @JoinColumn(name = "empleado_numero_documento")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "rolEmpleado_id_rol")
    private RolEmpleado rolEmpleado;

}
