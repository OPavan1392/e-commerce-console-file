package Ecommerce_Main;

import java.io.IOException;
import java.util.Scanner;

import Product_Main.ProductManagement;





public class EcommerceWithArray {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("**Welcome to the Ecommerce Application");
		boolean shouldcontinutill = true;

		while (shouldcontinutill) {
			System.out.println("1. Product Management");
			System.out.println("2. User Management");
			System.out.println("3. Exit Application ");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();

			switch (option) {
			case 1:
			new	ProductManagement().ProductListFromArrayMain();
				break;
			case 2:
				
				break;
			case 3:
				shouldcontinutill = false;
				break;

			}
		}

		
	}

}
