package br.com.ebac.memelandia.controllers;

import br.com.ebac.memelandia.dto.usuario.UsuarioDTO;
import br.com.ebac.memelandia.services.ServicoNovoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/memelandia")
public class UsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
    private final ServicoNovoUsuario servicoNovoUsuario;

    @Value("${applicationusers.url:}")
    private  String urlServico;

    public UsuarioController(ServicoNovoUsuario servicoNovoUsuario) {
        this.servicoNovoUsuario = servicoNovoUsuario;
    }

    @PostMapping(path = "/usuarios")
    public UsuarioDTO addUser(@RequestBody UsuarioDTO usuario) {
        if (urlServico.length() > 0) {
            UsuarioDTO novoUsuarioDToCriado = servicoNovoUsuario.criarNovoUsuario(usuario);
            LOGGER.info("Acessando o servico de Usuarios .... Criando usuario");
            return novoUsuarioDToCriado;
        }
        return null;
    }

    @GetMapping(path = "/usuarios")
    public Iterable<UsuarioDTO> encontrarTodosUsuarios() {
        if (urlServico.length() > 0) {
            LOGGER.info("Buscando todos os usuarios via servico");
            return servicoNovoUsuario.encontrarTodos();
        }
        return null;
    }

    @GetMapping(path = "/usuarios/{id}")
    public UsuarioDTO buscarPeloId(@PathVariable String id) {
        if (urlServico.length() > 0) {
            LOGGER.info("Buscando usuario pelo id via servico");
            return servicoNovoUsuario.buscarPeloId(id);
        }
        return null;
    }

}
