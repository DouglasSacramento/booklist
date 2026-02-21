package br.com.dsacramento.booklist.entity;

import br.com.dsacramento.booklist.enums.StatusLivro;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_livros")
@SequenceGenerator(name = "seq_livros", sequenceName = "seq_livros", initialValue = 1, allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livros")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private String autor;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Integer paginas;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private Instant dataCriacao;

    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private Instant dataAtualizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status_livro")
    private StatusLivro statusLivro;

    @ManyToOne
    @JoinColumn(
            name = "pessoa_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "pessoa_fk")
    )
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_livros_categorias",
            joinColumns = @JoinColumn(
                    name = "livro_id",
                    foreignKey = @ForeignKey(name = "livro_categoria_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "categoria_id",
                    foreignKey = @ForeignKey(name = "categoria_livro_fk")
            )
    )
    private Set<Categoria> categorias = new HashSet<>();

}
