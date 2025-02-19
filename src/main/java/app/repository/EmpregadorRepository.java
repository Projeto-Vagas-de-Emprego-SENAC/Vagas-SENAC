package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Empregador;

public interface EmpregadorRepository extends JpaRepository<Empregador, Long> {

}
