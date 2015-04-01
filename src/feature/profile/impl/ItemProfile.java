package feature.profile.impl;

/**
 * 商品特征
 * @author 朝
 *@version 1.0
 */
public class ItemProfile {
	int itemId;//商品ID
	private int scanCount; //浏览行为次数
	private int collectCount; //收藏行为次数
	private int cartCount; //加购物车行为次数
	private int purchaseCount; //购买行为次数
	private double averagePurchase;
	private double purchaseRateByAllUser;
	public double getAveragePurchase() {
		return averagePurchase;
	}
	public void setAveragePurchase(double averagePurchase) {
		this.averagePurchase = averagePurchase;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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

}
