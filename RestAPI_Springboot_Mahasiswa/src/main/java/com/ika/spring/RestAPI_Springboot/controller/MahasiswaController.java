package com.ika.spring.RestAPI_Springboot.controller;

import com.ika.spring.RestAPI_Springboot.entity.Mahasiswa;
import com.ika.spring.RestAPI_Springboot.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MahasiswaController {

    @Autowired
    private MahasiswaService service;

    @GetMapping(value = "/mahasiswa")
    public List<Mahasiswa> mahasiswa(){
    return service.find();
    }

    @GetMapping(value = "/mahasiswa")
    public Mahasiswa findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping(value = "/mahasiswa")
    public String save(@RequestBody Mahasiswa mahasiswa){
        Mahasiswa data = service.save(mahasiswa);
        if (data.getId() == 0) {
            return "gagal insert data";
        } else {
            return "insert berhasil";
        }
    }

    @PutMapping(value = "/mahasiswa")
    public  String update(@RequestBody Mahasiswa mahasiswa){
        Mahasiswa data= service.update(mahasiswa);
        if (data.getId()==0) {
            return "gagal update";
        } else {
            return "update berhasil";
        }
    }

    @DeleteMapping(value = "/mahasiswa/{id}")
    public String delete(@PathVariable("id") Integer id){
        int data = service.delete(new Mahasiswa(id));
        if (data == 0) {
            return "gagal delete";
        } else {
            return "delete berhasil";
        }
    }
}