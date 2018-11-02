package com.ika.spring.RestAPI_Springboot.dao.impl;

import com.ika.spring.RestAPI_Springboot.dao.MatakuliahDAO;
import com.ika.spring.RestAPI_Springboot.entity.MataKuliah;
import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class MatakuliahDAOImpl implements MatakuliahDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MataKuliah save(MataKuliah param){
        String sql = "INSERT INTO " + Table.TABLE_MATKUL + "(nama_matkul, sks) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama_matkul());
            ps.setString(2, param.getSks());
            return ps;
        }, keyHolder);

        param.setId_matkul(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;

        @Override
        public MataKuliah update(MataKuliah param){
            String sql = "UPDATE " + Table.TABLE_MATKUL + "SET " +
                    "nama_matkul = ?, " +
                    "sks = ? " +
                    "WHERE id_matkul = ? ";

            jdbcTemplate.update(sql,
                    param.getNama_matkul()),
                    param.getSks(),
                    param.getId_matkul());

            return param;
        }
        @Override
                public int delete(MataKuliah param){
            String sql = "DELETE FROM " + Table.TABLE_MATKUL + " WHERE id_matkul = ? ";

            final int delete = jdbcTemplate.update(sql, param.getId_matkul());
            return delete;
        }

        @Override
                public List<MataKuliah> find() {
            String sql = "SELECT * FROM " + Table.TABLE_MATKUL;

            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MataKuliah.class), id_matkul);
        }

        @Override
                public MataKuliah findById (int id_matkul) {
            String sql = "SELECT * FROM " + Table.TABLE_MATKUL + " WHERE id_matkul = ?";

            try {
                return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(MataKuliah.class), id_matkul);
            } catch (EmptyResultDataAccessException ignored){

            }

            return null;




    }
}