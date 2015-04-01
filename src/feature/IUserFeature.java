package feature;



import java.util.List;
import java.util.Map;

import feature.profile.impl.UserProfile;
import util.ItemRecord;
import util.UserItemRecord;


public interface IUserFeature {
	
	public Map<Integer, UserProfile> getUserFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);

}
