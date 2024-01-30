package br.com.ebac.categoriasmemelandia.repository;

import br.com.ebac.categoriasmemelandia.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCategoria extends CrudRepository<Categoria, String> {
}
