package com.easybank.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.easybank.api.model.Customer;
import com.easybank.api.model.Role;
import com.easybank.api.repo.CustomerRepository;

@Component
public class CustomAuthentication implements AuthenticationProvider {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Customer customer = customerRepository.findByname(username);

		if (encoder.matches(pwd, customer.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(customer.getRoles()));
		} else {
			throw new BadCredentialsException("Invalid password!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
	}

	private List<GrantedAuthority> getGrantedAuthorities(Set<Role> roles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return grantedAuthorities;

	}

}
