package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Merk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("MerkRepository")
public class MerkRepositoryImpl implements MerkRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Merk> findAll() {
        return jdbcTemplate.query("select * from tbl_merk",
                (rs, rowNum)->
                        new Merk(
                                rs.getString("idMerk"),
                                rs.getString("namaMerk")
                        )
        );
    }
    // Add new customer
    public void addMerk(Merk merk) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        jdbcTemplate.update("INSERT INTO tbl_merk(idmerk,namaMerk) VALUES (?,?)",
                randomUUIDString,merk.getNamaMerk());
    }
    // update new customer
    public void updateMerk(Merk merk) {
        jdbcTemplate.update("UPDATE tbl_merk SET namaMerk= ? Where idMerk=?",
                merk.getNamaMerk(), merk.getIdMerk());
    }

    public Merk findById(String idMerk){
        String sql = "select * from tbl_merk WHERE idMerk='"+idMerk+"'";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum)->
                        new Merk(
                                rs.getString("idMerk"),
                                rs.getString("namaMerk")
                        )
        );
    }
    public List<Merk> findByName(String namaMerk){
        return jdbcTemplate.query("Select * FROM tbl_merk where namaMerk like ?",
                new Object[]{"%"+namaMerk+"%"},
                (rs, rowNum)->
                        new Merk(
                                rs.getString("idMerk"),
                                rs.getString("namaMerk")
                        )
        );
    }

    public void deleteMerkById(String idMerk){
        jdbcTemplate.execute(" DELETE FROM tbl_merk WHERE idMerk='"+idMerk+"'");
    }
    public void deleteAllMerk(){
        jdbcTemplate.execute(" DELETE FROM tbl_merk");
    }
}
