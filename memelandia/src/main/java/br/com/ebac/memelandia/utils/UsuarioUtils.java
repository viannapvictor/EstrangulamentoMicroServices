package br.com.ebac.memelandia.utils;

import br.com.ebac.memelandia.dto.usuario.NovoUsuarioDTO;
import br.com.ebac.memelandia.dto.usuario.UsuarioDTO;

public class UsuarioUtils {
    private UsuarioUtils() {}

    public static UsuarioDTO inputFromNovoUsuario(NovoUsuarioDTO novoUsuarioDTO) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                null,
                novoUsuarioDTO.getNome(),
                novoUsuarioDTO.getEmail(),
                novoUsuarioDTO.getDataCadastro()
        );
        usuarioDTO.setIdNovoUsuario(novoUsuarioDTO.getId());
        return usuarioDTO;
    }

    public static NovoUsuarioDTO outputToNovoUsuario(UsuarioDTO usuarioDTO) {
        return new NovoUsuarioDTO(
                null,
                usuarioDTO.getNome(),
                usuarioDTO.getEmail(),
                usuarioDTO.getDataCadastro()
        );
    }
}
