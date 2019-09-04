package entity;


import java.io.Serializable;

public class User implements Serializable{

	private Integer id;
	private String name;
	private String pass;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

