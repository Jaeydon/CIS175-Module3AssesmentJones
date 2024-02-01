/**
 * @author Jaeydon Jones - jmjones31@dmacc.edu
 * CIS175 22895 - Java II
 * {2/1/2024}
 */

import java.util.List;
import java.util.Scanner;

import controller.InventoryHelper;
import model.AdventurerInventory;

public class Runner{

	static Scanner in = new Scanner(System.in);
	static InventoryHelper iH = new InventoryHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			startMenu();
		} catch (Exception e) {
			System.out.println();
			System.out.println();
		} finally {
			iH.closeIH();
			in.close();
		}

	}

	private static void startMenu() {
		// TODO Auto-generated method stub

		boolean exitProgram = false;

		System.out.println("Adventurer Item List");
		System.out.println();
		
		while (exitProgram == false) {

			System.out.println("Please select an option:");
			System.out.println("1.) Add a Item");
			System.out.println("2.) Edit a Item");
			System.out.println("3.) Delete a Item");
			System.out.println("4.) Show Item List");
			System.out.println("5.) Exit program");
			System.out.print("Your Choice: ");

			int userChoice = in.nextInt();
			in.nextLine();

			if (userChoice == 1) {
				addItem();

			} else if (userChoice == 2) {
				editItem();

			} else if (userChoice == 3) {
				deleteItem();

			} else if (userChoice == 4) {
				showList();

			} else if (userChoice == 5) {
				iH.closeIH();
				in.close();
				exitProgram = true;

			} else {
				System.out.println();
				System.out.println("I'm sorry, that wasn't a option.");
			}
		}
		
		System.out.println();
		System.out.println("End Program");
	}



	private static void addItem() {
		// TODO Auto-generated method stub
		System.out.print("Please enter the Category of Item: ");
		String itemcat = in.nextLine();
		System.out.print("Please enter the Item: ");
		String item = in.nextLine();
		
		AdventurerInventory inventoryToAdd = new AdventurerInventory(itemcat,item);
		iH.addInventory(inventoryToAdd);
		
	}
	
	private static void editItem() {
		// TODO Auto-generated method stub
		System.out.println("What should we search by?");
		System.out.println("1.) ItemCategory");
		System.out.println("2.) Item");
		
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<AdventurerInventory> foundInventory;
		
		if(searchBy == 1) {
			System.out.print("Please enter the ItemCategory: ");
			String itemCategory = in.nextLine();
			foundInventory = iH.searchForItemCategory(itemCategory);
		} else {
			System.out.print("Please enter the Item: ");
			String item = in.nextLine();
			foundInventory = iH.searchForItem(item);
		}
		
		if(!foundInventory.isEmpty()) {
			System.out.println("Success!  Posting Results:");
			
			for (AdventurerInventory a : foundInventory) {
				System.out.println(a.toString());
			}
			System.out.println("Enter Gold amount of the Item you would like to change: ");
			int goldToEdit = in.nextInt();
			
			AdventurerInventory goldbagToEdit = iH.searchForGold(goldToEdit);
			System.out.println("Pulled :  ItemCategory- " + goldbagToEdit.getItemCategory() + " Item- " + goldbagToEdit.getItem());
			System.out.println("1.) Change ItemCategory");
			System.out.println("2.) Change Item");
			
			int updateChoice = in.nextInt();
			in.nextLine();
			
			if (updateChoice == 1) {
				System.out.print("New Make: ");
				String newItemcat = in.nextLine();
				goldbagToEdit.setItemCategory(newItemcat);
			} else if (updateChoice == 2) {
				System.out.print("New Model: ");
				String newItem = in.nextLine();
				goldbagToEdit.setItem(newItem);
			}
			
			iH.editInventory(goldbagToEdit);
		} else {
			System.out.println("No Item found with Specified Data");
		}
	}
	
	private static void deleteItem() {
		// TODO Auto-generated method stub
		System.out.print("Please enter Item: ");
		String make = in.nextLine();
		System.out.print("Please enter the Category of the Item: ");
		String model = in.nextLine();
		
		AdventurerInventory toRemove = new AdventurerInventory(make,model);
		iH.deleteInventory(toRemove);
	}
	
	private static void showList() {
		// TODO Auto-generated method stub
		List<AdventurerInventory> completeInventory = iH.showAllInventory();
		
		for(AdventurerInventory singleCar : completeInventory) {
			System.out.println(singleCar.toString());
		}
	}
}