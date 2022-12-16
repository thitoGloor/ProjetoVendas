package com.vendas.venda.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
import com.vendas.venda.controller.form.VendedorForm;
import com.vendas.venda.modelo.Venda;
import com.vendas.venda.modelo.Vendedor;
import com.vendas.venda.repository.VendedorRepository;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorRepository vendedorRepository;

	@GetMapping
	public List<VendedorDto> getAll(String nome) {
		if (nome == null) {
			List<Vendedor> vendedores = vendedorRepository.findAll();
			return VendedorDto.converter(vendedores);
		} else {
			List<Vendedor> vendedores = vendedorRepository.findByNome(nome);
			return VendedorDto.converter(vendedores);

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VendedorDto> buscaPorId(@PathVariable Integer id) {
			
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		if(vendedor.isPresent()) {
			return ResponseEntity.ok(new VendedorDto(vendedor.get())) ;
		}
		return ResponseEntity.notFound().build();
	}				

	@PostMapping
	@Transactional
	public ResponseEntity<VendedorDto> post(@RequestBody VendedorForm form, UriComponentsBuilder uriBuilder) {
		Vendedor vendedor = form.converter(vendedorRepository);
		vendedorRepository.save(vendedor);

		URI uri = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VendedorDto> atualizar(@PathVariable Integer id, @RequestBody AtualizarVendedorForm form){		
		
		Optional<Vendedor> optional = vendedorRepository.findById(id);
		if(optional.isPresent()) {
			Vendedor vendedor = form.atualizar(id, vendedorRepository);
			return ResponseEntity.ok(new VendedorDto(vendedor)) ;
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Integer id){
		Optional<Vendedor> optional = vendedorRepository.findById(id);
		if(optional.isPresent()) {
		vendedorRepository.deleteById(id);
		return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();	
	}
		
}
