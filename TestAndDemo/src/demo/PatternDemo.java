package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    private static boolean isTimeValid(String timeStr) {
        Pattern pattern = Pattern.compile("^([0-1][0-9]|2[0-4]):([0-5][0-9])$");
        Matcher matcher = pattern.matcher(timeStr);

        return matcher.matches();
    }
}
