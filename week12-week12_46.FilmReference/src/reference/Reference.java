package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
    private RatingRegister ratingRegister;


    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person pX) {
        if (this.ratingRegister.reviewers().contains(pX)) {
            return filmToRecommend(notWatchedFilmsToRecommend(pX, bestSynergyWith(synergyMap(pX))));
        } else {
            return highestRatedFilm();
        }
    }

    public Film highestRatedFilm() {
        List<Film> list = listOfExistingFilmes();
        //System.out.println(list);
        Collections.sort(list, new FilmComparator(this.ratingRegister.filmRatings()));
        //System.out.println(list);
        return list.get(0);
    }

    public Map<Person, Integer> synergyMap(Person pX) {
        Map<Person, Integer> map = new HashMap<Person, Integer>();

        for (Person each : this.ratingRegister.getPersonalReviews().keySet()) {
            int synergyLevel = 0;
            boolean isThereAnySynergy = false;
            if (each == pX) {
                continue;
            } else {
                for (Film filmEach : filmsRatedBy(each).keySet()) {
                    for (Film filmPX : filmsRatedBy(pX).keySet()) {
                        if (filmEach == filmPX) {
                            synergyLevel += filmsRatedBy(each).get(filmEach).getValue() * filmsRatedBy(pX).get(filmPX).getValue();
                            isThereAnySynergy = true;
                        }
                    }
                }

            }
            if (isThereAnySynergy) {
                map.put(each, synergyLevel);
            }
        }
        return map;
    }

    public Person bestSynergyWith(Map<Person, Integer> synergyMap) {
        Person best = new Person("best");
        int bestSynergy = Collections.max(synergyMap.values());
        for (Person each : synergyMap.keySet()) {
            if (synergyMap.get(each) == bestSynergy) {
                best = each;
                break;
            }
        }
        return best;
    }

    public Map<Film, Rating> notWatchedFilmsToRecommend(Person pX, Person bestSynergyWith) {
        Map<Film, Rating> toRecommend = new HashMap<Film, Rating>();

        for (Film filmEach : filmsRatedBy(bestSynergyWith).keySet()) {
            for (Film filmPX : filmsRatedBy(pX).keySet()) {
                if (filmEach != filmPX) {
                    if (!filmsRatedBy(pX).containsKey(filmEach)) {
                        toRecommend.put(filmEach, filmsRatedBy(bestSynergyWith).get(filmEach));
                    }
                }
            }
        }
        return toRecommend;
    }

    public Film filmToRecommend(Map<Film, Rating> notWatchedYet) {
        if (notWatchedYet.isEmpty()) {
            return null;
        } else {
            int bestRatedFilm = -5;
            for (Film each : notWatchedYet.keySet()) {
                if (notWatchedYet.get(each).getValue() > bestRatedFilm) {
                    bestRatedFilm = notWatchedYet.get(each).getValue();
                }
            }
            Film best = new Film("best");
            if (bestRatedFilm > 1) {
                for (Film each : notWatchedYet.keySet()) {
                    if (notWatchedYet.get(each).getValue() == bestRatedFilm) {
                        best = each;
                        break;
                    }
                }
                return best;
            } else {
                return null;
            }
        }
    }


    public Map<Film, Rating> filmsRatedBy(Person person) {
        return this.ratingRegister.getPersonalRatings(person);
    }

    //Kroki:
    //1 sprawdzenie czy osoba O wprowadziła jakiekolwiek recenzje
    //case 1: jeśli nie, to wyszukujemy najwyżej oceniony film

//    public Film bestFilm(Person p1, Person p2){
//
//    }
//
//    public Person synergy(Person person){
//        //this.ratingRegister.getPersonalRatings(person);                           /// filmy i ich oceny testowanej osoby
//        Map<Person, Integer> synergryMap = new HashMap<Person, Integer>();
//        for (Person each : this.ratingRegister.getPersonalReviews().keySet()){     /// pętla do sprawdzania wywoływania kolejnych osób
//            if(each.equals(person)){
//                continue;                                                          /// jeśli sprawdzana osoba X to ona sama to continue
//            } else {
//                int synergyLevel = 0;
//                boolean ifSynergyIsReal = false;                                    /// jeśli nie to
//                for (Film filmPerson : this.ratingRegister.getPersonalRatings(person).keySet()){                         ///
//                    for(Film filmX : this.ratingRegister.getPersonalRatings(each).keySet()){
//                        if(filmPerson.equals(filmX)){
//                            synergyLevel += (this.ratingRegister.getPersonalRatings(person).get(filmPerson).getValue()*
//                                    this.ratingRegister.getPersonalRatings(each).get(filmX).getValue());
//                            ifSynergyIsReal = true;
//                        }
//                    }
//                }
//                synergryMap.put(each, synergyLevel);
//            }
//        }
//        int biggestSynergy = 0;
//        for(Person each : synergryMap.keySet()){
//            biggestSynergy = synergryMap.get(each);
//            System.out.println(biggestSynergy);
//            break;
//        }
//        Person bestPerson = new Person("bestPerson");
//        for (Person each : synergryMap.keySet()){
//            System.out.println(biggestSynergy);
//            if(synergryMap.get(each) > biggestSynergy){
//                biggestSynergy = synergryMap.get(each);
//                bestPerson = each;
//            }
//        }
//
//        if(bestPerson.getName().equals("bestPerson")){
//            return null;
//        } else {
//            System.out.println(bestPerson.getName()+123);
//            return bestPerson;
//        }
//    }

    public List<Film> listOfExistingFilmes() {
        List<Film> list = new ArrayList<Film>();
        for (Film each : this.ratingRegister.filmRatings().keySet()) {
            list.add(each);
        }
        return list;
    }
}
