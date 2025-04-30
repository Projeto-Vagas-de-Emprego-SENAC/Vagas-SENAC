package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.entity.Candidato;
import app.entity.Endereco;
import app.repository.EnderecoRepository;
import app.service.EnderecoService;

@SpringBootTest
public class EnderecoServiceTest {
	
	@Autowired
	EnderecoService enderecoService;

	@MockitoBean
	EnderecoRepository enderecoRepository;
	
	@Test
	void testandoSaveEndereco(){
	Endereco endereco = new Endereco();
	endereco.setRua("tibagi");
	endereco.setCidade("foz");
	
	
	String result = enderecoService.save(endereco);
	assertEquals("o Endereco tibagi foi salvo com sucesso", result);
	
	
	
	}
	
	
	
	
	
	
}
