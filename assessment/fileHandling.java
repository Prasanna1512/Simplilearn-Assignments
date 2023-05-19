import java.io.IOException;
import java.util.Scanner;

public class fileHandling {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Project: Virtual Key for Your Repositories \nDeveloper: Prasanna S");
		System.out.println("-------------------------------------------------------------\n");
		fileOperations fileOperations = new fileOperations();

		while (true) {
			System.out.println("\n\nChoose from the below options:");
			System.out.println("1. Retrieve All files (ascending order)\n2. Business-level operations\n3. Close application");
			int choice = scanner.nextInt();

			if (choice >= 3) {
				System.out.println("Application Successfully Closed");
				System.exit(0);
			}

			switch (choice) {
				case 1:
					fileOperations.viewAllFiles();
					break;
				case 2:
					while (true) {
						System.out.println("\n1. Add file to the application\n2. Delete file from the application\n3. Search file from the application\n4. Return");
						System.out.print("Enter your choice: ");
						int subChoice = scanner.nextInt();

						if (subChoice >= 4) {
							break;
						}

						switch (subChoice) {
							case 1:
								System.out.println("Enter the name of the file to be added:");
								String fileName = scanner.next();
								String content = "The file contains confidential information.";
								fileOperations.addNewFile(fileName, content);
								break;
							case 2:
								System.out.println("Enter the name of the file that needs to be deleted:");
								fileName = scanner.next();
								fileOperations.deleteFile(fileName);
								break;
							case 3:
								System.out.println("Enter the name of the file:");
								fileName = scanner.next();
								fileOperations.searchFile(fileName);
								break;
						}
					}
			}
		}
	}
}
