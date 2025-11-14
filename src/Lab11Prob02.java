import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
* File: Lab11Prob01.java
* Class: CSCI 1302
* Author: Emily Flowers, Sam Lewis
* Created on: Nov 14, 2025
* Last Modified: Nov 14, 2025
* Description: 
*/


public class Lab11Prob02 {
	public static void main(String[] args) {

		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));) {

			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();

				System.out.printf("%d %s %s %d %.2f\n", age, name, address, zipCode, salary);

				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipCode);
				output.writeDouble(salary);

			}

		} catch (EOFException ex) {
			
		} catch (Exception e) {
			System.out.println("An error occurred");
		}

	}
}




