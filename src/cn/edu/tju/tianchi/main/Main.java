package cn.edu.tju.tianchi.main;

import java.util.List;

import cn.edu.tju.tianchi.feature.IUserFeature;
import cn.edu.tju.tianchi.feature.impl.ItemFeature;
import cn.edu.tju.tianchi.feature.impl.RelationFeature;
import cn.edu.tju.tianchi.feature.impl.UserFeature;
import cn.edu.tju.tianchi.feature.profile.IItemProfile;
import cn.edu.tju.tianchi.feature.profile.IRelationProfile;
import cn.edu.tju.tianchi.feature.profile.IUserProfile;
import cn.edu.tju.tianchi.util.FeatureRecord;
import cn.edu.tju.tianchi.util.FeatureUtil;
import cn.edu.tju.tianchi.util.ItemRecord;
import cn.edu.tju.tianchi.util.UserItemRecord;

public class Main {
	
	public static void main(String args[])
	{
		List<UserItemRecord> userItemRecords=FeatureUtil.read("test.data");
		List<ItemRecord> itemRecord=FeatureUtil.readItemRecord("tianchi_mobile_recommend_train_item.csv");
		
		
		List<IUserProfile> userProfile=new UserFeature().getUserFeature(userItemRecords,itemRecord);
		List<IItemProfile> itemProfile=new ItemFeature().getItemFeature(userItemRecords,itemRecord);
		List<IRelationProfile> relationProfile=new RelationFeature().getRelationFeature(userItemRecords,itemRecord);
		
		
		List<FeatureRecord> records=FeatureUtil.handle(userProfile, itemProfile, relationProfile);
		FeatureUtil.write2File(records,"featureRecord.csv");
		
		return;
	}

}
