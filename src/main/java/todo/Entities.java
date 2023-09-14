package todo;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notes")
public class Entities {
	@Id
	private int id;
	private String Tital;
	
	private String content;
	
	private Date SavedDate;		

	public Entities( String tital, String content, Date savedDate) {
		super();
		id = new Random().nextInt(100) ;  // To generate the id automatically its one way to generate
		Tital = tital;
		this.content = content;
		SavedDate = savedDate;
	}

	public Entities() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTital() {
		return Tital;
	}

	public void setTital(String tital) {
		Tital = tital;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSavedDate() {
		return SavedDate;
	}

	public void setSavedDate(Date savedDate) {
		SavedDate = savedDate;
	}


}
