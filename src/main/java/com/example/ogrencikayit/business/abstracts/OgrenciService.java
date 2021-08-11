package com.example.ogrencikayit.business.abstracts;

import java.util.List;

import com.example.ogrencikayit.concretes.Ders;
import com.example.ogrencikayit.concretes.Ogrenci;
import com.example.ogrencikayit.utility.Result;

public interface OgrenciService {
	 List<Ogrenci>  getAll();
	 void addOrUpdate(Ogrenci ogrenci);
	 Result addDers(int ogrenciId,int dersId);
	 void deleteDers(int ogrenciId,int dersId);
	 void delete(Ogrenci ogrenci);
	 List<Ders> getDersler(int ogrenciId);
	 List<Object[]> getOgrenciWithDers();

}
