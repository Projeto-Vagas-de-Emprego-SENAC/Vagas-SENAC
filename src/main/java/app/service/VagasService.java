package app.service;

import java.time.LocalDate;
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

	public List<Vagas> findByTitulo(String titulo){
		return this.vagasRepository.findByTitulo(titulo);
	}
	
	public List<Vagas> findByRequisito(String requisito){
		return this.vagasRepository.findByTitulo(requisito);
	}
	
	public List<Vagas> findBySalario(float salario){
		return this.vagasRepository.findBySalario(salario);
	}
	
	public List<Vagas> findBySetor(String setor){
		return this.vagasRepository.findBySetor(setor);
	}
	
	public List<Vagas> findByData(LocalDate dataAnuncio){
		return this.vagasRepository.findByData(dataAnuncio);
	}
	
	public List<Vagas> findByTipo(String tipo){
		return this.vagasRepository.findByTipo(tipo);
	}
	
	public List<Vagas> findByNivelExp(String nivelExperiencia){
		return this.vagasRepository.findByNivelExp(nivelExperiencia);
	}
	
}
