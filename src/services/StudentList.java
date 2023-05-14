package services;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;
import constant.Const;

import model.Student;

public class StudentList {
    static Scanner scanner = new Scanner(System.in);
    public static List<Student> listStudent = new ArrayList<>();


    public static void createStudent() {
        String name = InformationStudent.inputName();
        LocalDate dateOfBirth = InformationStudent.inputDateOfBirth();
        String address = InformationStudent.inputAddress();
        Float height = InformationStudent.inputHeight();
        Float weight = InformationStudent.inputWeight();
        String code = InformationStudent.inputStudentCode();
        String universityName = InformationStudent.inputUniversityName();
        int year = InformationStudent.inputAdmissionYear();
        Float gpa = InformationStudent.inputGpa();
        Student student = new Student(name, dateOfBirth, address, height, weight, code, universityName, year, gpa);
        System.out.println("Student created successfully");
        listStudent.add(student);
    }

    public static void showListStudent() {
        if (listStudent.size() != 0) {
            System.out.println("List student");
            for (Student student : listStudent) {
                System.out.println(student.toString());
                System.out.println();
            }
        } else System.out.println("List student no data");
    }

    public Student findById(int id) {
        for (Student student : listStudent) {
            if (student.getId() == id) {
                System.out.print(" Student information!");
                return student;
            }
        }
        return null;
    }


    public void updateStudentWithSId() {
        if (listStudent.size() != 0) {
            System.out.println("Input the student id you are update: ");
            int id = InformationStudent.inputIntNumber();
            for (Student student : listStudent) {
                if (student.getId() == id) {
                    editStudent(student);
                    System.out.println("Updated successfully.");
                } else System.out.println("Student does not exist.");
            }
        } else System.out.println("No data.");
    }

    public void editStudent(Student s) {
        do {
            if (listStudent.size() != 0) {
                System.out.printf("%-30s%-30s%-30s%n", "1. Student Code", "2. Name", "3. DOB");
                System.out.printf("%-30s%-30s%-30s%n", "4. Address", "5. Height", "6. Weight");
                System.out.printf("%-30s%-30s%-30s%n", "7. University", "8. Admission year", "9. GPA");
                System.out.println("Select from 1 to 9 (Select 0 to exit.):  ");
                int select = Integer.parseInt(scanner.nextLine());
                switch (select) {
                    case 0:
                        return;
                    case 1:
                        s.setStudentCodes(InformationStudent.inputStudentCode());
                        break;
                    case 2:
                        s.setName(InformationStudent.inputName());
                        break;
                    case 3:
                        s.setDateOfBirth(InformationStudent.inputDateOfBirth());
                        break;
                    case 4:
                        s.setAddress(InformationStudent.inputAddress());
                        break;
                    case 5:
                        s.setHeight(InformationStudent.inputHeight());
                        break;
                    case 6:
                        s.setWeight(InformationStudent.inputWeight());
                        break;
                    case 7:
                        s.setUniversityName(InformationStudent.inputUniversityName());
                        break;
                    case 8:
                        s.setAdmissionYear(InformationStudent.inputAdmissionYear());
                        break;
                    case 9:
                        s.setGpa(InformationStudent.inputGpa());
                        s.checkRank();
                        break;
                    default:
                        System.out.println("Choose the number from 0 - 9");
                        continue;
                }
                System.out.println("student updated");
            }
        } while (true);
    }


    public void deleteArrayListStudentById() {
        System.out.print("Input student's id need delete: ");
        int id = InformationStudent.inputIntNumber();
        boolean found = false;
        for (Student student : listStudent) {
            if (student.getId() == id) {
                int choice;
                System.out.println("Are you sure deleting this student? (1.Yes  2.No");
                choice = new Scanner(System.in).nextInt();
                if (choice == 1) listStudent.remove(student);
                found = true;
                for (Student s : listStudent) {
                    s.setId(s.getId() - 1);
                }
            }
        }
        if (!found) {
            System.out.println("Can not find student with id " + id);
        }
    }


    public void percentOfRank() {
        try {
            int sizeList = listStudent.size();
            if (sizeList != 0) {
                int poor = 0, weak = 0, average = 0, belowGood = 0, good = 0, excellent = 0;
                for (Student st : listStudent) {
                    if (st.getRank() == Classification.Rank.POOR) {
                        poor++;
                    } else if (st.getRank() == Classification.Rank.WEAK) {
                        weak++;
                    } else if (st.getRank() == Classification.Rank.AVERAGE) {
                        average++;
                    } else if (st.getRank() == Classification.Rank.BELOW_GOOD) {
                        belowGood++;
                    } else if (st.getRank() == Classification.Rank.GOOD) {
                        good++;
                    } else if (st.getRank() == Classification.Rank.EXCELLENT) {
                        excellent++;
                    }
                }
                float percentPoor = (float) ((poor * 100) / sizeList);
                float percentWeak = (float) ((weak * 100) / sizeList);
                float percentAverage = (float) ((average * 100) / sizeList);
                float percentBelowGood = (float) ((belowGood * 100) / sizeList);
                float percentGood = (float) ((good * 100) / sizeList);
                float percentExcellent = (float) ((excellent * 100) / sizeList);
                System.out.println("List sort!");
                Map<String, Float> sort = new HashMap<>();
                sort.put("POOR ", percentPoor);
                sort.put("WEAK ", percentWeak);
                sort.put("AVERAGE ", percentAverage);
                sort.put("BELOW_GOOD ", percentBelowGood);
                sort.put("GOOD ", percentGood);
                sort.put("EXCELLENT ", percentExcellent);
                List<Map.Entry<String, Float>> list = new ArrayList<>();
                list.addAll(sort.entrySet());
                Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println(list.get(i) + "%");
                }
            } else System.out.println("List student no data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void showPercentGpa() {
        try {
            if (listStudent.size() != 0) {
                System.out.println("Show medium score of students!");
                int sizeList = listStudent.size();
                Map<Float, Integer> mapGpa = new HashMap<>();
                for (Student student : listStudent) {
                    if (mapGpa.containsKey(student.getGpa())) {
                        mapGpa.put(student.getGpa(), (mapGpa.get(student.getGpa()) + 1));
                    } else {
                        mapGpa.put(student.getGpa(), 1);
                    }
                }
                Set<Map.Entry<Float, Integer>> entry = mapGpa.entrySet();
                for (Map.Entry<Float, Integer> x : entry) {
                    System.out.println(x.getKey() + " : " + (x.getValue() * 1.0 / sizeList) * 100 + "%");
                }
            } else System.out.println("List student no data");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showInformationStudentByRank() {
        if (listStudent.size() != 0) {
            System.out.println("\t0.Exit \t1. Yeu\t2. Kem\t3. Trung_binh \t4. Kha\t5. Gioi\t6. Xuat sac");
            System.out.print("Select from 1 to 6:  ");
            int select = InformationStudent.inputIntNumber();
            Classification.Rank rank ;
            switch (select) {
                case 1:
                    rank = Classification.Rank.POOR;
                    break;
                case 2:
                    rank = Classification.Rank.WEAK;
                    break;
                case 3:
                    rank = Classification.Rank.AVERAGE;
                    break;
                case 4:
                    rank = Classification.Rank.BELOW_GOOD;
                    break;
                case 5:
                    rank = Classification.Rank.GOOD;
                    break;
                case 6:
                    rank = Classification.Rank.EXCELLENT;
                    break;
                default:
                    System.out.println("err");
                    return;
            }
            boolean isStudentFound = false;
            for (Student student : listStudent) {
                if (student.getRank().equals(rank)) {
                    System.out.print(student);
                    isStudentFound = true;
                }
            }
            if (!isStudentFound)
                System.out.println("No student found in rank." );
        } else System.out.println("No data");
    }


    public static void saveStudentList() {
        try {
            System.out.println("Write file students!");
            String urlStudent = Const.FILENAME;
            FileWriter fileWriter = new FileWriter(urlStudent);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (listStudent.size() != 0) {
                for (Student st : listStudent) {
                    bufferedWriter.write(st.toString());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();

            } else System.out.println("File no data");
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            System.out.println("write file successfully");
        }
    }

}



