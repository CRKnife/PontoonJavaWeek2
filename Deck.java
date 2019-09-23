/*
 *Pontoon program to learn Object Oriented Programming
 *16/09/2019
 *@author Wiktoria Sobczyk
 *Version 1.0
*/
package pontoonweek2;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cardDeck; //(resizable array to accomodate the deck)
    
    public Deck(){
        this.cardDeck = new ArrayList<Card>();
    }
    
    public void createOriginalDeck(){//method for creating the card deck
        for(Suit typeSuit : Suit.values()){ //for each suit type create a value
            for(Value typeValue : Value.values()){
                this.cardDeck.add(new Card(typeSuit,typeValue)); //adding new cards
            }
        }
    }
    
    public void shuffleCards(){ //temporary deck that will move cards around
        ArrayList<Card> swapDeck = new ArrayList<Card>(); //new temp deck
        Random randomNum = new Random();
        int randomCard = 0;
        int deckSize = this.cardDeck.size();
        for(int x=0; x<deckSize; x++){
            randomCard = randomNum.nextInt((this.cardDeck.size()-1-0) + 1) + 0; //((max-min)+1)+min
            swapDeck.add(this.cardDeck.get(randomCard)); //adding a random card from original card into this deck
            this.cardDeck.remove(randomCard); //removes the random card from the original deck
        }
        this.cardDeck = swapDeck; //put the cards into the temp deck
    }
    
    public String toString(){
        String cardOutput = "";
        for(Card aCard : this.cardDeck){ // for every card in array list
           cardOutput += "\n " + aCard.toString();
        }
        return cardOutput;
    }
    
    public void removeCards(int x){
        this.cardDeck.remove(x); //removes the card from deck
    }
    
    public Card getCards(int x){
        return this.cardDeck.get(x); //gets the card
    }
    
    public void addCards(Card addCards){
        this.cardDeck.add(addCards); //adds a card
    }
    
    public void drawCard(Deck cardMove){//draws cards from the deck
        this.cardDeck.add(cardMove.getCards(0));//getting the very first card from the deck
        cardMove.removeCards(0);//removing the card from this deck and setting it into another deck
    }
    
    public int sizeOfDeck(){//stores the size of the card deck
        return this.cardDeck.size();
    }
    
    public void moveCardsBack(Deck moveTo){//shifting the cards back into the deck
        int currentDeckSize = this.cardDeck.size();
        
        for(int x=0; x<currentDeckSize; x++){//putting the cards into the moveTo deck
            moveTo.addCards(this.getCards(x));
        }
        
        for(int x=0; x<currentDeckSize; x++){//removing cards from the deck
            this.removeCards(0);
        }
    }
    
    public int cardValue(){//stores the value of each card drawn in deck
        int totalValue = 0;
        for (Card aCard : this.cardDeck){//for every card that is drawn
            switch(aCard.getCardValue()){
                case Ace: totalValue += 1; break;
                case Two: totalValue += 2; break;  
                case Three: totalValue += 3; break;
                case Four: totalValue += 4; break;
                case Five: totalValue += 5; break;  
                case Six: totalValue += 6; break;
                case Seven: totalValue += 7; break;
                case Eight: totalValue += 8; break;  
                case Nine: totalValue += 9; break;
                case Ten: totalValue += 10; break;
                case Jack: totalValue += 10; break;  
                case Queen: totalValue += 10; break;
                case King: totalValue += 10; break;
            }
        }
        return totalValue;
    }
}