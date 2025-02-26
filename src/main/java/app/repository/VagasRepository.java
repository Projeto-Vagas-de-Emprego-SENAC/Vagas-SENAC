package app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Vagas;

public interface VagasRepository extends JpaRepository<Vagas, Long> {
	
	public List<Vagas> findByTitulo(String titulo);
	
	public List<Vagas> findByRequisito(String requisito);
	
	public List<Vagas> findBySalario(float salario);
	
	public List<Vagas> findBySetor(String setor);
	
	public List<Vagas> findByData(LocalDate dataAnuncio);
	
	public List<Vagas> findByTipo(String tipo);
	
	public List<Vagas> findByNivelExp(String nivelExperiencia);

}
