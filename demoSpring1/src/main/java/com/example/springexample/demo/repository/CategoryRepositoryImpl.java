package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CategoryRepository")
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> findAll() {
        return jdbcTemplate.query("select * from category ",
                (rs, rowNum) ->
                        new Category(
                                rs.getInt("categoryId"),
                                rs.getString("name")
                        )
        );
    }
    public List<Category> findAllSave() {
        return jdbcTemplate.query("select * from category ORDER By categoryId DESC Limit 1",
                (rs, rowNum) ->
                        new Category(
                                rs.getInt("categoryId"),
                                rs.getString("name")
                        )
        );
    }

    // Add new customer
    public void addCategory(Category category) {
        jdbcTemplate.update("INSERT INTO category(name) VALUES (?)",
                category.getName());
    }



    // update new customer
    public void updateCategory(Category category) {
        jdbcTemplate.update("UPDATE category SET name= ?",
                category.getName());
    }

    public Category findById(int id) {
        String sql = "select * from category WHERE categoryId=" + id + "";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) ->
                        new Category(
                                rs.getInt("categoryId"),
                                rs.getString("name")
                        )
        );
    }

    public List<Category> findByName(String name) {
        return jdbcTemplate.query("Select * FROM category where name like ?",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) ->
                        new Category(
                                rs.getInt("categoryId"),
                                rs.getString("name")
                        )
        );
    }

    @Override
    public List<Category> findByIdAndName(int id, String name) {
        return jdbcTemplate.query(
                "select * from category where CategoryId=? OR name like ?",
                new Object[]{id, "%" + name + "%"},
                (rs, rowNum) ->
                        new Category(
                                rs.getInt("categoryId"),
                                rs.getString("name")
                        )
        );
    }
    @Override
    public void deleteCategoriById(int id) {
        jdbcTemplate.execute(" DELETE FROM category WHERE categoryId=" + id + "");
    }
    public void deleteCategoryByName(String name) {
        jdbcTemplate.execute(" DELETE FROM category WHERE name='" + name + "'");
    }
    public void deleteAllCategory() {
        jdbcTemplate.execute(" DELETE FROM category");
    }
}
