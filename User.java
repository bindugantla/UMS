package org.jsp.ums;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Cacheable
public class User
{
	@Id
	@GeneratedValue
  private int id;
  private String name;
  private String username;
  private String email;
  private long phone;
  private String password;
  public User()
  {
	  
  }
  
public User(int id, String name, String username, String email, long phone, String password)
{
	super();
	this.id = id;
	this.name = name;
	this.username = username;
	this.email = email;
	this.phone = phone;
	this.password = password;
}
public int getId() 
{
	return id;
}
public void setId(int id)
{
	this.id = id;
}
public String getName() 
{
	return name;
}
public void setName(String name) 
{
	this.name = name;
}
public String getUserName() 
{
	return username;
}
public void setUserName(String userName) 
{
	this.username = userName;
}
public String getEmail() 
{
	return email;
}
public void setEmail(String email) 
{
	this.email = email;
}
public long getPhone() 
{
	return phone;
}
public void setPhone(long phone) 
{
	this.phone = phone;
}
public String getPassword() 
{
	return password;
}
public void setPassword(String password)
{
	this.password = password;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", userName=" + username + ", email=" + email + ", phone=" + phone
			+ ", password=" + password + "]";
}
  
  
}
