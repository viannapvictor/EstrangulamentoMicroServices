package br.com.ebac.usuariosmemelandia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    @Id
    private String id;

    private String nome;

    private String email;

    private Date dataCadastro;

    public Usuario() {};

    @PrePersist
    public void idCreate() {
        this.id = UUID.randomUUID().toString();
    }
}
