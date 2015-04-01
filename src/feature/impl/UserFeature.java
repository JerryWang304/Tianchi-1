package feature.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.ItemRecord;
import util.UserItemRecord;
import feature.IUserFeature;
import feature.profile.impl.UserProfile;

import feature.profile.impl.Category;

public class UserFeature implements IUserFeature{



	public Map<Integer, UserProfile> getUserFeature(List<UserItemRecord> records,List<ItemRecord> itemRecord) {
		// TODO Auto-generated method stub
		List<UserProfile> userProfiles=new ArrayList<UserProfile>();
		Map<Integer,UserProfile> user=new  HashMap<Integer,UserProfile>();
		for(UserItemRecord record:records)
		{
			int userId=record.getUser_id();
			if(user.containsKey(userId))
			{
				UserProfile profile=(UserProfile) user.get(userId);
				
				int categoryID=record.getItem_category();
				Map<Integer,Category> pairs=profile.getPairs();
				Set<Integer> categorys=pairs.keySet();
				if(categorys.contains(categoryID))
				{
					Category category=pairs.get(categoryID);
					category.count[record.getBehavior_type()-1]++;
				}
				else
				{
					Category category=new Category();
					category.count[record.getBehavior_type()-1]++;
					pairs.put(categoryID,category);
				}
			}
			else
			{
				UserProfile profile=new UserProfile();
				int categoryID=record.getItem_category();
				Map<Integer,Category> pairs=profile.getPairs();
				Category category=new Category();
				category.count[record.getBehavior_type()-1]++;
				pairs.put(categoryID,category);
			}
			
		}
		
		
		
		return user;
	}

}
