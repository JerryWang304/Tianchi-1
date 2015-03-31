package cn.edu.tju.tianchi.feature.profile.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.tju.tianchi.feature.profile.IUserProfile;


public class UserProfile implements IUserProfile {
	
	int id;//�û�ID
	int click_count[];//���ද���Ĵ���
	List<Pair> pairs =new ArrayList<Pair>();
	class Pair//����ÿһ����������Щ����
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
