

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dixonaws on 2/18/16.
 */
public class JustOneMorev3 {
	/*
	The third and final level starts with a list that
	contains values that have numeric and non-numeric parts.
	 Here is is:

	[ ‘ab123’, ‘gh00’, ‘ijk8’, ‘lmn12’, ‘cd99ef11’ ]

	Your challenge is to take the items from this list
	and increment the numeric parts and then put them back
	into the string.

	Given the list [ ‘ab12’, ‘a5’, ‘b23a51’ ]
	When you run your code
	Then it would output [ ‘ab13’, ‘a6’, ‘b24a52’ ]
	*/

	public static void main(String[] args) {
		ArrayList wordList = new ArrayList();
		ArrayList newWordList=null;
		ArrayList elementList=null;
		ArrayList newElementList=new ArrayList();
		long startTime=0;
		long endTime=0;
		String word="";

		// whole sequences of letters and numbers are words
		// individual groupings of either alpha letters or numbers are elements
		wordList.add("ab12");
		wordList.add("a5");
		wordList.add("b23a51");
		wordList.add("z28nnaha5100988abc123a0tz12");
		wordList.add("asdfg89hbng67hefwh3434urkn");
		wordList.add("483fhiokds434389jdewklnnregre438344ujrekrl");

		int wordListLength = wordList.size();
		System.out.print("Working with this wordList(" + wordListLength + "): ");
		System.out.println(displayList(wordList));

		// this regex pattern returns groups of alpha characters or numeric characters
		Pattern pattern=Pattern.compile("\\d+|\\D+");

		startTime= Calendar.getInstance().getTimeInMillis();
		System.out.print("Processing... ");

		// loop through our values list and create a list of numbers
		for (int i = 0; i < wordListLength; i++) {
			// from here, we're working on an element
			elementList =new ArrayList();
			newWordList = new ArrayList();

			word=(String)wordList.get(i);

			// check for alpha or numeric elements (groups of characters)
			Matcher matcher=pattern.matcher(word);

			// add all the elements (groups of alpha or numeric characters) to a list
			while(matcher.find() ) {
				elementList.add(matcher.group());
			}

			// loop through the element list and increment the numeric values by one
			for(int j=0; j<elementList.size(); j++) {
				// pull out the element as a string
				String element=(String)elementList.get(j);
				String newElement="";

				// try to get the integer value of the word and increment it
				// we'll hit an exception if we try to convert an alpha element to an integer
				try {
					int intElement = Integer.valueOf(element);
					intElement=intElement+1;
					newElement=String.valueOf(intElement);
				}
				catch(NumberFormatException nfe) {
					// we came across a string, not a number!
					newElement=element;
				}
				finally {

				}

				newElementList.add(newElement);
			} // for j

			// now combine the newWordList into a new wordList
			String newWord="";

			for(int j=0; j<newElementList.size()-1; j=j+2) {
				newWord=newWord+(String)newElementList.get(j) + (String)newElementList.get(j+1);
			} // for j

			newWordList.add(newWord);

		} // for i

		endTime= Calendar.getInstance().getTimeInMillis();
		System.out.println("done (" + (endTime-startTime) + "ms).");

		System.out.print("We have created a newWordlist: ");
		System.out.println(displayList(newWordList));

	} // main

	// returns a string representation of the items in a list
	public static String displayList(List list) {
		String contents="";
		int listSize=list.size();

		contents+="[";
		for (int i = 0; i < listSize; i++) {
			contents+=list.get(i);

			if (i < listSize - 1)
				contents+=", ";
		} // for

		contents+="]";

		return(contents);
	} // displayList()

	// increment each element in a list of numbers and return it
	public static List justOneMore(List list) {
		int element=0;
		int newElement=0;
		List newNumberList=new ArrayList();

		for(int i=0; i<list.size(); i++) {
			element=(Integer) list.get(i);

			// increment the existing element
			newElement=element+1;

			// add the new element in the same index as the old element
			newNumberList.add(newElement);
		}

		return(newNumberList);
	} // justOneMore()

} // class JustOneMorev2
