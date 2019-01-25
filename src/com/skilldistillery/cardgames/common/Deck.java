package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>(52);
	
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				//deck.add(rank);
				System.out.println(rank);

			}
		}
//		for (Card card : deck) {
//			card = new Card(Suit, Rank);
//		}
		//checkDeckSize();
	}

	public int checkDeckSize() {
		System.out.println(deck.size());
		return deck.size();
	}
	public void dealCard(List<Card> currentDeck) {
		deck.remove(0);
	}
	
	public void shuffle(List<Card> currentDeck) {
		Collections.shuffle(deck);
	}

}
