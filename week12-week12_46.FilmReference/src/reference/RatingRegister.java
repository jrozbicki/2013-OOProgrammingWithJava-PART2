package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class RatingRegister {
    private Map<Film, List<Rating>> listOfFilmsAndItsRatings;
    private Map<Person, Map<Film, Rating>> personalReviews;
    private List<Person> listOfReviewers;

    public RatingRegister(){
        this.listOfReviewers = new ArrayList<Person>();
        this.personalReviews = new HashMap<Person, Map<Film, Rating>>();
        this.listOfFilmsAndItsRatings = new HashMap<Film, List<Rating>>();
    }

    public void addRating(Film film, Rating rating){
        if(listOfFilmsAndItsRatings.containsKey(film)){
            listOfFilmsAndItsRatings.get(film).add(rating);
        } else {
            this.listOfFilmsAndItsRatings.put(film, new ArrayList<Rating>());
            listOfFilmsAndItsRatings.get(film).add(rating);
        }
    }

    public Map<Person, Map<Film, Rating>> getPersonalReviews(){
        return this.personalReviews;
    }

    public List<Rating> getRatings(Film film){
        return this.listOfFilmsAndItsRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings(){
        return this.listOfFilmsAndItsRatings;
    }

    public void addRating(Person person, Film film, Rating rating){
        if(personalReviews.containsKey(person)){
            if(personalReviews.containsValue(personalReviews.get(person).containsKey(film))){
                System.out.println("This person already rated this film");
            } else {
                personalReviews.get(person).put(film, rating);
                addRating(film,rating);
            }
        } else {
            this.listOfReviewers.add(person);
            this.personalReviews.put(person, new HashMap<Film, Rating>());
            this.personalReviews.get(person).put(film, rating);
            addRating(film,rating);
        }
    }

    public Rating getRating(Person person, Film film){
        if(personalReviews.get(person).containsKey(film)){
            return personalReviews.get(person).get(film);
        } else {
            return Rating.NOT_WATCHED;
        }
    }

    public Map<Film, Rating> getPersonalRatings(Person person){
        if(personalReviews.containsKey(person)) {
            return personalReviews.get(person);
        } else {
            return new HashMap<Film, Rating>();
        }
    }

    public List<Person> reviewers(){
        return listOfReviewers;
    }
}
