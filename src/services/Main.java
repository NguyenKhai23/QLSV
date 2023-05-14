package services;


import model.Student;


public class Main {

    public static void showSelect() {
        System.out.println("\n----MENU----");
        System.out.println("1: Create a student");
        System.out.println("2: Print the student list");
        System.out.println("3: Search student by id");
        System.out.println("4: Update student");
        System.out.println("5: Delete student by id");
        System.out.println("6: Print student rank distribution");
        System.out.println("7: Print student gpa distribution");
        System.out.println("8: Search students by rank");
        System.out.println("9: Save the student list");
        System.out.println("0: Save the student list and Exit");

    }

    public static void main(String[] args) {
        StudentList list = new StudentList();
        while (true) {
            showSelect();
            System.out.print("Select: ");
            int select = InformationStudent.inputIntNumber();
            switch (select) {
                case 0:
                    System.exit(0);
                case 1:
                    StudentList.createStudent();
                    break;
                case 2:
                    StudentList.showListStudent();
                    break;
                case 3:
                    if (StudentList.listStudent.size() != 0) {
                        int id;
                        System.out.println("Enter an ID: ");
                        id = InformationStudent.inputIntNumber();
                        Student student = list.findById(id);
                        if (student == null) {
                            System.out.println("Not found");
                        } else {
                            System.out.println(student);
                        }
                    } else System.out.println("List student no data");
                    break;
                case 4:
                    list.updateStudentWithSId();
                    break;
                case 5:
                    list.deleteArrayListStudentById();
                    break;
                case 6:
                    list.percentOfRank();
                    break;
                case 7:
                    list.showPercentGpa();
                    break;
                case 8:
                    list.showInformationStudentByRank();
                    break;
                case 9:
                    StudentList.saveStudentList();
                    break;
                default:
                    break;
            }
        }
    }
}

