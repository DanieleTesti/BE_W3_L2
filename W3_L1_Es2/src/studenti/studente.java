package studenti;


import java.time.LocalDate;

public class studente {

	private Long id;
	private String name, lastname, gender;
	private Integer max_vote, min_vote;
	private LocalDate birthdate;
	private Integer avg;

	public studente(Long id, String name, String lastname, String gender, Integer max_vote,
			Integer min_vote, String birthdate, Integer avg) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.max_vote = max_vote;
		this.min_vote = min_vote;
		this.birthdate = LocalDate.parse(birthdate);
		this.avg = (min_vote + max_vote) / 2;
	}

	public studente(String name, String lastname, String gender, Integer max_vote, Integer min_vote,
			String birthdate, Integer avg) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = LocalDate.parse(birthdate);
		this.max_vote = max_vote;
		this.min_vote = min_vote;
		this.avg = avg;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(Integer max_vote) {
		this.max_vote = max_vote;
	}

	public Integer getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(Integer min_vote) {
		this.min_vote = min_vote;
	}

	public LocalDate getDate() {
		return birthdate;
	}

	public void setDate(LocalDate date) {
		this.birthdate = date;
	}

	public Integer getAvg() {
		return avg;
	}

	public void setAvg(Integer avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "studente [id=" + id + ", name=" + name + ", lastname=" + lastname + ", gender=" + gender + ", max_vote="
				+ max_vote + ", min_vote=" + min_vote + ", birthdate=" + birthdate + ", avg=" + avg + "]";
	}
}