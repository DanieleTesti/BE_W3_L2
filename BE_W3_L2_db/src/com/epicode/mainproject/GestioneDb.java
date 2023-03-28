package com.epicode.mainproject;

import java.sql.SQLException;
import java.util.ArrayList;

import com.epicode.connector.DBConnection;
import com.epicode.model.user;

public class GestioneDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DBConnection db = new DBConnection();
//			user utente = new user("Mario", "Rossi", 25, "m.rossi@example.com");
//			user utente = new user("Giuseppe", "Verdi", 64, "g.verdi@example.com");
//			user utente = new user("Francesca", "Neri", 29, "f.neri@example.com");
//			db.createUser(utente);
			user utenteLetto = db.findUser(1);
//			System.out.println(utenteLetto);

//			utenteLetto.setAnni(44);

//			db.updateUser(utenteLetto);
//			System.out.println(utenteLetto);
//			db.deleteUser(utenteLetto);

			ArrayList<user> userList = db.findAllUsers();
			userList.forEach(u -> System.out.println(u));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
