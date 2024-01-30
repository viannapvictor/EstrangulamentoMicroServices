package br.com.ebac.categoriasmemelandia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Categoria {
    @Id
    private String id;

    private String nome;

    private String descricao;

    private Date dataCadastro;

    private Long usuario_id;

    public Categoria() {};

    @PrePersist
    public void idCreate() {
        this.id = UUID.randomUUID().toString();
    }
}
