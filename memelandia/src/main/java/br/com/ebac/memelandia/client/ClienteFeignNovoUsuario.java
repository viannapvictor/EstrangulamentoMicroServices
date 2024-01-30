package br.com.ebac.memelandia.client;

import br.com.ebac.memelandia.dto.usuario.NovoUsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cliente-novo-usuario", url = "http://localhost:8082")
public interface ClienteFeignNovoUsuario {

    @RequestMapping(method = RequestMethod.POST, path = "/memelandia/novosusuarios")
    NovoUsuarioDTO criarNovoUsuario(@RequestBody NovoUsuarioDTO novoUsuarioDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/memelandia/novosusuarios")
    List<NovoUsuarioDTO> encontrarTodos();

    @RequestMapping(method = RequestMethod.GET, path = "/memelandia/novosusuarios/{id}")
    NovoUsuarioDTO buscarPeloId(@PathVariable("id") String id);
}
