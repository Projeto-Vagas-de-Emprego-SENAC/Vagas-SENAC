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

import app.entity.Curriculo;
import app.service.CurriculoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {
	
	@Autowired
	private CurriculoService curriculoService;

	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Curriculo curriculo){
		try {

			String mensagem = this.curriculoService.save(curriculo);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {

			String mensagem = this.curriculoService.delete(id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Curriculo>findById(@PathVariable long id) {

		try {
			Curriculo curriculo = this.curriculoService.findById(id);
			return new ResponseEntity<>(curriculo, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Curriculo curriculo){
		try {

			String mensagem = this.curriculoService.update(curriculo, id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Curriculo>> findAll(){
		try {
			List<Curriculo> lista = this.curriculoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
