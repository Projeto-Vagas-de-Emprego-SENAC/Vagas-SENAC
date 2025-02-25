package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Contato;
import app.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public String save(Contato contato) {
		
		this.contatoRepository.save(contato);
		
		return "o Contato " + contato.getEmail() + " foi salvo com sucesso";
	}
	
	public Contato findById(long id) {
		
		Contato contato = this.contatoRepository.findById(id).get();
		
		return contato;
	}
	
	public String update(Contato contato, long id) {
		contato.setId(id);
		this.contatoRepository.save(contato);
		return contato.getEmail() + " foi atualizado com sucesso!";
	}
	
	public List<Contato> findAll(){
		
		List<Contato> lista = this.contatoRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.contatoRepository.deleteById(id);
		return "O Contato foi deletado";
	}
}
