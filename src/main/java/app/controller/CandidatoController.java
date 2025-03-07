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

import app.entity.Candidato;
import app.service.CandidatoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {
	
	@Autowired
	private CandidatoService candidatoService;

	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Candidato candidato){
		try {

			String mensagem = this.candidatoService.save(candidato);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!"+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {

			String mensagem = this.candidatoService.delete(id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Candidato>findById(@PathVariable long id) {

		try {
			Candidato candidato = this.candidatoService.findById(id);
			return new ResponseEntity<>(candidato, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Candidato candidato){
		try {

			String mensagem = this.candidatoService.update(candidato, id);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Candidato>> findAll(){
		try {
			List<Candidato> lista = this.candidatoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/inscricao")
	public ResponseEntity<String> inscricao(@RequestParam long idCandidato, @RequestParam long idVaga){
		try {

			String mensagem = this.candidatoService.inscricao(idCandidato, idVaga);

			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Deu erro!",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByCpf/{cpf}")
    public ResponseEntity<Candidato> findByCpf(@PathVariable String cpf) {
        Candidato candidato = candidatoService.findByCpf(cpf);
        return ResponseEntity.ok(candidato);
    }

}
