package forum.hub.api.usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, String senha, Boolean ativo) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getAtivo());
    }
}
