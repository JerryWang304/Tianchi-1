package feature.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.FeatureUtil;
import util.ItemRecord;
import util.UserItemRecord;
import feature.IRelationFeature;
import feature.profile.impl.RelationProfile;

/**
 * 提取用户商品关系特征
 * @author 朝
 * @version 1.0
 */
public class RelationFeature implements IRelationFeature {

	/**
	 * 得到相关特征
	 */
	public List<RelationProfile> getRelationFeature(
			List<UserItemRecord> userItemRecord, List<ItemRecord> itemRecord) {
		List<RelationProfile> list=new ArrayList<RelationProfile>();
		Map<String,Map> map=new HashMap();
		for(UserItemRecord record:userItemRecord){
			int user_id=record.getUser_id();
			int item_id=record.getItem_id();
			int catogaryId=record.getItem_category();//要改进
			String key=String.valueOf(user_id)+";"+String.valueOf(item_id)+";"+String.valueOf(catogaryId);
			if(map.containsKey(key)){  //map里之前已有此记录
				//*****得到四种类型行为的次数**************//
				Map mapTemp=map.get(key);
				if(mapTemp.containsKey(record.getBehavior_type()))
				{
					
					Map mapTemp2=(Map) mapTemp.get(record.getBehavior_type());
					Integer count=Integer.valueOf((String) mapTemp2.get("count"));
					count=count+1;
					String time=(String) mapTemp2.get("time");
					int compareResult=record.getDate().compareTo(time);
					if(compareResult>0)
					{
						mapTemp2.put("time", record.getDate());
					}
					mapTemp2.put("count", String.valueOf(count));
					
					mapTemp.put(record.getBehavior_type(), mapTemp2);
					map.put(key, mapTemp);
				}
				else
				{
					Map mapTemp2=new HashMap();
					mapTemp2.put("count", String.valueOf(1));
					mapTemp2.put("time", record.getDate());
					mapTemp.put(record.getBehavior_type(), mapTemp2);
					map.put(key, mapTemp);
				}
				
			}
			else{   //此商品用户尚无任何记录
				Map<Integer,Map> mapTemp=new HashMap<Integer,Map>();
				Map mapTemp2=new HashMap();
				mapTemp2.put("count", String.valueOf(1));
				mapTemp2.put("time", record.getDate());
				mapTemp.put(record.getBehavior_type(), mapTemp2);
				map.put(key, mapTemp);
			}
		}
		
		Set<String> key = map.keySet();
        for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            String sTemp[]=s.split(";");
            RelationProfile relation=new RelationProfile();
            int user_id=Integer.valueOf(sTemp[0]);
            int item_id=Integer.valueOf(sTemp[1]);
            int catogaryId=Integer.valueOf(sTemp[2]);
            relation.setCatogaryId(catogaryId);
            relation.setUserId(user_id);
            relation.setItemId(item_id);
            Map mapTemp=map.get(s);
            //type==1 
            if(mapTemp.containsKey(1))
            {
            	Map mapTemp2=(Map) mapTemp.get(1);
            	int count=Integer.valueOf((String) mapTemp2.get("count"));
            	String time=(String) mapTemp2.get("time");
            	relation.setScanCount(count);
            	relation.setLastScanTime(time);
            }
          //type==2
            if(mapTemp.containsKey(2))
            {
            	Map mapTemp2=(Map) mapTemp.get(2);
            	int count=Integer.valueOf((String) mapTemp2.get("count"));
            	String time=(String) mapTemp2.get("time");
            	relation.setCollectCount(count);
            	relation.setLastCollectTime(time);
            }
            //type==3
            if(mapTemp.containsKey(3))
            {
            	Map mapTemp2=(Map) mapTemp.get(3);
            	int count=Integer.valueOf((String) mapTemp2.get("count"));
            	String time=(String) mapTemp2.get("time");
            	relation.setCartCount(count);
            	relation.setLastCartTime(time);
            }
            //type==4
            if(mapTemp.containsKey(4))
            {
            	Map mapTemp2=(Map) mapTemp.get(4);
            	int count=Integer.valueOf((String) mapTemp2.get("count"));
            	String time=(String) mapTemp2.get("time");
            	relation.setPurchaseCount(count);
            	relation.setLastPurchaseTime(time);
            }
            
            list.add(relation);
        }
		System.out.println(list.size());
		return list;
	}
	
	public static void main(String args[])
	{
		List<UserItemRecord> userItemRecords=FeatureUtil.read("train_dateset1217.csv");
		List<ItemRecord> itemRecord=FeatureUtil.readItemRecord("tianchi_mobile_recommend_train_item.csv");
		List<RelationProfile> relationProfile=new RelationFeature().getRelationFeature(userItemRecords,itemRecord);
		File file=new File("test.txt");
		PrintWriter pw=null;
		
		try {
			pw=new PrintWriter(new FileWriter(file));
			
			for(RelationProfile record:relationProfile)
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
		
	}



}
