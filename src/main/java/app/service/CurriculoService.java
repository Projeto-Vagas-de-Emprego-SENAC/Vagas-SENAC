package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.entity.Curriculo;
import app.repository.CurriculoRepository;

public class CurriculoService {
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	public String save(Curriculo curriculo) {
		
		this.curriculoRepository.save(curriculo);
		
		return "o Curriculo " + curriculo.getExperiencia() + curriculo.getGraduacao() + " foi salvo com sucesso";
	}
	
	public Curriculo findById(long id) {
		
		Curriculo curriculo = this.curriculoRepository.findById(id).get();
		
		return curriculo;
	}
	
	public String update(Curriculo curriculo, long id) {
		curriculo.setId(id);
		this.curriculoRepository.save(curriculo);
		return curriculo.getExperiencia() + " foi atualizado com sucesso!";
	}
	
	public List<Curriculo> findAll(){
		
		List<Curriculo> lista = this.curriculoRepository.findAll();


		return lista;
	}
	
	public String delete(long id) {
		this.curriculoRepository.deleteById(id);
		return "O Curriculo foi deletado";
	}

}
