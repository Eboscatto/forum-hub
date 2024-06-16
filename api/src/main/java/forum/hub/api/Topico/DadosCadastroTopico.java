package forum.hub.api.Topico;

import forum.hub.api.Resposta.Resposta;
import forum.hub.api.curso.Curso;
import forum.hub.api.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroTopico(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        StatusTopico status,
        @NotBlank
        Usuario autor,
        @NotBlank
        Curso curso,
        List<Resposta> respostas) {
}
