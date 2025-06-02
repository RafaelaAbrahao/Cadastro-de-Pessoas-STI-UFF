package exercicio_cadastro.service;

import exercicio_cadastro.model.PessoaModel;
import exercicio_cadastro.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository repository;

    @InjectMocks
    private PessoaService pessoaService;

    private PessoaModel pessoaValida;
    private final long ID_EXISTENTE = 45L;
    private final long ID_INEXISTENTE = 999L;

    @BeforeEach
    void setUP() {
        pessoaValida = new PessoaModel();
        pessoaValida.setId(ID_EXISTENTE);
        pessoaValida.setNome("Bela Maria Rezende dos Santos");
    }

    @Test
    void FindByID_QuandoIdNaoExiste_DeveLancarExcecao() {
        when(repository.findById(ID_INEXISTENTE)).thenReturn(Optional.empty());

        RuntimeException exception = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> pessoaService.findById(ID_INEXISTENTE)
        );
        assertEquals("Pessoa não encontrada", exception.getMessage());
        verify(repository).findById(ID_INEXISTENTE);
    }

    @Test
    void FindById_QuandoIdExiste_DeveRetornarPessoa() {
        when(repository.findById(ID_EXISTENTE)).thenReturn(Optional.of(pessoaValida));

        PessoaModel pessoaRetornada = pessoaService.findById(ID_EXISTENTE);

        assertEquals(pessoaValida, pessoaRetornada);
        verify(repository).findById(ID_EXISTENTE);
    }

    @Test
    void FindAll_DeveRetornarListaDePessoas() {
        when(repository.findAll()).thenReturn(List.of(pessoaValida));
        List<PessoaModel> pessoas = pessoaService.findAll();

        assertEquals(1, pessoas.size());
        assertEquals(pessoaValida, pessoas.get(0));
        verify(repository).findAll();
    }

    @Test
    void SalvarPessoa_DeveSalvarPessoaCorretamente() {
        pessoaService.salvarPessoa(pessoaValida);
        ArgumentCaptor<PessoaModel> captor = ArgumentCaptor.forClass(PessoaModel.class);
        verify(repository).save(captor.capture());

        PessoaModel pessoaSalva = captor.getValue();
        assertEquals(pessoaValida.getId(), pessoaSalva.getId());
        assertEquals(pessoaValida.getNome(), pessoaSalva.getNome());
    }

}