package com.salitreMagico.SM_Parque_De_Diversiones;


import com.salitreMagico.SM_Parque_De_Diversiones.View.MenuLogistica;
import com.salitreMagico.SM_Parque_De_Diversiones.View.MenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private MenuPrincipal clienteView;

    @Autowired
    private MenuLogistica menuLogistica;




    @Override
    public void run(String... args) throws IOException, InterruptedException {

        clienteView.validarEmpleado();
    }
}