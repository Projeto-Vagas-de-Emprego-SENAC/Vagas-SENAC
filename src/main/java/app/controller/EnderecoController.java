package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Endereco;
import app.service.EnderecoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;

	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Endereco endereco){
		try {

			String mensagem = this.enderecoService.save(endereco);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {

			String mensagem = this.enderecoService.delete(id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Endereco>findById(@PathVariable long id) {

		try {
			Endereco endereco = this.enderecoService.findById(id);
			return new ResponseEntity<>(endereco, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Endereco endereco){
		try {

			String mensagem = this.enderecoService.update(endereco, id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Endereco>> findAll(){
		try {
			List<Endereco> lista = this.enderecoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByCidade")
	public ResponseEntity<List<Endereco>> findByCidade(String cidade){
		try {
			List<Endereco> lista = this.enderecoService.findByCidade(cidade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByEstado")
	public ResponseEntity<List<Endereco>> findByEstado(String estado){
		try {
			List<Endereco> lista = this.enderecoService.findByEstado(estado);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		}
	
	@GetMapping("/findByCidadeContaining")
	public ResponseEntity<List<Endereco>> findByCidadeContaining(String cidade){
		try {
			List<Endereco> lista = this.enderecoService.findByCidadeContaining(cidade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

					@GetMapping("/findByEstadoContaining")
			public ResponseEntity<List<Endereco>> findByEstadoContaining(String estado){
				try {
					List<Endereco> lista = this.enderecoService.findByEstadoContaining(estado);
					return new ResponseEntity<>(lista, HttpStatus.OK);
					
				}catch (Exception e){
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}

					}
		}
