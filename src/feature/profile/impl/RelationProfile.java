package feature.profile.impl;

/**
 *�û���Ʒ���� 
 * 
 * @author ��
 * @version 1.0
 */
public class RelationProfile {
	
	private int userId;   // �û�id
	private int itemId;   //��Ʒid
	private String lastScanTime;   //���һ�������Ϊʱ��
	private String lastCollectTime;   //���һ���ղ���Ϊʱ��
	private String lastCartTime;   //���һ�μӹ��ﳵ��Ϊʱ��
	private String lastPurchaseTime;   //���һ�ι�����Ϊʱ��
	private int scanCount; //�����Ϊ����
	private int collectCount; //�ղ���Ϊ����
	private int cartCount; //�ӹ��ﳵ��Ϊ����
	private int purchaseCount; //������Ϊ����
	public int getUserId() {
		return userId;
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
	
}
