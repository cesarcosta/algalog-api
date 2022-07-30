package com.algaworks.algalog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping
	public List<Cliente> listar() {
		Cliente cliente = new Cliente();
		cliente.setId(1l);
		cliente.setNome("cesar");
		cliente.setEmail("cesar@gmail.com");
		cliente.setTelefone("98989888");
		
		var cliente2 = new Cliente();
		cliente2.setId(2l);
		cliente2.setNome("Maria");
		cliente2.setEmail("maria@gmail.com");
		cliente2.setTelefone("98989865656");
		
		return Arrays.asList(cliente, cliente2);
	}
}