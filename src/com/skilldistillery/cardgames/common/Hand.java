package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Hand {

	private List<Card> hand;
	//hand created empty
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
	
	//we can add card to the hand
	public void addCard(Card c) {
		try {
			hand.add(c);
		} catch (NullPointerException e) {
			System.out.println("Card is null");
		}
		
	}
	
	public void clearHand() {
		hand.clear();// or should I new ArrayList
	}
	
	public List<Card> getCards() {
		return hand;	
	}

	@Override
	public String toString() {
		return hand.toString();
	}
	
	//show top one card for dealer
	public Card showOneCard() {
		return hand.get(0);
	}
	

}
