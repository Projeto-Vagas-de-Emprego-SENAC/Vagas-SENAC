package app.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Vagas;
import app.service.VagasService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/vagas")
public class VagasController {
	
	@Autowired
	private VagasService vagasService;

	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Vagas vagas){
		try {

			String mensagem = this.vagasService.save(vagas);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {

			String mensagem = this.vagasService.delete(id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Vagas>findById(@PathVariable long id) {

		try {
			Vagas vagas = this.vagasService.findById(id);
			return new ResponseEntity<>(vagas, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Vagas vagas){
		try {

			String mensagem = this.vagasService.update(vagas, id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Vagas>> findAll(){
		try {
			List<Vagas> lista = this.vagasService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByTitulo")
	public ResponseEntity<List<Vagas>> findByTitulo(@RequestParam String titulo){
		try {
			return new ResponseEntity<>(this.vagasService.findByTitulo(titulo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findByRequisito")
	public ResponseEntity<List<Vagas>> findByRequisito(@RequestParam String requisito){
		try {
			return new ResponseEntity<>(this.vagasService.findByRequisito(requisito), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findBySalario")
	public ResponseEntity<List<Vagas>> findBySalario(@RequestParam float salario){
		try {
			return new ResponseEntity<>(this.vagasService.findBySalario(salario), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findBySetor")
	public ResponseEntity<List<Vagas>> findBySetor(@RequestParam String setor){
		try {
			return new ResponseEntity<>(this.vagasService.findBySetor(setor), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findByDataAnuncio")
	public ResponseEntity<List<Vagas>> findByDataAnuncio(@RequestParam LocalDate data){
		try {
			return new ResponseEntity<>(this.vagasService.findByDataAnuncio(data), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findByTipo")
	public ResponseEntity<List<Vagas>> findByTipo(@RequestParam String tipo){
		try {
			return new ResponseEntity<>(this.vagasService.findByTipo(tipo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findByNivelExperiencia")
	public ResponseEntity<List<Vagas>> findByNivelExperiencia(@RequestParam String nivelExperiencia){
		try {
			return new ResponseEntity<>(this.vagasService.findByNivelExperiencia(nivelExperiencia), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	
}
