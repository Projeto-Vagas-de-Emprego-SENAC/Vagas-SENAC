package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank (message = "Rua não pode estar vazia")
	private String rua;
	@NotBlank (message = "Estado não pode estar vazio")
	private String estado;
	@NotBlank (message = "Cidade não pode estar vazia")
	private String cidade;
	@NotBlank (message = "CEP não pode estar vazia")
	private String cep;
	private int numero;
	
}
