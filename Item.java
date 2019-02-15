
public class Item {
	String name;
	int value;
	String storeName;
	public Item(String name, int value, String storeName) {
		this.name = name;
		this.value = value;
		this.storeName = storeName;
	}
	
	
	@Override 
	public String toString(){
		return name;
	}
	


}
