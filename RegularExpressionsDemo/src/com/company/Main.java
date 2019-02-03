package com.company;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am";
        System.out.println(string);
        String yourSting = string.replaceAll("I", "You");
        System.out.println(yourSting);
        String alphamnumeric = "abcDeeeF12Ghhiiiikk99z";
        System.out.println(alphamnumeric.replaceAll(".", "Y"));
        System.out.println(alphamnumeric.replaceAll("^abcDeee", "YYY"));
        String secondString = "abcDeeeF12Ghhiiiikk99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));
        System.out.println(alphamnumeric.matches("^abcDeee"));
        System.out.println(alphamnumeric.matches("^abcDeeeF12Ghhiiiikk99z"));
        System.out.println(alphamnumeric.replaceAll("ikk99z$", "THE END "));
        System.out.println(alphamnumeric.replaceAll("[aei]", "x"));
        System.out.println(alphamnumeric.replaceAll("[aei][Fj]", "X"));
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        String newAplhanumeric = "abcDeeeF12Ghhiiiikk99z";
        System.out.println(newAplhanumeric.replaceAll("[^ej]","X"));
        System.out.println(newAplhanumeric.replaceAll("[abcdef345678]","X"));
        System.out.println(newAplhanumeric.replaceAll("[a-fA-F3-8]","X"));
        System.out.println(newAplhanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAplhanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAplhanumeric.replaceAll("\\d","X"));
        System.out.println(newAplhanumeric.replaceAll("\\D","X"));
        String hasWhiteSpace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));
        System.out.println(hasWhiteSpace.replaceAll("\t","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S","M"));
        System.out.println(newAplhanumeric.replaceAll("\\w","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));

        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}","YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

//        String h2Pattern = ".*<h2>.*";
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);  //| Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurrence " + count +  " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while (groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        System.out.println("\n----------------------------\n");

        String h2TextGroups = "(<h2>(.+?)(</h2>))";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()){
            count++;
            System.out.println("Occurrence " + count +  " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));


    }
}
