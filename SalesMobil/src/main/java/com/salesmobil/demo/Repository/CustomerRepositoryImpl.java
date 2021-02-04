package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Customer;
import com.salesmobil.demo.Model.Mobil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Repository("CustomerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll(){
        List<Customer> customerHeaders;
        customerHeaders = jdbcTemplate.query("SELECT * FROM tbl_customer",
                (rs, rowNum)->
                        new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        )
        );

        for (Customer ch : customerHeaders) {
            ch.setMobilList(jdbcTemplate.query("select * from tbl_customerdetail c, tbl_mobil p, tbl_merk d, tbl_type e where " +
                            "c.idMobil = p.idMobil AND p.idMerk=d.idMerk AND p.idType=e.idType AND c.idCustomer=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getIdCustomer()),
                    (rs, rowNum) ->
                            new Mobil(
                                    rs.getString("idMobil"),
                                    rs.getString("namaMobil"),
                                    rs.getString("namaMerk"),
                                    rs.getString("namaType"),
                                    rs.getInt("harga"),
                                    rs.getInt("tahun"),
                                    rs.getInt("qty")

                            )));
        }
        return customerHeaders;
    }

    public List<Customer> find(){
        List<Customer> customersHeaders;
        customersHeaders = jdbcTemplate.query("SELECT * FROM tbl_customer ORDER BY tglTransaksi DESC LIMIT 1",
                (rs, rowNum)->
                        new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        )
        );

        for (Customer ch : customersHeaders) {
            ch.setMobilList(jdbcTemplate.query("select * from tbl_customerdetail c, tbl_mobil p, tbl_merk d, tbl_type e where " +
                            "c.idMobil = p.idMobil AND p.idMerk=d.idMerk AND p.idType=e.idType AND c.idCustomer=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getIdCustomer()),
                    (rs, rowNum) ->
                            new Mobil(
                                    rs.getString("idMobil"),
                                    rs.getString("namaMobil"),
                                    rs.getString("namaMerk"),
                                    rs.getString("namaType"),
                                    rs.getInt("harga"),
                                    rs.getInt("tahun"),
                                    rs.getInt("qty")

                            )));
        }
        return customersHeaders;
    }

    public void saveCustomer(Customer customer){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        jdbcTemplate.update("INSERT INTO tbl_customer(idCustomer,namaCustomer,tglTransaksi) VALUES (?,?,?)",
                randomUUIDString,customer.getNamaCustomer(),new Date());
        List<Mobil> mobils = customer.getMobilList();
        for (int i=0; i<mobils.size(); i++){
            Mobil mobil = mobils.get(i);
            UUID uuid1 = UUID.randomUUID();
            String randomUUIDString1 = uuid1.toString();
            jdbcTemplate.update("INSERT INTO tbl_customerdetail(idCustomerDetail, idCustomer,idMobil, qty) VALUES (?,?,?,?)",
                    randomUUIDString1, randomUUIDString, mobils.get(i).getIdMobil(),mobil.getQty());
        }

    }

    public void updateCustomer(Customer customer){

        jdbcTemplate.update("DELETE from tbl_customerdetail WHERE idCustomer=?",customer.getIdCustomer());

        List<Mobil> mobils = customer.getMobilList();
        for (int i=0; i<mobils.size(); i++){
            Mobil mobil = mobils.get(i);
            UUID uuid1 = UUID.randomUUID();
            String randomUUIDString1 = uuid1.toString();
            jdbcTemplate.update("INSERT INTO tbl_customerdetail(idCustomerDetail, idCustomer,idMobil, qty) VALUES (?,?,?,?)",
                    randomUUIDString1, customer.getIdCustomer(), mobils.get(i).getIdMobil(),mobil.getQty());
        }
    }

    @Override
    public Customer findByBulanTahun(int tahunCustomer, String bulanCustomer) {
        Customer customer;
        System.out.println(tahunCustomer);
        System.out.println(bulanCustomer);
        customer =  jdbcTemplate.queryForObject("SELECT * FROM tbl_customer WHERE tglTransaksi LIKE '%"+tahunCustomer+"%-%"+bulanCustomer+"%'",
                (rs,rowNum)->
                        new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        ));

        customer.setMobilList(jdbcTemplate.query("select * from tbl_customerdetail c, tbl_mobil p, tbl_merk d, tbl_type e where " +
                        "c.idMobil = p.idMobil AND p.idMerk=d.idMerk AND p.idType=e.idType AND c.idCustomer=?",
                preparedStatement -> preparedStatement.setString(1,customer.getIdCustomer()),
                (rs, rowNum) ->
                        new Mobil(
                                rs.getString("idMobil"),
                                rs.getString("namaMobil"),
                                rs.getString("namaMerk"),
                                rs.getString("namaType"),
                                rs.getInt("harga"),
                                rs.getInt("tahun"),
                                rs.getInt("qty")

                        )));
        return customer;
    }

    public void deleteCustomerById(String idCustomer){
        jdbcTemplate.update("DELETE from tbl_customer WHERE idCustomer=?",idCustomer);
        jdbcTemplate.update("DELETE from tbl_customerdetail WHERE idCustomer=?",idCustomer);
    }

    public Customer findById(String idCustomer) {
        Customer customer;

        customer =  jdbcTemplate.queryForObject("SELECT * FROM tbl_customer WHERE idCustomer=?",new Object[]{idCustomer},
                (rs,rowNum)->
                        new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        ));

        customer.setMobilList(jdbcTemplate.query("select * from tbl_customerdetail c, tbl_mobil p, tbl_merk d, tbl_type e where " +
                        "c.idMobil = p.idMobil AND p.idMerk=d.idMerk AND p.idType=e.idType AND c.idCustomer=?",
                preparedStatement -> preparedStatement.setString(1,customer.getIdCustomer()),
                (rs, rowNum) ->
                        new Mobil(
                                rs.getString("idMobil"),
                                rs.getString("namaMobil"),
                                rs.getString("namaMerk"),
                                rs.getString("namaType"),
                                rs.getInt("harga"),
                                rs.getInt("tahun"),
                                rs.getInt("qty")

                        )));
        return customer;
    }

}

