package Product_Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
	List<String> productlistFromList = new ArrayList<>();

	public void ProductListFromArrayMain() throws IOException {

		Product productDetails = new Product();
		System.out.println("Welcome to the Product Management");
		System.out.println("What do want to do today?");
		System.out.println("1: Add Product ");
		System.out.println("2: Print Product Detail ");
		System.out.println("3: Update Product ");
		System.out.println("4: Delete Product ");
		System.out.println("5: Search Product ");
		System.out.println("6: Exit Application ");
		Scanner scProduct = new Scanner(System.in);
		int option = scProduct.nextInt();

		boolean shouldContinueProductM = true;
		while (shouldContinueProductM) {

			switch (option) {
			case 1:
				Scanner scAddProduct = new Scanner(System.in);
				System.out.println("Enter the Name of the Product ");
				productDetails.productName = scAddProduct.next();
				System.out.println("Enter the Price of the Product ");
				productDetails.productPrice = scAddProduct.nextInt();
				System.out.println("Enter the Quantity of the Product ");
				productDetails.productQuantity = scAddProduct.nextInt();

				productlistFromList.add(productDetails.productName + "" + productDetails.productPrice + ""
						+ productDetails.productQuantity);

				break;
			case 2:
				for (String productlistofarry : productlistFromList) {
					System.out.println(productlistofarry);
				}
				break;
			case 3:
				System.out.println("Enter the Product Name You want to Edit:");
				Scanner scToUpdateProduct = new Scanner(System.in);

				String productToUpdate = scToUpdateProduct.next();

				for (int i = 0; i < productlistFromList.size(); i++) {

					if (productlistFromList.get(i).contains(productToUpdate)) {

						scToUpdateProduct = new Scanner(System.in);
						System.out.println("Enter the Name of the Product ");
						String updatedproductName = scToUpdateProduct.next();
						System.out.println("Enter the Price of the Product ");
						int updatedproductPrice = scToUpdateProduct.nextInt();
						System.out.println("Enter the Quantity of the Product ");
						int productQuantity = scToUpdateProduct.nextInt();

						productlistFromList.set(i, updatedproductName);
					}
				}

				break;
			case 4:
				System.out.println("Enter the Product Name You want to Delete:");
				Scanner scToDeleteProduct = new Scanner(System.in);
				String deleteProductFromList = scToDeleteProduct.next();
				for (int i = 0; i < productlistFromList.size(); i++) {
					if (productlistFromList.get(i).contains(deleteProductFromList)) {
						productlistFromList.remove(i);
					} else {
						System.out.println("Product Not Found");
					}
				}

				break;
			case 5:
				System.out.println("Enter the Product Name You want to Search:");
				Scanner scToSerachProduct = new Scanner(System.in);
				String serachProductFromList = scToSerachProduct.next();
				for (int i = 0; i < productlistFromList.size(); i++) {
					if (productlistFromList.get(i).contains(serachProductFromList)) {
						System.out.println(productlistFromList.get(i));
					} else {
						System.out.println("Product not found");
					}
				}

				break;
			case 6:
				writeProductListDataIntoFile();
				break;

			}
		}

	}

	public void ProductReaderClass() throws IOException {
		String filePath = "C:\\Users\\archa\\eclipse-workspace\\Ecommerce_Array\\src\\Product_Main\\product.txt";
		File fileToReadProduct = new File(filePath);
		FileReader fileToRead = new FileReader(fileToReadProduct);
		BufferedReader bufferedReaderProduct = new BufferedReader(fileToRead);

		String line = "";
		while ((line = bufferedReaderProduct.readLine()) != null) {
			productlistFromList.add(line);

		}
		bufferedReaderProduct.close();
	}

	public void writeProductListDataIntoFile() throws IOException {
		String pathFileToWrite = "C:\\Users\\archa\\eclipse-workspace\\Ecommerce_Array\\src\\Product_Main\\product.txt";
		File fileToWrite = new File(pathFileToWrite);
		FileWriter writerintoFile = new FileWriter(fileToWrite, false);
		BufferedWriter brToWriteIntoList = new BufferedWriter(writerintoFile);
		for(String file:productlistFromList) {
		brToWriteIntoList.write(file);;
	}brToWriteIntoList.close();}

}
