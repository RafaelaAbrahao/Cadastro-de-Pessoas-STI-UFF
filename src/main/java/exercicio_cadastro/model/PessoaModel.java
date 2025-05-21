package exercicio_cadastro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table ("pessoa")
@Data
public class PessoaModel {

    private @Id Long id;

    private String nome;
    private Integer idade;
    private LocalDate data_inicio;
}