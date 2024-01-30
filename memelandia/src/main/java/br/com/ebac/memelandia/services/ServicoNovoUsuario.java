package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.client.ClienteFeignNovoUsuario;
import br.com.ebac.memelandia.controllers.UsuarioController;
import br.com.ebac.memelandia.dto.usuario.NovoUsuarioDTO;
import br.com.ebac.memelandia.dto.usuario.UsuarioDTO;
import br.com.ebac.memelandia.utils.UsuarioUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicoNovoUsuario {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoNovoUsuario.class);

    @Value("${applicationusers.url:}")
    private  String urlServico;

    private final ClienteFeignNovoUsuario clienteFeignNovoUsuario;

    public ServicoNovoUsuario(ClienteFeignNovoUsuario clienteFeignNovoUsuario) {
        this.clienteFeignNovoUsuario = clienteFeignNovoUsuario;
    }

    public UsuarioDTO criarNovoUsuario(UsuarioDTO usuarioDTO) {
        if (urlServico.length() > 0) {
            NovoUsuarioDTO novoUsuarioDTO = UsuarioUtils.outputToNovoUsuario(usuarioDTO);
            novoUsuarioDTO = clienteFeignNovoUsuario.criarNovoUsuario(novoUsuarioDTO);
            LOGGER.info("Criando novo User via FeignClient .......");
            return UsuarioUtils.inputFromNovoUsuario(novoUsuarioDTO);
        }
        return null;
    }

    public Iterable<UsuarioDTO> encontrarTodos() {
        List<NovoUsuarioDTO> novoUsuarioDTOList = clienteFeignNovoUsuario.encontrarTodos();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

        for (NovoUsuarioDTO novoUsuarioDTO : novoUsuarioDTOList) {
            usuarioDTOList.add(UsuarioUtils.inputFromNovoUsuario(novoUsuarioDTO));
        }
        return usuarioDTOList;
    }

    public UsuarioDTO buscarPeloId(String id) {
        List<NovoUsuarioDTO> novoUsuarioDTOList = clienteFeignNovoUsuario.encontrarTodos();
        UsuarioDTO usuarioDTO = null;

        for (NovoUsuarioDTO novoUsuarioDTO : novoUsuarioDTOList) {
            if (novoUsuarioDTO.getId().equalsIgnoreCase(id)) {
                usuarioDTO = UsuarioUtils.inputFromNovoUsuario(novoUsuarioDTO);
            }
        }
        return usuarioDTO;
    }
}
