package com.example.ogrencikayit.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ogrencikayit.business.abstracts.OgrenciService;
import com.example.ogrencikayit.concretes.Ders;
import com.example.ogrencikayit.concretes.Ogrenci;
import com.example.ogrencikayit.dataAccess.DersDao;
import com.example.ogrencikayit.dataAccess.OgrenciDao;
import com.example.ogrencikayit.utility.ErrorResult;
import com.example.ogrencikayit.utility.Result;
import com.example.ogrencikayit.utility.SuccessResult;

@Service
public class OgrenciManager implements OgrenciService {
	private OgrenciDao ogrenciDao;
	private DersDao dersDao;

	@Autowired
	public OgrenciManager(OgrenciDao ogrenciDao,DersDao dersDao) {
		super();
		this.ogrenciDao = ogrenciDao;
		this.dersDao = dersDao;
	}

	@Override
	public List<Ogrenci> getAll() {
		return ogrenciDao.findAll();
	}

	@Override
	public void addOrUpdate(Ogrenci ogrenci) {
		this.ogrenciDao.save(ogrenci);
	}

	@Override
	public void delete(Ogrenci ogrenci) {
		this.ogrenciDao.delete(ogrenci);
	}

	@Override
	public Result addDers(int ogrenciId, int dersId) {
		Ders ders = null;
		if(dersDao.findById(dersId).isPresent())
			ders = this.dersDao.findById(dersId).get();
		else 
			return new ErrorResult("Böyle bir ders bulunmamaktadır.");

		Ogrenci ogrenci = null;
		if(ogrenciDao.findById(ogrenciId).isPresent())
			ogrenci = this.ogrenciDao.findById(ogrenciId).get();
		else 
			return new ErrorResult("Böyle bir öğrenci bulunmamaktadır.");


		if(ders.getOgrencis().size() <  ders.getKontejan()) {
			ogrenci.getDersList().add(ders);
			this.ogrenciDao.save(ogrenci);
			return new SuccessResult("Ders Eklendi");
		}
		return new ErrorResult("Yeterli Kontejana Ulaşıldığı için ders eklenemedi");
	}

	@Override
	public List<Ders> getDersler(int ogrenciId) {
		Ogrenci ogrenci = null;
		if(ogrenciDao.findById(ogrenciId).isPresent())
			ogrenci = this.ogrenciDao.findById(ogrenciId).get();
		else 
			return null;

		return ogrenci.getDersList();
	}

	@Override
	public void deleteDers(int ogrenciId, int dersId) {
		Ders ders = this.dersDao.findById(dersId).get();
		Ogrenci ogrenci = this.ogrenciDao.findById(ogrenciId).get();
		ogrenci.getDersList().remove(ders);
		this.ogrenciDao.save(ogrenci);
	}

	@Override
	public List<Object[]> getOgrenciWithDers() {
		return this.ogrenciDao.getOgrenciWithDers();
	}

}
