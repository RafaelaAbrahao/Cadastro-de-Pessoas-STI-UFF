package exercicio_cadastro.controller;

import exercicio_cadastro.service.PessoaService;
import exercicio_cadastro.model.PessoaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PessoaService pessoaService;

    private PessoaModel pessoa;

    @BeforeEach
    void SetUp(){
        pessoa = new PessoaModel();
        pessoa.setId(45L);
        pessoa.setNome("Bela Maria Rezende dos Santos");
    }

    @Test
    void Listar_DeveRetornarListaDePessoas() throws Exception{
        //void SetUp
        when(pessoaService.findAll()).thenReturn(List.of(pessoa));

        //act e assert
        mockMvc.perform(get("/cadastro"))
                .andExpect(status().isOk())
                .andExpect(view().name("listagem"))
                .andExpect(model().attributeExists("pessoas"))
                .andExpect(model().attribute("pessoas", List.of(pessoa)));
    }

    // mockMvc.perform(get(URL))

    @Test
    void Editar_DeveRetornarPessoaPorIDParaEdicao() throws Exception{
        when(pessoaService.findById(45L)).thenReturn(pessoa);

        mockMvc.perform(get ("/cadastro/45"))
                .andExpect(status().isOk())
                .andExpect(view().name("edicao"))
                .andExpect(model().attributeExists("pessoa"))
                .andExpect(model().attribute("pessoa", pessoa));
    }

    @Test
    void Criar_DeveRetornarViewDeCriacao() throws Exception {
        mockMvc.perform(get("/cadastro/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("formulario"))
                .andExpect(model().attributeExists("pessoa"))
                .andExpect(model().attribute("pessoa", new PessoaModel()));
    }

}
