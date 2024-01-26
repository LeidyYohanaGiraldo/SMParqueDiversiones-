package com.salitreMagico.SM_Parque_De_Diversiones.service.contracts;

import com.salitreMagico.SM_Parque_De_Diversiones.entities.Venta;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IVentaService {

    public String registrarVenta(Venta venta);

    public  int consultarClientesTotales( LocalDate fecha);
}
