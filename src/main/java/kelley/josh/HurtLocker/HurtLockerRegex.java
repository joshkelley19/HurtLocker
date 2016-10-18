package kelley.josh.HurtLocker;

import kelley.josh.HurtLocker.HurtLockerTests.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class HurtLockerRegex {
    static Main main = new Main();

    public HurtLockerRegex(){

    }

    public String getInputData() throws HurtLockerException{
        String rawData = "";
        try {
            rawData = main.readRawDataToString();
        } catch (Exception e) {
            throw new HurtLockerException("Unable to access raw data");
        }
        return rawData;
    }

    public int valueMatches(Matcher matcher){
//        nameValue = valueMatcher.matcher(stringToFind);
        int numberOfMatches=0;
        while (matcher.find()){
            numberOfMatches++;
        }
        return numberOfMatches;
    }
    //send name value to set, track how many times overwritten

    public List<String> jerkSonObjectMatch(){
        String match = "";
        int matches = 0;
        ArrayList<String> jerkSonObjects = new ArrayList<>();
        try {
            Pattern p = Patterns.jerkSonObject;
            Matcher m = p.matcher(getInputData());
            while (m.find()){
                match = m.group();
                jerkSonObjects.add(match);
                matches++;
            }
        }catch (HurtLockerException e){
            System.out.println(e.getMessage());
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        return jerkSonObjects;
    }

    public Matcher getMatcher(String pattern, String match){
        Pattern holder = Pattern.compile(pattern);
        return holder.matcher(match);
    }

    public int getFoodMatches(String pattern){
        int matches = 0;
        List<String> data = jerkSonObjectMatch();
        for (String d: data){
            if(getMatcher(pattern,d).find())matches++;
        }
        return matches;
    }

    public TreeSet<String> prices(String pattern){
        TreeSet<String> prices = new TreeSet<>();
        List<String> data = jerkSonObjectMatch();
        for (String d: data){
            Matcher matcher1 = getMatcher(pattern,d);
            if(matcher1.find()){
                String[] holder = matcher1.group().split(":");
                prices.add(holder[1]);
            }
        }
        return prices;
    }

    public int getPriceMatches(String pattern, String price){
        int matches=0;
        List<String> data = jerkSonObjectMatch();
        for (String d: data){
            Matcher matcher = getMatcher(pattern,d);
            if(matcher.find()){
                String[] holder = matcher.group().split(":");
                if(holder[1].equals(price))matches++;
            }
        }
        return matches;
    }

    public int checkForErrors(String name, String price){
        int errors=0;
        List<String> data = jerkSonObjectMatch();
        for (String d: data){
            if(!getMatcher(name,d).find()){
                errors++;
            }
            if(!getMatcher(price,d).find()){
                errors++;
            }
        }
        return errors;
    }
}
