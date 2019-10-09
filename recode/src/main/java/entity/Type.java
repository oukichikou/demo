package entity;


import java.io.Serializable;

public class Type implements Serializable{
	private Integer id;
	private String name;
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Type(String name) {
		super();
		this.name = name;
	}


	public Type(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	private int uploadstatus=0;  // 0δ�ϴ�  1�ɹ�  2ʧ��
	public String getUploadstatusname() {
		return uploadstatus==0?"δ�ϴ�":"�ɹ�";
	}
	public int getUploadstatus() {
		return uploadstatus;
	}
	public void setUploadstatus(int uploadstatus) {
		this.uploadstatus = uploadstatus;
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

