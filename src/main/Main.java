package main;

import java.util.List;

import util.FeatureRecord;
import util.FeatureUtil;
import util.ItemRecord;
import util.UserItemRecord;
import feature.IUserFeature;
import feature.impl.ItemFeature;
import feature.impl.RelationFeature;
import feature.impl.UserFeature;
import feature.profile.IItemProfile;
import feature.profile.IRelationProfile;
import feature.profile.IUserProfile;

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
