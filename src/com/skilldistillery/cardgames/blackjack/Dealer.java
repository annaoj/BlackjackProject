package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;
import com.skilldistillery.cardgames.common.Hand;

public class Dealer{
	private Deck deck;
	
	private BlackJackHand dealerHand;

	public Dealer() {
		super();
		this.deck = new Deck();
		this.dealerHand = new BlackJackHand();
		
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(BlackJackHand dealerHand) {
		this.dealerHand = dealerHand;
	}
	//dealer need to gt deck
	
	public Deck getDeck() {
		return deck;
	}
	
	//method dealCard return card
	public Card dealCard() {
		return deck.dealCard();
	}
	
	public void addCard(Card c) {
		dealerHand.addCard(c);;
	}
	
	public void showCardinDealerHand(BlackJackHand hand) {
		List<Card> dealerCards = hand.getCards();
		for (int i= 0; i<=dealerCards.size(); i++ ) {
			if(i != 0) {
				System.out.println(dealerCards.get(i));
			}
		}
	}


}
