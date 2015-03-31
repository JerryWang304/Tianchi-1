package cn.edu.tju.tianchi.feature;

import java.util.List;

import cn.edu.tju.tianchi.feature.profile.IItemProfile;
import cn.edu.tju.tianchi.util.ItemRecord;
import cn.edu.tju.tianchi.util.UserItemRecord;

public interface IItemFeature {
	public  List<IItemProfile>  getItemFeature(List<UserItemRecord> userItemRecord,List<ItemRecord> itemRecord);

}
