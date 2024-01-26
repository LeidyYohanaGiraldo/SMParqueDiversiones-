package com.salitreMagico.SM_Parque_De_Diversiones.service.contracts;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;

public interface IClienteService {
    public String crearCliente (Persona persona, Cliente cliente);

    public String consultarDocumento(String documento);

    public Cliente findByNumeroDocumento(String numeroDocumento);
}
