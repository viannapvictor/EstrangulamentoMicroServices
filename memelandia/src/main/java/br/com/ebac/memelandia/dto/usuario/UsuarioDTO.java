package br.com.ebac.memelandia.dto.usuario;

import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

@Getter
public class UsuarioDTO implements Serializable {
    private final Long id;
    private final String nome;
    private final String email;
    private final Date dataCadastro;
    private String idNovoUsuario;

    public UsuarioDTO(Long id, String nome, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public void setIdNovoUsuario(String idNovoUsuario) {
        this.idNovoUsuario = idNovoUsuario;
    }
}
