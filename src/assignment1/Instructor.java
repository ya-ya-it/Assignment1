package assignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Dasha
 */
public class Instructor extends Person {

    private int employeeNum;
    private LocalDate hireDate;
    private ArrayList<String> teachableCourse;

    public Instructor(String firstName, String lastName, String address,
            String city, String province, String postalCode, LocalDate birthday,
            int employeeNum, LocalDate hireDate) {
        super(firstName, lastName, address, city, province, postalCode, birthday);
        teachableCourse = new ArrayList();
        this.employeeNum = employeeNum;
        setHireDate(hireDate);
        setBirthday(birthday);
    }

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

    public void addTeachableCourse(String course) {
        teachableCourse.add(course.toUpperCase());
    }

    public boolean canTeach(String course) {
        if (teachableCourse.contains(course.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    public int getYearsAtCollege() {
        LocalDate today = LocalDate.now();
        Period years = Period.between(hireDate, today);
        int yearsAtCollege = years.getYears();
        return yearsAtCollege;
    }

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
