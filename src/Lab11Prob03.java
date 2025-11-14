import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * File: Lab11Prob01.java Class: CSCI 1302 Author: Emily Flowers, Sam Lewis
 * Created on: Nov 14, 2025 Last Modified: Nov 14, 2025 Description:
 */

public class Lab11Prob03 {
	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<>();

		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));) {

			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();

				// Add person to list
				personList.add(new Person(age, name, address, zipCode, salary));

			}

		} catch (EOFException ex) {

		} catch (Exception e) {
			System.out.println("An error occurred");
		}

		try (ObjectOutputStream output =
				new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat"));) {

			java.util.Collections.sort(personList);
			for (int i = 0; i < personList.size(); i++) {
				System.out.println(personList.get(i).toString());
				output.writeObject(personList.get(i));
			}
		} catch (EOFException ex) {

		} catch (Exception e) {
			System.out.println("An error occurred");
		}

	}
}