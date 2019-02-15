import java.util.ArrayList;

public class NatickCollection extends Mall {
    ArrayList<Store> storeList = new ArrayList<Store>();
	public NatickCollection() {
		super("Natick Collection");
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Store> makeStores() {
		Store apple = new Apple();
		Store nordstrom = new Nordstrom();
		Store wegman = new Wegman();
		Store claires = new Claires();
		Store americangirl = new AmericanGirl();
		storeList.add(apple);
		storeList.add(nordstrom);
		storeList.add(wegman);
		storeList.add(claires);
		storeList.add(americangirl);

		return storeList;
		
	}
	

}
