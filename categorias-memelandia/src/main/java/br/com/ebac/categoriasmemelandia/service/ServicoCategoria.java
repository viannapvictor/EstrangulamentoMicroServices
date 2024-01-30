package br.com.ebac.categoriasmemelandia.service;
import br.com.ebac.categoriasmemelandia.entity.Categoria;
import br.com.ebac.categoriasmemelandia.repository.RepositorioCategoria;
import org.springframework.stereotype.Component;

@Component
public class ServicoCategoria {
    private final RepositorioCategoria repositorioCategoria;

    public ServicoCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public Iterable<Categoria> encontrarTodos() {
        return repositorioCategoria.findAll();
    }

    public Categoria criarCategoria(Categoria categoria) {
        return repositorioCategoria.save(categoria);
    }

}
