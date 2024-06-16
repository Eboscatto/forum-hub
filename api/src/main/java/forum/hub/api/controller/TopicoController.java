package forum.hub.api.controller;

import forum.hub.api.Topico.DadosCadastroTopico;
import forum.hub.api.Topico.Topico;
import forum.hub.api.Topico.TopicoRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
       topicoRepository.save(new Topico(dados));
    }
}
