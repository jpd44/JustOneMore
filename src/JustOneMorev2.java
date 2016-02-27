import java.util.ArrayList;
import java.util.List;

/**
 * Created by dixonaws on 2/18/16.
 */
public class JustOneMorev2 {
	/*
	The second level starts with a list as well, but
	this list will be a list of strings. As you
	can see some of the strings represent numbers
	and others do not.

	[ ‘1’, ‘c’, ‘0’, ‘-1’, ‘5’, ‘b’, ‘100’, ‘37’, ‘a’, ‘20’, ‘18’, ‘12’, ‘0’ ]

	Your challenge is to write code that increments
	the numbers and discards items that do not represent numbers.
	*/

	public static void main(String[] args) {
		ArrayList valueList = new ArrayList();
		ArrayList numberList = new ArrayList();

		valueList.add("1");
		valueList.add("c");
		valueList.add("0");
		valueList.add("-1");
		valueList.add("5");
		valueList.add("b");
		valueList.add("100");
		valueList.add("37");
		valueList.add("a");
		valueList.add("20");
		valueList.add("18");
		valueList.add("12");
		valueList.add("0");

		int valueListLength = valueList.size();
		System.out.print("Working with this list(" + valueList.size() + "): ");
		System.out.println(displayList(valueList));

		// loop through our values list and create a list of numbers
		for (int i = 0; i < valueListLength; i++) {
			// test to see if we have a number or something else
			try {
				Object o = valueList.get(i);
				int number = Integer.valueOf((String) o);

				// if we got here, we must have a number, so add it to the numberList
				numberList.add(number);
			}
			catch (NumberFormatException nfe) {
				// we do not have a number
				// noop
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {

			} // try

		} // for

		System.out.println();
		System.out.print("We have created a new list(" + numberList.size() + ") of only numbers: ");
		System.out.println(displayList(numberList));

		System.out.println();

		System.out.print("We have created a list of JustOneMore numbers: ");
		System.out.println(displayList(justOneMore(numberList)));


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
