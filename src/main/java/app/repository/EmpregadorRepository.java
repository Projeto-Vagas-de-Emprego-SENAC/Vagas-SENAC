package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Empregador;

public interface EmpregadorRepository extends JpaRepository<Empregador, Long> {
	
	List<Empregador> findByNome(String nome);
    List<Empregador> findByNomeContaining(String nome);

}
