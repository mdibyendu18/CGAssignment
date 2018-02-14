package com.cg.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Problem Statement
 * Write a program to print the top 5 most repeated words from a List?
 *The output should be sorted in descending order. 
 *Consider this list as an example input: 
 *{AAA,AAA,BBB,BBB,BBB,CC,CC XXX, XXX,PP,QQ,XXX,XXX}*/

public class Problem2 {

	public static void main(String[] args) {
		int count = 0;
		List<String> al = new ArrayList<>();
		al.add("AAA");
		al.add("AAA");
		al.add("BBB");
		al.add("BBB");
		al.add("BBB");
		al.add("CC");
		al.add("CC");
		al.add("XXX");
		al.add("XXX");
		al.add("PP");
		al.add("QQ");
		al.add("XXX");
		al.add("XXX");

		Map<String,Integer> map = new HashMap<>();

		for(String temp: al) {
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);
			} else {
				map.put(temp, 1);
			}
		}
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        for(Map.Entry<String, Integer> entry:list){
        	count++;
        	if(count >5)
        		break;
        	System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
	}

}
