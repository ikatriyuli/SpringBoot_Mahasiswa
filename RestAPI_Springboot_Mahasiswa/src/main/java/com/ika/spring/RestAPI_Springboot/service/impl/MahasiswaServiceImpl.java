package com.ika.spring.RestAPI_Springboot.service.impl;

import com.ika.spring.RestAPI_Springboot.dao.MahasiswaDAO;
import com.ika.spring.RestAPI_Springboot.entity.Mahasiswa;
import com.ika.spring.RestAPI_Springboot.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaDAO mahasiswaDAO;

    @Override
    public Mahasiswa save(Mahasiswa param){
        return mahasiswaDAO.save(param);
    }
    @Override
    public  Mahasiswa update (Mahasiswa param){
        return mahasiswaDAO.update(param);
    }

    @Override
    public int delete (Mahasiswa param){
        return mahasiswaDAO.delete(param);
    }

    @Override
    public List<Mahasiswa> find(){
        return mahasiswaDAO.find();
    }

    @Override
    public Mahasiswa findById(int id) {
        return mahasiswaDAO.findById(id);
    }




}
