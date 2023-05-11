package A1.Avaliacao.Controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import A1.Avaliacao.Dominio.Aluno;
import A1.Avaliacao.Repository.AlunoRepository;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "cotacao")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping(value = "")
    public List<Aluno> getAlunos() {
        return alunoRepository.getAlunos();
    }

    @GetMapping(value = "{id}")
    public Aluno getAluno(@PathVariable("id") Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Aluno createAluno(@RequestBody @NotNull Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Aluno updateAluno(@PathVariable("id") Long id, @RequestBody @NotNull Aluno aluno) {
        if (ObjectUtils.isEmpty(alunoRepository.findById(id))) {
            return null;
        }
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean deleteAluno(@PathVariable("id") Long id) {
        alunoRepository.deleteById(id);
        return true;
    }

}
