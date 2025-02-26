package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Empregador;
import app.entity.Vagas;

public interface EmpregadorRepository extends JpaRepository<Empregador, Long> {
	
	List<Empregador> findByNome(String nome);
    List<Empregador> findByNomeContaining(String nome);
    public Empregador findByCnpj(String cnpj);

}
