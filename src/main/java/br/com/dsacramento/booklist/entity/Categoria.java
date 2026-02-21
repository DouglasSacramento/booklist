package br.com.dsacramento.booklist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_categorias")
@SequenceGenerator(name = "seq_categorias", sequenceName = "seq_categorias", allocationSize = 1, initialValue = 1)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categorias")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome_desc",
            nullable = false,
            unique = true, length = 50)
    private String nomeDesc;
}
