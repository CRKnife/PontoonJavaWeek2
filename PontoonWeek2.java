/*
 *Pontoon program to learn Object Oriented Programming
 *16/09/2019
 *@author Wiktoria Sobczyk
 *Version 1.0
*/
package pontoonweek2;
import java.util.Scanner;

public class PontoonWeek2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);
        boolean roundEnd = false;
        String choice = "";
        
        System.out.println("Welcome to the game of Pontoon!");
        
        Deck originalDeck = new Deck(); //make the playing deck
        originalDeck.createOriginalDeck();
        originalDeck.shuffleCards();
        
        Deck playerCardDeck = new Deck(); //creating a deck for the player
        Deck houseCardDeck = new Deck(); //creating the deck for the house
        
        playerCardDeck.drawCard(originalDeck);//drawing out cards for player
        playerCardDeck.drawCard(originalDeck);
        houseCardDeck.drawCard(originalDeck);//drawing out cards for house
        houseCardDeck.drawCard(originalDeck);
          
        while(true){
            System.out.println("These are your cards:");
            System.out.println(playerCardDeck.toString());
            System.out.println("The overall value of cards is: " + playerCardDeck.cardValue());
            System.out.println("Would you like to draw another card y/n?");
            choice = kboard.nextLine();
            
            if (choice.equalsIgnoreCase("y")){
                playerCardDeck.drawCard(originalDeck);
                System.out.println("You drew a: " +playerCardDeck.getCards(playerCardDeck.sizeOfDeck() - 1).toString());//(-1) is getting the deck size to start at 0 
                
                if(playerCardDeck.cardValue() > 21){
                    System.out.println("Busted! Your cards equal to " +playerCardDeck.cardValue()+ " which is over 21.");
                    roundEnd = true;
                    break;
                }
            }
            
            if(choice.equalsIgnoreCase("n")){
                break;
            }
        }
        
        while((houseCardDeck.cardValue() < 17) && roundEnd == false){//house will draw at 16 and no more cards will be drawn at 17
            houseCardDeck.drawCard(originalDeck);
        }
        
        System.out.println("The house received the cards " +houseCardDeck.toString());//revealing the house cards
        
        if((houseCardDeck.cardValue() > 21) && roundEnd == false){
            System.out.println("The house busted! You win!");
            roundEnd = true;
        }
        if(houseCardDeck.cardValue() > playerCardDeck.cardValue() && roundEnd == false){
            System.out.println("You lost! The house scored " +houseCardDeck.cardValue());
        }
        
        if((playerCardDeck.cardValue() == houseCardDeck.cardValue()) && roundEnd == false){
            System.out.println("It's a tie!");
            roundEnd = true;
        }
        
        if((playerCardDeck.cardValue() > houseCardDeck.cardValue()) && roundEnd == false){
            System.out.println("You win this round of pontoon!");
            roundEnd = true;
        } 
        
        playerCardDeck.moveCardsBack(originalDeck);//moving cards back onto the end of the array
        houseCardDeck.moveCardsBack(originalDeck);
    }
}
