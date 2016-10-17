package kelley.josh.HurtLocker;

import kelley.josh.HurtLocker.HurtLockerTests.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    public ArrayList jerkSonObjectMatch() throws HurtLockerException{
//        int numberOfMatches = 0;
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
        }catch (IllegalStateException e){
            throw new HurtLockerException("No Matches found");
        }
        return jerkSonObjects;
    }


    public int getFoodMatches(Pattern pattern){
        Matcher matcher1 = null;
        List<String> data = null;
        int matches = 0;
        try {
        data = jerkSonObjectMatch();
        }catch (HurtLockerException e){
            System.out.println(e.getMessage());
        }
        for (String d: data){
            matcher1 = pattern.matcher(d);
            if(matcher1.find())matches++;
        }
        return matches;
    }

    public TreeSet<String> prices(Pattern pattern){
        Matcher matcher1 = null;
        TreeSet<String> prices = new TreeSet<>();
        List<String> data = null;
        try {
            data = jerkSonObjectMatch();
        }catch (HurtLockerException e){
            System.out.println(e.getMessage());
        }
        for (String d: data){
            matcher1 = pattern.matcher(d);
            if(matcher1.find()){
                String[] holder = matcher1.group().split(":");
                prices.add(holder[1]);
            }
        }
        return prices;
    }

    public int getPriceMatches(Pattern pattern, String price){
        Matcher matcher1;
        int matches=0;
        List<String> data = null;
        try {
            data = jerkSonObjectMatch();
        }catch (HurtLockerException e){
            System.out.println(e.getMessage());
        }
        for (String d: data){
            matcher1 = pattern.matcher(d);
            if(matcher1.find()){
                String[] holder = matcher1.group().split(":");
                if(holder[1].equals(price))matches++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        HurtLockerRegex hurtLockerRegex = new HurtLockerRegex();
//        Pattern keyMatcher = Pattern.compile(hurtLockerRegex.jerkSonObjectDelimiter);
//        boolean b = false;
//        int testNumber = 0;
//        try{
//            Matcher delimit = keyMatcher.matcher(main.readRawDataToString());
//            testNumber = hurtLockerRegex.valueMatches(delimit);
////            b = delimit.matches();
//        }catch (Exception e){
//            System.out.println("ERROR!!!!!!!!! "+e.getMessage());
//        }
//        System.out.println(testNumber);
//        hurtLockerRegex.jerkSonObjectMatch();

    }
}
