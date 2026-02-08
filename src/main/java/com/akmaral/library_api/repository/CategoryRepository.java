package com.akmaral.library_api.repository;

import com.akmaral.library_api.model.Category;
import org.springframework.stereotype.Repository;
import com.akmaral.library_api.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private final DatabaseConnection db;
    public CategoryRepository(DatabaseConnection db) {
        this.db = db;
    }

    public Category create(Category c) {
        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO categories(name) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }
            return c;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Category get(int id) {
        try (Connection conn = db.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement("SELECT * FROM categories WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();

        try (Connection conn = db.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM categories")) {
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, String name) {
        try (Connection conn = db.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement("UPDATE categories SET name=? WHERE id=?")) {

            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection conn = db.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement("DELETE FROM categories WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
