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
		}
		;
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

		System.out.println("Dealer hand " + dealer.getDealerHand());
		System.out.println("Player hand " + player.getPlayerHand());

		if (!bjh.checkForWinnerAtTheBeginning(dealer, player)) {
			boolean play = true;
			while (play) {
				System.out.print("Would you like to Hit or Stay? >> ");
				input = sc.next();

				int valueOfCards;
				if (input.equalsIgnoreCase("Hit")) {
					player.addCard(dealer.dealCard());
					valueOfCards = player.getPlayerHand().getHandValue();
					System.out.println("Player hand " + player.getPlayerHand());
					if (valueOfCards == 21) {
						System.out.println("yeayyy you won!!" + " your cards total value is "
								+ player.getPlayerHand().getHandValue());
						play = false;
					} else if (valueOfCards > 21) {
						System.out.println(
								"You lost!!" + " Your cards total value is " + player.getPlayerHand().getHandValue());
						play = false;
					} else {
						play = true;
					}

				}else if (input.equalsIgnoreCase("Stay")) {
					play = false;

				}else {
					System.out.println("Wrong input");
					play = true;
				}

			};

			bjh.determineFinalWinner(dealer, player);
			//clear old deck
			dealer.getDealerHand().clearHand();
			player.getPlayerHand().clearHand();
			
			System.out.println("Size of deck" +dealer.getDeck().checkDeckSize());

		}
	}

	public void printGreeting() {
		System.out.println("Hello!Welcome To Las Vegas!");
	}

	// check for low size of deck
	// check for if to play again to clear old deck

}
