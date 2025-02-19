package app.entity;

import java.time.LocalDateTime;

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

public class Candidato {
	private long id;
	private String nome;
	private String rg;
	private LocalDateTime datanascimento;
	
	
	

}
