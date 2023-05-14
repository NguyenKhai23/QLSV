package services;

import java.time.LocalDate;
import java.util.Scanner;

import constant.Const;
import model.Student;

public class InformationStudent {

    public static Scanner sc = new Scanner(System.in);
    public static int inputIntNumber() {
        int intNumber;
        while (!sc.hasNextInt()) {
            System.out.println("Enter a suitable number.");
            sc.next();
        }
        intNumber = sc.nextInt();
        sc.nextLine();
        return intNumber;
    }

    public static float inputFloatNumber() {
        float floatNumber;
        while (!sc.hasNextFloat()) {
            System.out.println("Enter a suitable number.");
            sc.next();
        }
        floatNumber = sc.nextFloat();
        sc.nextLine();
        return floatNumber;
    }

    public static boolean checkStudentCode(String code) {
        for (Student st : StudentList.listStudent)
            if (st.getStudentCodes().equals(code))
                return true;
        return false;
    }

    public static String inputStudentCode() {
        while (true) {
            try {
                System.out.print("Enter student code: ");
                String studentCode = sc.nextLine();
                if (studentCode.length() == Const.MAX_STUDENT_CODE && !checkStudentCode(studentCode))
                    return studentCode;
                System.out.println("Err!");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static String inputName() {
        String name;
        do {
            try {
                System.out.print("Input the student's name: ");
                name = sc.nextLine();
                if (name.length() > Const.MAX_NAME || name.trim().length() == 0)
                    throw new IllegalArgumentException("The name must be less than 100 characters");
                return name;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);

    }


    public static String inputAddress() {
        String address;
        do {
            try {
                System.out.print("Input the student's address: ");
                address = sc.nextLine();
                if (address.trim().length() == 0 || address.length() > Const.MAX_ADDRESS)
                    throw new IllegalArgumentException("The address must be less than 300 characters");
                return address;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static float inputHeight() {
        float height;
        do {
            try {
                System.out.print("Input the student's height (cm): ");
                height = inputFloatNumber();
                if (height < Const.MIN_HEIGHT || height > Const.MAX_HEIGHT)
                    throw new IllegalArgumentException("The height must be between 50 and 300 cm");
                return height;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static float inputWeight() {
        float weight;
        do {
            try {
                System.out.print("Input the student's weight (kg): ");
                weight = inputFloatNumber();
                if (weight < Const.MIN_WEIGHT || weight > Const. MAX_WEIGHT)
                    throw new IllegalArgumentException("The weight must be between 5 and 1000 kg");
                return weight;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static String inputUniversityName() {
        String universityName;
        do {
            try {
                System.out.print("Input the student's university: ");
                universityName = sc.nextLine();
                if (universityName == null || universityName.length() > Const.MAX_LENGTH_UNIVERSITY_NAME)
                    throw new IllegalArgumentException("The university name must be not null and less than 300 characters");
                return universityName;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    // nam bat dau hoc dai hoc
    public static int inputAdmissionYear() {
        int year;
        do {
            try {
                System.out.print("Input the admission year: ");
                year =  inputIntNumber();
                if (year < Const.MIN_YEAR || year > Const.MAX_YEAR)
                    throw new IllegalArgumentException("The admission year must be between 1990 and 9999");
                return year;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static float inputGpa() {
        float gpa;
        do {
            try {
                System.out.print("Input the student's GPA: ");
                gpa = inputFloatNumber();
                if (gpa < Const.MIN_GPA || gpa > Const.MAX_GPA)
                    throw new IllegalArgumentException("The GPA value must be between 0 and 10");
                return gpa;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static LocalDate inputDateOfBirth() {
        return DateOfBirth.inputDateOfBirth();
    }

}



