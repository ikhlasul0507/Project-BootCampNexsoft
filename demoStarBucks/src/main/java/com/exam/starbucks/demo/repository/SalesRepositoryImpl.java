package com.exam.starbucks.demo.repository;

import com.exam.starbucks.demo.Model.Product;
import com.exam.starbucks.demo.Model.Sales;
import com.exam.starbucks.demo.Model.SalesDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("SalesRepository")
public class SalesRepositoryImpl implements SalesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Sales> findAll(){
        List<Sales> salesHeaders;
        List<SalesDetail> salesDetails;
        salesHeaders = jdbcTemplate.query("SELECT * FROM sales",
                (rs, rowNum)->
                        new Sales(
                                rs.getString("kodeTransaksi"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        )
        );

        for (Sales ch : salesHeaders) {
            ch.setProductList(jdbcTemplate.query("select * from salesdetail c, product p where " +
                            "c.kodeProduct = p.idProduct AND c.kodeTransaksi=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getKodeTransaksi()),
                    (rs, rowNum) ->
                            new Product(
                                    rs.getString("idProduct"),
                                    rs.getString("namaProduct"),
                                    rs.getInt("harga"),
                                    rs.getInt("qty")
                            )));
        }
        return salesHeaders;
    }

    public List<Sales> find(){
        List<Sales> salesHeaders;
        salesHeaders = jdbcTemplate.query("SELECT * FROM sales ORDER BY tglTransaksi DESC LIMIT 1",
                (rs, rowNum)->
                        new Sales(
                                rs.getString("kodeTransaksi"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        )
        );

        for (Sales ch : salesHeaders) {
            ch.setProductList(jdbcTemplate.query("select * from salesdetail c, product p where " +
                            "c.kodeProduct = p.idProduct AND c.kodeTransaksi=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getKodeTransaksi()),
                    (rs, rowNum) ->
                            new Product(
                                    rs.getString("idProduct"),
                                    rs.getString("namaProduct"),
                                    rs.getInt("harga"),
                                    rs.getInt("qty")
                            )));
        }
        return salesHeaders;
    }

    public void saveSales(Sales sales){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        jdbcTemplate.update("INSERT INTO sales(kodeTransaksi,namaCustomer,tglTransaksi) VALUES (?,?,?)",
                randomUUIDString,sales.getNamaCustomer(),new Date());
        List<Product> products = sales.getProductList();
        for (int i=0; i<products.size(); i++){
            Product product = products.get(i);
            UUID uuid1 = UUID.randomUUID();
            String randomUUIDString1 = uuid1.toString();
            jdbcTemplate.update("INSERT INTO salesdetail(kodeDetail, kodeTransaksi,kodeProduct, qty) VALUES (?,?,?,?)",
                    randomUUIDString1, randomUUIDString, products.get(i).getIdProduct(),product.getQty());
        }

    }

    public void updateSales(Sales sales){

        jdbcTemplate.update("DELETE from salesdetail WHERE kodeTransaksi=?",sales.getKodeTransaksi());

        List<Product> products = sales.getProductList();
        for (int i=0; i<products.size(); i++){
            Product product = products.get(i);
            UUID uuid1 = UUID.randomUUID();
            String randomUUIDString1 = uuid1.toString();

            jdbcTemplate.update("INSERT INTO salesdetail(kodeDetail, kodeTransaksi,kodeProduct, qty) VALUES (?,?,?,?)",
                    randomUUIDString1, sales.getKodeTransaksi(), products.get(i).getIdProduct(),product.getQty());
        }
    }

    public void deleteSalesById(String id){
        jdbcTemplate.update("DELETE from sales WHERE kodeTransaksi=?",id);
        jdbcTemplate.update("DELETE from salesdetail WHERE kodeTransaksi=?",id);
    }

    public Sales findById(String id) {
        Sales sales;

        sales =  jdbcTemplate.queryForObject("SELECT * FROM sales WHERE kodeTransaksi=?",new Object[]{id},
                (rs,rowNum)->
                        new Sales(
                                rs.getString("kodeTransaksi"),
                                rs.getString("namaCustomer"),
                                rs.getString("tglTransaksi")
                        ));

        sales.setProductList(jdbcTemplate.query("select * from salesdetail c, product p where " +
                        "c.kodeProduct = p.idProduct AND c.kodeTransaksi=?",
                preparedStatement -> preparedStatement.setString(1,sales.getKodeTransaksi()),
                (rs, rowNum) ->
                        new Product(
                                rs.getString("idProduct"),
                                rs.getString("namaProduct"),
                                rs.getInt("harga")
                        )));
        return sales;
    }

}
