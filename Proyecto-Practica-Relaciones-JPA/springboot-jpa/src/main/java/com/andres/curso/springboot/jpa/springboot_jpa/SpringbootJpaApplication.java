package com.andres.curso.springboot.jpa.springboot_jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andres.curso.springboot.jpa.springboot_jpa.exception.NotFoundException;
import com.andres.curso.springboot.jpa.springboot_jpa.models.Address;
import com.andres.curso.springboot.jpa.springboot_jpa.models.Client;
import com.andres.curso.springboot.jpa.springboot_jpa.models.Invoice;
import com.andres.curso.springboot.jpa.springboot_jpa.repositories.ClientRepository;
import com.andres.curso.springboot.jpa.springboot_jpa.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;

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
		manyToOneFindByIdCliente();
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

	public void manyToOneFindByIdCliente(){
		Client client =clientRepository.findById(10L).orElse(null);
		if(client == null ){
			throw new NotFoundException("No hay un cliente con esta caracteristicas");
		}
		/* Guardamos Cliente */
		Invoice invoice = new Invoice();
		invoice.setCliente(client);
		invoice.setDescription("Compras del Oficina");
		invoice.setTotal(2000L);
		Invoice invoiceDB=invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client();
		client.setName("Fran");
		client.setLastname("Desteeer");


		Address address = new Address();
		address.setStreet("Street");
		address.setNumber(1234);

		Address address2 = new Address();
		address2.setStreet("Vasco de Gama");
		address2.setNumber(9876);

		client.getAddresses().add(address);
		client.getAddresses().add(address2);
		
		clientRepository.save(client);


	}



}
