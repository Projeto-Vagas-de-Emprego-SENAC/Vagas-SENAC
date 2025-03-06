package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Empregador;
import app.entity.Endereco;
import app.entity.Vagas;

public interface EmpregadorRepository extends JpaRepository<Empregador, Long> {
	
	List<Empregador> findByNomeFantasia(String nomeFantasia);
    List<Empregador> findByNomeFantasiaContaining(String nomeFantasia);
    public Empregador findByCnpj(String cnpj);

	

}
