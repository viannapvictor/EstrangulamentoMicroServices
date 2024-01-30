package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.client.ClienteFeignNovaCategoria;
import br.com.ebac.memelandia.client.ClienteFeignNovoUsuario;
import br.com.ebac.memelandia.dto.usuario.NovoUsuarioDTO;
import br.com.ebac.memelandia.dto.usuario.UsuarioDTO;
import br.com.ebac.memelandia.entities.Meme;
import br.com.ebac.memelandia.repositories.RepositorioMeme;
import br.com.ebac.memelandia.utils.UsuarioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoMemelandia {
    private final ClienteFeignNovoUsuario clienteFeignNovoUsuario;
    private final ClienteFeignNovaCategoria clienteFeignNovaCategoria;
    private final RepositorioMeme repositorioMeme;

    public ServicoMemelandia
            (ClienteFeignNovoUsuario clienteFeignNovoUsuario,
             ClienteFeignNovaCategoria clienteFeignNovaCategoria,
             RepositorioMeme repositorioMeme)
    {
        this.clienteFeignNovoUsuario = clienteFeignNovoUsuario;
        this.clienteFeignNovaCategoria = clienteFeignNovaCategoria;
        this.repositorioMeme = repositorioMeme;
    }

    public Meme novoMeme(Meme meme) {
        if(clienteFeignNovaCategoria.encontrarTodos().size() > 0 && clienteFeignNovoUsuario.encontrarTodos().size() >0) {
            return repositorioMeme.save(meme);
        } return null;
    }

    public List<Meme> listaTodosMemes() {
        if(clienteFeignNovaCategoria.encontrarTodos().size() > 0 && clienteFeignNovoUsuario.encontrarTodos().size() >0) {
            return repositorioMeme.findAll();
        } return null;
    }

}
