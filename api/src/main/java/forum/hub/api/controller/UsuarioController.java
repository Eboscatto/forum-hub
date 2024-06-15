package forum.hub.api.controller;

import forum.hub.api.usuario.DadosCadastroUsuario;
import forum.hub.api.usuario.DadosListagemUsuario;
import forum.hub.api.usuario.Usuario;
import forum.hub.api.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        usuarioRepository.save(new Usuario(dados));
    }

    @GetMapping
    public List<DadosListagemUsuario> listar() {

        return usuarioRepository.findAll().stream().map(DadosListagemUsuario::new).toList();
    }

}
