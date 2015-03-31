package feature;



import java.util.List;

import util.ItemRecord;
import util.UserItemRecord;
import feature.profile.IUserProfile;

public interface IUserFeature {
	
	public List<IUserProfile> getUserFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);

}
