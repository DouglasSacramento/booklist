package br.com.dsacramento.booklist.service;

import br.com.dsacramento.booklist.dto.JwtResponse;
import br.com.dsacramento.booklist.dto.LoginRequest;
import br.com.dsacramento.booklist.dto.RegisterRequest;
import br.com.dsacramento.booklist.entity.RefreshToken;
import br.com.dsacramento.booklist.entity.Role;
import br.com.dsacramento.booklist.entity.Usuario;
import br.com.dsacramento.booklist.repository.RoleRepository;
import br.com.dsacramento.booklist.repository.UsuarioRepository;
import br.com.dsacramento.booklist.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final LoginHistoryService loginHistoryService;
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public JwtResponse login(LoginRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(), request.senha()
                        )
                );

        CustomUserDetails user =
                (CustomUserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken =
                refreshTokenService.create(user.getId());

        loginHistoryService.save(user, accessToken);

        return new JwtResponse(accessToken, refreshToken.getToken());
    }

    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.email()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setCpf(request.cpf());
        usuario.setNome(request.nome());
        usuario.setDataNasc(request.dataNasc());
        usuario.setEmail(request.email());
        usuario.setSenha(passwordEncoder.encode(request.senha()));
        usuario.setAtivo(Boolean.TRUE);

        Role userRole = roleRepository.findByNome("ROLE_USUARIO")
                        .orElseThrow(() -> new RuntimeException("Erro: Role ROLE_USUARIO não encontrada no sistema!"));

        usuario.getRoles().add(userRole);

        userRepository.save(usuario);
    }
}
