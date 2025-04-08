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
    public ResponseEntity<String> save(@RequestBody Candidato candidato) {
        String mensagem = this.candidatoService.save(candidato);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        String mensagem = this.candidatoService.delete(id);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Candidato> findById(@PathVariable long id) {
        Candidato candidato = this.candidatoService.findById(id);
        return ResponseEntity.ok(candidato);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Candidato candidato) {
        String mensagem = this.candidatoService.update(candidato, id);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Candidato>> findAll() {
        List<Candidato> lista = this.candidatoService.findAll();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/inscricao")
    public ResponseEntity<String> inscricao(@RequestParam long idCandidato, @RequestParam long idVaga) {
        String mensagem = this.candidatoService.inscricao(idCandidato, idVaga);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/findByCpf/{cpf}")
    public ResponseEntity<Candidato> findByCpf(@PathVariable String cpf) {
        Candidato candidato = candidatoService.findByCpf(cpf);
        return ResponseEntity.ok(candidato);
    }

}
