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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Empregador;
import app.service.EmpregadorService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/empregador")
public class EmpregadorController {
	
	@Autowired
	private EmpregadorService empregadorService;

	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Empregador empregador){
		try {

			String mensagem = this.empregadorService.save(empregador);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!"+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {

			String mensagem = this.empregadorService.delete(id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Empregador>findById(@PathVariable long id) {

		try {
			Empregador empregador = this.empregadorService.findById(id);
			return new ResponseEntity<>(empregador, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Empregador empregador){
		try {

			String mensagem = this.empregadorService.update(empregador, id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Empregador>> findAll(){
		try {
			List<Empregador> lista = this.empregadorService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	 @GetMapping("/findByNomeFantasia")
	    public List<Empregador> findByNomeFantansia(@RequestParam String nomeFantasia) {
	        return empregadorService.findByNomeFantasia(nomeFantasia);
	    }

	    @GetMapping("/findByNomeFantasiaContaining")
	    public List<Empregador> findByNomeFantasiaContaining(@RequestParam String nomeFantasia) {
	        return empregadorService.findByNomeFantasiaContaining(nomeFantasia);
	    }

}
