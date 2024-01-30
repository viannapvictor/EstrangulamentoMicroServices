package br.com.ebac.memelandia.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@AllArgsConstructor
public class NovoUsuarioDTO implements Serializable {
    private final String id;
    private final String nome;
    private final String email;
    private final Date dataCadastro;
}
