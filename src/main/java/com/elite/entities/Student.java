package com.elite.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
@Entity
public class Student { // POJO
	// boilerplate code
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(nullable = false)
@NotBlank
private String nom;
@Min(value = 18)
@Max(value = 35)
private int age;
@Temporal(TemporalType.DATE)
@Past
private Date dateNaissance;
@Column(unique = true)
@Email
private String email;
private String password;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(long id, String nom, @Min(18) @Max(35) int age, @Email String email, String password) {
	super();
	this.id = id;
	this.nom = nom;
	this.age = age;
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "Student [id=" + id + ", nom=" + nom + ", age=" + age + ", email=" + email + ", password=" + password + "]";
}
@Override
public int hashCode() {
	return Objects.hash(age, email, id, nom, password);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	return age == other.age && Objects.equals(email, other.email) && id == other.id && Objects.equals(nom, other.nom)
			&& Objects.equals(password, other.password);
}




}
