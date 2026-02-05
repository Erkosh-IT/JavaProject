package HOSPITAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor d) {
        String sql = "INSERT INTO doctors (id, name, specialization, experience) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getName());
            stmt.setString(3, d.getSpecialization());
            stmt.setInt(4, d.getExperienceYears());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Doctor> getAll() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors ORDER BY id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("id"), rs.getString("name"),
                        rs.getString("specialization"), rs.getInt("experience")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void updateSpec(int id, String spec) {
        String sql = "UPDATE doctors SET specialization = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, spec);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateExp(int id, int exp) {
        String sql = "UPDATE doctors SET experience = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, exp);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int id) {
        String sql = "DELETE FROM doctors WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Doctor> searchByName(String name) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE name ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("id"), rs.getString("name"),
                        rs.getString("specialization"), rs.getInt("experience")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public List<Doctor> searchBySpec(String spec) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE specialization ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, spec);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("id"), rs.getString("name"),
                        rs.getString("specialization"), rs.getInt("experience")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public List<Doctor> searchMinExp(int min) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE experience >= ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, min);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("id"), rs.getString("name"),
                        rs.getString("specialization"), rs.getInt("experience")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}