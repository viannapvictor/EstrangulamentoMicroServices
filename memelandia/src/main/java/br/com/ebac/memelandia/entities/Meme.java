package br.com.ebac.memelandia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "categoria_meme_id")
    private CategoriaMeme categoriaMeme;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Meme() {}

}
