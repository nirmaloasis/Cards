package com.allstate.models;

public class Card {
    String card;
    String suit;

    public Card(String card, String suit) {
        this.card = card;
        this.suit = suit;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
