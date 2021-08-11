package com.example.ogrencikayit.business.abstracts;

import java.util.List;

import com.example.ogrencikayit.concretes.Ders;
import com.example.ogrencikayit.concretes.Ogrenci;


public interface DersService {
	 List<Ders>  getAll();
	 void addOrUpdate(Ders ders);
	 void delete(Ders ders);
	 List<Ogrenci> getOgrenciler(int dersId);

}
