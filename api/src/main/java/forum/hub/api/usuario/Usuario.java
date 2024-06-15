package forum.hub.api.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name ="Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.ativo = true;

    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if (dados.nome() !=null) {
            this.nome = dados.nome();
        }

        if (dados.senha() !=null) {
            this.senha = dados.senha();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
