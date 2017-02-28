package assignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Daria Davydenko 
 * Student number: 200335788
 */
public class Student extends Person {

    private LocalDate enrollmentDate;
    private int studentNum;
    private String major;
    private boolean goodStanding;

    /**
     * This is a constructor for the class Student. It extends the Person class
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param province
     * @param postalCode
     * @param birthday check if the student is 14-90 years old
     * @param major
     * @param studentNum check if student num is greater than 0
     * @param enrollmentDate check if the student is not from the future
     */
    public Student(String firstName, String lastName, String address, String city,
            String province, String postalCode, LocalDate birthday, String major,
            int studentNum, LocalDate enrollmentDate) {
        super(firstName, lastName, address, city, province, postalCode, birthday);
        this.goodStanding = true;
        this.major = major;
        setStudentNum(studentNum);
        setEnrollmentDate(enrollmentDate);
        setBirthday(birthday);
    }

    /**
     * This method checks if the enrollment date is not greater than present
     * date. If the date is greater, that means that the student is from future
     *
     * @param enrollmentDate
     */
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        LocalDate today = LocalDate.now();
        if (enrollmentDate.getYear() <= today.getYear()) {
            this.enrollmentDate = enrollmentDate;
        } else {
            throw new IllegalArgumentException("The student is from the future");
        }
    }

    /**
     * This method checks if the student number is grater than 0.
     *
     * @param studentNum
     */
    public void setStudentNum(int studentNum) {
        if (studentNum > 0) {
            this.studentNum = studentNum;
        } else {
            throw new IllegalArgumentException("Student num should be greater than 0");
        }
    }

    /**
     * This method checks how long student is studying in college. If a Student
     * has been there 1.5 years, it should return 1.
     *
     * @return int years at college
     */
    public int getYearsAtCollege() {
        LocalDate today = LocalDate.now();
        Period years = Period.between(enrollmentDate, today);
        int yearsAtCollege = years.getYears();
        return yearsAtCollege;
    }

    /**
     * This method get year when student was enrolled.
     *
     * @return int year
     */
    public int getYearEnrolled() {
        int year = enrollmentDate.getYear();
        return year;
    }

    /**
     * This method set good the academic standing
     *
     * @return boolean goodStanding
     */
    public boolean reinstateStudent() {
        goodStanding = true;
        return goodStanding;
    }

    /**
     * This method set bad the academic standing
     *
     * @return boolean goodStanding
     */
    public boolean suspendStudent() {
        goodStanding = false;
        return goodStanding;
    }

    /**
     * This method set date of birth for the student. If age of student is
     * greater than 90 or less than 14 it will return an exception
     *
     * @param dateOfBirth
     */
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

    /**
     * This method override toString method in Person class and add student
     * number to it
     *
     * @return first name, last name, student number is: student number
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", student number is " + studentNum;
    }

    //Getters and Setters
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
