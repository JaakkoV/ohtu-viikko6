package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        matcher = new And();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int val, String cat) {
        this.matcher = new And(matcher, new HasAtLeast(val, cat));
        return this;
    }

    public QueryBuilder hasFewerThan(int val, String cat) {
        this.matcher = new And(matcher, new HasFewerThan(val, cat));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }

    public Matcher build() {
        return matcher;
    }
}
