package com.techtorial;

import java.util.Locale;
import java.util.Scanner;

public class Products {

    /*
	 * Please add more vending machine features
	 * - Buy a product
	 * - Search for a product
	 * - Get list of products
	 */

    private static String[] products  = new String[] {"Monitor", "Mouse", "Keyboard", "USB cable", "Charger", "Mouse pad"};
    private static int[]    prices    = new int[] {100, 70, 89, 17, 99, 5};
    private static int[]    inventory = new int[] {4, 10, 5, 10, 5, 7};

    //Create method to display all the prduct names in vneding machines
    // Create a method to display product name, price and inventory at the same time
    // I want to see products that are less than 50 and more than 20$
    //We should create a method which accepts two parameters


    public static String[] getAllProducts() {
        System.err.println("List of available Product : ");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j] );
            System.out.println(" ");
        }
        return products;
    }




    public static String[] getAllPrices() {
        System.err.println("Inventory left   Product's Name:  price$");
        for (int j = 0; j < products.length; j++) {
            System.out.println(inventory[j] + "   "+ products[j] + ":     $" + prices[j]);
        }
        return products;
    }



    public static void selectProduct(String productToBuy) {
    	//loop over the product list to find out if it is available in our vending machine

        for ( int j = 0; j < products.length; j++) {
            if ( products[j].toLowerCase().equalsIgnoreCase(productToBuy)){

                System.out.println( "Your product " +products[j] +" is available in our store " );
            }
        }

		//if yes find the price (tip: call a specific method)
		//and verify this product is available in inventory
		//ask if customer wants to buy it -> if yes call another method to buy a product
//											-> if no call method to cancel it
    }

    public static void buyProduct (String productToBuy){
       // getAllProducts();
       // selectProduct(productToBuy);
        yesPrice(productToBuy);
        System.out.println("Would you like to buy a product? Answer buy/cancel");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if(str.equalsIgnoreCase("buy")){
            for (int j = 0; j < products.length; j++) {
                if(products[j].equalsIgnoreCase(productToBuy)) {
                    double total = prices[j] + prices[j]*0.1;
                    System.out.println( "Thank you for shopping with us! Your total with taxes is " + total);
                    System.out.println("Quantity left: " + (inventory[j]-1) );
                }
            }
        }else if (str.equalsIgnoreCase("cancel" )){
            System.out.println("Search for more items");
        }
    }






    public static void selectProductFourth(String productToBuy) {
        //loop over the product list to find out if it is available in our vending machine
        for ( int j = 0; j < products.length; j++) {
            if ( products[j].toLowerCase().equalsIgnoreCase(productToBuy)){

                System.out.println( "Your product " +products[j] +" is available in our store " );

            }
        }

    }


    public static String yesPrice(String productToBuy) {

        String yes = "";
        for (int j = 0; j < products.length; j++) {
            if(products[j].equalsIgnoreCase(productToBuy)) {
                yes += prices[j];
                System.out.println("Quantity left:  Product Name:  Price in USD");
                System.out.println(inventory[j] + ":  " + products[j] + ":  $" + prices[j]);
            }
        }
        return yes;
    }



    //case 5-6

    public static String[] priceRange(int num1, int num2) {
        System.err.println("Inventory left   Product's Name:  price$");
        for (int j = 0; j < prices.length; j++) {

            if(prices[j] >= num1 && num2 >= prices[j]){
                System.out.println(inventory[j] + "   "+ products[j] + ":     $" + prices[j]);
            }
        }
        return products;
    }









// case 8
    public static void buyAProduct(String productToBuy) {


        System.out.println("Would you like to buy a product? Answer buy/cancel");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if(str.equalsIgnoreCase("buy")){
            for (int j = 0; j < products.length; j++) {
                if(products[j].equalsIgnoreCase(productToBuy)) {
                    double total = prices[j] + prices[j]*0.1;
                    System.out.println( "Thank you for shopping with us! Your total with taxes is " + total + "$. Please insert your payment");
                    Scanner scanner = new Scanner(System.in);
                    double payment = scanner.nextDouble();
                    if(payment == total){
                        System.out.println("Thank you for shopping with us! Enjoy your product :)");
                        System.out.println("Quantity left: " + (inventory[j]-1) );
                    }else if(payment<total){
                        System.out.println("You insert not enough payment. Please insert " + (total-payment) +"$ more");
                        Scanner scanner2 = new Scanner(System.in);
                        double payment2 = scanner2.nextDouble();
                        if(payment2 >=total){
                            System.out.println("Thank you for shopping with us! Enjoy your product :) Your change is " + (payment2 -total));
                            System.out.println("Quantity left: " + (inventory[j]-1) );
                        }else{
                            System.out.println("Please try another time with right amount of money");
                        }

                    }else if ( payment>total){
                        System.out.println("Thank you for shopping with us! Enjoy your product! Your change is " + (payment-total));
                        System.out.println("Quantity left: " + (inventory[j]-1) );
                    }

                }
            }
        }else if (str.equalsIgnoreCase("cancel" )){
            System.out.println("Search for more items");
        }





        /*
        Apply payment logic.
        Apply give back change logic
        Apply inventory update logic: if someone buys an item, we should decrement number of available items.
         */
    }
}
