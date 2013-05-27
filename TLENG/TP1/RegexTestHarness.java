package TP1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {

    public static void main(String[] args){
        
    	//String regEx = "^[(/<html/>)(/<//html/>)(/<head/>)(/<//head/>)(/<body/>)(/<//body/>) (/<title/>)(/<//title/>)(/<script/>)(/<//script/>)(/<div/>)(/<//div/>)(/<h1/>)(/<//h1/>)(/<p/>)(/<//p/>) (/<br>)]";
    	//String regEx = "(.*?)(^[(<html/>)|(<//html/>)]*)(.*?)";

    	//String regEx = "([^(<)]*[^(ti)]*>)";
    	//String text = "pap>a<title>pepe</title>";
    	
//    	String regEx = "([^(<)]*[^t]*>)";
//    	String text = "texto<title>";
    	
//    	String regEx = "(([^(<)])*<[^(title)]{1,})";
//    	String text = "texto<stitle>";
    	
//    	String regEx = "^((?!</script>).)*$";
//    	String text = "wowomy string <script>";

    	String regEx = "^((?!(<script>|</script>)).)*$";
    	String text = "wowomy script <script /script>";
    	
    	// "pepe" -> "pepe"
    	// "<title>pepe" -> "no match"
    	// ">pepe" -> ">pepe"
    	// "<span>" -> "<span>"
    	// "<span>texto</span>" -> "<span>texto</span>"
    	
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);

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