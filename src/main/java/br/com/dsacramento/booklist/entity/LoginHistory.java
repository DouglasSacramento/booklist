package br.com.dsacramento.booklist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_login_history")
@SequenceGenerator(name = "seq_login_history", sequenceName = "seq_login_history", allocationSize = 1, initialValue = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login_history")
    @EqualsAndHashCode.Include
    private Long id;

    private Long userId;

    private String email;

    private String accessToken;

    @CreationTimestamp
    private LocalDateTime loginAt;
}
