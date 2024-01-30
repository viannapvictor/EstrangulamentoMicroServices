package br.com.ebac.usuariosmemelandia.controllers;

import br.com.ebac.usuariosmemelandia.entity.Usuario;
import br.com.ebac.usuariosmemelandia.service.ServicoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/memelandia")
public class UsuarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
    private final ServicoUsuario servicoUsuario;

    public UsuarioController(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }

    @Value("${applicationusers.url:}")
    private  String urlServico;

    @PostMapping("/novosusuarios")
    public Usuario addUser(@RequestBody Usuario usuario) {
        if (urlServico.length() > 0) {
            LOGGER.info("Cliente executando serviço de criacao de usuarios");
            return servicoUsuario.criarUsuario(usuario);
        } return null;
    }

    @GetMapping("/novosusuarios")
    public Iterable<Usuario> findAllUsers() {
        if (urlServico.length() > 0) {
            LOGGER.info("Cliente executando serviço de listagem de usuarios");
            return servicoUsuario.encontrarTodos();
        } return null;
    }

    @GetMapping("/novosusuarios/{id}")
    public Usuario buscarPeloId(@PathVariable String id) {
        if (urlServico.length() > 0) {
            LOGGER.info("Cliente executando serviço de listagem por id");
            return servicoUsuario.buscarPeloId(id);
        } return null;
    }
}
