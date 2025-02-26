package app.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
	private String nivelExperiencia;
	
	//relações abaixo
	
}
