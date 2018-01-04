package reference;


import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Test your code here
//        RatingRegister ratings = new RatingRegister();
//        Film BestFilmEver = new Film("Best Film Ever");
//        Film goneWithTheWind = new Film("Gone with the Wind");
//        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
//        Film eraserhead = new Film("Eraserhead");
//        Film worst = new Film("Worst Film Ever");
//
//        Person matti = new Person("Matti");
//        Person pekka = new Person("Pekka");
//        Person mikke = new Person("Mikke");
//
//        ratings.addRating(matti, goneWithTheWind, Rating.FINE);
//        ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
//        ratings.addRating(matti, eraserhead, Rating.FINE);
//        ratings.addRating(matti, BestFilmEver, Rating.GOOD);
//
//        ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
//        ratings.addRating(pekka, theBridgesOfMadisonCounty, Rating.BAD);
//        ratings.addRating(pekka, eraserhead, Rating.MEDIOCRE);
//
//        //ratings.addRating(mikke, goneWithTheWind, Rating.FINE);
//        //ratings.addRating(mikke, theBridgesOfMadisonCounty, Rating.BAD);
//        ratings.addRating(mikke, BestFilmEver, Rating.NEUTRAL);
//        ratings.addRating(mikke, worst, Rating.BAD);
//
//        Reference ref = new Reference(ratings);
//        Film recommended = ref.recommendFilm(mikke);
//        System.out.println(ref.synergyMap(pekka));
//        System.out.println(ref.bestSynergyWith(ref.synergyMap(pekka)));
//        System.out.println("Pekka: "+ref.filmsRatedBy(pekka));
//        System.out.println("Matti: "+ref.filmsRatedBy(matti));
//        System.out.println("To recomend: "+ref.notWatchedFilmsToRecommend(pekka,ref.bestSynergyWith(ref.synergyMap(pekka))));
//        System.out.println("Film to recomend: "+ref.filmToRecommend(ref.notWatchedFilmsToRecommend(pekka, ref.bestSynergyWith(ref.synergyMap(pekka)))));
//        //System.out.println("The film recommended to Michael is: " + recommended);

        RatingRegister ratings = new RatingRegister();

        Film goneWithTheWind = new Film("Gone with the Wind");
        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
        Film eraserhead = new Film("Eraserhead");
        Film bluesBrothers = new Film("Blues Brothers");

        Person matti = new Person("Matti");
        Person pekka = new Person("Pekka");
        Person mikke = new Person("Mikael");
        Person thomas = new Person("Thomas");
        Person arto = new Person("Arto");

        ratings.addRating(matti, goneWithTheWind, Rating.BAD);
        ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
        ratings.addRating(matti, eraserhead, Rating.FINE);

        ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
        ratings.addRating(pekka, eraserhead, Rating.BAD);
        ratings.addRating(pekka, bluesBrothers, Rating.MEDIOCRE);

        ratings.addRating(mikke, eraserhead, Rating.BAD);

        ratings.addRating(thomas, bluesBrothers, Rating.GOOD);
        ratings.addRating(thomas, theBridgesOfMadisonCounty, Rating.GOOD);

        Reference ref = new Reference(ratings);
        System.out.println(thomas + " recommendation: " + ref.recommendFilm(thomas));
        System.out.println(mikke + " recommendation: " + ref.recommendFilm(mikke));
        System.out.println(matti + " recommendation: " + ref.recommendFilm(matti));
        System.out.println(arto + " recommendation: " + ref.recommendFilm(arto));

    }
}
