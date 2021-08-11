package com.example.ogrencikayit.dataAccess;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ogrencikayit.concretes.Ogrenci;



public interface OgrenciDao extends JpaRepository<Ogrenci, Integer>{

	@Query(value = "select o.id as ogr_id ,o.adi as ogr_adi ,o.soyadi as ogr_soyadi ,d.adi as ders_adi from ogrenci_ders as od  "
			+ "inner join ogrenci as o ON o.id = od.ogrenci_id "
			+ "inner join ders as d ON d.id = od.ders_id ",nativeQuery = true)
	List<Object[]> getOgrenciWithDers();

}
