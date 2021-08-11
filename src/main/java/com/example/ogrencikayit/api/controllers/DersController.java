package com.example.ogrencikayit.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ogrencikayit.business.abstracts.DersService;
import com.example.ogrencikayit.concretes.Ders;
import com.example.ogrencikayit.concretes.Ogrenci;


@RestController
@RequestMapping(value = "/api/ders")
@CrossOrigin
public class DersController {

	private DersService dersService;
	@Autowired
	public DersController(DersService dersService) {
		super();
		this.dersService = dersService;
	}
	
	//Tüm derslerin listelenmesi
	@GetMapping("/getall")
	public List<Ders> getAll(){
		return dersService.getAll();
	}
	
	//Ders Ekleme veya Güncelleme
	@PostMapping("/addOrUpdate")
	public void addOrUpdate(@RequestBody Ders ders) {
		dersService.addOrUpdate(ders);
	}
	//Silme İşlemi
	@PostMapping("/delete")
	public void delete(@RequestBody Ders ders) {
		dersService.delete(ders);
	}
	
	//Derse ait Tüm öğrenciler listelenmesi
	@GetMapping("/getOgrenciler")
	public List<Ogrenci> getOgrenciler(@RequestParam("dersId") int dersId) {
		return dersService.getOgrenciler(dersId);
	}
}
