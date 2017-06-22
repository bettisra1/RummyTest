package in.rummy.model;

import java.util.HashSet;
import java.util.List;

/**
 * Created by shsrini on 6/21/2017.
 */
public class Player {
    private HashSet<Card> cards;
    private boolean hasLife;
    private int sequenceCount;
    private int setCount;
    private PlayerStatus status;

    public int getId() {
        return id;
    }

    private int id;

    private Table table;

    public enum PlayerStatus{
        WAITING,
        PICKEDCARD;
    }



    public Player(int id) {
        cards = new HashSet<>(13,1);
        this.id = id;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void turn()
    {
        /*Print whether to pick from deck, opendeck*/
        //if(status == PlayerStatus.WAITING){
            // choose open deck or deck
            Card openCard = table.getOpenDeck().peekFirst();

            //figure out if this card add value to you
            // then pickup()
            // else pick up from Deck()
            // change the state to PICKEDCARD
            // return the discarded card

        //}
        //if(status == PlayerStatus.PICKEDCARD){
            // choose which card to discard
        //}
    }

    public void pick(Card card)
    {
        /*this card will be added into the deck and */
    }

    private void regroup(){

    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder(  "Player{" +
                "cards=");
        for(Card card: cards)
        {
            value.append(card.toString());
            value.append(",\n");
        }
        //value.deleteCharAt(value.lastIndexOf(","));
        value.append("}");

        return value.toString();
    }
}
