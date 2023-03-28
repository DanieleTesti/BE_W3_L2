package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import studenti.studente;

public class DBConnection {

	private String url = "jdbc:postgresql://localhost:5432/";
	private String dbName = "W3_L1_Es2";
	private String username = "postgres";
	private String password = "daniele";
	Statement st;

	public DBConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url + dbName, username, password);
		st = conn.createStatement();
	}

	public void createTabStudent() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS Students (" + "id_user SERIAL PRIMARY KEY," + "name VARCHAR NOT NULL,"
				+ "lastName VARCHAR NOT NULL," + "gender VARCHAR NOT NULL,"
				+ "birthdate DATE NOT NULL,avg INT2 , min_vote INT2 NOT NULL, max_vote INT2 NOT NULL)";
		this.st.executeUpdate(sql);
		System.out.println("Tabella creata!!");
	}

	public void creaStudente(studente s) throws SQLException {
		String sql = "INSERT INTO Students (name, lastName, gender, birthdate, avg, min_vote, max_vote) " + "VALUES ('"
				+ s.getName() + "', '" + s.getLastname() + "', '" + s.getGender() + "', '" + s.getDate() + "', "
				+ s.getAvg() + ", '" + s.getMin_vote() + "', '" + s.getMax_vote() + "')";
		this.st.executeUpdate(sql);
		System.out.println("Utente creato!!");
	}

	public void deleteStudent(studente s) throws SQLException {
		String sql = "DELETE FROM Students WHERE id_user = " + s.getId();
		this.st.executeUpdate(sql);
		System.out.println("Utente eliminato!!!");
	}

	public studente findStudent(Integer id) throws SQLException {
		studente utente = null;
		String sql = "SELECT * FROM Students Where id_user = " + id;
		ResultSet rs = this.st.executeQuery(sql);
		if (rs.next()) {
			Long id_user = rs.getLong("id_user");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String gender = rs.getString("gender");
			Integer min_vote = rs.getInt("min_vote");
			Integer max_vote = rs.getInt("max_vote");
			String birthdate = rs.getString("birthdate");
			Integer avg = rs.getInt("avg");
			utente = new studente(id_user, name, lastname, gender, min_vote, max_vote, birthdate, avg);
		}
		System.out.println("Utente trovato");
		return utente;
	}

	public void updateStudent(studente s) throws SQLException {
		String sql = "UPDATE Students " + "SET name='" + s.getName() + "', lastname='" + s.getLastname() + "', gender='"
				+ s.getGender() + "' " + "WHERE id_user = " + s.getId();
		this.st.executeUpdate(sql);
		System.out.println("Utente aggiornato!!");
	}

	public void getBest(studente s) throws SQLException {
		String sql = "SELECT * FROM Students ORDER BY avg DESC LIMIT 1";
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			Long id_user = rs.getLong("id_user");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String gender = rs.getString("gender");
			String birthdate = rs.getString("birthdate");
			Integer min_vote = rs.getInt("min_vote");
			Integer max_vote = rs.getInt("max_vote");
			Integer avg = rs.getInt("avg");
			System.out.println(new studente(id_user, name, lastname, gender, min_vote, max_vote, birthdate, avg));
		}
	}

	public void getVoteRange(int min, int max) throws SQLException {
		List<studente> studenti = new ArrayList<>();
		String sql = "SELECT * FROM Students WHERE min_vote > " + (min - 1) + " AND max_vote < " + (max + 1)
				+ " ORDER BY avg DESC";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Long id_user = rs.getLong("id_user");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String gender = rs.getString("gender");
			String birthdate = rs.getString("birthdate");
			Integer min_vote = rs.getInt("min_vote");
			Integer max_vote = rs.getInt("max_vote");
			Integer avg = rs.getInt("avg");
			studente stud = new studente(id_user, name, lastname, gender, min_vote, max_vote, birthdate, avg);
			studenti.add(stud);
		}
		System.out.println("Elenco studenti con voti compresi tra " + min + " e " + max);
		studenti.forEach(stud -> System.out.println(stud.toString()));
	}

}