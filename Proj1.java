import java.util.*;

public class Proj1
{
    public static void main(String[] args)
    {
        //Make a scanner to take the lower and upper bounds for the range of palindrome number.
        Scanner scan = new Scanner(System.in);
        System.out.println("Input> ");
        int lowerBound, upperBound;
        while(true)
        {
            lowerBound = scan.nextInt();
            upperBound = scan.nextInt();
            if(lowerBound < upperBound && lowerBound > 0)
                break;
            else if(lowerBound > upperBound)
                System.out.println("Error: First number is larger than second number. Try Again.");
            else if(lowerBound <= 0)
                System.out.println("Error: Invalid value entered. All values must be greater than zero. Try Again.");
        }
        System.out.println("Palindromes");
        System.out.printf("%-30.30s  %-30.30s%n", "Base 10", "Binary");

        //This loop will loop from the lower bound to teh upper bound, testing to see if the numbers are palindromes in both
        //decimal and the binary equivalent. 
        for(int testNum = lowerBound; testNum <= upperBound; testNum++)
        {
            /*Create an two ArrayLists, one for the Decimal number and one for the binary equivalent of that number.
                The ArrayList, will compare its contents with the equivalent binary stack, and check to see, if the
                number is a palindrome. If each individual number matches as the loop goes through the list and stack
                then the number is a palindrome. The list takes the number in backwards, and the stack takes the number
                in forwards.
             */
           List<Integer> decimalList = new ArrayList<>();
           List<Integer> binaryList = new ArrayList<>();
           Stack<Integer> decimalStack = new Stack<>();
           Stack<Integer> binaryStack = new Stack<>();

           boolean palindromeDecimal, palindromeBinary; //two boolean variables to check if the decimal and binary are palindromes

            //Call the methods below, and start the palindrome process.
           decimalListStackSetter(decimalList, decimalStack, testNum);
           palindromeDecimal = checkPalindrome(decimalList, decimalStack);

           binaryListStackSetter(binaryList, binaryStack, testNum);
           palindromeBinary = checkPalindrome(binaryList, binaryStack);

           //Finally, if the decimal number is a palindrome in its decimal and binary format, print out the decimal and binary values.
           if(palindromeDecimal && palindromeBinary)
               System.out.printf("%-30.30s  %-30.30s%n", testNum, Integer.toString(testNum, 2));//Use a printf to print two columns
        }
    }

    //This method will compare the specific decimal list, and decimal stack or binary list with the binary stack,
    //checking to see if the number being compared is a palindrome.
    public static boolean checkPalindrome(List<Integer> digitList, Stack<Integer> digitStack){
        for (Integer integer : digitList) {
            if (!(integer == digitStack.pop()))
                return false;
        }
        return true;
    }

    //This method takes in a list and a stack and adds the decimal number being observed to the stack and the list, to
    //later be tested to see if it is a palindrome.
    public static void decimalListStackSetter(List<Integer> decimalList, Stack<Integer> decimalStack, int num){
        while(num > 0){
            int digit = num % 10;
            decimalList.add(digit);
            decimalStack.push(digit);
            num /= 10;
        }
    }

    //This method will take in the decimal palindrome number,convert it to its binary equivalent value,
    //then it will split the binary number and add it to the list and stack, and later the list and stack will be compared,
    //to see if the binary value is a palindrome.
    public static void binaryListStackSetter(List<Integer> binaryList, Stack<Integer> binaryStack, int decimalNum)
    {
        int binaryNum = decimalNum;
        String binary = "";
        while(binaryNum != 0)
        {
            binary = (binaryNum % 2) + binary; //
            binaryNum /= 2;
        }

        int temp = Integer.parseInt(binary);
        while(temp > 0)
        {
            int binaryDigit = temp % 10;
            binaryList.add(binaryDigit);
            binaryStack.push(binaryDigit);
            temp /= 10;
        }
    }
}

