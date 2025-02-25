package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Endereco;
import app.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public String save(Endereco endereco) {
		
		this.enderecoRepository.save(endereco);
		
		return "o Endereco " + endereco.getRua() + " foi salvo com sucesso";
	}
	
	public Endereco findById(long id) {
		
		Endereco endereco = this.enderecoRepository.findById(id).get();
		
		return endereco;
	}
	
	public String update(Endereco endereco, long id) {
		endereco.setId(id);
		this.enderecoRepository.save(endereco);
		return endereco.getRua() + " foi atualizado com sucesso!";
	}
	
	public List<Endereco> findAll(){
		
		List<Endereco> lista = this.enderecoRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.enderecoRepository.deleteById(id);
		return "O Endereco foi deletado";
	}

}
