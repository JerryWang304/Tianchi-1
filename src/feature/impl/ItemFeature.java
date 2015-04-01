package feature.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.ItemRecord;
import util.UserItemRecord;
import feature.IItemFeature;
import feature.profile.impl.ItemProfile;

/**
 * 提取商品特征
 * @author 朝
 *
 */
public class ItemFeature implements IItemFeature{

	public List<ItemProfile> getItemFeature(
			List<UserItemRecord> userItemRecord, List<ItemRecord> itemRecord) {
		List<ItemProfile> list=new ArrayList<ItemProfile>();
		Map<String,Map<Integer,Integer>> map=new HashMap<String,Map<Integer,Integer>>();
		for(UserItemRecord record:userItemRecord){
			int item_id=record.getItem_id();
			String key=String.valueOf(item_id);
			if(map.containsKey(key)){  //map里之前已有此记录
				Map<Integer, Integer> mapTemp=map.get(key);
				if(mapTemp.containsKey(record.getBehavior_type())) //如果包含此类型的动作
				{
					int count=(Integer) mapTemp.get(record.getBehavior_type());
					count=count+1;
					mapTemp.put(record.getBehavior_type(), count);
					map.put(key, mapTemp);
				}
				else   //未包含此类型的动作
 				{
					mapTemp.put(record.getBehavior_type(), 1);
					map.put(key, mapTemp);
 				}
			}
			else
			{
				Map<Integer,Integer> mapTemp=new HashMap<Integer, Integer>();
				mapTemp.put(record.getBehavior_type(), 1);
				map.put(key, mapTemp);
			}
		}
		Set<String> key = map.keySet();
        for (Iterator<String> it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            ItemProfile item=new ItemProfile();
            int item_id=Integer.valueOf(s);
            item.setItemId(item_id);
            Map<Integer, Integer> mapTemp=map.get(s);
            //type==1 
            if(mapTemp.containsKey(1))
            {
            	int count=mapTemp.get(1);
            	item.setScanCount(count);
            }
          //type==2
            if(mapTemp.containsKey(2))
            {
            	int count=mapTemp.get(2);
            	item.setCollectCount(count);
            }
            //type==3
            if(mapTemp.containsKey(3))
            {
            	int count=mapTemp.get(3);
            	item.setCartCount(count);
            }
            //type==4
            if(mapTemp.containsKey(4))
            {
            	int count=mapTemp.get(4);
            	item.setPurchaseCount(count);
            }
            list.add(item);
        }
		System.out.println(list.size());
		return list;
	}

	

}
