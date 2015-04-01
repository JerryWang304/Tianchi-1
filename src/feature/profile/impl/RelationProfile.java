package feature.profile.impl;

import java.util.Map;

import util.ReflectUtil;
import feature.profile.impl.RelationProfile;


/**
 *用户商品特征 
 * 
 * @author 朝
 * @version 1.0
 */
public class RelationProfile {
	
	private int userId;   // 用户id
	private int itemId;   //商品id
	int catogaryId;
	private String lastScanTime;   //最近一次浏览行为时间
	private String lastCollectTime;   //最近一次收藏行为时间
	private String lastCartTime;   //最近一次加购物车行为时间
	private String lastPurchaseTime;   //最近一次购买行为时间
	private int scanCount; //浏览行为次数
	private int collectCount; //收藏行为次数
	private int cartCount; //加购物车行为次数
	private int purchaseCount; //购买行为次数
	public int getUserId() {
		return userId;
	}
	public int getCatogaryId() {
		return catogaryId;
	}
	public void setCatogaryId(int catogaryId) {
		this.catogaryId = catogaryId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getLastScanTime() {
		return lastScanTime;
	}
	public void setLastScanTime(String lastScanTime) {
		this.lastScanTime = lastScanTime;
	}
	public String getLastCollectTime() {
		return lastCollectTime;
	}
	public void setLastCollectTime(String lastCollectTime) {
		this.lastCollectTime = lastCollectTime;
	}
	public String getLastCartTime() {
		return lastCartTime;
	}
	public void setLastCartTime(String lastCartTime) {
		this.lastCartTime = lastCartTime;
	}
	public String getLastPurchaseTime() {
		return lastPurchaseTime;
	}
	public void setLastPurchaseTime(String lastPurchaseTime) {
		this.lastPurchaseTime = lastPurchaseTime;
	}
	public int getScanCount() {
		return scanCount;
	}
	public void setScanCount(int scanCount) {
		this.scanCount = scanCount;
	}
	public int getCollectCount() {
		return collectCount;
	}
	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}
	public int getCartCount() {
		return cartCount;
	}
	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}
	public int getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	
	public String parse2String() {
		// TODO Auto-generated method stub
		
		Map<String,Object> propertys=ReflectUtil.getProperty(this);
		String line=propertys.get("userId")+","+propertys.get("itemId");
		for(String key:propertys.keySet())
		{
			if(key.equals("userId")||key.equals("itemId"))
				continue;
			line+=","+propertys.get(key);
			
		}
		return line;
	}
	
	
}
