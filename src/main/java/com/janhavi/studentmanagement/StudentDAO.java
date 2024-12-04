package com.janhavi.studentmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements UserDAO {

	@Override
	public void insertUser(User user) {
		String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());

			statement.executeUpdate();
			System.out.println("User inserted successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "SELECT * FROM users";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");

				users.add(new User(id, username, email, ""));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public void deleteUser(int userId) {
		String sql = "DELETE FROM users WHERE id = ?";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, userId);
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("User deleted successfully!");
			} else {
				System.out.println("No user found with ID: " + userId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkIfUserExists(String email) {
		String sql = "SELECT COUNT(*) FROM users WHERE email = ?";

		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean loginUser(String email, String password) {
		String sql = "SELECT COUNT(*) FROM users WHERE email = ? and password = ?";
		try (Connection connection = DatabaseConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1) > 0;
			} 
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

}
