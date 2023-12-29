package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        Object[]strings=delimiters.toArray();
        List<String>javob=new ArrayList<>();
        for(Object a:strings){
            javob=Arrays.asList(source.split((String) a));
            String first="";
            for(String j:javob){
                first=first+j+" ";
            }
            source=first.trim();
        }
        source=source.replace(",","");
        javob=Arrays.asList(source.split(" "));
        List<String>hj=new ArrayList<>();
        for(String nb:javob){
            if(!nb.equals("")){
                hj.add(nb.strip());

            }

        }
        return hj;
    }

}
