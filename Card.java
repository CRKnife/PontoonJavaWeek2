/*
 *Pontoon program to learn Object Oriented Programming
 *16/09/2019
 *@author Wiktoria Sobczyk
 *Version 1.0
*/
package pontoonweek2;

public class Card {
    private Suit cardSuit; //refers to the enum and identifier
    private Value cardValue;
    
    public Card(Suit cardSuit, Value cardValue){
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }
    
    public String toString(){ //for printing out the suit and value
        return this.cardValue.toString()+ " of " +this.cardSuit.toString();
    }
    
    public Value getCardValue(){ //for finding out the card value
        return this.cardValue;
    }
}
