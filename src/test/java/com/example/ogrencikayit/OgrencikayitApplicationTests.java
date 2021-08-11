package com.example.ogrencikayit;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.ogrencikayit.business.abstracts.OgrenciService;
import com.example.ogrencikayit.concretes.Ogrenci;
import com.example.ogrencikayit.dataAccess.OgrenciDao;

@SpringBootTest
class OgrencikayitApplicationTests {


//    @Autowired
//    private OgrenciService ogrenciService;
//
//    @Autowired
//    private OgrenciDao ogrenciDao;

	@BeforeEach
	public void setUp() {
		System.out.println("setUp");
	}

	@Test
	void contextLoads() {
//		System.out.println("contextLoads");
//		List<Ogrenci> list = ogrenciDao.findAll();
//		
//		list.forEach(ogrenci -> System.out.println(ogrenci.getAdi()));
//
//	    Mockito.when(ogrenciDao.findAll());

	}
	

}
