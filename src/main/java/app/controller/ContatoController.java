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

import app.entity.Contato;
import app.service.ContatoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/turma")
public class ContatoController {
	
	@Autowired
   private ContatoService contatoService;

	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Contato contato){
		try {

			String mensagem = this.contatoService.save(contato);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {

			String mensagem = this.contatoService.delete(id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Contato>findById(@PathVariable long id) {

		try {
			Contato contato = this.contatoService.findById(id);
			return new ResponseEntity<>(contato, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Contato contato){
		try {

			String mensagem = this.contatoService.update(contato, id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Contato>> findAll(){
		try {
			List<Contato> lista = this.contatoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
