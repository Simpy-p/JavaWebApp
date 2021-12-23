package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if(query.toLowerCase().contains("following numbers") ){
            if(query.toLowerCase().contains("largest")){

                String partAfterDot = query.substring(query.indexOf(':') + 2);
                ArrayList<String> numbers = new ArrayList<>(Arrays.asList(query.split(":")));
                ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList(numbers.get(2).split(",")));
//                int largestNumber=-22;
                return numbers2.stream().map(x->parseInt(x.trim())).max(Integer::compare).toString();
//
//                for(int i=0;i<numbers2.size();i++){
//                    if (largestNumber < parseInt(numbers2.get(i).trim())){
//                          largestNumber =parseInt(numbers2.get(i).trim());
//                    }
//                }
//                return Integer.toString(largestNumber);
            }
        }


        return "";
    }
}
