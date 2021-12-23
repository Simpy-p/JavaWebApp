package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if(query.toLowerCase().contains("which year was Theresa May first elected as the Prime Minister of Great Britain") ){
            return "2016";
        }
        if(query.toLowerCase().contains("minus") ){
            ArrayList<String> numbers = new ArrayList<>(Arrays.asList(query.split(":")));
            ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList(numbers.get(1).split(" ")));
            List<Integer> numbers3 = numbers2.stream().filter(x->isInteger(x.trim())).map(i-> parseInt(i.trim())).collect(Collectors.toList());
            return Integer.toString(numbers3.get(0)-numbers3.get(1));

        }
        if(query.toLowerCase().contains("following numbers") ){
            if(query.toLowerCase().contains("largest")){
                ArrayList<String> numbers = new ArrayList<>(Arrays.asList(query.split(":")));
                ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList(numbers.get(2).split(",")));
                return numbers2.stream().map(x->parseInt(x.trim())).max(Integer::compare).toString();
            }
            if(query.toLowerCase().contains("square and a cube")){

                String partAfterDot = query.substring(query.indexOf(':') + 2);
                ArrayList<String> numbers = new ArrayList<>(Arrays.asList(query.split(":")));
                ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList(numbers.get(2).split(",")));
                 return numbers2.stream().map(x->parseInt(x.trim())).filter(i-> (isSquare(i)&&isCube(i))).collect(Collectors.toList()).toString();
            }




        }


        return "";
    }

    static Boolean isSquare(int n)
    {
        for (int i = 0; i < n / 2 + 2; i++)
        {
            if (i * i == n)
            {
                return true;
            }
        }
        return false;
    }
    static Boolean isCube(int n)
    {
        for (int i = 0; i < n / 2 + 2; i++)
        {
            if (i * i *i  == n)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
