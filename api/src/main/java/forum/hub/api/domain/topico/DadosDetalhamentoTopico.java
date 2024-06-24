package forum.hub.api.domain.topico;

import jakarta.transaction.Status;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, Long idAutor, Long idCurso) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
