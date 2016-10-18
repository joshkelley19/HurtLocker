package kelley.josh.HurtLocker.HurtLockerTests;

import java.util.regex.Pattern;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class Patterns {
    public static final String cookies = "[cC][oO0]{2}[kK][iI][eE][sS].";
    public static final String apples = "[aA][pP]{2}[lL][eE][sS].";
    public static final String milk = "[mM][iI][lL][kK].";
    public static final String bread = "[bB][rR][eE][aA][dD].";
    public static final Pattern jerkSonObject = Pattern.compile("([nN][aA][mM][eE]):(\\w)*[:@^*%;](([pP][rR][iI][cC][eE]):([\\d][.][\\d][\\d])?[:@^*%;])((type):(\\w)*[:@^*%;!])((expiration):([\\d][/][\\d]{1,2}[/][\\d]{4})?)##");
    public static final String price = "(\\w)*:[\\d][.][\\d]{2}";
    public static final String foodName = "[nN][aA][mM][eE].[\\w]+";

}
