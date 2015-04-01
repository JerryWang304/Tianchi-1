package feature.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.ItemRecord;
import util.UserItemRecord;
import feature.IRelationFeature;
import feature.profile.IRelationProfile;
import feature.profile.IUserProfile;
import feature.profile.impl.RelationProfile;

/**
 * ��ȡ�û���Ʒ��ϵ����
 * @author ��
 * @version 1.0
 */
public class RelationFeature implements IRelationFeature {

	/**
	 * �õ��������
	 */
	public List<RelationProfile> getRelationFeature(
			List<UserItemRecord> userItemRecord, List<ItemRecord> itemRecord) {
		List<RelationProfile> list=new ArrayList<RelationProfile>();
		Map<String,Map> map=new HashMap();
		for(UserItemRecord record:userItemRecord){
			int user_id=record.getUser_id();
			int item_id=record.getItem_id();
			String key=String.valueOf(user_id)+";"+String.valueOf(item_id);
			if(map.containsKey(key)){  //map��֮ǰ���д˼�¼
				//*****�õ�����������Ϊ�Ĵ���**************//
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
			else{   //����Ʒ�û������κμ�¼
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



}
