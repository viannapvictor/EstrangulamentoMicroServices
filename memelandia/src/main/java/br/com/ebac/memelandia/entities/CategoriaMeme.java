package br.com.ebac.memelandia.entities;

import br.com.ebac.memelandia.dto.usuario.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class CategoriaMeme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categoria_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    public CategoriaMeme() {}
}
