package com.mph.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@NotNull(message = "First name cannot be null")
	@Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@NotNull(message = "Last name cannot be null")
	@Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@Column(name = "password", nullable = false)
	private String password;

	@Past(message = "Date of birth must be in the past")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@NotNull(message = "Gender cannot be null")
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
	@Column(name = "gender", nullable = false)
	private String gender;

	@Min(value = 0, message = "Salary must be positive")
	@Max(value = 1000000, message = "Salary must not exceed 1 million")
	@Column(name = "salary")
	private Double salary;

	@NotNull(message = "Phone number cannot be null")
	@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Phone number should be valid")
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@AssertTrue(message = "Terms must be accepted")
	@Column(name = "accepted_terms")
	private Boolean acceptedTerms;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getAcceptedTerms() {
		return acceptedTerms;
	}

	public void setAcceptedTerms(Boolean acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", salary="
				+ salary + ", phoneNumber=" + phoneNumber + ", acceptedTerms=" + acceptedTerms + "]";
	}
}
