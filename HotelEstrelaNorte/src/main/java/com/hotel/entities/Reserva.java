package com.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserva_id", nullable = false)
	private Long id;

	@Column(name = "data",nullable = false, length = 100)
	private String data;
	
	@ManyToOne
	@JoinColumn(name = "hospede_id", nullable = false)
	private Hospede hospede;

	@OneToOne
	@JoinColumn(name = "quarto_id", nullable = false)
	private Quarto quarto;
}
