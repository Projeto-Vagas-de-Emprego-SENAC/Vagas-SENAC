package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Empregador;
import app.entity.Vagas;
import app.repository.EmpregadorRepository;

@Service
public class EmpregadorService {
	
	@Autowired
	private EmpregadorRepository empregadorRepository;
	
	public String save(Empregador empregador) {
		
		Empregador emp = this.empregadorRepository.findByCnpj(empregador.getCnpj());
		if(emp != null) {
			throw new RuntimeException("Ja esxiste um aluno cadastrado com o "+emp.getCnpj());
		}
		
		this.empregadorRepository.save(empregador);
		
		return "o Empregador " + empregador.getNomeFantasia() + empregador.getCnpj() + " foi salvo com sucesso";
	}
	
	public Empregador findById(long id) {
		
		Empregador empregador = this.empregadorRepository.findById(id).get();
		
		return empregador;
	}
	
	public String update(Empregador empregador, long id) {
		empregador.setId(id);
		this.empregadorRepository.save(empregador);
		return empregador.getNomeFantasia() + " foi atualizado com sucesso!";
	}
	
	public List<Empregador> findAll(){
		
		List<Empregador> lista = this.empregadorRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.empregadorRepository.deleteById(id);
		return "O Empregador foi deletado";
	}
	
	 public List<Empregador> findByNomeFantasia(String nomeFantasia) {
	        return empregadorRepository.findByNomeFantasia(nomeFantasia);
	    }

	    public List<Empregador> findByNomeFantasiaContaining(String nomeFantasia) {
	        return empregadorRepository.findByNomeFantasiaContaining(nomeFantasia);
	    }

		}

