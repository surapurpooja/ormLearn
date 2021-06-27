package com.cognizant.ormlearn.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "country")
public class Country {

	@Id
	@Column(name = "co_code")
	private String code;

	@NonNull
	@Column(name = "co_name")
	private String name;

}
