package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import util.FeatureRecord;
import util.FeatureUtil;
import util.ItemRecord;
import util.UserItemRecord;
import feature.IUserFeature;
import feature.impl.ItemFeature;
import feature.impl.RelationFeature;
import feature.impl.UserFeature;
import feature.profile.impl.ItemProfile;
import feature.profile.impl.RelationProfile;
import feature.profile.impl.UserProfile;

public class Main {
	
	public static void main(String args[])
	{
		List<UserItemRecord> userItemRecords=FeatureUtil.read("train_dateset1216.csv");
		List<ItemRecord> itemRecord=FeatureUtil.readItemRecord("tianchi_mobile_recommend_train_item.csv");
		
		
		Map<Integer, UserProfile> userProfile=new UserFeature().getUserFeature(userItemRecords,itemRecord);
		List<ItemProfile> itemProfile=new ItemFeature().getItemFeature(userItemRecords,itemRecord);
		List<RelationProfile> relationProfile=new RelationFeature().getRelationFeature(userItemRecords,itemRecord);
		
		List<FeatureRecord> records=FeatureUtil.handle(userProfile, itemProfile, relationProfile);
		FeatureUtil.write2File(records,"featureRecord16.csv");
		
		return;
	}

}
