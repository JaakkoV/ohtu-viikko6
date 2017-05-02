package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query1 = new QueryBuilder();
        QueryBuilder query2 = new QueryBuilder();
        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query1.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query2.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
