package com.salitreMagico.SM_Parque_De_Diversiones.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class Persona {
    @Id
    @Column(name ="numero_documento", unique = true)
    private String nroDocumento;
    private String nombre;
    private String telefono;
    private String correo;

}
