import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class fileOperations {
	public void viewAllFiles() {
		File directory = new File("./temp");
		String[] fileNames = directory.list();
		if (fileNames == null)
			System.out.println("Directory is empty");
		else {
			Arrays.sort(fileNames);
			System.out.println("List of Files:");
			for (String fileName : fileNames) {
				System.out.println(fileName);
			}
		}
	}

	public void addNewFile(String fileName, String content) throws IOException {
		File directory = new File("./temp");
		String[] fileNames = directory.list();
		for (String existingFileName : fileNames) {
			if (fileName.equals(existingFileName)) {
				System.out.println("File is already present in the system");
				return;
			}
		}
		File file = new File("./temp/" + fileName + ".txt");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(content);
		fileWriter.close();
		System.out.println("A new file has been created");
	}

	public void deleteFile(String fileName) {
		boolean fileDeleted = false;
		File directory = new File("./temp");
		File[] files = directory.listFiles();
		if (files == null)
			System.out.println("Directory is empty");
		else {
			for (File file : files) {
				if (fileName.equals(file.getName())) {
					file.delete();
					System.out.println("File deleted successfully");
					fileDeleted = true;
				}
			}
			if (!fileDeleted)
				System.out.println("File is not present in the system");
		}
	}

	public void searchFile(String fileName) {
		boolean fileFound = false;
		File directory = new File("./temp");
		String[] fileNames = directory.list();
		if (fileNames == null)
			System.out.println("Directory is empty");
		else {
			for (String existingFileName : fileNames) {
				if (fileName.equals(existingFileName)) {
					System.out.println("File is present in the system");
					fileFound = true;
				}
			}
			if (!fileFound)
				System.out.println("File is not present in the system");
		}
	}
}
