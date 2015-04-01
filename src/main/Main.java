package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import feature.profile.impl.RelationProfile;

public class Main {
	
	public static void main(String args[])
	{
		List<UserItemRecord> userItemRecords=FeatureUtil.read("test.data");
		List<ItemRecord> itemRecord=FeatureUtil.readItemRecord("tianchi_mobile_recommend_train_item.csv");
		
		
		//List<IUserProfile> userProfile=new UserFeature().getUserFeature(userItemRecords,itemRecord);
		//List<IItemProfile> itemProfile=new ItemFeature().getItemFeature(userItemRecords,itemRecord);
		List<RelationProfile> relationProfile=new RelationFeature().getRelationFeature(userItemRecords,itemRecord);
		File file=new File("d:test.txt");
		PrintWriter pw=null;
		
		try {
			pw=new PrintWriter(new FileWriter(file));
			
			for(RelationProfile record:relationProfile)
			{
				String line=record.toString();
				pw.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			pw.close();
		}
		
		//List<FeatureRecord> records=FeatureUtil.handle(userProfile, itemProfile, relationProfile);
		//FeatureUtil.write2File(records,"featureRecord.csv");
		
		return;
	}

}
