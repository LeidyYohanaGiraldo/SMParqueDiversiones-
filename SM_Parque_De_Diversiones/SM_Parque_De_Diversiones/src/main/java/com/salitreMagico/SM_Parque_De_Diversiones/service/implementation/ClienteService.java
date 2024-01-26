package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Cliente;
import com.salitreMagico.SM_Parque_De_Diversiones.entities.Persona;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IClienteRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IPersonaRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository iClienteRepository;

    @Autowired
    private IPersonaRepository iPersonaRepository;

    @Override
    public String crearCliente(Persona persona, Cliente cliente) {
        iPersonaRepository.save(persona);
        iClienteRepository.save(cliente);
        return "Cliente creado exitosamente";
    }

    @Override
    public String consultarDocumento(String documento) {

        Object doc = iClienteRepository.consultarDocumento(documento);
        return doc == null?null:String.valueOf(doc);
    }

    @Override
    public Cliente findByNumeroDocumento(String numeroDocumento) {
        Cliente datosCliente = iClienteRepository.findByNumeroDocumento(numeroDocumento);
        return datosCliente;
    }
}
