package com.j8.streams.map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPagination {

	public static void main(String[] args) {

		String[][] items = { { "bcd", "2", "11" }, { "cdef", "21", "12" }, { "defgh", "216", "13" },
				{ "abc", "21999", "10" } };
		// sort by price in descending order , 2 items per page
		// sortParam is 2 and sort Oder is 1, itemsper page is 2 , pageno 0

		// return string array with items name only

		Stream<String[]> finalLst =   fetchDispLst(items,1,0,4,1);
		
		finalLst.forEach(x->{ int i= 0; System.out.println("final sorted with item column only:"+x[i]);  i++;});
		    
	}
	
public static Stream<String[]> fetchDispLst(String[][] items, int sortParam ,int sortOrder ,int itemsPerPage ,int pageNo   ) {
		 System.out.println("____________________________________");
	 List<String[]> strmlist = Stream.of(items).sorted((first,second)->  {  
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
			 }).collect(Collectors.toList());
	 
	 strmlist.subList((pageNo - 1) * itemsPerPage ,  strmlist.size()).forEach(x->{ int i=0;System.out.println("first col:"+x[i]+"second col:"+x[i+1]+"third col:"+x[i+2]); i++;});
			 System.out.println("____________________________________");
	 
	return strmlist.subList((pageNo - 1) * itemsPerPage ,  strmlist.size()).stream();
	 
   }
}




	

	




