package cn.edu.tju.tianchi.feature;



import java.util.List;

import cn.edu.tju.tianchi.feature.profile.IUserProfile;
import cn.edu.tju.tianchi.util.ItemRecord;
import cn.edu.tju.tianchi.util.UserItemRecord;

public interface IUserFeature {
	
	public List<IUserProfile> getUserFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);

}
