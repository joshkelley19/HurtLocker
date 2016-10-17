package kelley.josh.HurtLocker;

import kelley.josh.HurtLocker.HurtLockerTests.Patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class FoodManager {
    ArrayList<Food> foods = new ArrayList<>();
    HurtLockerRegex regex = new HurtLockerRegex();

    public FoodManager(){
        setup();
    }

    private void setup() {
        findApples();findBread();findCookies();findMilk();
    }

    public void createNewFood(String name, int nameOccurrences, TreeSet price, ArrayList priceOccurrences){
        foods.add(new Food(name,nameOccurrences,price,priceOccurrences));
    }

    public void findCookies(){
        String name = "Cookies";
        int nameOccurrences = regex.getFoodMatches(Patterns.cookies);
        TreeSet<String> price=regex.prices(Patterns.cookiesPrice);
        ArrayList<Integer> priceOccurrences = new ArrayList<>();
        Iterator<String> priceIterator = price.iterator();
        while (priceIterator.hasNext()){
            priceOccurrences.add(regex.getPriceMatches(Patterns.cookiesPrice,priceIterator.next()));
        }
        createNewFood(name,nameOccurrences,price,priceOccurrences);
    }
    public void findApples(){
        String name = "Apples";
        int nameOccurrences = regex.getFoodMatches(Patterns.apples);
        TreeSet<String> price=regex.prices(Patterns.applesPrice);
        ArrayList<Integer> priceOccurrences = new ArrayList<>();
        Iterator<String> priceIterator = price.iterator();
        while (priceIterator.hasNext()){
            priceOccurrences.add(regex.getPriceMatches(Patterns.applesPrice,priceIterator.next()));
        }
        createNewFood(name,nameOccurrences,price,priceOccurrences);
    }
    public void findMilk(){
        String name = "Milk";
        int nameOccurrences = regex.getFoodMatches(Patterns.milk);
        TreeSet<String> price=regex.prices(Patterns.milkPrice);
        ArrayList<Integer> priceOccurrences = new ArrayList<>();
        Iterator<String> priceIterator = price.iterator();
        while (priceIterator.hasNext()){
            priceOccurrences.add(regex.getPriceMatches(Patterns.milkPrice,priceIterator.next()));
        }
        createNewFood(name,nameOccurrences,price,priceOccurrences);
    }
    public void findBread(){
        String name = "Bread";
        int nameOccurrences = regex.getFoodMatches(Patterns.bread);
        TreeSet<String> price=regex.prices(Patterns.breadPrice);
        ArrayList<Integer> priceOccurrences = new ArrayList<>();
        Iterator<String> priceIterator = price.iterator();
        while (priceIterator.hasNext()){
            priceOccurrences.add(regex.getPriceMatches(Patterns.breadPrice,priceIterator.next()));
        }
        createNewFood(name,nameOccurrences,price,priceOccurrences);
    }


}
