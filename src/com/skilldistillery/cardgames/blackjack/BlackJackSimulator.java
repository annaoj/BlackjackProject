package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

public class BlackJackSimulator {

	public static void main(String[] args) {
		BlackJackSimulator bjs = new BlackJackSimulator();
		Scanner sc = new Scanner(System.in);
		bjs.start(sc);
		sc.close();
	}

	public void start(Scanner sc) {
		boolean letUserPlay = true;
		printGreeting();

		while (letUserPlay) {
			System.out.print("Would you like to play BlackJack? Yes/No >> ");
			String userResponse = sc.next();
			if (userResponse.equalsIgnoreCase("yes")) {
				playBlackJack(sc);
			} else if (userResponse.equalsIgnoreCase("no")) {
				letUserPlay = false;
			} else {
				System.out.println("I don't understand!!");
			}
		};
		System.out.println("\n Good Bye!Come back again!");
	}

	public void playBlackJack(Scanner sc) {
		
		Player player = new Player();
		Dealer dealer = new Dealer();
		BlackJackHand bjh = new BlackJackHand();
		String input;

		dealer.getDeck().shuffle();
		
		dealer.addCard(dealer.dealCard());
		player.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());
		player.addCard(dealer.dealCard());

		System.out.println("Dealer \u270B " + dealer.getDealerHand().showOneCard());
		System.out.println("Bond \u270B " + player.getPlayerHand());

		if (!bjh.checkForWinnerAtTheBeginning(dealer, player)) {
			boolean play = true;
			while (play) {
				System.out.print("Would you like to Hit or Stay? >> ");
				input = sc.next();

				int valueOfCards;
				if (input.equalsIgnoreCase("Hit")) {
					player.addCard(dealer.dealCard());
					valueOfCards = player.getPlayerHand().getHandValue();
					System.out.println("Bond \u270B " + player.getPlayerHand());
					if (valueOfCards == 21) {
						System.out.println("Yeayy, you Won and Saved the world!!" + " your cards total value is "
								+ player.getPlayerHand().getHandValue());
						System.out.println("Dealer \u270B " + dealer.getDealerHand());
						play = false;
					} else if (valueOfCards > 21) {
						System.out.println(
								"You lost!!" + " Your cards total value is " + player.getPlayerHand().getHandValue());
						System.out.println("Dealer \u270B " + dealer.getDealerHand());

						play = false;
					} else {
						play = true;
					}

				}else if (input.equalsIgnoreCase("Stay")) {
					bjh.determineFinalWinner(dealer, player);
					play = false;

				}else {
					System.out.println("Wrong input");
					play = true;
				}

			};

			dealer.getDealerHand().clearHand();
			player.getPlayerHand().clearHand();
			
		}
	}

	public void printGreeting() {
		System.out.println("\n\n\t\t\t\t Hello and Thank you for joining!");
		printgun();
		
		System.out.println("\n" + 
				"                                                                        \n" + 
				"                   .------.                                             \n" + 
				".------.           |A .   |   YOU ARE BRITISH SECRET AGENT 007, JAMES BOND   \n" + 
				"|A_  _ |    .------; / \\  |   You are going to the BlackJack tournament in Monte Negro at the CASINO ROYALE.    \n" + 
				"|( \\/ )|-----. _   |(_,_) |   You need to win this game and get important coordinates of the place\n" + 
				"| \\  / | /\\  |( )  |  I  A|   where terrorists hid the bomb.       \n" + 
				"|  \\/ A|/  \\ |_x_) |------'                                             \n" + 
				"`-----+'\\  / | Y  A|          GOOD LUCK MR.BOND!                       \n" + 
				"      |  \\/ A|-----'                                                    \n" + 
				"      `------'                                          ");

		
		printgun();
		
		
		System.out.println("\n\t\t\t\t\t" + ("Welcome To Casino Royale!").toUpperCase()+ "\n\n");

	}

	
	public void printgun() {
		System.out.println("     _,________\n" + 
				"007 _ _==____()" + "==========================================================================\n"+
				"   /##(_)-'\n" + 
				"  /##/\n" + 
				"  \"\"\"");
	}
}
