package assignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Dasha
 */
public class Student extends Person {

    private LocalDate enrollmentDate;
    private int studentNum;
    private String major;
    private boolean goodStanding;

    public Student(String firstName, String lastName, String address, String city,
            String province, String postalCode, LocalDate birthday, String major,
            int studentNum, LocalDate enrollmentDate) {
        super(firstName, lastName, address, city, province, postalCode, birthday);
        setStudentNum(studentNum);
        this.major = major;
        setEnrollmentDate(enrollmentDate);
        this.goodStanding = true;
        setBirthday(birthday);
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setStudentNum(int studentNum) {
        if (studentNum > 0) {
            this.studentNum = studentNum;
        } else {
            throw new IllegalArgumentException("Student num should be greater than 0");
        }
    }

    public int getYearsAtCollege() {
        LocalDate today = LocalDate.now();
        Period years = Period.between(enrollmentDate, today);
        int yearsAtCollege = years.getYears();
        return yearsAtCollege;
    }

    public int getYearEnrolled() {
        int date = enrollmentDate.getYear();
        return date;
    }

    public boolean reinstateStudent() {
        goodStanding = true;
        return goodStanding;
    }

    public boolean suspendStudent() {
        goodStanding = false;
        return goodStanding;
    }

    public void setBirthday(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateOfBirth, today);
        int age = period.getYears();

        if (age < 90) {
            if (age > 14) {
                super.setBirthday(dateOfBirth);
            } else {
                throw new IllegalArgumentException("Too young");
            }
        } else {
            throw new IllegalArgumentException("Too old");
        }
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", student number is " + studentNum;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean inGoodStanding() {
        return goodStanding;
    }

    public void setGoodStanding(boolean goodStanding) {
        this.goodStanding = goodStanding;
    }

}
