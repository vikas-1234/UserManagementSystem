package com.example.demo.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetails {
	
	public Collection<? extends GrantedAuthority> getAuthorities();
	
	public String getPassword();
	
	public String getUserName();
	
	public boolean isAccountNonExpired();
	
	public boolean isAccountNonLocked();

	public boolean isCredentialsNonExpired();
	
	public boolean isEnabled();
}
