package com.andres.curso.springboot.jpa.springboot_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andres.curso.springboot.jpa.springboot_jpa.models.Client;
import com.andres.curso.springboot.jpa.springboot_jpa.models.Invoice;
import com.andres.curso.springboot.jpa.springboot_jpa.repositories.ClientRepository;
import com.andres.curso.springboot.jpa.springboot_jpa.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		manyToOne();
	}

	public void manyToOne(){

		Client client = new Client(); 
		/* Guardamos Cliente */
		client.setName("John");
		client.setLastname("Dae");
		clientRepository.save(client);

		Invoice invoice = new Invoice();
		invoice.setCliente(client);
		invoice.setDescription("Compras del Total");
		invoice.setTotal(2000L);
		Invoice invoiceDB=invoiceRepository.save(invoice);
		System.out.println(invoiceDB);


	}




}
