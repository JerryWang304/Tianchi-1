package feature;

import java.util.List;

import util.ItemRecord;
import util.UserItemRecord;
import feature.profile.IItemProfile;

public interface IItemFeature {
	public  List<IItemProfile>  getItemFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);

}
