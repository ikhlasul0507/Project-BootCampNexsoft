package com.exam.starbucks.demo.repository;

import com.exam.starbucks.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("ProductRepository")
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product",
                (rs, rowNum)->
                        new Product(
                                rs.getString("idProduct"),
                                rs.getString("namaProduct"),
                                rs.getInt("harga")
                        )
                );
    }
    public List<Product> findAllSave() {
        return jdbcTemplate.query("select * from product ORDER BY idProduct DESC Limit 1",
                (rs, rowNum)->
                        new Product(
                                rs.getString("idProduct"),
                                rs.getString("namaProduct"),
                                rs.getInt("harga")

                        )
        );
    }
    // Add new customer
    public void addProduct(Product product) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        Date date= new Date();
        long time = date.getTime();
        jdbcTemplate.update("INSERT INTO product(idProduct,namaProduct,harga) VALUES (?,?,?)",
                randomUUIDString,product.getNamaProduct(), product.getHarga());
    }
    // update new customer
    public void updateProduct(Product product) {
        jdbcTemplate.update("UPDATE product SET nameProduct= ?, harga=?",
                product.getNamaProduct(), product.getHarga());
    }

    public Product findById(String idProduct){
        String sql = "select * from product WHERE idProduct='"+idProduct+"'";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum)->
                        new Product(
                                rs.getString("idProduct"),
                                rs.getString("namaProduct"),
                                rs.getInt("harga")
                        )
        );
    }
    public List<Product> findByName(String namaProduct){
       return jdbcTemplate.query("Select * FROM product where namaProduct like ?",
               new Object[]{"%"+namaProduct+"%"},
                (rs, rowNum)->
                        new Product(
                                rs.getString("idProduct"),
                                rs.getString("namaProduct"),
                                rs.getInt("harga")
                        )
        );
    }

    public void deleteProductById(String idProduct){
        jdbcTemplate.execute(" DELETE FROM product WHERE idProduct='"+idProduct+"'");
    }
    public void deleteAllProduct(){
        jdbcTemplate.execute(" DELETE FROM product");
    }
}
