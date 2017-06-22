package in.rummy.model;

/**
 * Created by shsrini on 6/20/2017.
 */
public enum Suite {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static Suite getSuite(String suiteString)
    {
        if(suiteString.toLowerCase().equals("c")) return Suite.CLUBS;
        if(suiteString.toLowerCase().equals("d")) return Suite.DIAMONDS;
        if(suiteString.toLowerCase().equals("h")) return Suite.HEARTS;
        if(suiteString.toLowerCase().equals("s")) return Suite.SPADES;

        else throw new IllegalArgumentException("Not a valid Suite Sting: "+suiteString);
    }
}
