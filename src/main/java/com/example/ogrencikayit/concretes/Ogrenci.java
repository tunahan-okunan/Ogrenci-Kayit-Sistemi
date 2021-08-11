package com.example.ogrencikayit.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name= "ogrenci")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","dersList"})
public class Ogrenci {

	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "adi")
	private String adi;

	@Column(name = "soyadi")
	private String soyadi;

	@Column(name = "numara")
	private String numara;

	@ManyToMany
	@JoinTable(name = "ogrenci_ders",joinColumns =@JoinColumn(name =  "ogrenci_id"),inverseJoinColumns = @JoinColumn(name = "ders_id"))
	private List<Ders> dersList = new ArrayList<Ders>();
}
