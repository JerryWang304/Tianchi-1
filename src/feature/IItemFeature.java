package feature;

import java.util.List;

import util.ItemRecord;
import util.UserItemRecord;

import feature.profile.impl.ItemProfile;

public interface IItemFeature {
	public  List<ItemProfile>  getItemFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);

}
