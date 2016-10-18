package kelley.josh.HurtLocker;

import kelley.josh.HurtLocker.HurtLockerTests.Patterns;

import java.util.*;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class FoodManager {
    ArrayList<Food> foods = new ArrayList<>();
    HurtLockerRegex regex = new HurtLockerRegex();
    String[] foodsList = {"Cookies",Patterns.cookies,"Apples",Patterns.apples,"Milk",Patterns.milk,"Bread",Patterns.bread};
    HashMap<String,String> foodMap = new HashMap<>();

    public FoodManager(){
        createFoodMap();setup();
    }

    private void setup() {
        for(Map.Entry<String,String> strang: foodMap.entrySet()){
            createFoodObject(strang.getKey(),strang.getValue(),Patterns.price);
        }
    }

    private void createFoodObject(String name, String food, String prices){
        int nameOccurrences = regex.getFoodMatches(food);
        TreeSet<String> price=regex.prices(food+prices);
        ArrayList<Integer> priceOccurrences = new ArrayList<>();
        Iterator<String> priceIterator = price.iterator();
        while (priceIterator.hasNext()){
            priceOccurrences.add(regex.getPriceMatches(food+prices,priceIterator.next()));
        }
        createNewFood(name,nameOccurrences,price,priceOccurrences);
    }

    public void createNewFood(String name, int nameOccurrences, TreeSet price, ArrayList priceOccurrences){
        foods.add(new Food(name,nameOccurrences,price,priceOccurrences));
    }

    public String errorBreakdown(){
        return String.format("Errors %15s seen: %d times"," ",regex.checkForErrors(Patterns.foodName,Patterns.price));
    }

    private void createFoodMap(){
        for (int i = 0;i<7;i+=2){
            foodMap.put(foodsList[i],foodsList[i+1]);
        }
    }
}
