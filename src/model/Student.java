package model;

import java.time.LocalDate;

import services.Classification;

public class Student extends Person {
    private String studentCodes;
    private String universityName;
    private Integer admissionYear;
    private Float gpa;

    private services.Classification.Rank Rank;



    public Student(String name, LocalDate dateOfBirth, String address,
            Float height, Float weight, String codeSt, String universityName,
            Integer admissionYear, Float gpa) {
        super(name, dateOfBirth, address, height, weight);
        this.studentCodes = codeSt;
        this.universityName = universityName;
        this.admissionYear = admissionYear;
        this.gpa = gpa;
        checkRank();
    }

    public String getStudentCodes() {
        return studentCodes;
    }

    public void setStudentCodes(String studentCodes) {
        this.studentCodes = studentCodes;
    }



    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }


    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }



    public Classification.Rank getRank() {
        return Rank;
    }

    public String toString() {
        return "\n{ " + " id = " + super.getId() + " | " + " name = " + super.getName() + " | " + " born = "
                + super.getDateOfBirth() + " | " +
                " address = " + super.getAddress() + " | " + " height = " + super.getHeight() + " | " + " weight = "
                + super.getWeight() +
                "\ncode student = " + studentCodes + " | " + " name university = " + universityName
                + " | " + " start year = " + admissionYear + " | " + " gpa = " + gpa + " | " + " rank = " + Rank
                + " } ";
    }


    public void checkRank() {
        if (getGpa() < 3) {
            this.Rank = Classification.Rank.POOR;
        } else if (getGpa() < 5) {
            this.Rank = Classification.Rank.WEAK;
        } else if (getGpa() < 6.5) {
            this.Rank = Classification.Rank.AVERAGE;
        } else if (getGpa() < 7.5) {
            this.Rank = Classification.Rank.BELOW_GOOD;
        } else if (getGpa() < 9) {
            this.Rank = Classification.Rank.GOOD;
        } else if (getGpa() <= 10) {
            this.Rank = Classification.Rank.EXCELLENT;
        }
    }

}
