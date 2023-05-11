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

import A1.Avaliacao.Dominio.Curso;
import A1.Avaliacao.Repository.CursoRepository;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "curso")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping(value = "")
    public List<Curso> getCursos() {
        return cursoRepository.getCursos();
    }

    @GetMapping(value = "{id}")
    public Curso getCurso(@PathVariable("id") Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Curso createCurso(@RequestBody @NotNull Curso curso) {
        return cursoRepository.save(curso);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Curso updateCurso(@PathVariable("id") Long id, @RequestBody @NotNull Curso curso) {
        if (ObjectUtils.isEmpty(cursoRepository.findById(id))) {
            return null;
        }
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean deleteCurso(@PathVariable("id") Long id) {
        if (ObjectUtils.isEmpty(cursoRepository.findById(id))) {
            return false;
        }
        cursoRepository.deleteById(id);
        return true;
    }
}
