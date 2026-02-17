package br.com.dsacrament.booklist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Entity
@Table(name = "tb_roles")
@SequenceGenerator(name = "seq_roles", sequenceName = "seq_roles", allocationSize = 1, initialValue = 1)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_roles")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome_desc", nullable = false, unique = true, length = 50)
    private String nomeDesc;

    @Override
    public String getAuthority() {
        return this.nomeDesc;
    }
}
