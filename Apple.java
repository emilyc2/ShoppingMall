import ls.java.menu.LSMenu;

public class Apple extends Store{
	int payed;
	String bought;
	int choice;
	boolean shopping;
	String[][] itemList;
	public Apple() {
		super("Apple");
	}
	public void script(Shopper theShopper) {
		System.out.println("YOU MADE IT TO APPLE! WANT A PEAR?");
		shopping = true;
		while(shopping == true){
			Item iPod = new Item("iPod", 425, "Apple");
			Item iPhone = new Item("iPhone", 800,"Apple");
			Item iPad = new Item("iPad", 500,"Apple");
			Item macBook = new Item("macbook", 1100,"Apple");
			Item[] itemList = {iPod, iPhone, iPad, macBook};
			LSMenu myMenu = new LSMenu("Choose one:");
			for(int i=0; i<itemList.length; i++) {
				String addMe = itemList[i].name;
				myMenu.addItem(addMe);
			}
			myMenu.addItem("B");
			myMenu.addItem("L");
			myMenu.addItem("returns");
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
			}else if(choice ==(itemList.length+3)) {
				boolean amReturning = true;
				while (amReturning ==true) {
				 LSMenu returnsMenu = new LSMenu("What do you want to return?");
					for(int j=0; j<theShopper.purchaseList.size(); j++) {
						if(theShopper.purchaseList.get(j).storeName == "Apple") {
							String addMe = theShopper.purchaseList.get(j).toString();
							returnsMenu.addItem(addMe);
						}
					}
					returnsMenu.addItem("exit");
					int returning;
					try {
						returning = returnsMenu.displayAndChoose();
						System.out.println(returning);
					}catch(java.lang.NumberFormatException e){
						returning = myMenu.displayAndChoose();
					}
					if(returning == (theShopper.purchaseList.size()+1)) {
						amReturning = false;
					}else {
						theShopper.balance = theShopper.balance + theShopper.purchaseList.get(returning-1).value;
						theShopper.purchaseList.remove(returning-1);
					}
				}
			}
			else if(choice == (itemList.length+4)) {
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
				}else {
					System.out.println("Do you want to steal the item???");
					LSMenu stealMenu = new LSMenu("Choose one:");
					stealMenu.addItem("Yes");
					stealMenu.addItem("No");
					int yesNo = stealMenu.displayAndChoose();
					if(yesNo == 1) {
						System.out.println("you stole a "+itemList[choice - 1].name);
						theShopper.purchaseList.add(itemList[choice-1]);
					}else {
						System.out.println("thank you for being a good person");
					}
				}
			}
		}
	}
}
