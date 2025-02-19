package app.entity;

import jakarta.persistence.Entity;
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
	
	private long id;
	private String rua;
	private String estado;
	private String cidade;
	private String cep;

}
