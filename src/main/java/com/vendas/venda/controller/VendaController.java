package com.vendas.venda.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.vendas.venda.controller.dto.VendaDto;
import com.vendas.venda.controller.dto.VendedorDto;
import com.vendas.venda.controller.form.AtualizarVendaForm;
import com.vendas.venda.controller.form.AtualizarVendedorForm;
import com.vendas.venda.controller.form.VendaForm;
import com.vendas.venda.modelo.Venda;
import com.vendas.venda.modelo.Vendedor;
import com.vendas.venda.repository.VendaRepository;
import com.vendas.venda.repository.VendedorRepository;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public List<VendaDto> getAll(Integer id){

			List<Venda> vendas = vendaRepository.findAll();				
			
			return VendaDto.converter(vendas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VendaDto> buscaPorId(@PathVariable Integer id) {
		
		Optional<Venda> venda = vendaRepository.findById(id);
		if(venda.isPresent()) {
			return ResponseEntity.ok(new VendaDto(venda.get())) ;
		}
		return ResponseEntity.notFound().build();
	}				
	
	@PostMapping
	@Transactional
	public ResponseEntity<VendaDto> cadastrar(@RequestBody VendaForm form, UriComponentsBuilder uriBuilder){
		Venda venda = form.converter(vendedorRepository);
		vendaRepository.save(venda);
		
		URI uri =uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendaDto(venda));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VendaDto> atualizar(@PathVariable Integer id, @RequestBody AtualizarVendaForm form){		
		
		Optional<Venda> optional = vendaRepository.findById(id);
		if(optional.isPresent()) {
			Venda venda = form.atualizar(id, vendaRepository);
			return ResponseEntity.ok(new VendaDto(venda)) ;
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Integer id){
		Optional<Venda> optional = vendaRepository.findById(id);
		if(optional.isPresent()) {
		vendaRepository.deleteById(id);
		return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();	
	}
	
	@GetMapping("/contar")
	public Integer contador () {
	Integer qnt =	vendaRepository.quantidadeVenda();
		return qnt;
	}
	
	}

