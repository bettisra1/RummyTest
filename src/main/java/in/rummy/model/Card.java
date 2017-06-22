package in.rummy.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shsrini on 6/20/2017.
 */
public class Card {

    private static Pattern cardStringPattern = Pattern.compile("(^([2-9]|(10)|[jqkaJQKA])([cdhsCDHS]))|(jok)$");
    private static Pattern rankPattern = Pattern.compile("[2-9]|(10)|[jqkaJQKA]");
    private static Pattern suitePattern = Pattern.compile("[cdhsCDHS]");

    public  static Rank jokerRank = Rank.JOKER;


    private Suite suite;
    private Rank rank;

    private boolean isJoker;

    public Card(Suite suite, Rank value) {
        this.suite = suite;
        this.rank = value;
    }

    public Card(String cardString)
    {
        isJoker = false;
        Matcher wordMatcher = cardStringPattern.matcher(cardString);
        if(wordMatcher.find()) {
            if(wordMatcher.group().toLowerCase().equals("jok")) {
                this.rank = Rank.JOKER;
                isJoker = true;
            }
            else {
                Matcher suiteMatcher = suitePattern.matcher(cardString);
                Matcher rankMatcher = rankPattern.matcher(cardString);

                if (suiteMatcher.find()) {
                    suite = Suite.getSuite(suiteMatcher.group());
                }

                if (rankMatcher.find()) {
                    rank = Rank.getRank(rankMatcher.group());
                    if(rank.equals(jokerRank)){
                        isJoker = true;
                    }
                }
            }
        }
        else throw new IllegalArgumentException("Illegal cardString: "+ cardString);
    }

    public boolean isJoker() {
        return isJoker;
    }

    public void setJoker() {
        isJoker = true;
        jokerRank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite=" + suite +
                ", rank=" + rank +
                ", isJoker=" + isJoker +
                '}';
    }
}
