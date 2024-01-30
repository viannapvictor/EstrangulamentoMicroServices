package br.com.ebac.memelandia.dto.categoria;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

@Getter

public class CategoriaMemeDTO implements Serializable {

    private final Long id;

    private final String nome;

    private final String descricao;

    private final Date dataCadastro;

    private String idNovaCategoria;

    public CategoriaMemeDTO(Long id, String nome, String descricao, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public void setIdNovoUsuario(String idNovoUsuario) {
        this.idNovaCategoria = idNovoUsuario;
    }
}
