import ls.java.menu.LSMenu;

public class Claires extends Store{
	int payed;
	String bought;
	boolean shopping;
	static int choice;
	String[][] itemList;
	public Claires() {
		super("Claires");
	}
	public void script(Shopper theShopper) {
		System.out.println("WELCOME TO CLAIRES! EVERY 12 YEAR OLDS FAVORITE STORE");
		shopping = true;
		while(shopping == true){
			Item diamond = new Item("Fake Diamond", 100, "Claires");
			Item flowers = new Item("Flowers", 75, "Claires");
			Item pearls = new Item("Fake {Pearls", 80, "Claires");
			Item[] itemList = {diamond, flowers, pearls};
			LSMenu myMenu = new LSMenu("Choose one:");
			for(int i=0; i<itemList.length; i++) {
				String addMe = itemList[i].name;
				myMenu.addItem(addMe);
			}
			myMenu.addItem("B");
			myMenu.addItem("L");
			myMenu.addItem("exit");
			try {
				choice = myMenu.displayAndChoose();
				System.out.println(choice);
			}catch(java.lang.NumberFormatException e){
				choice = myMenu.displayAndChoose();
			}
			if(choice ==(itemList.length+1)) {
				System.out.println(theShopper.balance);
			}else if(choice ==(itemList.length+2)){
				theShopper.purchases();
			}
			else if(choice == (itemList.length+3)) {
				shopping = false;
			}
			else {
				if(theShopper.balance-itemList[choice-1].value>0) {
					payed = itemList[choice-1].value;
					bought = itemList[choice - 1].name;
					System.out.println("you bought " + itemList[choice - 1].name + " for " +itemList[choice - 1].value );
					theShopper.balance = theShopper.balance - itemList[choice - 1].value;
					System.out.println("my balance is "+theShopper.balance);
					theShopper.purchaseList.add(itemList[choice-1]);
				}
			}
		}
	}
}
