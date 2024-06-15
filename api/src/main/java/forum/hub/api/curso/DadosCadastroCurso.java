package forum.hub.api.curso;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCurso(
        @NotBlank
        String nome,
        @NotNull
        Categoria categoria) {
}