import java.util.List;

public class Admin extends User {
private static Admin instance;

private Admin() {}

public static Admin getInstance() {
    if (instance == null) {
        instance = new Admin();
    }
    return instance;
}

public void addMovie(Movie movie) {}
public void addTheatre(Theatre theatre) {}
public void addMovieShow(Show show) {}
public void setPricingRules(List<PricingStrategy> rules) {}
}
