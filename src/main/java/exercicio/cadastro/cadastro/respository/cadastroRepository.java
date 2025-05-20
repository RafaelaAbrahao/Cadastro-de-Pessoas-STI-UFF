package exercicio.cadastro.cadastro.respository;

import exercicio.cadastro.cadastro.model.PessoaModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Repository
public class cadastroRepository {
    private final JdbcTemplate jdbcTemplate;

    public cadastroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(PessoaModel pessoa) {
        String sql = "INSERT INTO pessoa (nome, idade, data_inicio) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, pessoa.getNome(), pessoa.getIdade(), pessoa.getData_inicio());
    }

    public List<PessoaModel> findAll(){
        String sql ="SELECT * FROM pessoa";
        RowMapper<PessoaModel> rowMapper = (rs, rowNum) -> {
            PessoaModel pessoa = new PessoaModel();
            pessoa.setId(rs.getLong("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setIdade(rs.getInt("idade"));
            pessoa.setData_inicio(rs.getDate("data_inicio").toLocalDate());
            return pessoa;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public int update(PessoaModel pessoa){
        String sql = "UPDATE pessoa SET nome = ?, idade = ?, data_inicio = ? WHERE id = ?";
        return jdbcTemplate.update(sql, pessoa.getNome(), pessoa.getIdade(), pessoa.getData_inicio(), pessoa.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}