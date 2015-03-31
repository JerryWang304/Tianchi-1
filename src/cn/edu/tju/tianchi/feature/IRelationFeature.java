package cn.edu.tju.tianchi.feature;

import java.util.List;


import cn.edu.tju.tianchi.feature.profile.IRelationProfile;
import cn.edu.tju.tianchi.util.ItemRecord;
import cn.edu.tju.tianchi.util.UserItemRecord;

public interface IRelationFeature {
	public List<IRelationProfile>  getRelationFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);
	

}
