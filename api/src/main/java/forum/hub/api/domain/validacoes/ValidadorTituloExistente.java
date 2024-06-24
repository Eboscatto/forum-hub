package forum.hub.api.domain.validacoes;

import forum.hub.api.domain.topico.DadosPostagemTopico;
import forum.hub.api.domain.topico.Topico;
import forum.hub.api.domain.topico.TopicoRepository;

public class ValidadorTituloExistente implements ValidadorPostagemDeTopico {

    private TopicoRepository topicoRepository;

    public ValidadorTituloExistente(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validar (DadosPostagemTopico dados) {
        if (topicoRepository.existsByTitulo(dados.titulo())) {
            throw new IllegalArgumentException("Já existe um tópico com esse título");
        }

       // var topico = new Topico(dados);
        //return topicoRepository.save(topico);
    }
}
