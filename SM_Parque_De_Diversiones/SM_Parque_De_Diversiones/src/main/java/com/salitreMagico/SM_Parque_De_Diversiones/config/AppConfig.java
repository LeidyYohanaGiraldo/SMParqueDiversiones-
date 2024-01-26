package com.salitreMagico.SM_Parque_De_Diversiones.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.salitreMagico.SM_Parque_De_Diversiones.View.MenuPrincipal;

@Configuration
@ComponentScan(basePackages ={
        "com.salitreMagico.SM_Parque_De_Diversiones.View.MenuPrincipal.",
        "com.salitreMagico.SM_Parque_De_Diversiones.View.MenuLogistica.",
        "com.salitreMagico.SM_Parque_De_Diversiones"
})
public class AppConfig {
}
