package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.entity.Candidato;
import app.repository.CandidatoRepository;

public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public String save(Candidato candidato) {
		
		this.candidatoRepository.save(candidato);
		
		return "o Candidato " + candidato.getNome() + " foi salvo com sucesso";
	}
	
	public Candidato findById(long id) {
		
		Candidato candidato = this.candidatoRepository.findById(id).get();
		
		return candidato;
	}
	
	public String update(Candidato candidato, long id) {
		candidato.setId(id);
		this.candidatoRepository.save(candidato);
		return candidato.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Candidato> findAll(){
		
		List<Candidato> lista = this.candidatoRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.candidatoRepository.deleteById(id);
		return "O Candidato foi deletado";
	}
}
