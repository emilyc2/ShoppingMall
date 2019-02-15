import java.util.ArrayList;

import ls.java.menu.LSMenu;
public class Shopper {
    ArrayList<Item> purchaseList = new ArrayList<Item>();

	String name;
	double balance;
	boolean goWhere;
	public Shopper(String name , double balance) {
		this.name = name;
		this.balance = balance;
	}
	public void visit(Mall theMall) {
		goWhere = true;
		System.out.println("Welcome to the Natick Collection.");
		System.out.println ("Your debit card balance is $6000.");
		System.out.println ("Please choose one of the following stores.");
		System.out.println ("You can also type B to see your balance, ");
		System.out.println ( "or L to list the items you have purchased:");
		ArrayList<Store> storeList = new ArrayList<Store>();
	    storeList = theMall.makeStores();

		while(goWhere == true) {
		    LSMenu myMenu = new LSMenu("Choose one:");
			for(int i=0; i<storeList.size(); i++) {
				String addMe = storeList.get(i).toString();
				myMenu.addItem(addMe);
			}
			myMenu.addItem("B");
			myMenu.addItem("L");
			myMenu.addItem("exit");
			
			int choice;
			try {
				choice = myMenu.displayAndChoose();
				System.out.println(choice);

			}catch(java.lang.NumberFormatException e){
				choice = myMenu.displayAndChoose();

			}
			if(choice == (storeList.size()+1)) {
				System.out.println(balance);
			}else if(choice == (storeList.size()+2)) {
				purchases();
			}
			else if(choice == (storeList.size()+3)) {
				System.out.println("Goodbye");
				goWhere = false;

			}
			else {
				storeList.get(choice-1).script(this);
			}
	
		}
	}
	
	public void purchases() {
		System.out.println("This is what you purchased" + purchaseList);
				
	}
	public boolean done() {
		
		return true;
	}
}
