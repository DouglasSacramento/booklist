package br.com.dsacrament.booklist.entity;

import br.com.dsacrament.booklist.enums.StatusLivro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tb_livros")
@SequenceGenerator(name = "seq_livros", sequenceName = "seq_livros", initialValue = 1, allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livro implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livros")
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private String autor;

    @Column(name = "image_url")
    private String imageUrl;

    private String isbn;

    @Column(nullable = false)
    private int paginas;

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
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_livros_categorias",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

}
