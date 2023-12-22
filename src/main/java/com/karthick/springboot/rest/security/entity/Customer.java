package com.karthick.springboot.rest.security.entity;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	@Column(nullable = false)
	private Long id;
	private String email;
	private String pwd;
	private String role;

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Class<?> oEffectiveClass = obj instanceof HibernateProxy hibernateProxy
				? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
				: obj.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
				? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
				: this.getClass();
		if (thisEffectiveClass != oEffectiveClass)
			return false;
		Customer customer = (Customer) obj;
		return getId() != null && Objects.equals(getId(), customer.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
				? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
				: getClass().hashCode();
	}
}
