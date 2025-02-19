package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Vagas;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

}
