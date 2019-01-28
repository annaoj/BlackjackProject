package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;
import com.skilldistillery.cardgames.common.Hand;

public class Dealer{
	private Deck deck;
	
	private Hand dealerHand;

	public Dealer() {
		this.deck = new Deck();
		this.dealerHand = new BlackJackHand();	
	}

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(BlackJackHand dealerHand) {
		this.dealerHand = dealerHand;
	}
	
	public Deck getDeck() {
		return deck;
	}

	public Card dealCard() {
		return deck.dealCard();
	}
	
	public void addCard(Card c) {
		dealerHand.addCard(c);
	}

}
