package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;

public class BlackJackHand extends Hand {
	public BlackJackHand() {
		super();
	}

	public boolean shouldDealerHit(Dealer dealerHand, Player playerHand) {
		int countDealerVal = dealerHand.getDealerHand().getHandValue();
		if (countDealerVal < 17) {
			System.out.println("Dealer value " + countDealerVal);
			System.out.println("Dealer did Hit ");
			return true;
		} else {
			System.out.println("Dealer value " + countDealerVal);
			System.out.println("Dealer did stay ");
			return false;
		}
	}

	public boolean checkForWinnerAtTheBeginning(Dealer dealerHand, Player playerHand) {
		int countDealerVal = dealerHand.getDealerHand().getHandValue();
		int countPlayerHand = playerHand.getPlayerHand().getHandValue();
		if (countDealerVal == 21) {
			System.out.println("Dealer Won ");
			System.out.println("Dealer cards value is  " + countDealerVal);
			return true;
		} else if (countPlayerHand == 21) {
			System.out.println("Congrats! You won! ");
			System.out.println("Your cards value  is" + countPlayerHand);

			return true;

		} else if (countPlayerHand == 21 && countDealerVal == 21) {
			System.out.println("Both has 21.Lets play again!");
			return true;

		} else if (countPlayerHand > 21 && countDealerVal > 21) {
			System.out.println("Both over 21.Lets play again!");
			return true;

		} else if (countPlayerHand > 21 && countDealerVal <= 21) {
			System.out.println("You lost!!!");
			return true;
		} else if (countDealerVal > 21 && countPlayerHand <= 21) {
			System.out.println("You Won!!!");
			return true;

		}
		return false;
	}

	public void determineFinalWinner(Dealer dealer, Player player) {

		while (shouldDealerHit(dealer, player)) {
			dealer.addCard(dealer.dealCard());
		}

		int countDealerVal = dealer.getDealerHand().getHandValue();
		int countPlayerVal = player.getPlayerHand().getHandValue();

		if (countDealerVal < 21 && countPlayerVal < 21) {
			if ((21 - countPlayerVal) < (21 - countDealerVal)) {
				System.out.println("Congratulations! You won!");
			} else if((21 - countPlayerVal) == (21 - countDealerVal)){
				System.out.println("Neither won! Lets play again");
			}
			else {
				System.out.println("Sorry! You lost!");
			}
		} else {
			checkForWinnerAtTheBeginning(dealer, player);
		}

	}

	public void showCardinDealerHand(BlackJackHand hand) {
		List<Card> dealerCards = hand.getCards();
		for (int i = 0; i <= dealerCards.size(); i++) {
			if (i != 0) {
				System.out.println(dealerCards.get(i));
			}
		}
	}

}
