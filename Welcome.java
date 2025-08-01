import java.util.Scanner;

public class Welcome{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first name");
		String fname = sc.nextLine();
		
		System.out.println("Enter last name");
		String lname = sc.nextLine();
		
		System.out.println("Welcome to the second year " + fname + " " + lname);
		}
}