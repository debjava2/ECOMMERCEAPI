package com.javatechie.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
@Builder
@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column = @Column(name="gurdian_name")
			),
	@AttributeOverride(
			name = "email",
			column = @Column(name="gurdian_email")
			),
	@AttributeOverride(
			name = "mobile",
			column = @Column(name="gurdian_mobile")
			)
})

public class Guardian {
	private String name;
	private String email;
	private String mobile;
}
