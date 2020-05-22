package com.j8.streams.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class Pagination {

	public static void main(String[] args) {
				    
		  //  String[][] items = { {"abc", "21999", "10"}, {"bcd", "2", "11"}, {"cdef", "21", "12"} , {"defgh", "216", "13"}};

		String[][] items = {  {"bcd", "2", "11"}, {"cdef", "21", "12"} , {"defgh", "216", "13"},{"abc", "21999", "10"} };
		    // sort by price in descending order   , 2 items per page
		    // sortParam is 2 and sort Oder is 1,  itemsper page is 2 , pageno 0
	    
		    // return string array with items name only
		    
		List<String[]> finalLst =   fetchDispLst(items,0,0,2,2);
		
		finalLst.toArray();
		for(String[] s: finalLst) {
			
			int i= 0;
			System.out.println("result:"+s[i]);
	    	i = i + 2;
			  
		}
	  
		    
	}
	
public static List<String[]> fetchDispLst(String[][] items, int sortParam ,int sortOrder ,int itemsPerPage ,int pageNo   ) {
	/*
	 Arrays.sort(items, new Comparator<String[]>(){
		 @Override
          public int compare(String[] first, String[] second){
        	  if (sortOrder == 0) { 
              final String time1 = first[sortParam];
              final String time2 = second[sortParam];
              int compare = time1.compareTo(time2);
              if(compare != 0){
                  return compare;
              }
              return compare;
        	  }else {
        		  final String time1 = first[sortParam];
                  final String time2 = second[sortParam];
                  int compare = time2.compareTo(time1);
                  if(compare != 0){
                      return compare;
                  }
                  return compare;
        	  }
          }
          });
          */
	 
	 Arrays.sort(items,(first,second) ->  {  
		 if (sortOrder == 0) { 
         final String time1 = first[sortParam];
         final String time2 = second[sortParam];
         int compare = time1.compareTo(time2);
         if(compare != 0){
             return compare;
         }
         return compare;
   	  }else {
   		  final String time1 = first[sortParam];
             final String time2 = second[sortParam];
             int compare = time2.compareTo(time1);
             if(compare != 0){
                 return compare;
             }
             return compare;
   	  }
		 });
	 
	// Comparator c = items.(first,second)-> (first< second)?-1: (first > second) ? 1: 0;
	 //Stream.of(items).flatMap(Stream::of).sorted(comparator)
	 List<String[]> list =   Arrays.asList(items);
	 
	 int fromIndex = (pageNo - 1) * itemsPerPage;
	    if(list == null || list.size() < fromIndex){
	        return Collections.emptyList();
	    }

	    // toIndex exclusive
	    return list.subList(fromIndex, Math.min(fromIndex + itemsPerPage, list.size()));
	}
			 
	 
}




	

	




