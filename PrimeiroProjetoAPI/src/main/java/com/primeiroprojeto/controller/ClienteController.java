package com.primeiroprojeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojeto.model.Cliente;
import com.primeiroprojeto.repository.ClienteRepository;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {
	private final ClienteRepository clienteRepository;
	
	public ClienteController(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable long id){
		if(!clienteRepository.existsById(id)) 
			return ResponseEntity.notFound().build();
		
		clienteRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,@RequestBody Cliente clienteAtualizado ){
		if(!clienteRepository.existsById(id))
			return ResponseEntity.notFound().build();
		
		Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
		
		if(clienteExistente != null) {
			clienteExistente.setNome(clienteAtualizado.getNome());
		
			Cliente clienteAtualizadoNoBanco = clienteRepository.save(clienteExistente);
			
			return ResponseEntity.ok(clienteAtualizadoNoBanco);
		}
		else return ResponseEntity.notFound().build();
	}
}
