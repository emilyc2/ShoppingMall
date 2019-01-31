import ls.java.menu.LSMenu;
public class Shopper {
	String name;
	double balance;
	public Shopper(String name , double balance) {
		this.name = name;
		this.balance = balance;
	}
	public void visit(Mall theMall) {
		System.out.println("Welcome to the Natick Collection.");
		System.out.println ("Your debit card balance is $6000.");
		System.out.println ("Please choose one of the following stores.");
		System.out.println ("You can also type B to see your balance, ");
		System.out.println ( "or L to list the items you have purchased:");
		LSMenu myMenu = new LSMenu("Choose one:");
		for(int i=0; i<3; i++) {
			String addMe = NatickCollection.storeList[i].toString();
			myMenu.addItem(addMe);
		}
		int choice = myMenu.displayAndChoose();
		System.out.println(choice);
		

	}
}
