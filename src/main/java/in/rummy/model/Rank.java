package in.rummy.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shsrini on 6/20/2017.
 */
public enum Rank {
    JOKER(0),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    private static final Map<String, Rank> map = new HashMap<>(values().length,1);

    static {
        for(Rank r : values()) {
            if(r.rank <=10 ) map.put(String.valueOf(r.rank), r);
            else if(r.rank == 11) map.put("j", r);
            else if(r.rank == 12) map.put("q", r);
            else if(r.rank == 13) map.put("k", r);
            else if(r.rank == 14) map.put("a", r);
        }
    }

    public static Rank getRank(String rank){
        Rank result = map.get(rank.toLowerCase());

        if (result == null)
            throw new IllegalArgumentException("illegal rank string: "+rank);
        else return result;
    }

}
