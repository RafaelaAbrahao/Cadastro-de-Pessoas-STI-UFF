package exercicio_cadastro.service;

import exercicio_cadastro.repository.PessoaRepository;
import exercicio_cadastro.model.PessoaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository repository2;

    public PessoaModel findById(long id){
        Optional<PessoaModel> pessoa = repository2.findById(id);
        return pessoa.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<PessoaModel> findAll() {
        return (List<PessoaModel>) repository2.findAll();
    }

    public void salvarPessoa(PessoaModel pessoa){
        repository2.save(pessoa);
    }

    public void deletarPessoa(long id){
        repository2 .deleteById(id);
    }
}
