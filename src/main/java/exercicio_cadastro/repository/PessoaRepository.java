package exercicio_cadastro.repository;

import exercicio_cadastro.model.PessoaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaModel, Long> {
}
