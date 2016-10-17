package kelley.josh.HurtLocker.HurtLockerTests;

import java.util.regex.Pattern;

/**
 * Created by joshuakelley on 10/17/16.
 */
public class Patterns {
    public static final Pattern cookies = Pattern.compile("[cC][oO0]{2}[kK][iI][eE][sS]");
    public static final Pattern cookiesPrice = Pattern.compile("[cC][oO0]{2}[kK][iI][eE][sS].(\\w)*:[\\d][.][\\d]{2}");
    public static final Pattern apples = Pattern.compile("[aA][pP]{2}[lL][eE][sS]");
    public static final Pattern applesPrice = Pattern.compile("[aA][pP]{2}[lL][eE][sS].(\\w)*:[\\d][.][\\d]{2}");
    public static final Pattern milk = Pattern.compile("[mM][iI][lL][kK]");
    public static final Pattern milkPrice = Pattern.compile("[mM][iI][lL][kK].(\\w)*:[\\d][.][\\d]{2}");
    public static final Pattern bread = Pattern.compile("[bB][rR][eE][aA][dD]");
    public static final Pattern breadPrice = Pattern.compile("[bB][rR][eE][aA][dD].(\\w)*:[\\d][.][\\d]{2}");
    public static final Pattern jerkSonObject = Pattern.compile("([nN][aA][mM][eE]):(\\w)*[:@^*%;](([pP][rR][iI][cC][eE]):([\\d][.][\\d][\\d])?[:@^*%;])((type):(\\w)*[:@^*%;!])((expiration):([\\d][/][\\d]{1,2}[/][\\d]{4})?)##");
    public static final Pattern price = Pattern.compile("[\\d][.][\\d]{2}");
    public static final Pattern foodName = Pattern.compile("[nN][aA][mM][eE].[\\w]+");

}
