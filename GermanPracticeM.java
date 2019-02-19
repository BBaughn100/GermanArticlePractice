/*
 * Author: Brendon Baughn
 * Version: 1.0.0
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GermanPracticeM {

	public static void practice(Scanner inScan, Scanner in, List<String> list, List<String> incorList) {
		list.clear();
		incorList.clear();
		while (inScan.hasNext()) {
			String germList = inScan.nextLine();
			list.add(germList);
		}


		int counter = 0;
		int incorrectCount = 0;
		while (incorList.isEmpty() && counter == 0) {
			for (int i = 0; i < list.size(); ++i) {
				String noun = list.get(i);
				String beginning = noun.substring(0, 3);
				String beginning2 = "";
				String lowerc1 = "d" + noun.substring(1, 3);
				String lowerc2 = "";
				String end = noun.substring(4);
				if (noun.contains("/")) {
					beginning2 = noun.substring(4, 7);
					lowerc2 = "d" + noun.substring(5, 7);
					end = noun.substring(8);
				}
				System.out.print("Article of " + end + ": ");
				String article = in.nextLine();

				if (article.equals(beginning) || article.equals(beginning2) ||
					article.equals(lowerc1) || article.equals(lowerc2)) {
					System.out.println("Correct!");
					System.out.println();
					++counter;
				} else {
					System.out.println("False!");
					if (noun.contains("/")) {
						System.out.println("The article is: " + beginning + " or " + beginning2);
					} else {
					System.out.println("The article is: " + beginning);
					}
					System.out.println();
					incorList.add(noun);
					++incorrectCount;
				}
			}
		}
		System.out.println("Number of correct answers: " + counter + "/" + (incorrectCount + counter));
		
		if (!incorList.isEmpty()) {
			System.out.print("Practise wrong answers!");
			System.out.println();
		}
		while (!incorList.isEmpty()) {
			for (int j = 0; j < incorList.size(); ++j) {
				String noun = incorList.get(j);
				String beginning = noun.substring(0, 3);
				String beginning2 = "";
				String lowerc1 = "d" + noun.substring(1, 3);
				String lowerc2 = "";
				String end = noun.substring(4);
				if (noun.contains("/")) {
					beginning2 = noun.substring(4, 7);
					lowerc2 = "d" + noun.substring(5, 7);
					end = noun.substring(8);
				}
				System.out.print("Article of " + end + ": ");
				String article = in.nextLine();

				if (article.equals(beginning) || article.equals(beginning2) ||
						article.equals(lowerc1) || article.equals(lowerc2)) {
					System.out.println("Correct!");
					System.out.println();
					incorList.remove(noun);
					++counter;
				} else {
					System.out.println("False!");
					System.out.println("The article is: " + beginning);
					System.out.println();
				}
			}
		}
		System.out.println("All answers correct!");

		inScan.close();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		List<String> incorList = new ArrayList<String>();

		String msg = "Would you like to practice [F]oods or [R]andom?: ";
		System.out.print(msg);
		String whatToPrac = in.nextLine().toUpperCase().substring(0, 1);

		boolean boo = false;

		while (boo == false) {
			if (whatToPrac.equals("F")) {
				try {
					File inFile = new File("foods.txt");
					Scanner inScan = new Scanner(inFile);
					practice(inScan, in, list, incorList); // FIXME
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (whatToPrac.equals("R")) {
				try {
					File inFile = new File("random.txt");
					Scanner inScan = new Scanner(inFile);
					practice(inScan, in, list, incorList); // FIXME
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.print("Would you like to go again? [Y/N]: ");
			String goAgain = in.nextLine().toUpperCase().substring(0, 1);

			if (goAgain.equals("Y")) {
				System.out.print(msg);
				whatToPrac = in.nextLine().toUpperCase().substring(0, 1);
			} else if (goAgain.equals("N")) {
				boo = true;
			} else {
				System.out.println("Undefined answer!");
				boo = true;
			}
		}

		System.out.println();
		System.out.println("Goodbye!");

		in.close();
	}

}
