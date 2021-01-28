package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductRepository")
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product",
                (rs, rowNum)->
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("categoryId"),
                                rs.getDouble("harga")
                        )
                );
    }
    public List<Product> findAllSave() {
        return jdbcTemplate.query("select * from product ORDER BY id DESC Limit 1",
                (rs, rowNum)->
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("categoryId"),
                                rs.getDouble("harga")
                        )
        );
    }
    // Add new customer
    public void addProduct(Product product) {
        jdbcTemplate.update("INSERT INTO product(name, categoryId, harga) VALUES (?,?,?)",
                product.getName(), product.getCategoryId(), product.getPrice());
    }
    // update new customer
    public void updateProduct(Product product) {
        jdbcTemplate.update("UPDATE product SET name= ?, categoryId=?, harga=?",
                product.getName(), product.getCategoryId(), product.getPrice());
    }

    public Product findById(int id){
        String sql = "select * from product WHERE id="+id+"";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum)->
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("categoryId"),
                                rs.getDouble("harga")
                        )
        );
    }
    public List<Product> findByName(String name){
       return jdbcTemplate.query("Select * FROM product where name like ?",
               new Object[]{"%"+name+"%"},
                (rs, rowNum)->
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("categoryId"),
                                rs.getDouble("harga")
                        )
        );
    }
    @Override
    public List<Product> findByIdAndName(int id, String name) {
        return jdbcTemplate.query(
                "select * from product where id=? OR name like ?",
                new Object[]{id,"%"+name+"%"},
                (rs, rowNum)->
                        new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("categoryId"),
                                rs.getDouble("harga")
                        )
        );
    }

    public void deleteProductById(int id){
        jdbcTemplate.execute(" DELETE FROM product WHERE id="+id+"");
    }
    public void deleteProductByName(String name) {
        jdbcTemplate.execute(" DELETE FROM product WHERE name='"+name+"'");
    }
    public void deleteAllProduct(){
        jdbcTemplate.execute(" DELETE FROM product");
    }
}
