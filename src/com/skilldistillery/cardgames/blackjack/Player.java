package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;

public class Player {

	private Hand playerHand;

	public Player() {
		this.playerHand = new BlackJackHand();
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(BlackJackHand playerHand) {
		this.playerHand = playerHand;
	}
	public void addCard(Card c) {
		playerHand.addCard(c);
	}

}
