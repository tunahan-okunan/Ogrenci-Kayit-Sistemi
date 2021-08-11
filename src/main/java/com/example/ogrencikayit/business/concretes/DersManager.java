package com.example.ogrencikayit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ogrencikayit.business.abstracts.DersService;
import com.example.ogrencikayit.concretes.Ders;
import com.example.ogrencikayit.concretes.Ogrenci;
import com.example.ogrencikayit.dataAccess.DersDao;



@Service
public class DersManager implements DersService {

	private DersDao dersDao;
	@Autowired
	public DersManager(DersDao dersDao) {
		super();
		this.dersDao = dersDao;
	}

	@Override
	public List<Ders> getAll() {
		return  dersDao.findAll();
	}

	@Override
	public void addOrUpdate(Ders ders) {
        this.dersDao.save(ders);
	}

	@Override
	public void delete(Ders ders) {
        this.dersDao.delete(ders);
	}

	@Override
	public List<Ogrenci> getOgrenciler(int dersId) {
		Ders ders = this.dersDao.findById(dersId).get();
		return ders.getOgrencis();
	}

}
