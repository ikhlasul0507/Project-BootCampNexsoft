package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.Model.CartDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("CartDetailRepository")
public class CartDetailRepositoryImpl implements CartDetailRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CartDetail> findAll(){
        return jdbcTemplate.query("select*from cartdetail",
                (rs,rowNum)->
                        new CartDetail(
                                rs.getInt("idCartDetail"),
                                rs.getString("idCart"),
                                rs.getString("idProduct"),
                                rs.getInt("qty")
                        ));
    }
    public List<CartDetail> find(){
        return jdbcTemplate.query("select*from cartdetail Order By idCartDetail Desc limit 1",
                (rs,rowNum)->
                        new CartDetail(
                                rs.getInt("idCartDetail"),
                                rs.getString("idCart"),
                                rs.getString("idProduct"),
                                rs.getInt("qty")
                        ));
    }
    public void saveCartDetail(CartDetail cartDetail){
        jdbcTemplate.update("INSERT INTO cartdetail(idCart, idProduct, qty) VALUES (?,?,?)",
                cartDetail.getIdCart(), cartDetail.getIdProduct(),cartDetail.getQty());
    }

    public void updateCartDetail(CartDetail cartDetail){
        jdbcTemplate.update("UPDATE cartdetail SET idCart = "+cartDetail.getIdCart()+
                ", idProduct = "+cartDetail.getIdProduct()+
                ", qty = "+cartDetail.getQty()+" " +
                "WHERE idCartDetail = "+cartDetail.getIdCartDetail()+"");
    }

    public void deleteCartDetailById(long id){
        jdbcTemplate.update("DELETE from cartdetail WHERE idCartDetail=?",id);
    }

    public CartDetail findById(long id) {

        return jdbcTemplate.queryForObject("SELECT * FROM cartdetail WHERE idCartDetail=?",new Object[]{id},
                (rs,rowNum)->
                        new CartDetail(
                                rs.getInt("idCartDetail"),
                                rs.getString("idCart"),
                                rs.getString("idProduct"),
                                rs.getInt("qty")
                        ));
    }

    public CartDetail findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM cartdetail WHERE idCard=?",new Object[]{name},
                (rs,rowNum)->
                        new CartDetail(
                                rs.getInt("idCartDetail"),
                                rs.getString("idCart"),
                                rs.getString("idProduct"),
                                rs.getInt("qty")
                        ));
    }
}
