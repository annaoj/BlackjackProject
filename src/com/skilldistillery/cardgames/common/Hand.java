package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	private List<Card> hand;

	public Hand(){
		hand = new ArrayList<Card>();
	};
	
	public int getHandValue() {
		int counter = 0;
		for(Card card : hand) {
			counter+= card.getValue();
		}
		return counter;
	}
	
	public void addCard(Card c) {
		try {
			hand.add(c);
		} catch (NullPointerException e) {
			System.out.println("Card is null");
		}
		
	}
	
	public void clearHand() {
		hand.clear();
	}
	
	public List<Card> getCards() {
		return hand;	
	}

	@Override
	public String toString() {
		return hand.toString();
	}

	public Card showOneCard() {
		return hand.get(0);
	}
	
}
