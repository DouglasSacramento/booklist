package br.com.dsacrament.booklist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_pessoas")
@SequenceGenerator(name = "seq_pessoas", sequenceName = "seq_pessoas", allocationSize = 1, initialValue = 1)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoas")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,
            name = "data_nasc")
    private LocalDate dataNasc;

    @Column(nullable = false,
            unique = true)
    private String cpf;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private Instant dataCriacao;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Livro> livros;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "usuario_fk")
    )
    private Usuario usuario;
}
