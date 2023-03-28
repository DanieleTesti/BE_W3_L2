package com.epicode.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epicode.model.user;

public class DBConnection {

	private String url = "jdbc:postgresql://localhost:5432/";
	private String dbName = "JDBC_W3_L2";
	private String username = "postgres";
	private String password = "daniele";
	Statement st;

	public DBConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url + dbName, username, password);
		st = conn.createStatement();
		createTabUser();
	}

	public void createTabUser() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS Users (" + "id_user SERIAL PRIMARY KEY," + "nome VARCHAR NOT NULL,"
				+ "cognome VARCHAR NOT NULL," + "anni INT2 NOT NULL," + "email VARCHAR NOT NULL UNIQUE)";
		this.st.executeUpdate(sql);
	}

	public void createUser(user u) throws SQLException {
		String sql = "INSERT INTO Users (nome, cognome, anni, email) " + "VALUES ('" + u.getNome() + "', '"
				+ u.getCognome() + "', " + u.getAnni() + ", '" + u.getEmail() + "')";
		this.st.executeUpdate(sql);
		System.out.println("Utente creato");
	}

	public user findUser(Integer id) throws SQLException {
		user utente = null;
		String sql = "SELECT * FROM users Where id_user = " + id;
		ResultSet rs = this.st.executeQuery(sql);
		if (rs.next()) {
			Long id_user = rs.getLong("id_user");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			Integer anni = rs.getInt("anni");
			String email = rs.getString("email");
			utente = new user(id_user, nome, cognome, anni, email);
		}
		return utente;
	}

	public void updateUser(user u) throws SQLException {
		String sql = "UPDATE Users " + "SET nome='" + u.getNome() + "', cognome='" + u.getCognome() + "', " + "anni="
				+ u.getAnni() + ", email='" + u.getEmail() + "' " + "WHERE id_user = " + u.getId();
		this.st.executeUpdate(sql);
	}

	public void deleteUser(user u) throws SQLException {
		String sql = "DELETE FROM Users WHERE id_user = " + u.getId();
		this.st.executeUpdate(sql);
		System.out.println("Utente eliminato!!!");
	}

	public ArrayList<user> findAllUsers() throws SQLException {
		ArrayList<user> users = new ArrayList<user>();
		String sql = "SELECT * FROM Users";
		ResultSet rs = this.st.executeQuery(sql);
		while (rs.next()) {
			Long id_user = rs.getLong("id_user");
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			int anni = rs.getInt("anni");
			String email = rs.getString("email");
			user utente = new user(id_user, nome, cognome, anni, email);
			users.add(utente);
		}
		return users;
	}

}
