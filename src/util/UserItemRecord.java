package util;

public class UserItemRecord {
	int user_id,item_id,behavior_type,item_category;
	String user_geohash;
	String time;
	public UserItemRecord(String line) {
		// TODO Auto-generated constructor stub
		
		
		String[] tokens=line.split(",");
		user_id=Integer.parseInt(tokens[0]);
		item_id=Integer.parseInt(tokens[1]);
		behavior_type=Integer.parseInt(tokens[2]);
		user_geohash=tokens[3];
		item_category=Integer.parseInt(tokens[4]);
		time=tokens[5];
		
//		for(int i=0;i<tokens.length;i++)
//			System.out.print(tokens[i]+"*");
//		System.out.println("");
		
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getBehavior_type() {
		return behavior_type;
	}
	public void setBehavior_type(int behavior_type) {
		this.behavior_type = behavior_type;
	}
	public int getItem_category() {
		return item_category;
	}
	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}
	public String getUser_geohash() {
		return user_geohash;
	}
	public void setUser_geohash(String user_geohash) {
		this.user_geohash = user_geohash;
	}
	public String getDate() {
		return time;
	}
	public void setDate(String time) {
		this.time = time;
	}
	public static  void main(String args[])
	{
		String line="99512554,37320317,3,94gn6nd,9232,2014-11-26 20";
		new UserItemRecord(line);
	}

}
