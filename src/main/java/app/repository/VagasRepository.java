package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Vagas;

public interface VagasRepository extends JpaRepository<Vagas, Long> {
	
	public List<Vagas> findByTitulo(String titulo);

}
