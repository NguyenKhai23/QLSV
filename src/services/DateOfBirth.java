package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import constant.Const;

public class DateOfBirth {
    static Scanner scanner = new Scanner(System.in);
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate inputDateOfBirth() {
        LocalDate dateOfBirth;
        do {
            try {
                System.out.print("Enter the student's date of birth (dd-mm-yyyy): ");
                String dateOfBirthText = scanner.nextLine();
                dateOfBirth = LocalDate.parse(dateOfBirthText, formatter);
                if (dateOfBirth.getYear() < Const.MIN_YEAR) {
                    System.out.println("The date must be greater than or equal to 1-1-1900");
                } else
                    return dateOfBirth;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date of birth format. Please retry again");
            }
        } while (true);
    }
}
