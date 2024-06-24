package forum.hub.api.controller;

import forum.hub.api.domain.topico.DadosPostagemTopico;
import forum.hub.api.domain.topico.DadosDetalhamentoTopico;
import forum.hub.api.domain.topico.PostagemDeTopicos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private PostagemDeTopicos postagem;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosPostagemTopico dados) {

        var dto = postagem.postar(dados);

        System.out.println(dados);

       // postagem.postar(dados);

        return ResponseEntity.ok(dto);
    }
}
