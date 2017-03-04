package assignment1;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Daria Davydenko
 * Student number: 200335788
 */
public class Course {

    private Instructor prof;
    private int maxNumberOfStudents, duration;
    private String courseCode, courseName, description, room;
    private DayOfWeek dayOfClass;
    private LocalTime startTime;
    private ArrayList<Student> listOfStudents;

    /**
     * This is a constructor for Course class.
     *
     * @param courseCode
     * @param courseName
     * @param description
     * @param roomNum
     * @param instructor check if the professor has this course in the checklist
     * @param dayOfWeek class can be in Monday-Friday only
     * @param beginningOfClass class can start just after 8:00 AM
     * @param durationOfClass
     * @param maxAllowedOfStudents allowed 10-50 students in course
     */
    public Course(String courseCode, String courseName, String description,
            String roomNum, Instructor instructor, DayOfWeek dayOfWeek,
            LocalTime beginningOfClass, int durationOfClass, int maxAllowedOfStudents) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.room = roomNum;
        this.duration = durationOfClass;
        listOfStudents = new ArrayList<>();
        setMaxNumberOfStudents(maxAllowedOfStudents);
        setProf(instructor);
        setDayOfClass(dayOfWeek);
        setStartTime(beginningOfClass);
    }

    /**
     * This method check if the professor has this particular course in his
     * course list. If the course is not in the list, the
     * IllegalArgumentException will be thrown.
     *
     * @param instructor
     */
    public void setProf(Instructor instructor) {
        if (instructor.canTeach(courseCode)) {
            this.prof = instructor;
        } else {
            throw new IllegalArgumentException("The instructor cannot teach this course");
        }
    }

    /**
     * This method checks the day the class is. If it is weekends, the
     * IllegalArgumentException will be thrown
     *
     * @param dayOfClass
     */
    public void setDayOfClass(DayOfWeek dayOfClass) {
        if (dayOfClass == DayOfWeek.SATURDAY || dayOfClass == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("There is no classes at Saturday or Sunday");
        } else {
            this.dayOfClass = dayOfClass;
        }
    }

    /**
     * This method checks how many students is attending the course. If it is
     * less than 10 or more than 50 the IllegalArgumentException will be thrown.
     *
     * @param maxAllowedOfStudents
     */
    public void setMaxNumberOfStudents(int maxAllowedOfStudents) {
        if (maxAllowedOfStudents >= 10 && maxAllowedOfStudents <= 50) {
            this.maxNumberOfStudents = maxAllowedOfStudents;
        } else {
            throw new IllegalArgumentException("There should be 10-50 students in the class");
        }
    }

    /**
     * This method checks the time the class begins and ends. If it is earlier
     * than 8:00 AM or later than 6:00 PM the IllegalArgumentException will be
     * thrown.
     *
     * @param beginningOfClass
     */
    public void setStartTime(LocalTime beginningOfClass) {
        LocalTime beginning = LocalTime.of(7, 59);
        LocalTime finishing = LocalTime.of(18, 1);

        if (beginningOfClass.isAfter(beginning) && beginningOfClass.isBefore(finishing)) {
            this.startTime = beginningOfClass;
        } else {
            throw new IllegalArgumentException("The class should be in range of 8:00 - 18:00");
        }
    }

    /**
     * This method checks if students is in Good Academic Standing and if it is
     * free space in the class. If the result is true, the student will be added
     * to the course list, if the result is false the InvalidStudentException
     * will be thrown.
     *
     * @param student
     * @throws InvalidStudentException
     */
    public void addStudent(Student student) throws InvalidStudentException {
        if (student.inGoodStanding() && listOfStudents.size() < maxNumberOfStudents) {
            listOfStudents.add(student);
        } else {
            throw new InvalidStudentException("The student cannot be added");
        }
    }

    /**
     * This method counts how many students are attending the course.
     *
     * @return int number of students on the course
     */
    public int getNumberOfStudentsEnrolled() {
        int counter = 0;
        for (Student student : listOfStudents) {
            counter++;
        }
        return counter;
    }

    /**
     * This method shows the list of the students with student numbers in course
     * in String format.
     *
     * @return String list of students are attending the course
     */
    public String showClassList() {
        String students = "";
        for (Student student : listOfStudents) {
            students += student.toString() + "%n";
        }
        return students.format(students);
    }

    /**
     * This method counts the average time all students in a particular course
     * are attending the college. If there is no students in the class, the
     * result will be 0;
     *
     * @return double average years all students are in college
     */
    public double averageStudentTimeAtCollege() {
        double allYears = 0;
        for (Student student : listOfStudents) {
            allYears += student.getYearsAtCollege();
        }
        double result = allYears / getNumberOfStudentsEnrolled();

        if (getNumberOfStudentsEnrolled() == 0) {
            result = 0;
        }

        return result;
    }

    /**
     * This method return the course name and the course number in String format
     *
     * @return String course name course number
     */
    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }

    //Getters and Setters
    public Instructor getProf() {
        return prof;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public DayOfWeek getDayOfClass() {
        return dayOfClass;
    }

    public ArrayList<Student> getStudents() {
        return listOfStudents;
    }

    public void setStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
}
