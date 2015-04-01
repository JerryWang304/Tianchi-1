package feature.profile.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class UserProfile {
	
	int userId;//用户ID
	int click_count[];//四类动作的次数
	Map<Integer,Category> pairs =new HashMap<Integer,Category>();
	
	
	int week[]=new int[7];  
	
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public int[] getClick_count() {
		return click_count;
	}
	public void setClick_count(int[] click_count) {
		this.click_count = click_count;
	}
	public Map<Integer, Category> getPairs() {
		return pairs;
	}
	public void setPairs(Map<Integer, Category> pairs) {
		this.pairs = pairs;
	}
	

}
