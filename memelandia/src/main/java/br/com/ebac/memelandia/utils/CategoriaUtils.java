package br.com.ebac.memelandia.utils;

import br.com.ebac.memelandia.dto.categoria.NovaCategoriaMemeDTO;
import br.com.ebac.memelandia.dto.categoria.CategoriaMemeDTO;

public class CategoriaUtils {
    private CategoriaUtils() {}

    public static CategoriaMemeDTO inputFromNovoUsuario(NovaCategoriaMemeDTO novaCategoriaMemeDTO) {
        CategoriaMemeDTO CategoriaMemeDTO = new CategoriaMemeDTO(
                null,
                novaCategoriaMemeDTO.getNome(),
                novaCategoriaMemeDTO.getDescricao(),
                novaCategoriaMemeDTO.getDataCadastro()
        );
        CategoriaMemeDTO.setIdNovoUsuario(novaCategoriaMemeDTO.getId());
        return CategoriaMemeDTO;
    }

    public static NovaCategoriaMemeDTO outputToNovoUsuario(CategoriaMemeDTO categoriaMemeDTO) {
        return new NovaCategoriaMemeDTO(
                null,
                categoriaMemeDTO.getNome(),
                categoriaMemeDTO.getDescricao(),
                categoriaMemeDTO.getDataCadastro()
        );
    }
}
