package kelley.josh.HurtLocker;


import kelley.josh.HurtLocker.HurtLockerTests.Patterns;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class RegexTests {
    public HurtLockerRegex regex;
    @Before
    public void init(){
        regex = new HurtLockerRegex();
    }

    @Test
    public void getRawDataTest0()throws HurtLockerException{
        String unexpected = "";//method variable initialized to ""
        String actual = regex.getInputData();
        assertNotEquals(unexpected,actual);
    }

    @Test
    public void valueMatchesTest0(){
        Pattern p = Pattern.compile("j");
        Matcher m = p.matcher("jrwsssjrttdjrjqwwqewrrrrrrrrj");
        int expected = 5;
        int actual = regex.valueMatches(m);
        assertEquals(expected,actual);
    }

    @Test
    public void valueMatchesTest1(){
        Pattern p = Pattern.compile("j");
        Matcher m = p.matcher("jrwsssjrttdjrjqwwqewrrrrrrrrjggersgj");
        int expected = 6;
        int actual = regex.valueMatches(m);//will return 6
        assertEquals(expected,actual);
    }

    @Test
    public void jerkSonObjectTest0() throws HurtLockerException{
        int expected = 28;
        int actual = regex.jerkSonObjectMatch().size();
        assertEquals(expected,actual);
    }

    @Test
    public void getCookieMatches0(){
        int expected = 8;
        int actual = regex.getFoodMatches(Patterns.cookies);
        assertEquals(expected,actual);
    }

    @Test
    public void getApplesMatches0(){
        int expected = 4;
        int actual = regex.getFoodMatches(Patterns.apples);
        assertEquals(expected,actual);
    }

    @Test
    public void getMilkMatches0(){
        int expected = 8;
        int actual = regex.getFoodMatches(Patterns.milk);
        assertEquals(expected,actual);
    }

    @Test
    public void getBreadMatches0(){
        int expected = 6;
        int actual = regex.getFoodMatches(Patterns.bread);
        assertEquals(expected,actual);
    }
}
