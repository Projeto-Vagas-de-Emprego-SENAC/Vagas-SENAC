package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.entity.Empregador;
import app.repository.EmpregadorRepository;

public class EmpregadorService {
	
	@Autowired
	private EmpregadorRepository empregadorRepository;
	
	public String save(Empregador empregador) {
		
		this.empregadorRepository.save(empregador);
		
		return "o Empregador " + empregador.getNome() + empregador.getCnpj() + " foi salvo com sucesso";
	}
	
	public Empregador findById(long id) {
		
		Empregador empregador = this.empregadorRepository.findById(id).get();
		
		return empregador;
	}
	
	public String update(Empregador empregador, long id) {
		empregador.setId(id);
		this.empregadorRepository.save(empregador);
		return empregador.getNome() + " foi atualizado com sucesso!";
	}
	
	public List<Empregador> findAll(){
		
		List<Empregador> lista = this.empregadorRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.empregadorRepository.deleteById(id);
		return "O Empregador foi deletado";
	}

}
