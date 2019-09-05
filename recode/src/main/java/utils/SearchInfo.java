package utils;

public class SearchInfo {
	private String where="";

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	
	public void addLike(String colname) {
		if(where.length()>0)where=" where "+colname+" like '%"+where+"%' ";
	}
	
}
