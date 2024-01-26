package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_numero_documento")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "venta_id_pasaporte")
    private Pasaporte pasaporte;

    @ManyToOne
    @JoinColumn(name = "empleado_numero_documento")
    private Empleado empleado;



}
