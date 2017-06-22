package in.rummy.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shsrini on 6/20/2017.
 */
public class Table {
    private int numOfPlayers;
    private int numOfDecks;
    private Card joker;
    private LinkedList<Card> openDeck;
    private List<Card> deck;

    public Table(int numOfPlayers, int numOfDecks) {
        this.numOfPlayers = numOfPlayers;
        this.numOfDecks = numOfDecks;
        openDeck = new LinkedList<Card>();
    }

    public void setJoker(Card joker) {
        joker = joker;
        joker.setJoker();
    }

    public LinkedList<Card> getOpenDeck() {
        return openDeck;
    }

    public void setOpenDeck(LinkedList<Card> openDeck) {
        this.openDeck = openDeck;
    }

    public void addCardToOpenDeck(Card card)
    {
        openDeck.add(card);
        // adds it to the last of the list
    }

    public Card removeCardFromOpenDeck()
    {
        return openDeck.removeLast();
        // removes from the last to behave it like stack
    }
}
