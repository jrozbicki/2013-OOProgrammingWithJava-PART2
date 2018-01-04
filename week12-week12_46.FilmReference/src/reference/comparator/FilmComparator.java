package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
        private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.ratings = ratings;
    }

    public int averageRating(Film film){
        Iterator<Rating> iterator = this.ratings.get(film).iterator();
        int average = 0;
        int counter = 0;
        while(iterator.hasNext()){
            average+=iterator.next().getValue();
            counter++;
        }
        int result = average/counter;
        return result;
    }

    @Override
    public int compare(Film o1, Film o2) {
        return averageRating(o2) - averageRating(o1);
    }
}
