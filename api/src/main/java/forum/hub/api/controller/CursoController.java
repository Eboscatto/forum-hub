package forum.hub.api.controller;

import forum.hub.api.curso.*;
import forum.hub.api.usuario.DadosAtualizacaoUsuario;
import forum.hub.api.usuario.DadosListagemUsuario;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired
    private CursorRepository cursorRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCurso dados) {
        cursorRepository.save(new Curso(dados));
    }
    @GetMapping
    public Page<DadosListagemCurso> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //return cursorRepository.findAll(paginacao).map(DadosListagemCurso::new);
        return cursorRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCurso::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCurso dados) {
        var curso = cursorRepository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var curso = cursorRepository.getReferenceById(id);
        curso.excluir();
    }
}
