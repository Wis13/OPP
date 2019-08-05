package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcaptionHandligMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        PrintWriter writer = null;
        do{ try {
            System.out.println("Please enter numberator ");
            int numerator = scanner.nextInt();
            System.out.println("Please enter denumerator ");
            int denumerator = scanner.nextInt();
           // System.out.println(divide(numerator, denumerator));
            writer = new PrintWriter(new PrintWriter("out.txt"));
            writer.println("Result = "+divide(numerator,denumerator));
            continueLoop = false;

         } catch (ArithmeticException | InputMismatchException e){
            System.out.println("Exception " +e);
            scanner.nextLine();
            System.out.println("Only integer non-zero parameters allowed");

         } catch (IOException e){
            System.out.println("Unable to open file");
            e.printStackTrace();

        } finally {
            System.out.println("Finally block called");
            writer.close();
        }

            System.out.println("Try catch block finished");

        }while (continueLoop);

    }

    private static int divide(int numerator, int denumerator)throws ArithmeticException,NullPointerException{
        return numerator/denumerator;
    }

}
