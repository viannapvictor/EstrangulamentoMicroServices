package br.com.ebac.memelandia.client;

import br.com.ebac.memelandia.dto.categoria.NovaCategoriaMemeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "cliente-nova-categoria", url = "http://localhost:8083")
public interface ClienteFeignNovaCategoria {

    @RequestMapping(method = RequestMethod.POST, path = "/memelandia/novascategorias")
    NovaCategoriaMemeDTO criarNovaCategoria(@RequestBody NovaCategoriaMemeDTO novaCategoriaMemeDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/memelandia/novascategorias")
    List<NovaCategoriaMemeDTO> encontrarTodos();
}
