package com.akmaral.library_api.repository;

import com.akmaral.library_api.model.Author;
import org.springframework.stereotype.Repository;
import com.akmaral.library_api.utils.DatabaseConnection;

import java.sql.*;
import java.util.*;

@Repository
public class AuthorRepository {
    private final DatabaseConnection db;
    public AuthorRepository(DatabaseConnection db) {
        this.db = db;
    }

    public Author create(Author a) {
        try (Connection c = db.getConnection();
             PreparedStatement ps = c.prepareStatement(
                     "INSERT INTO authors(name) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) a.setId(rs.getInt(1));
            return a;
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public Author get(int id) {
        try (Connection c = db.getConnection();
             PreparedStatement ps =
                     c.prepareStatement("SELECT * FROM authors WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? new Author(rs.getInt("id"), rs.getString("name")) : null;
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public List<Author> getAll() {
        List<Author> list = new ArrayList<>();
        try (Connection c = db.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM authors")) {
            while (rs.next())
                list.add(new Author(rs.getInt("id"), rs.getString("name")));
            return list;
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public void update(int id, String name) {
        try (Connection c = db.getConnection();
             PreparedStatement ps =
                     c.prepareStatement("UPDATE authors SET name=? WHERE id=?")) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }
    }


    public void delete(int id) {
        try (Connection c = db.getConnection();
             PreparedStatement ps =
                     c.prepareStatement("DELETE FROM authors WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
