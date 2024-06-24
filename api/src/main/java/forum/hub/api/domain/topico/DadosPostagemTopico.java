package forum.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosPostagemTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        @NotNull
        Long idAutor,
        @NotNull
        Long idCurso) {
}
