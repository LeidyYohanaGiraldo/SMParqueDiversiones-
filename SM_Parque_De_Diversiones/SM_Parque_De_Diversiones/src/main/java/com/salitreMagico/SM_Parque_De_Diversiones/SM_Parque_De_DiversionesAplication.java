package com.salitreMagico.SM_Parque_De_Diversiones;

import com.salitreMagico.SM_Parque_De_Diversiones.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@SpringBootApplication(scanBasePackages = "com.salitreMagico.SM_Parque_De_Diversiones")
public class SM_Parque_De_DiversionesAplication {

    public static void main(String[] args) {
        SpringApplication.run(SM_Parque_De_DiversionesAplication.class, args);
    }

}