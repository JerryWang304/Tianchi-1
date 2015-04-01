package util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

public class FeatureRecord {
	
	int user_id=1;
	int item_id=2;
	double score= 0.5;
	
	
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
	public String parse2String() {
		// TODO Auto-generated method stub
		
		Map<String,Object> propertys=ReflectUtil.getProperty(this);
		String line=propertys.get("user_id")+","+propertys.get("item_id");
		for(String key:propertys.keySet())
		{
			if(key.equals("user_id")||key.equals("item_id"))
				continue;
			line+=","+propertys.get(key);
			
		}
		return line+"\n";
	}
	
	public static void main(String args[])
	{
		FeatureRecord record=new FeatureRecord();
		System.out.println(record.parse2String());
	}
	
}
