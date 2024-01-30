package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.client.ClienteFeignNovaCategoria;
import br.com.ebac.memelandia.client.ClienteFeignNovoUsuario;
import br.com.ebac.memelandia.dto.categoria.NovaCategoriaMemeDTO;
import br.com.ebac.memelandia.dto.categoria.CategoriaMemeDTO;
import br.com.ebac.memelandia.utils.CategoriaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicoNovaCategoria {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoNovoUsuario.class);

    @Value("${applicationcategorys.url:}")
    private  String urlServico;
    
    private final ClienteFeignNovoUsuario clienteFeignNovoUsuario;
    private final ClienteFeignNovaCategoria clienteFeignNovaCategoria;

    public ServicoNovaCategoria
            (ClienteFeignNovoUsuario clienteFeignNovoUsuario, 
            ClienteFeignNovaCategoria clienteFeignNovaCategoria)
    {
        this.clienteFeignNovoUsuario = clienteFeignNovoUsuario;
        this.clienteFeignNovaCategoria = clienteFeignNovaCategoria;
    }

    public CategoriaMemeDTO criarNovaCategoria(CategoriaMemeDTO categoriaMemeDTO) {

        if(clienteFeignNovoUsuario.encontrarTodos().size() > 0 && urlServico.length() > 0) {

            NovaCategoriaMemeDTO novaCategoriaMemeDTO = CategoriaUtils.outputToNovoUsuario(categoriaMemeDTO);
            novaCategoriaMemeDTO = clienteFeignNovaCategoria.criarNovaCategoria(novaCategoriaMemeDTO);
            LOGGER.info("Criando nova Categoria via FeignClient .......");
            return CategoriaUtils.inputFromNovoUsuario(novaCategoriaMemeDTO);

        }

        return null;
            
    }

    public Iterable<CategoriaMemeDTO> encontrarTodos() {
        
        List<NovaCategoriaMemeDTO> novaCategoriaMemeDTOList = clienteFeignNovaCategoria.encontrarTodos();
        List<CategoriaMemeDTO> categoriaMemeDTOList = new ArrayList<>();

        if(clienteFeignNovoUsuario.encontrarTodos().size() > 0) {

            for (NovaCategoriaMemeDTO novaCategoriaMemeDTO : novaCategoriaMemeDTOList) {
                categoriaMemeDTOList.add(CategoriaUtils.inputFromNovoUsuario(novaCategoriaMemeDTO));
            }
            return categoriaMemeDTOList;
        }

        return null;
    }

}
