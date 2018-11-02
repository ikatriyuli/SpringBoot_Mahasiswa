package com.ika.spring.RestAPI_Springboot.service.impl;

import com.ika.spring.RestAPI_Springboot.dao.MatakuliahDAO;
import com.ika.spring.RestAPI_Springboot.entity.MataKuliah;
import com.ika.spring.RestAPI_Springboot.service.MahasiswaService;
import com.ika.spring.RestAPI_Springboot.service.MatakuliahService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatakuliahServiceImpl implements MatakuliahService {

    @Autowired
    private MatakuliahDAO matakuliahDAO;

    @Override
    public MataKuliah save(MataKuliah param){
        return matakuliahDAO.save(param);
    }

    @Override
    public MataKuliah update(MataKuliah param) {
        return matakuliahDAO.update(param);
    }

    @Override
    public int delete(MataKuliah param){
        return matakuliahDAO.delete(param);
    }

    @Override
    public List<MataKuliah> find() {
        return matakuliahDAO.find();
    }

    @Override
    public MataKuliah findById(int id_matkul){
        return matakuliahDAO.findById(id_matkul);
    }
}
