package com.kh.cafe.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Cafe")
public class Cafe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cafe_id_sequence")
	@SequenceGenerator(name = "cafe_id_sequence", sequenceName = "cafe_id_sequence", allocationSize = 1)
	@Column(name = "cafe_id")
	private Long cafeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "opening_hours")
	private String openingHours;
}