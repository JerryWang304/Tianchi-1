package util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

public class FeatureRecord {
	
	int userId=1;
	int itemId=2;
	
	int count[];
	int lastInteral[];
	int category_count[];
	int item_count[];
	
	
	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public int getItemId() {
		return itemId;
	}




	public void setItemId(int itemId) {
		this.itemId = itemId;
	}




	public int[] getCount() {
		return count;
	}




	public void setCount(int[] count) {
		this.count = count;
	}




	public int[] getLastInteral() {
		return lastInteral;
	}




	public void setLastInteral(int[] lastInteral) {
		this.lastInteral = lastInteral;
	}




	public int[] getCategory_count() {
		return category_count;
	}




	public void setCategory_count(int[] category_count) {
		this.category_count = category_count;
	}




	public int[] getItem_count() {
		return item_count;
	}




	public void setItem_count(int[] item_count) {
		this.item_count = item_count;
	}




	public FeatureRecord()
	{
		count=new int[4];
		lastInteral=new int[4];
		category_count=new int[4];
		item_count=new int[4];
		for(int i=0;i<4;i++)
		{
			count[i]=0;
			lastInteral[i]=0;
			category_count[i]=0;
			item_count[i]=0;
		}
	}
	
	
	
	
	public int getUser_id() {
		return userId;
	}
	public void setUser_id(int userId) {
		this.userId = userId;
	}
	public int getItem_id() {
		return itemId;
	}
	public void setItem_id(int itemId) {
		this.itemId = itemId;
	}
	
	
	public String parse2String() {
		// TODO Auto-generated method stub
		String line=""+userId+"#"+itemId;
		for(int i=0;i<4;i++)
		{
			
			line+=","+count[i]+","+lastInteral[i]+","+category_count[i]+","+item_count[i];
		}
		return line;
	}
	
	
	public String toString() {
		// TODO Auto-generated method stub
		
		Map<String,Object> propertys=ReflectUtil.getProperty(this);
		String line=propertys.get("userId")+","+propertys.get("itemId");
		for(String key:propertys.keySet())
		{
			System.out.println(key+":"+propertys.get(key));
			if(key.equals("userId")||key.equals("itemId"))
				continue;
			
			else if(propertys.get(key).getClass().isArray() )
			{
				int[] a=(int[]) propertys.get(key);
				for(int i=0;i<a.length;i++)
					line+=","+a[i];
			}
			else
			line+=","+propertys.get(key);
			
		}
		return line;
	}
	public static void main(String args[])
	{
		FeatureRecord record=new FeatureRecord();
		System.out.println(record.parse2String());
	}
	
}
