package feature;

import java.util.List;




import util.ItemRecord;
import util.UserItemRecord;
import feature.profile.IRelationProfile;

public interface IRelationFeature {
	public List<IRelationProfile>  getRelationFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);
	

}
