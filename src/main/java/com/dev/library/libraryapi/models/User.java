package com.dev.library.libraryapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore; // Importante!
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    
    @JsonIgnore // Impede que a senha apareça em qualquer lugar
    private String password;
    private String role;

    @Override
    @JsonIgnore // O Swagger vai parar de tentar ler as permissões aqui
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if("ADMIN".equals(this.role)) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override public String getPassword() { return password; }
    @Override public String getUsername() { return login; }

    @Override @JsonIgnore public boolean isAccountNonExpired() { return true; }
    @Override @JsonIgnore public boolean isAccountNonLocked() { return true; }
    @Override @JsonIgnore public boolean isCredentialsNonExpired() { return true; }
    @Override @JsonIgnore public boolean isEnabled() { return true; }
    
    // Getter para o login (TokenService)
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}