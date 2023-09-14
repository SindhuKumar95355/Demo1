package simpleCrud;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="ent")
public class entities {
	
	@Id
	private int id = new Random().nextInt(100);
	@Column(name = "Sname")
	private String name;
	
	private String USN;
	
	private int Password;
	
	@Temporal(TemporalType.DATE)
	private Date LoginDate;
	
	@Override
	public String toString() {
		return "entities [id=" + id + ", name=" + name + ", USN=" + USN + ", Password=" + Password + ", LoginDate="
				+ LoginDate + "]";
	}


	public entities(int id, String name, String uSN, int password ) {
		super();
		this.id = id;
		this.name = name;
		USN = uSN;
		Password = password;
	}


	public entities() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
//                       id is not working because of the not created the contructer  
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUSN() {
		return USN;
	}

	public void setUSN(String uSN) {
		USN = uSN;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}

	public Date getLoginDate() {
		return LoginDate;
	}

	public void setLoginDate(Date loginDate) {
		LoginDate = loginDate;
		
	}

}
