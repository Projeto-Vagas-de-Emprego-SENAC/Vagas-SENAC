package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.entity.Endereco;
import app.entity.Vagas;
import app.repository.EnderecoRepository;
import app.repository.VagasRepository;
import app.service.EnderecoService;
import app.service.VagasService;

@SpringBootTest
public class VagasServiceTest {
	
	
	@Autowired
	VagasService vagasService;

	@MockitoBean
	VagasRepository vagasRepository;
	
	@Test
	void testandoSaveVaga(){
	Vagas vaga = new Vagas();
	vaga.setTitulo("pintor");
	vaga.setDescricao("pintar");
	
	
	String result = vagasService.save(vaga);
	assertEquals("a Vaga pintar foi salvo com sucesso", result);
	}

}
