package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Pasaporte;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IPasaporteRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IPasaporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasaporteService implements IPasaporteService {
    @Autowired
    private IPasaporteRepository iPasaporteRepository;
    @Override
    public String crearCliente(Pasaporte pasaporte) {
        iPasaporteRepository.save(pasaporte);
        return "Pasaporte creado exitosamente";
    }
}
