package runner;

import java.sql.SQLException;

import connector.DBConnection;
import studenti.studente;

public class gestioneDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DBConnection db = new DBConnection();
// 			CREAZIONE TABELLA STUDENTI
			db.createTabStudent();

			// AGGIUNTA UTENTE
//			studente s = new studente("Daniele", "Testi", "Male", 9, 6, "2002-09-14");
			// studente s = new studente("Bebo", "Macis", "Male", 7, 4, "1994-09-14");
			// db.creaStudente(s);

			// RICERCA UTENTE
			studente utenteLetto = db.findStudent(1);
			System.out.println(utenteLetto);

			// CANCELLAZIONE STUDENTE
//			db.deleteStudent(utenteLetto);

			// UPDATE STUDENTE
			utenteLetto.setMin_vote(3);
			db.updateStudent(utenteLetto);
			System.out.println(utenteLetto);

			db.getBest(utenteLetto);

			db.getVoteRange(5, 10);

			// ELIMINAZIONE UTENTE
//			db.deleteStudent(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
