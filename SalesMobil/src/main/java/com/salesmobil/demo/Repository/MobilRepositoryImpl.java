package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Customer;
import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Mobil;
import com.salesmobil.demo.Model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("MobilRepository")
public class MobilRepositoryImpl implements MobilRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Mobil> findAll() {
        List<Mobil> mobilHeaders;
        mobilHeaders = jdbcTemplate.query("select * from tbl_mobil c, tbl_merk d, tbl_type e where c.idMerk=d.idMerk AND c.idType=e.idType ",
                (rs, rowNum)->
                        new Mobil(
                                rs.getString("idMobil"),
                                rs.getString("namaMobil"),
                                rs.getString("namaMerk"),
                                rs.getString("namaType"),
                                rs.getInt("harga"),
                                rs.getInt("tahun")
                        )
        );
        for (Mobil ch : mobilHeaders) {
            ch.setMerkList(jdbcTemplate.query("select * from tbl_merk c, tbl_mobil p where " +
                            "c.idMerk=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getIdMerk()),
                    (rs, rowNum) ->
                            new Merk(
                                    rs.getString("idMerk"),
                                    rs.getString("namaMerk")
                            )));
        }
        return mobilHeaders;
    }
    // Add new customer
    public void addMobil(Mobil mobil) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        jdbcTemplate.update("INSERT INTO tbl_mobil(idMobil,namaMobil,idMerk, idType, harga ,tahun) VALUES (?,?,?,?,?,?)",
                randomUUIDString,mobil.getNamaMobil(),mobil.getIdMerk(),mobil.getIdType(),mobil.getHarga(),mobil.getTahun());
    }
    // update new customer
    public void updateMobil(Mobil mobil) {
        jdbcTemplate.update("UPDATE tbl_mobil SET namaMobil='"+mobil.getNamaMobil()+"',idMerk='"+mobil.getIdMerk()+"',idType='"+mobil.getIdType()+"',harga="+mobil.getHarga()+",Tahun="+mobil.getTahun()+" where idMobil='"+mobil.getIdMobil()+"'");
    }

    public Mobil findById(String idMobil){
        String sql = "select * from tbl_mobil WHERE idMobil='"+idMobil+"'";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum)->
                        new Mobil(
                                rs.getString("idMobil"),
                                rs.getString("namaMobil"),
                                rs.getString("idMerk"),
                                rs.getString("idType"),
                                rs.getInt("harga"),
                                rs.getInt("tahun")
                        )
        );
    }
    public List<Mobil> findByName(String namaMobil){
        return jdbcTemplate.query("Select * FROM tbl_mobil where namaMobil like ?",
                new Object[]{"%"+namaMobil+"%"},
                (rs, rowNum)->
                        new Mobil(
                                rs.getString("idMobil"),
                                rs.getString("namaMobil"),
                                rs.getString("idMerk"),
                                rs.getString("idType"),
                                rs.getInt("harga"),
                                rs.getInt("tahun")
                        )
        );
    }

    public void deleteMobilById(String idMobil){
        jdbcTemplate.execute(" DELETE FROM tbl_mobil WHERE idMobil='"+idMobil+"'");
    }
    public void deleteAllMobil(){
        jdbcTemplate.execute(" DELETE FROM tbl_Mobil");
    }
}
