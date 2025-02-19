package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {

}
