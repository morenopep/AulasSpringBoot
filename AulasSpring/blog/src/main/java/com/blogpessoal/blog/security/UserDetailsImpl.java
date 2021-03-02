package com.blogpessoal.blog.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blogpessoal.blog.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	
	private static final Long serialVersionUID = 1L;
	
	private String username;
	
	private String password;
	
	public UserDetailsImpl() {}
	
	public UserDetailsImpl(Usuario user) {
		this.username = user.getNome();
		this.password = user.getSenha();
	} 
	
	@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return null;
		}

	@Override
		public String getPassword() {
			return password;
		}

	@Override
		public String getUsername() {
			return username;
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
