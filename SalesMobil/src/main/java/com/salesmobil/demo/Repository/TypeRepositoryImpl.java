package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("TypeRepository")
public class TypeRepositoryImpl implements TypeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Type> findAll() {
        return jdbcTemplate.query("select * from tbl_type",
                (rs, rowNum)->
                        new Type(
                                rs.getString("idType"),
                                rs.getString("namaType")
                        )
        );
    }
    // Add new customer
    public void addType(Type type) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        jdbcTemplate.update("INSERT INTO tbl_type(idType,namaType) VALUES (?,?)",
                randomUUIDString,type.getNamaType());
    }
    // update new customer
    public void updateType(Type type) {
        jdbcTemplate.update("UPDATE tbl_type SET namaType= ?",
                type.getNamaType());
    }

    public Type findById(String idType){
        String sql = "select * from tbl_type WHERE idType='"+idType+"'";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum)->
                        new Type(
                                rs.getString("idType"),
                                rs.getString("namaType")
                        )
        );
    }
    public List<Type> findByName(String namaType){
        return jdbcTemplate.query("Select * FROM tbl_type where namaType like ?",
                new Object[]{"%"+namaType+"%"},
                (rs, rowNum)->
                        new Type(
                                rs.getString("idType"),
                                rs.getString("namaType")
                        )
        );
    }

    public void deleteTypeById(String idType){
        jdbcTemplate.execute(" DELETE FROM tbl_type WHERE idType='"+idType+"'");
    }
    public void deleteAllType(){
        jdbcTemplate.execute(" DELETE FROM tbl_type");
    }
}

