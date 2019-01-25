package com.skilldistillery.cardgames.common;

public enum Suit {
	HEARTS("\u2661"), SPADES("\u2664"), CLUBS("\u2663"), DIAMONDS("\u2662");
	
	final private String name;
	
	
	Suit(String s){
		name = s;
	}
	
	  @Override
	  public String toString() {
	    return name;
	  }

	  public String getName() {
	    return name;
	  }
	
}
