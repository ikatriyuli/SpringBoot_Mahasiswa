package com.ika.spring.RestAPI_Springboot.entity;

import java.io.Serializable;

public class MataKuliah implements Serializable {

    private int id_matkul;
    private String nama_matkul;
    private  String sks;

    public MataKuliah() {
        this.id_matkul=id_matkul;
    }

    public MataKuliah (int id_matkul){
        this.id_matkul=id_matkul;
    }
    public MataKuliah (String nama_matkul, String sks){
        this.nama_matkul=nama_matkul;
        this.sks=sks;
    }

    public int getId_matkul() {
        return id_matkul;
    }

    public void setId_matkul(int id_matkul){
        this.id_matkul=id_matkul;
    }

    public String getNama_matkul() {
        return nama_matkul;

    }

    public void setNama_matkul(String nama_matkul){
        this.nama_matkul=nama_matkul;
    }
    public String getSks(){
        return sks;
    }
    public void setSks(String sks){
        this.sks=sks;
    }

    @Override
    public String toString() {
        return "Matakuliah(" +
                "id_matkul=" + id_matkul +
                ",nama_matkul='" + nama_matkul +'\'' +
                ",sks='" + sks + '\'' +
                ')';

    }

}
