package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Empregador {
	
	@Id
	
	private long id;
	private String nome;
	private String razaoSocial;
	private String cnpj;
	private String ie;
	
	

}
