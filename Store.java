
public abstract class Store {
	String storeName;
	int payed;
	String bought;
	public Store(String storeName) {
		this.storeName = storeName;
	}
	
	
	@Override 
	public String toString(){
		return storeName;
	}

	public void script(Shopper theShopper) {
		
	}
	

}
