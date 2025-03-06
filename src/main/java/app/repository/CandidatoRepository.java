package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	public Candidato findByCpf(String cpf);
	
	@Query(value = "INSERT INTO vagas_candidato VALUES (:idCandidato, :idVagas)", nativeQuery = true)
	public void inscricao(long idCandidato, long idVagas);
	

}
