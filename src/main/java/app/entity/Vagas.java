package app.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.JoinTable;
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
	@NotBlank (message = "Titulo não pode estar vazio")
	private String titulo;
	@NotBlank (message = "Descrição não pode estar vazio")
	private String descricao;
	@NotBlank (message = "Salario não pode estar vazio")
	private float salario;
	@NotBlank (message = "Requisitos não pode estar vazio")
	private String requisito;
	private String setor;
	private String tipo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataAnuncio;
	private Boolean status;
	private String nivelExperiencia;

	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("vagas")
	private Empregador empregador;
	
	@ManyToMany(mappedBy = "vagas")
	@JsonIgnoreProperties("vagas")
	private List<Candidato> candidatos;
	
	//@NotEmpty
	@OneToOne
	private Endereco endereco;
	
}
