package cn.edu.tju.tianchi.feature.profile.impl;

import cn.edu.tju.tianchi.feature.profile.IUserProfile;


public class UserProfile implements IUserProfile {
	
	int id;
	int click_count[];
	
	class Pair
	{
		int item_category;
		int count[];
		float conversion[];
		public Pair(int item_category,int count[],float conversion[])
		{
			this.item_category=item_category;
			count=new int[4];
			for(int i=0;i<4;i++)
				this.count[i]=count[i];
			conversion=new float[4];
			for(int i=0;i<4;i++)
				this.conversion[i]=conversion[i];
		}
	}

}
