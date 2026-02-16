package br.com.dsacrament.booklist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuarios")
@SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", allocationSize = 1, initialValue = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

    @CreatedDate
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
}
