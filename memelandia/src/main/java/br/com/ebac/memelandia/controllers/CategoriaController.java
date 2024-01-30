package br.com.ebac.memelandia.controllers;

import br.com.ebac.memelandia.dto.categoria.CategoriaMemeDTO;
import br.com.ebac.memelandia.services.ServicoNovaCategoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/memelandia")
public class CategoriaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);
    private final ServicoNovaCategoria servicoNovaCategoria;

    @Value("${applicationcategorys.url:}")
    private  String urlServico;

    public CategoriaController(ServicoNovaCategoria ServicoNovaCategoria) {
        this.servicoNovaCategoria = ServicoNovaCategoria;
    }

    @PostMapping(path = "/categorias")
    public CategoriaMemeDTO addUser(@RequestBody CategoriaMemeDTO categoriaMemeDTO) {
        if (urlServico.length() > 0) {
            CategoriaMemeDTO novaCategoriaMemeDTOCriado = servicoNovaCategoria.criarNovaCategoria(categoriaMemeDTO);
            LOGGER.info("Acessando o servico de Categorias .... Criando categorias");
            return novaCategoriaMemeDTOCriado;
        } return null;
    }

    @GetMapping(path = "/categorias")
    public Iterable<CategoriaMemeDTO> encontrarTodasCategorias() {
        if (urlServico.length() > 0) {
            LOGGER.info("Buscando todas as categorias via servico");
            return servicoNovaCategoria.encontrarTodos();
        } return null;
    }

}
