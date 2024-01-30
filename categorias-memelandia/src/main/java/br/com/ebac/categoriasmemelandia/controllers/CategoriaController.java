package br.com.ebac.categoriasmemelandia.controllers;

import br.com.ebac.categoriasmemelandia.entity.Categoria;
import br.com.ebac.categoriasmemelandia.service.ServicoCategoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/memelandia")
public class CategoriaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);
    private final ServicoCategoria servicoCategoria;

    @Value("${applicationcategorys.url:}")
    private  String urlServico;

    public CategoriaController(ServicoCategoria servicoCategoria) {
        this.servicoCategoria = servicoCategoria;
    }

    @PostMapping("/novascategorias")
    public Categoria addUser(@RequestBody Categoria Categoria) {
        if (urlServico.length() > 0) {
            LOGGER.info("Cliente executando serviço de criacao de categorias");
            return servicoCategoria.criarCategoria(Categoria);
        }
        return null;
    }

    @GetMapping("/novascategorias")
    public Iterable<Categoria> findAllUsers() {
        if (urlServico.length() > 0) {
            LOGGER.info("Cliente executando serviço de listagem de categorias");
            return servicoCategoria.encontrarTodos();
        } return null;
    }

}
