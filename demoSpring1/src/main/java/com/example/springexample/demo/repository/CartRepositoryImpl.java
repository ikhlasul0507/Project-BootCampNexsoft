package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("CartRepository")
public class CartRepositoryImpl implements CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cart> findAll(){
        return jdbcTemplate.query("select*from Cart",
                (rs,rowNum)->
                        new Cart(
                                rs.getInt("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar"),null
                        ));
    }

    public List<Cart> find(){
        return jdbcTemplate.query("select*from Cart Order By idCart Desc limit 1",
                (rs,rowNum)->
                        new Cart(
                                rs.getInt("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar"),null
                        ));
    }

    public void saveCart(Cart cart){
        jdbcTemplate.update("INSERT INTO Cart(tglTransaksi, idCustomer, statusBayar) VALUES (?,?,?)",
                new Date(), cart.getIdCustomer(), "No");
        List<Product> products = cart.getProductList();

        for (int i=0; i<products.size(); i++){
            Product product = products.get(i);
            jdbcTemplate.update("INSERT INTO cartdetail(idCart, idProduct, qty) VALUES (?,?,?)",
                    cart.getIdCart(), products.get(i).getId(),product.getQty());
        }

    }

    public void updateCart(Cart cart){
        jdbcTemplate.update("UPDATE Cart SET statusBayar = '"+cart.getStatusBayar()+"' WHERE idCart = '"+cart.getIdCart()+"'");
    }

    public void deleteCartById(long id){
        jdbcTemplate.update("DELETE from Cart WHERE idCart=?",id);
    }

    public Cart findById(long id) {

        return jdbcTemplate.queryForObject("SELECT * FROM Cart WHERE idcart=?",new Object[]{id},
                (rs,rowNum)->
                        new Cart(
                                rs.getInt("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar"),null
                        ));
    }

    public Cart findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM Cart WHERE name=?",new Object[]{name},
                (rs,rowNum)->
                        new Cart(
                                rs.getInt("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar"),null
                        ));
    }

}
