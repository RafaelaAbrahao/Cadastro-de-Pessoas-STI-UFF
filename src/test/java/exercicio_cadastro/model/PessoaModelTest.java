package exercicio_cadastro.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PessoaModelTest {

    private PessoaModel pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new PessoaModel();
        pessoa.setId(1L);
        pessoa.setNome("Bela Maria");
        pessoa.setIdade(30);
        pessoa.setData_inicio(LocalDate.of(2020, 1, 1));
    }

    @Test
    void GettersAndSetters_funcionam() {
        assertEquals(1L, pessoa.getId());
        assertEquals("Bela Maria", pessoa.getNome());
        assertEquals(30, pessoa.getIdade());
        assertEquals(LocalDate.of(2020, 1, 1), pessoa.getData_inicio());
    }

    @Test
    void testEqualsAndHashCode() {
        PessoaModel pessoa2 = new PessoaModel();
        pessoa2.setId(1L);
        pessoa2.setNome("Bela Maria");
        pessoa2.setIdade(30);
        pessoa2.setData_inicio(LocalDate.of(2020, 1, 1));

        assertEquals(pessoa, pessoa2);
        assertEquals(pessoa.hashCode(), pessoa2.hashCode());
    }

    @Test
    void testToString() {
        String toString = pessoa.toString();
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("nome=Bela Maria"));
    }
}