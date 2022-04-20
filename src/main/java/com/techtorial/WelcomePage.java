package com.techtorial;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static com.techtorial.Instructions.getInstructions;

/*
 * This is your main page where the vending machine application is going to be triggered and
 * all inputs being accepted.
 */
public class WelcomePage {

    public static void main(String[] args) {
        Products shop = new Products();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Techtorial sponsored vending machine!");
        System.out.println("What is your name?");
         boolean isAllCasesCovered = true;
        String name = scanner.next();
        System.out.println("Nice to meet you, " + name);
        System.out.println("Please press 0 for available options...");

        int allOptions = getIntegerInput(scanner, new Integer[] {0});
        getInstructions(allOptions);



        scanner = new Scanner(System.in);
        System.out.println("Enter what you want to do: ");
        String productToBuy="";
        while (isAllCasesCovered ){
            switch (getIntegerInput(scanner, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})) {
                case 1: // List all items/products, names of products
                    shop.getAllProducts();
                    getInstructions(0);
                    break;
                case 2:
                    shop.getAllPrices();
                    getInstructions(0);
                    break;
                case 3:
                    shop.getAllProducts();
                    System.out.println("Which product from above you would like to choose?");
                    Scanner kerim3 = new Scanner(System.in);
                    productToBuy = kerim3.nextLine().toLowerCase();
                    shop.buyProduct(productToBuy);
                    getInstructions(0);
                    break;
                case 4:
                    shop.getAllProducts();
                    System.out.println("Which product from above you would like to choose?");
                    Scanner kerim4 = new Scanner(System.in);
                    productToBuy = kerim4.nextLine().toLowerCase();
                    shop.selectProduct(productToBuy);
                    shop.yesPrice(productToBuy);
                    getInstructions(0);
                    break;
                case 5:
                    shop.getAllPrices();
                    getInstructions(0);
                    break;
                case 6:
                    System.out.println("Set a best price range of a product for you");
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("Eneter a mininmum price");
                    int num1 = scanner6.nextInt();
                    System.out.println("Eneter a maximum price");
                    int num2 = scanner6.nextInt();
                    shop.priceRange(num1, num2);
                    getInstructions(0);
                    break;
                case 7:
                    System.out.println("Thanks for shopping with us");
                    isAllCasesCovered = false;
                    break;
                case 8:
                    shop.getAllProducts();
                    System.out.println("Which product from above you would like to choose?");
                    Scanner kerim8 = new Scanner(System.in);
                    productToBuy = kerim8.nextLine().toLowerCase();
                    shop.selectProduct(productToBuy);
                    shop.yesPrice(productToBuy);
                    shop.buyAProduct(productToBuy);
                    getInstructions(0);
                    isAllCasesCovered =true;
                    break;
            }

        }




    }

    private static int getIntegerInput(Scanner scanner, Integer[] expected) {
        int allOptions = -1;
        for (int i = 1; i <= 3; i++) {
            scanner = new Scanner(System.in);
            int input;
            try {
                input = scanner.nextInt();

                if (!Arrays.asList(expected).contains(input)) {
                    throw new IOException();
                }
            } catch (Exception e) {
                if (i < 3) {
                    System.out.println("Please enter 0");
                    System.out.printf("You have %d more retries", 3 - i);
                    System.out.println();
                } else {
                    System.out.println("Sorry, try next time");
                    System.exit(1);
                }
                continue;
            }
            allOptions = input;
            break;
        }
        return allOptions;
    }
}
