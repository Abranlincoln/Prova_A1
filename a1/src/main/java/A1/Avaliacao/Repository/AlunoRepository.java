package A1.Avaliacao.Repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import A1.Avaliacao.Dominio.Aluno;

@EnableScan
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    List<Aluno> getAlunos();
}
