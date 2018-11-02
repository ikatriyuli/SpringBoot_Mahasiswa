package com.ika.spring.RestAPI_Springboot.entity;

import java.io.Serializable;
import java.util.List;


public class Mahasiswa implements Serializable {

    private int id;
    private String nama;
    private String alamat;

    public Mahasiswa(int id) {
        this.id = id;
    }

    public Mahasiswa (String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
    }



    public Mahasiswa(){

    }

   public int getId() {
        return id;
   }
   public void setId(int id){
        this.id=id;
   }

   public String getNama(){
        return nama;
   }
   public void setNama(String nama){
        this.nama=nama;
   }
   public String getAlamat(){
        return alamat;
   }
   public void setAlamat(String alamat){
        this.alamat=alamat;
   }


    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + id +
                ", nama='" + nama +
                ", alamat='" + alamat + '\'' +
                '}';
    }


}

