package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import feature.profile.impl.ItemProfile;
import feature.profile.impl.RelationProfile;
import feature.profile.impl.UserProfile;
import util.FeatureRecord;

public class FeatureUtil {
	public static List<UserItemRecord> read(String filename){
		BufferedReader br = null;
		File file=new File(filename);
		List<UserItemRecord> records=new ArrayList<UserItemRecord>();
		try {
			br=new  BufferedReader(new FileReader(file));
			System.out.println(br.readLine());
			String line="";
			while((line=br.readLine())!=null)
			{
				UserItemRecord record=new UserItemRecord(line);
				records.add(record);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return records;
	}
	
	public static List<ItemRecord> readItemRecord(String filename){
		BufferedReader br = null;
		File file=new File(filename);
		List<ItemRecord> records=new ArrayList<ItemRecord>();
		try {
			br=new  BufferedReader(new FileReader(file));
			System.out.println(br.readLine());
			String line="";
			while((line=br.readLine())!=null)
			{
				ItemRecord record=new ItemRecord(line);
				records.add(record);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return records;
	}
	
	public  static List<FeatureRecord>  handle(Map<Integer, UserProfile> userProfile,List<ItemProfile> itemProfile ,List<RelationProfile> relationProfile)
	{
		List<FeatureRecord> records=new ArrayList<FeatureRecord>();
		for(RelationProfile rp:relationProfile)
		{
			FeatureRecord record=new FeatureRecord();
			int userId=rp.getUserId();
			int itemId=rp.getItemId();
			record.setUser_id(userId);
			record.setItem_id(itemId);
			int catogaryId=rp.getCatogaryId();
			record.count[0]=rp.getScanCount();
			record.count[1]=rp.getCollectCount();
			record.count[2]=rp.getCartCount();
			record.count[3]=rp.getPurchaseCount();
			if(rp.getLastScanTime()!=null)
			record.lastInteral[0]=Time2Interal.getInteral(rp.getLastScanTime());
			if(rp.getLastCollectTime()!=null)
			record.lastInteral[1]=Time2Interal.getInteral(rp.getLastCollectTime());
			if(rp.getLastCartTime()!=null)
			record.lastInteral[2]=Time2Interal.getInteral(rp.getLastCartTime());
			if(rp.getLastPurchaseTime()!=null)
			record.lastInteral[3]=Time2Interal.getInteral(rp.getLastPurchaseTime());
			
			if(userProfile.get(userId)!=null&&userProfile.get(userId).getPairs().get(catogaryId)!=null)
				for(int i=0;i<4;i++)
				{
				//record.item_count[i]=itemProfile
				
					record.category_count[i]=userProfile.get(userId).getPairs().get(catogaryId).count[i];
				
				}
			else
			{
				for(int i=0;i<4;i++)
				{
				
					record.category_count[i]=0;
				
				}
				
			}
			records.add(record);
		}
		
		return records;
	}
	
	
	public  static void write2File(List<FeatureRecord> records,String outfilename)
	{
		File file=new File(outfilename);
		PrintWriter pw=null;
		
		try {
			pw=new PrintWriter(new FileWriter(file));
			
			for(FeatureRecord record:records)
			{
				String line=record.parse2String();
				pw.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			pw.close();
		}
		
		
		
		return ;
	}

}
