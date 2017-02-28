package assignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Daria Davydenko 
 * Student number: 200335788
 */
public class Instructor extends Person {

    private int employeeNum;
    private LocalDate hireDate;
    private ArrayList<String> teachableCourse;

    /**
     * This is a constructor for the class Instructor. It extends the Person
     * class
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param province
     * @param postalCode
     * @param birthday check if the student is 18-100 years old
     * @param employeeNum
     * @param hireDate check if the hiring date is not the future or if it is
     * not greater then 90 years from now
     */
    public Instructor(String firstName, String lastName, String address,
            String city, String province, String postalCode, LocalDate birthday,
            int employeeNum, LocalDate hireDate) {
        super(firstName, lastName, address, city, province, postalCode, birthday);
        teachableCourse = new ArrayList();
        this.employeeNum = employeeNum;
        setHireDate(hireDate);
        setBirthday(birthday);
    }

    /**
     * This method set the hiring date for the instructor. If this date is over
     * 80 years before present day or if it is a date in the future, there will
     * be an exception
     *
     * @param hireDate
     */
    public void setHireDate(LocalDate hireDate) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(hireDate, today);
        int age = period.getYears();

        if (hireDate.getYear() <= today.getYear()) {
            if (age < 80) {
                this.hireDate = hireDate;
            } else {
                throw new IllegalArgumentException("The teacher is vunderkind!");
            }
        } else {
            throw new IllegalArgumentException("The teacher is from the future");
        }
    }

    /**
     * This method set date of birth for the instructor. If age of instructor is
     * greater than 100 or less than 18 it will return an exception
     *
     * @param dateOfBirth
     */
    public void setBirthday(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateOfBirth, today);
        int age = period.getYears();

        if (age < 100) {
            if (age > 18) {
                super.setBirthday(dateOfBirth);
            } else {
                throw new IllegalArgumentException("Too young");
            }
        } else {
            throw new IllegalArgumentException("Too old");
        }
    }

    /**
     * This method add courses to the list of courses for the teacher. All
     * courses stored in the UpperCase.
     *
     * @param course
     */
    public void addTeachableCourse(String course) {
        teachableCourse.add(course.toUpperCase());
    }

    /**
     * This method checks if the course is in the list of courses for the
     * teacher.
     *
     * @param course
     * @return true/false
     */
    public boolean canTeach(String course) {
        if (teachableCourse.contains(course.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method get how long the teacher studies at college
     *
     * @return int years
     */
    public int getYearsAtCollege() {
        LocalDate today = LocalDate.now();
        Period years = Period.between(hireDate, today);
        int yearsAtCollege = years.getYears();
        return yearsAtCollege;
    }

    /**
     * This method read a list of courses that teacher has and returns it as an
     * one line
     *
     * @return String courses
     */
    public String listOfSubjectsCertifiedToTeach() {
        StringBuilder sb = new StringBuilder(teachableCourse.size());
        for (int i = 0; i < teachableCourse.size(); i++) {
            sb.append(teachableCourse.get(i));
            if (i < teachableCourse.size() - 1) {
                sb.append(", ");
            }
        }
        String courses = sb.toString();
        return courses;
    }
    
    /**
     * This method override toString method in Person class and add employee
     * number to it
     *
     * @return first name, last name, employee number is: employee number
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", employee number is " + employeeNum;
    }

    //Getters and Setters
    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public ArrayList getTeachableCourses() {
        return teachableCourse;
    }

    public void setTeachableCourses(ArrayList teachableCourse) {
        this.teachableCourse = teachableCourse;
    }

}
