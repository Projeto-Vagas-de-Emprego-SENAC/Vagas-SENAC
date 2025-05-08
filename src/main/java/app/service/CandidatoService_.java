package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Candidato;
import app.repository.CandidatoRepository;
import jakarta.persistence.EntityNotFoundException;
@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public String save(Candidato candidato) {
		
		Candidato cand = this.candidatoRepository.findByCpf(candidato.getCpf());
		if(cand != null) {
			throw new RuntimeException("Ja existe um candidato cadastrado com o "+cand.getCpf());
		}
		
		
		
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
	
	public String inscricao(long idCandidato, long idVaga) {
		this.candidatoRepository.inscricao(idCandidato, idVaga);
		
		return "inscricao realizada com sucesso";
		
	}
	public Candidato findByCpf(String cpf) {
              throw new RuntimeException("Candidato não encontrado com CPF: " + cpf);
   }
	
}
