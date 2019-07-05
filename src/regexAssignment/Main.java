package regexAssignment;
/*
 * Ali Abu Al Rub
 * 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static ArrayList<Regex> arrList = new ArrayList<Regex>();
	static String srcFile = "text.txt";
	static FileInputStream file;
	static Scanner scanner;
	static ArrayList<String> arrString = new ArrayList<>();

	public static void main(String args[]) throws IOException {

		file = new FileInputStream(srcFile);
		scanner = new Scanner(file);
		int equalsNumberOfInterfaces = 0;// counter to check if it is equal to NumberOfInterfaces
		String text = "";// text to read from the file line by line
		String text2 = "";// text2 to take each paragraph for a special interface and send it to test
							// method

		int numberOfInterfaces = 0;//counter to count number of interfaces
		while (scanner.hasNext()) {// to loop through the given file
			text = scanner.nextLine();
			if (!text.equals("")) {
				if (text.charAt(0) != ' ' && numberOfInterfaces >= 1) {

					arrList.add(test(text2));
					numberOfInterfaces++;
					equalsNumberOfInterfaces++;
					text2 = "";
				} else if (text.charAt(0) != ' ' && numberOfInterfaces < 1) {
					numberOfInterfaces++;
				}
				text2 += text + "\n";

			}
		}

		if (equalsNumberOfInterfaces != numberOfInterfaces) {// to check if equalsNumberOfInterfaces reached the number
																// of interfaces if not means that there
																// is one interface paragraph hasn't been sent to the
																// test method
			arrList.add(test(text2));
		}

		if (numberOfInterfaces == 1) {
			System.out.println("One Matched interface");
		} else if (numberOfInterfaces > 1) {
			System.out.println("Matched interfaces are " + numberOfInterfaces);
		}

		for (int i = 0; i < numberOfInterfaces; i++) {
			System.out.println("Interface #" + (i + 1) + ": \n");
			System.out.println(arrList.get(i) + "\n");
		}
	}

	public static Regex test(String text) throws FileNotFoundException {
		Regex regex = new Regex();

		regex.setInterfacee(find("^[^\\d\\W][\\w]+\\W\\w[\\W]?[\\d]?", text));
		regex.setMacAddress(find("\\w{4}.\\w{4}.\\w{4}(?=\\s\\(bia\\s\\w{4}.\\w{4}.\\w{4}\\))", text));
		regex.setDescription(find("(?<=Description:).*", text));
		regex.setIpAddress(find("(?<=Internet address is )\\d{1,}.\\d{1,}.\\d{1,}.\\d{1,}", text));
		regex.setMtu(find("(?<=MTU)\\s\\d+[\\s\\S]\\w*", text));
		regex.setOperationStatus(find("(?<= line protocol is).*", text));
		regex.setAdminStatus(find("(?<=is ).*(?=[,.] line protocol)", text));
		regex.setDuplexMode(find("\\w*-duplex", text));
		regex.setIfSpeed(find("(?<=\\w-duplex,\\W).*(?=[,.])", text));

		return regex;
	}

	public static String find(String pattern, String text) {

		Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
		Matcher m = p.matcher(text);

		while (m.find()) {
			return m.group(0);
		}
		return "";
	}

}
