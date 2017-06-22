package in.rummy.game;

import in.rummy.model.*;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shsrini on 6/20/2017.
 */
public class Game {

    public static void main(String[] args) {
        int numOfPlayers = 6;
        int numOfDecks = 2;
        Scanner scanner = new Scanner(System.in);

        Table table = new Table(numOfPlayers, numOfDecks);

        /*Enter Joker*/
        System.out.println("Joker:");
        String jokerString = scanner.nextLine();
        if(jokerString != null & !jokerString.isEmpty())
        {
            Card joker = new Card(jokerString);
            table.setJoker(joker);
            System.out.println("joker - "+joker);
        }
        /*Enter Your Cards*/

        System.out.println("Enter your cards");
        Player you = new Player(0);
        for(int i = 0; i < 13 ; i++ )
        {
            System.out.print((i+1) + ">");
            String cardString = scanner.nextLine();
            if(cardString != null & !cardString.isEmpty()){
                Card card;
                try {
                    card = new Card(cardString);
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong entry : "+ cardString+ " Enter again :" );
                    i--;
                    continue;
                }
                you.addCard(card);
            }
        }
        System.out.println("Your cards are:"+ you.toString());

        /*
            Player numbering starts from the right hand side and goes in anti clockwise direction.
            apart from you there will be 5 other players.
            Player 0 is always you.
         */
        System.out.println("Open Card: ");
        Card openCard = new Card(scanner.next());
        table.addCardToOpenDeck(openCard);


        System.out.println("First turn :");
        int playerNum = scanner.nextInt();

        LinkedList<Player> players = new LinkedList<>();
        LinkedList<Player> droppedPlayers = new LinkedList<>();
        players.add(you);
        for (int i = 1; i < 6; i++) {
            Player player = new Player(i);
            players.add(player);
        }

        ListIterator<Player> iterator = players.listIterator(playerNum);

        while(iterator.hasNext())
        {
            Player current = iterator.next();

            System.out.println("Player"+ current.getId());
            System.out.println(">Actions: pick [0]open card, [1]deck card, [2] close, [3] Drop");
            int action = scanner.nextInt();
            if(action == 0) // picked the open card
            {
                Card pickedCard = table.removeCardFromOpenDeck();
                current.pick(pickedCard); // or players[i].addCard(card)
                System.out.println("> Discarded Card: ");
                String discardedCardString = scanner.next();
                Card discardedCard = new Card(discardedCardString);
                table.addCardToOpenDeck(discardedCard);

            }
            else if(action == 1)
            {
                System.out.println("> Discarded Card: ");
                String discardedCardString = scanner.next();
                Card discardedCard = new Card(discardedCardString);
                table.addCardToOpenDeck(discardedCard);
            }
            else if(action == 2)
            {
                System.out.println("Game Closed!!");
                break;

            }
            else if(action == 3)
            {
                droppedPlayers.add(current);
                iterator.remove(); // player will be removed
            }

            if(!iterator.hasNext())
            {
                iterator = players.listIterator();
            }
        }

        for(Player player : players){
            System.out.println("Player "+player.getId());
            System.out.println(player.toString());
        }
    }
}
