package forum.hub.api.domain.validacoes;

import forum.hub.api.domain.topico.DadosPostagemTopico;
import forum.hub.api.domain.topico.TopicoRepository;

public class ValidadorMensagemExistente implements ValidadorPostagemDeTopico {


    private TopicoRepository topicoRepository;

    public ValidadorMensagemExistente(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validar (DadosPostagemTopico dados) {
        if (topicoRepository.existsByMensagem(dados.mensagem())) {
            throw new IllegalArgumentException("Já existe um tópico com essa mensagem");
        }
    }
}
