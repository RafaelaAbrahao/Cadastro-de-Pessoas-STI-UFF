package exercicio.cadastro.cadastro.service;

import exercicio.cadastro.cadastro.respository.Cadastro2Repository;
import exercicio.cadastro.cadastro.respository.cadastroRepository;
import exercicio.cadastro.cadastro.model.PessoaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CadastroService {

    private final cadastroRepository repository;
    private final Cadastro2Repository repository2;

    public PessoaModel findById(long id){
        Optional<PessoaModel> pessoa = repository2.findById(id);
        return pessoa.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<PessoaModel> findAll(){
        return repository.findAll();
    }

    public void salvarPessoa(PessoaModel pessoa){
        repository2.save(pessoa);
    }

    public void deletarPessoa(long id){
        repository2 .deleteById(id);
    }
}
