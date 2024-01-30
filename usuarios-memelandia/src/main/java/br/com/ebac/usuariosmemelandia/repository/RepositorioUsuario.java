package br.com.ebac.usuariosmemelandia.repository;

import br.com.ebac.usuariosmemelandia.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuario extends CrudRepository<Usuario, String> {
}
