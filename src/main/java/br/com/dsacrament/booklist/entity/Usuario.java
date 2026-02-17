package br.com.dsacrament.booklist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", allocationSize = 1, initialValue = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    // atualizar esse campo manualmente no seu Service toda vez que o usuário autenticar com sucesso.
    @Column(name = "ultimo_login")
    private Instant ultimoLogin;

    @OneToOne(mappedBy = "usuario")
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
                    foreignKey = @ForeignKey(name = "fk_usuario_role")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    foreignKey = @ForeignKey(name = "fk_role_usuario")

            )
    )
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public @Nullable String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
