package kelley.josh.HurtLocker;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;
import java.util.TreeSet;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class Food {
    public final String name;
    public final int nameOccurrences;
    public final TreeSet<String> price;
    public final ArrayList<Integer> priceOccurrences;

    public Food(String name,int nameOccurrences,TreeSet price, ArrayList priceOccurrences){
        this.name=name;this.nameOccurrences=nameOccurrences;this.price=price;this.priceOccurrences=priceOccurrences;
    }

    public String getName() {
        return name;
    }

    public int getNameOccurrences() {
        return nameOccurrences;
    }

    public TreeSet getPrice() {
        return price;
    }

    public ArrayList getPriceOccurrences() {
        return priceOccurrences;
    }

    public String toString(){
        Iterator<String> priceIterator = price.iterator();
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %7s %8s seen: %d times\n",name," ",nameOccurrences)).append("-------------          ---------------\n");
        for (int i = 0;i<price.size();i++){
            builder.append("-------------          ---------------\n")
                    .append(String.format("Price: %6s %8s seen: %d times\n",priceIterator.next()," ",priceOccurrences.get(i)));
        }
        builder.append("\n");
        return builder.toString();
    }
}
