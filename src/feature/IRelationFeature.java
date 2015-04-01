package feature;

import java.util.List;





import util.ItemRecord;
import util.UserItemRecord;

import feature.profile.impl.RelationProfile;

public interface IRelationFeature {
	public List<RelationProfile>  getRelationFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);
	

}
