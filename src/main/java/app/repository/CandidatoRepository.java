package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import app.entity.Candidato;
import jakarta.transaction.Transactional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	public List<Candidato> findByCpfContaining(String cpf);
	
	@Transactional
	  @Modifying
	@Query(value = "INSERT INTO vagas_candidato VALUES (:idCandidato, :idVagas)", nativeQuery = true)
	public Object inscricao(long idCandidato, long idVagas);
	

}
