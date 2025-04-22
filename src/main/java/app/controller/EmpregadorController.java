package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entity.Empregador;
import app.service.EmpregadorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empregador")
@CrossOrigin ("*")
public class EmpregadorController {

    @Autowired
    private EmpregadorService empregadorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Empregador empregador) {
        String mensagem = this.empregadorService.save(empregador);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        String mensagem = this.empregadorService.delete(id);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Empregador> findById(@PathVariable long id) {
        Empregador empregador = this.empregadorService.findById(id);
        return ResponseEntity.ok(empregador);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@Valid @PathVariable long id, @RequestBody Empregador empregador) {
        String mensagem = this.empregadorService.update(empregador, id);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Empregador>> findAll() {
        List<Empregador> lista = this.empregadorService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/findByNomeFantasia")
    public List<Empregador> findByNomeFantansia(@RequestParam String nomeFantasia) {
        return empregadorService.findByNomeFantasia(nomeFantasia);
    }

    @GetMapping("/findByNomeFantasiaContaining")
    public List<Empregador> findByNomeFantasiaContaining(@RequestParam String nomeFantasia) {
        return empregadorService.findByNomeFantasiaContaining(nomeFantasia);
    }
    @GetMapping("/findByCnpjContaining")
    public List<Empregador> findByCnpj(@RequestParam String cnpj) {
        return empregadorService.findByCnpjContaining(cnpj);
    }
    
}