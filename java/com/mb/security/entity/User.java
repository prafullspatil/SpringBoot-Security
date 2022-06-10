package com.mb.security.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@ElementCollection
	@CollectionTable(name = "roles_tbl", joinColumns = @JoinColumn(name = "id"))
	private Set<String> roles;

	public User(long id, String username, String email, String password, Set<String> roles)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Set<String> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<String> roles)
	{
		this.roles = roles;
	}

	// private Set<Role> role = new HashSet<>();

	// @Override
	// public Collection<? extends GrantedAuthority> getAuthorities()
	// {
	//
	// Set<Role> roles = user.getRoles();
	// List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	//
	// for (Role role : roles)
	// {
	// authorities.add(new SimpleGrantedAuthority(role.getName()));
	// }
	//
	// return authorities;
	// }
	//
	// @Override
	// public boolean isAccountNonExpired()
	// {
	//
	// return true;
	// }
	//
	// @Override
	// public boolean isAccountNonLocked()
	// {
	//
	// return true;
	// }
	//
	// @Override
	// public boolean isCredentialsNonExpired()
	// {
	//
	// return true;
	// }
	//
	// @Override
	// public boolean isEnabled()
	// {
	//
	// return true;
	// }
}
