package HOSPITAL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DoctorDAO {
    // insert part
    public void addDoctor(Doctor doc) {
        String sql = "INSERT INTO doctors (id, name, specialization, experience) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, doc.getId());
            stmt.setString(2, doc.getName());
            stmt.setString(3, doc.getSpecialization());
            stmt.setInt(4, doc.getExperienceYears());

            stmt.executeUpdate();
            System.out.println("Doctor saved to database!");

        } catch (SQLException e) {
            System.out.println("Error adding: " + e.getMessage());
        }
    }

    // select part
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) { // Получаем таблицу

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String spec = rs.getString("specialization");
                int exp = rs.getInt("experience");

                list.add(new Doctor(id, name, spec, exp));
            }
        } catch (SQLException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
        return list;
    }

//delete part
    public void deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Doctor deleted.");

        } catch (SQLException e) {
            System.out.println("Error deleting: " + e.getMessage());
        }
    }

    // update part
    public void updateSpecialization(int id, String newSpec) {
        String sql = "UPDATE doctors SET specialization = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newSpec);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Doctor updated.");

        } catch (SQLException e) {
            System.out.println("Error updating: " + e.getMessage());
        }
    }

    // 5. search ilike
    public List<Doctor> searchByExperience(int minYears) {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE experience >= ?"; // Поиск по числу

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, minYears);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
        return list;
    }

    public List<Doctor> searchByName(String name) {
        List<Doctor> list = new ArrayList<>();
        // ILIKE = поиск без учета регистра (John = john)
        String sql = "SELECT * FROM doctors WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%"); // % означает "любые символы"
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
        return list;
    }
}