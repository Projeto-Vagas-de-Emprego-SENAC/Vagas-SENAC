package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Vagas;
import app.repository.VagasRepository;

@Service
public class VagasService {
	
	@Autowired
	private VagasRepository vagasRepository;
	
	public String save(Vagas vagas) {
		
		this.vagasRepository.save(vagas);
		
		return "a Vaga " + vagas.getDescricao() + " foi salvo com sucesso";
	}
	
	public Vagas findById(long id) {
		
		Vagas vagas = this.vagasRepository.findById(id).get();
		
		return vagas;
	}
	
	public String update(Vagas vagas, long id) {
		vagas.setId(id);
		this.vagasRepository.save(vagas);
		return vagas.getDescricao() + " foi atualizado com sucesso!";
	}
	
	public List<Vagas> findAll(){
		
		List<Vagas> lista = this.vagasRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.vagasRepository.deleteById(id);
		return "A Vaga foi deletado";
	}

}
