package com.andres.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource(value="classpath:values.properties",encoding = "UTF-8")
}) //Permite el uso de resource....properties... lo cual permite agregar nuevos archivos corre

public class ValuesConfig {
    
}
