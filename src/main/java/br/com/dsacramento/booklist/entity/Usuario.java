package br.com.dsacramento.booklist.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuarios")
@SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", allocationSize = 1, initialValue = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false,
            unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    // atualizar esse campo manualmente no seu Service toda vez que o usuário autenticar com sucesso.
    @Column(name = "ultimo_login")
    private Instant ultimoLogin;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_usuarios_roles",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {"usuario_id", "role_id"},
                    name = "unique_role_user"
            ),
            joinColumns = @JoinColumn(
                    name = "usuario_id",
                    foreignKey = @ForeignKey(name = "usuario_role_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    foreignKey = @ForeignKey(name = "role_usuario_fk")

            )
    )
    private Set<Role> roles = new HashSet<>();
}
