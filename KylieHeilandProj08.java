/**
 * This program creates a two dimensional array that will convert a decimal number into a binary number, which will then determine whether a specific element (coin)
 * is heads or tails. It begins by prompting the user to input a decimal number between 0-511. After input, the number is checked to see whether it is valid. If it
 * is not, the program ends, else a message is outputted and then the method coinState is called. This method then begins to convert the decimal number into a 
 * binary number. It does it this by first looking if the number inputted is greater than or equal to 2^8, and if it is, a 1 would be assigned to the first row
 * first column, else a 0 is placed there. This loops until 2^0 (the final digit in the binary number) has a 0 or 1. After conversion, then the array is looped 
 * through, and if the specific element contains a 0, 'H' is outputted for heads, and if it contains 1, 'T' is outputted for tails.
 * 
 * 
 * Kylie Heiland
 * 
 * Project08
 * 
 * 3/26/22
 */

import java.util.Scanner; 
public class KylieHeilandProj08
{
    public static void main(String[] args)
    {
        //Creates an two-dimensional array that holds 9 total elements in 3 rows and 3 columns.
        double[][] matrix = new double[3][3];
        
        //Creates a scanner so that the user can input a number between zero and 511.
        Scanner input = new Scanner(System.in);
        
        //The user inputs an integer between zero and 511, which wil be determine what coins are in the state of heads or tails.
        System.out.print("Enter an integer representing the state of the coins (0 - 511): ");
        int intToCoin = input.nextInt();
        //Checks that the number inputted from the user is a valid representation of all the states.
        if(intToCoin < 0 || intToCoin > 511)
        { //If the number is not valid:
            System.out.println("Error, you must choose a number between 0 and 511 (inclusively).");
            System.exit(1);
        }
        else
        { //If the number is valid:
            System.out.println("You chose: " + intToCoin);
        }
        
        //Calls the method with the two-dimensional array and the valid number inputted from the user. 
        coinState(matrix, intToCoin);
    }
    
    public static void coinState(double[][] matrix, int intToCoin)
    {
        //Since the first digit of binary is 2^8, we initialize x as 8 so we can begin converting the decimal number into binary.
        int x = 8;
        
        //Loops through all rows and columns, adding zero or one, respectfully.
        for(int row = 0; row <= 2; row++)
        {
            for(int column = 0; column <= 2; column++)
            {
                if(intToCoin >= Math.pow(2, x))
                { //If the number inputted is greater than or equal to 2^x, then that means that particular element in the matrix is 1 in binary.
                    matrix[row][column] = 1; //Sets this particular element to 1.
                    intToCoin -= Math.pow(2, x);  //Since the integer the user inputted is greater than 2^x, it is subtracted. This is done so 
                }                                   //the next column will evaluate the new value of intToCoin with 2^x-1, rather than the original value of intToCoin.
                else if(intToCoin < Math.pow(2, x))
                { //If the number inputted is less than to 2^x, then it is 0 in binary.
                    matrix[row][column] = 0; //Sets this particular element to 0.
                }
                x--; //Decrements x. Will be either 2^7, 2^6, 2^5, 2^4, 2^3, 2^2, 2^1, 2^0 to correspond to the binary digits.
            }
        }
        
        //Loops through all rows and columns, outputting the corresponding matrix.
        for(int row = 0; row <= 2; row++)
        {
            for(int column = 0; column <= 2; column++)
            {
                if(matrix[row][column] == 0)
                { //If the element is zero:
                    if(column == 2)
                    { //If it is the final column of the matrix, a new line is printed out.
                        System.out.println('H');
                    }
                    else if(column != 2)
                    { //If it is not the final column of the matrix, just the 'H' is outputted, with spaces after it.
                    System.out.printf("%-5c", 'H');
                    }
                }
                else if(matrix[row][column] == 1)
                { //If the element is one:
                    if(column == 2)
                    { //If it is the final column of the matrix, a new line is printed out after 'T.'
                        System.out.println('T');
                    }
                    else if(column != 2)
                    { //If it is not the final column of the matrix, just the 'T' is outputted, with spaces after it.
                    System.out.printf("%-5c", 'T');
                    }
                }
            }
        }
        
    }
}
/* 
OUTPUT:
Enter an integer representing the state of the coins (0 - 512): 77
You chose: 77
H    H    T
H    H    T
T    H    T
Enter an integer representing the state of the coins (0 - 512): 511
You chose: 511
T    T    T
T    T    T
T    T    T
Enter an integer representing the state of the coins (0 - 511): 512
Error, you must choose a number between 0 and 511 (inclusively).
Enter an integer representing the state of the coins (0 - 511): 46
You chose: 46
H    H    H
T    H    T
T    T    H
Enter an integer representing the state of the coins (0 - 511): 140
You chose: 140
H    T    H
H    H    T
T    H    H
Enter an integer representing the state of the coins (0 - 511): 33
You chose: 33
H    H    H
T    H    H
H    H    T
Enter an integer representing the state of the coins (0 - 511): -4
Error, you must choose a number between 0 and 511 (inclusively).
Enter an integer representing the state of the coins (0 - 511): 255
You chose: 255
H    T    T
T    T    T
T    T    T
*/
