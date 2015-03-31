package cn.edu.tju.tianchi.util;

public class ItemRecord {
	int item_id	;
	String item_geohash;
	int item_category;
	public ItemRecord(String line) {
		// TODO Auto-generated constructor stub

		String[] tokens=line.split(",");
	
		item_id=Integer.parseInt(tokens[0]);
		item_geohash=tokens[1];
		item_category=Integer.parseInt(tokens[2]);
		
		
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_geohash() {
		return item_geohash;
	}
	public void setItem_geohash(String item_geohash) {
		this.item_geohash = item_geohash;
	}
	public int getItem_category() {
		return item_category;
	}
	public void setItem_category(int item_category) {
		this.item_category = item_category;
	}
	


}
