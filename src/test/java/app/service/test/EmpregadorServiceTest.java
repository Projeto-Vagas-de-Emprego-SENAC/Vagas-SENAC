package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import app.entity.Empregador;
import app.service.EmpregadorService;
import app.repository.EmpregadorRepository;

@SpringBootTest
public class EmpregadorServiceTest {
		
	@Autowired
	EmpregadorService empregadorService;
	
	@MockitoBean
	EmpregadorRepository empregadorRepository;
	
	@DisplayName("testando save do service")			
    @Test
    void testSaveEmpregadorSucesso() {
        Empregador empregador = new Empregador();
        empregador.setCnpj("12345678000195");
        empregador.setNomeFantasia("Test Empregador");

        when(empregadorRepository.findByCnpjContaining(anyString())).thenReturn(Arrays.asList());

        String result = empregadorService.save(empregador);

        assertEquals("o Empregador Test Empregador de CNPJ: 12345678000195 foi salvo com sucesso", result);
        verify(empregadorRepository, times(1)).save(empregador);
    }
    
    
    

	
	
	
}
