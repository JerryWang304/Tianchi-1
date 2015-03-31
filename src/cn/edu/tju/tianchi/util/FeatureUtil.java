package cn.edu.tju.tianchi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import cn.edu.tju.tianchi.feature.profile.IItemProfile;
import cn.edu.tju.tianchi.feature.profile.IRelationProfile;
import cn.edu.tju.tianchi.feature.profile.IUserProfile;
import cn.edu.tju.tianchi.util.FeatureRecord;

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
	
	public  static List<FeatureRecord>  handle(List<IUserProfile> userProfile,List<IItemProfile> itemProfile ,List<IRelationProfile> relationProfile)
	{
		return null;
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
