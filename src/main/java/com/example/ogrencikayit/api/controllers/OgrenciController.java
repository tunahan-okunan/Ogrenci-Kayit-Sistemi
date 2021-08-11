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

import com.example.ogrencikayit.business.abstracts.OgrenciService;
import com.example.ogrencikayit.concretes.Ders;
import com.example.ogrencikayit.concretes.Ogrenci;
import com.example.ogrencikayit.utility.Result;

@RestController
@RequestMapping(value = "/api/ogrenci")
@CrossOrigin
public class OgrenciController {
	private OgrenciService ogrenciService;
	@Autowired
	public OgrenciController(OgrenciService ogrenciService) {
		super();
		this.ogrenciService = ogrenciService;
	}
	
	//Tüm öğrencilerin listelenmesi
	@GetMapping("/getall")
	public List<Ogrenci> getAll(){
		return ogrenciService.getAll();
	}
	
	//Öğrenci Ekleme veya Güncelleme
	@PostMapping("/addOrUpdate")
	public void addOrUpdate(@RequestBody Ogrenci ogrenci) {
		ogrenciService.addOrUpdate(ogrenci);
	}
	
	//Öğrenciye ders ekleme işlemi
	@PostMapping("/addDers")
	public Result addDers(@RequestParam("ogrenciId") int ogrenciId,@RequestParam("dersId") int dersId) {
		return ogrenciService.addDers(ogrenciId, dersId);
	}
	//Öğrenciye ders silme işlemi
	@PostMapping("/deleteDers")
	public void deleteDers(@RequestParam("ogrenciId") int ogrenciId,@RequestParam("dersId") int dersId) {
		ogrenciService.deleteDers(ogrenciId, dersId);
	}

	//Öğrenci Silme
	@PostMapping("/delete")
	public void delete(@RequestBody Ogrenci ogrenci) {
		ogrenciService.delete(ogrenci);
	}
	
	//Öğrenciye ait dersleri listeleme
	@GetMapping("/getDers")
	public List<Ders> getDers(@RequestParam("ogrenciId") int ogrenciId) {
		return ogrenciService.getDersler(ogrenciId);
	}

	//Tüm Öğrencilerin aldığı tüm derslerin listelenmesi
	@GetMapping("/getOgrenciWithDers")
	public List<Object[]> getOgrenciWithDers() {

		return 	this.ogrenciService.getOgrenciWithDers();
	}
}
