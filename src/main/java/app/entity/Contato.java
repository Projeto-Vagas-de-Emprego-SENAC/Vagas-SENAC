package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Contato {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String telefone;
	private String celular;
	private String email;
	

}
