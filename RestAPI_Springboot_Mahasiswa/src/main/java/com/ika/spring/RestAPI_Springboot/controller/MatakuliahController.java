package com.ika.spring.RestAPI_Springboot.controller;

import com.ika.spring.RestAPI_Springboot.entity.MataKuliah;
import com.ika.spring.RestAPI_Springboot.service.MatakuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MatakuliahController {

    @Autowired
    private MatakuliahService service;

    @GetMapping(value = "/matakuliah")
    public List<MataKuliah> matakuliah() {
        return service.find();
    }

    @GetMapping (value = "/matakuliah/{id_matkul}")
    public MataKuliah findById(@PathVariable("id_matkul") Integer id_matkul){
        return service.findById(id_matkul);
    }

    @PostMapping (value = "/matakuliah")
    public String save(@RequestBody MataKuliah mataKuliah){
        MataKuliah data = service.save(mataKuliah);
        if (data.getId_matkul()==0) {
            return "gagal insert";
        } else {
            return "berhasil insert";
        }
    }

    @PutMapping (value = "/matakuliah")
    public String update (@RequestBody MataKuliah mataKuliah){
        MataKuliah data = service.update(mataKuliah);
        if (data.getId_matkul()== 0) {
            return "gagal update";
        } else {
            return "update berhasil";
        }
    }

    @DeleteMapping (value = "/matakuliah/{id_matkul}")
    public String delete (@PathVariable("id_matkul") Integer id_matkul){
        int data = service.delete(new MataKuliah(id_matkul));
        if (data == 0) {
            return "gagal delete";
        } else {
            return "delete berhasil";
        }
    }

    }
