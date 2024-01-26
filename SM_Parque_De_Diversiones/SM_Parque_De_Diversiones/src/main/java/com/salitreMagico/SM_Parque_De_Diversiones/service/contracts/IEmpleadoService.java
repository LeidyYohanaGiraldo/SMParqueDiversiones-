package com.salitreMagico.SM_Parque_De_Diversiones.service.contracts;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Empleado;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;

public interface IEmpleadoService {

    public String crearCliente (Persona persona, Empleado empleado);

    public Long consultarDocumento(String documento);

    public Empleado findByNumeroDocumento(String numeroDocumento);
}
