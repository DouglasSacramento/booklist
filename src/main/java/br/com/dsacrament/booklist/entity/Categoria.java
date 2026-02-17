package br.com.dsacrament.booklist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_categorias")
@SequenceGenerator(name = "seq_categorias", sequenceName = "seq_categorias", allocationSize = 1, initialValue = 1)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categorias")
    private Long id;

    @Column(name = "nome_desc", nullable = false, unique = true, length = 50)
    private String nomeDesc;
}
