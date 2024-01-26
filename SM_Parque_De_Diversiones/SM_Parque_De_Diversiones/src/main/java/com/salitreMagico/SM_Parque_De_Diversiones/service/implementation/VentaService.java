package com.salitreMagico.SM_Parque_De_Diversiones.service.implementation;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Venta;
import com.salitreMagico.SM_Parque_De_Diversiones.repository.IVentaRepository;
import com.salitreMagico.SM_Parque_De_Diversiones.service.contracts.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository iVentaRepository;
    @Override
    public String registrarVenta(Venta venta) {
        iVentaRepository.save(venta);
        return "Compra Registrada Exitosamente";
    }

    @Override
    public int consultarClientesTotales(LocalDate fecha) {
        return iVentaRepository.consultarClientesTotales(fecha);

    }
}
