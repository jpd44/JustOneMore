public class JustOneMorev1 {

/*
	In the first level you start with the following list of numbers:

	[ 1, 0, -1, 5, 100, 37, 20, 18, 12, 0 ]

	Your challenge is to write code to increment each number
	in the list so that your final output will be a list of
	numbers that has values one larger than the input list.
*/
    public static void main(String[] args) {
	    System.out.println("JustOneMore v1.0");

		int[] numberList=new int[9];

		numberList[0]=1;
		numberList[1]=0;
		numberList[2]=5;
		numberList[3]=100;
		numberList[4]=37;
		numberList[5]=20;
		numberList[6]=18;
		numberList[7]=12;
		numberList[8]=0;

		int numberListLength=numberList.length;

		System.out.println("Working with a list of " + numberList.length + " numbers...");

		System.out.print("[");
		for(int i=0; i<numberListLength; i++) {
			System.out.print(numberList[i]);
			if(i<numberListLength-1) System.out.print(", ");
		}
		System.out.println("]");

		for(int i=0; i<numberListLength; i++) {
			// we wont do any error checking in this version
			numberList[i]=numberList[i]+1;
		}

		System.out.println();

		System.out.println("Our new list of numbers... ");
		System.out.print("[");
		for(int i=0; i<numberListLength; i++) {
			System.out.print(numberList[i]);
			if(i<numberListLength-1) System.out.print(", ");
		}
		System.out.println("]");


    }
}
