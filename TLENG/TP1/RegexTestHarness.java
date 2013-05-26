package TP1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args){
        
    	String regEx = "foo";
    	String text = "foo";
    	
        Pattern pattern = 
        Pattern.compile(regEx);

        Matcher matcher = 
        pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text \"%s\" starting at index %d and ending at index %d.%n",
                matcher.group(),
                matcher.start(),
                matcher.end()
                );
            found = true;
        }
        if(!found){
        	System.out.printf("No match found.%n");
        }
    }
}