package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.Model.CartDetail;
import com.example.springexample.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("CartRepository")
public class CartRepositoryImpl implements CartRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cart> findAll(){
        List<Cart> cartHeaders;
        List<CartDetail> cartDetails = null;
        cartHeaders = jdbcTemplate.query("SELECT * FROM cart",
                (rs, rowNum)->
                        new Cart(
                                rs.getString("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar")
                        )
        );

        for (Cart ch : cartHeaders) {
            ch.setProductList(jdbcTemplate.query("select * from cartdetail c, product p where " +
                            "c.idProduct = p.id AND c.idCart=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getIdCart()),
                    (rs, rowNum) ->
                            new Product(
                                    rs.getString("id"),
                                    rs.getString("name"),
                                    rs.getInt("categoryId"),
                                    rs.getDouble("harga"),
                                    rs.getInt("qty")

                            )));
        }
        return cartHeaders;
    }

    //pagination
    public List<Cart> findWithPaging(int page, int limit) {
        int numPages;
        numPages = jdbcTemplate.query("SELECT COUNT(*) as count FROM cart",
                (rs,rowNum)->rs.getInt("count")).get(0);

        //page
        if(page < 1) page =1;
        if(page>numPages) page = numPages;
        int start = (page-1)*limit;

        List<Cart> cartHeaders = jdbcTemplate.query("SELECT * FROM cart LIMIT "+start+","+limit+";",
                (rs, rowNum)->
                        new Cart(
                                rs.getString("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar")
                        )
        );
        for (Cart ch : cartHeaders) {
            ch.setProductList(jdbcTemplate.query("select * from cartdetail c, product p where " +
                            "c.idProduct = p.id AND c.idCart=?",
                    preparedStatement -> preparedStatement.setString(1,ch.getIdCart()),
                    (rs, rowNum) ->
                            new Product(
                                    rs.getString("id"),
                                    rs.getString("name"),
                                    rs.getInt("categoryId"),
                                    rs.getDouble("harga"),
                                    rs.getInt("qty")

                            )));
        }
        return cartHeaders;
    }

    public List<Cart> find(){
        return jdbcTemplate.query("select*from Cart Order By tglTransaksi Desc limit 1",
                (rs,rowNum)->
                        new Cart(
                                rs.getString("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar")
                        ));
    }

    public void saveCart(Cart cart){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        jdbcTemplate.update("INSERT INTO Cart(idCart,tglTransaksi, idCustomer, statusBayar) VALUES (?,?,?,?)",
                randomUUIDString,new Date(), cart.getIdCustomer(), "No");
        List<Product> products = cart.getProductList();
        for (int i=0; i<products.size(); i++){
            Product product = products.get(i);
            jdbcTemplate.update("INSERT INTO cartdetail(idCart, idProduct, qty) VALUES (?,?,?)",
                    randomUUIDString, products.get(i).getId(),product.getQty());
        }

    }

    public void updateCart(Cart cart){

        jdbcTemplate.update("DELETE from cartdetail WHERE idCart=?",cart.getIdCart());

//        jdbcTemplate.update("UPDATE Cart SET statusBayar = '"+cart.getStatusBayar()+"' WHERE idCart = '"+cart.getIdCart()+"'");

        List<Product> products = cart.getProductList();
        for (int i=0; i<products.size(); i++){
            Product product = products.get(i);

            jdbcTemplate.update("INSERT INTO cartdetail(idCart, idProduct, qty) VALUES (?,?,?)",
                    cart.getIdCart(), products.get(i).getId(),product.getQty());
        }
    }

    public void updateCartStatus(Cart cart){
        jdbcTemplate.update("UPDATE Cart SET statusBayar = '"+cart.getStatusBayar()+"' WHERE idCart = '"+cart.getIdCart()+"'");

    }


    public void deleteCartById(String id){
        jdbcTemplate.update("DELETE from Cart WHERE idCart=?",id);
    }

    public Cart findById(String id) {
        Cart cart;

        cart =  jdbcTemplate.queryForObject("SELECT * FROM Cart WHERE idcart=?",new Object[]{id},
                (rs,rowNum)->
                        new Cart(
                                rs.getString("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar")
                        ));

            cart.setProductList(jdbcTemplate.query("select * from cartdetail c, product p where " +
                            "c.idProduct = p.id AND c.idCart=?",
                    preparedStatement -> preparedStatement.setString(1,cart.getIdCart()),
                    (rs, rowNum) ->
                            new Product(
                                    rs.getString("id"),
                                    rs.getString("name"),
                                    rs.getInt("categoryId"),
                                    rs.getDouble("harga"),
                                    rs.getInt("qty")
                            )));

        return cart;
    }

    public Cart findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM Cart WHERE name=?",new Object[]{name},
                (rs,rowNum)->
                        new Cart(
                                rs.getString("idCart"),
                                rs.getString("tglTransaksi"),
                                rs.getInt("idCustomer"),
                                rs.getString("statusBayar")
                        ));
    }

}
