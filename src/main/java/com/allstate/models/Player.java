package com.allstate.models;


import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards;

    public Player(Card c1, Card c2) {
        this.cards = new ArrayList<Card>();
        this.cards.add(c1);
        this.cards.add(c2);

    }

    public void addCard(Card c){
        cards.add(c);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getTotalValue(){
        
    }
}

