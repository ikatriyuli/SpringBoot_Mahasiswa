package com.ika.spring.RestAPI_Springboot.dao.impl;


import com.ika.spring.RestAPI_Springboot.common.Tabel;
import com.ika.spring.RestAPI_Springboot.dao.MahasiswaDAO;
import com.ika.spring.RestAPI_Springboot.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mahasiswa save(Mahasiswa param){
        String sql = "INSERT INTO " + Tabel.TABLE_MAHASISWA + "(nama,alamat) VALUES (?, ?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama());
            ps.setString(2, param.getAlamat());
            return ps;
        }, keyHolder);

        param.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        return null;
    }

    @Override
    public int delete(Mahasiswa param) {
        return 0;
    }

    @Override
    public List<Mahasiswa> find() {
        String sql = "SELECT * FROM " + Tabel.TABLE_MAHASISWA;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public Mahasiswa findById(int id) {
        return null;
    }

}


