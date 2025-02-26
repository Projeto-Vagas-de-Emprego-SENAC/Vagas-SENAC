package app.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Vagas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private String descricao;
	private float salario;
	private String requisito;
	private String setor;
	private String tipo;
	private LocalDate dataAnuncio;
	private String nivelExperiencia;
	
	@ManyToOne
	@JsonIgnoreProperties("vagas")
	private Empregador empregador;
	
	@ManyToMany(mappedBy = "vagas")
	@JsonIgnoreProperties("vagas")
	private List<Candidato> candidatos;
	
	@OneToOne
	private List<Endereco> enderecos;
	
}
