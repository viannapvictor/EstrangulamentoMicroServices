package br.com.ebac.usuariosmemelandia.service;
import br.com.ebac.usuariosmemelandia.entity.Usuario;
import br.com.ebac.usuariosmemelandia.repository.RepositorioUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicoUsuario {
    private final RepositorioUsuario repositorioUsuario;

    public ServicoUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Iterable<Usuario> encontrarTodos() {
        return repositorioUsuario.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Usuario buscarPeloId(String id) {
        for (Usuario usuario : encontrarTodos()) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
