package com.akmaral.library_api.repository;

import com.akmaral.library_api.model.*;
import org.springframework.stereotype.Repository;
import com.akmaral.library_api.utils.DatabaseConnection;

import java.sql.*;
import java.util.*;

@Repository
public class BookRepository {
    private final DatabaseConnection db;
    public BookRepository(DatabaseConnection db) {
        this.db = db;
    }

    public Book create(Book b, String type, int authorId, int categoryId) {
        try (Connection c = db.getConnection();
             PreparedStatement ps = c.prepareStatement(
                     "INSERT INTO books(name, book_type, available, author_id, category_id) VALUES (?,?,?,?,?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, b.getName());
            ps.setString(2, type);
            ps.setBoolean(3, true);
            ps.setInt(4, authorId);
            ps.setInt(5, categoryId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) b.setId(rs.getInt(1));
            return b;
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        try (Connection c = db.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM books")) {
            while (rs.next()) {
                Book b = "EBOOK".equals(rs.getString("book_type")) ? new EBook() : new PrintedBook();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setAvailable(rs.getBoolean("available"));
                list.add(b);
            }
            return list;
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public void updateAvailability(int id, boolean available) {
        try (Connection c = db.getConnection();
             PreparedStatement ps =
                     c.prepareStatement("UPDATE books SET available=? WHERE id=?")) {
            ps.setBoolean(1, available);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public void delete(int id) {
        try (Connection c = db.getConnection();
             PreparedStatement ps =
                     c.prepareStatement("DELETE FROM books WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }

    }


}
