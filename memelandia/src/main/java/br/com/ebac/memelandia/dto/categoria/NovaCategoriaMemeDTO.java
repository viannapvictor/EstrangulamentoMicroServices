package br.com.ebac.memelandia.dto.categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@AllArgsConstructor
public class NovaCategoriaMemeDTO implements Serializable {

    private final String id;

    private final String nome;

    private final String descricao;

    private final Date dataCadastro;
}
