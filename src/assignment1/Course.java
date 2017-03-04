package assignment1;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Dasha
 */
public class Course {

    private Instructor prof;
    private int maxNumberOfStudents, duration;
    private String courseCode, courseName, description, room;
    private DayOfWeek dayOfClass;
    private LocalTime startTime;
    private ArrayList<Student> listOfStudents;

    public Course(String courseCode, String courseName, String description,
            String roomNum, Instructor instructor, DayOfWeek dayOfWeek,
            LocalTime beginningOfClass, int durationOfClass, int maxAllowedOfStudents) {
        this.courseCode = courseCode;
        setMaxNumberOfStudents(maxAllowedOfStudents);
        this.courseName = courseName;
        this.description = description;
        this.room = roomNum;
        setDayOfClass(dayOfWeek);
        setStartTime(beginningOfClass);
        this.duration = durationOfClass;
        setProf(instructor);
        listOfStudents = new ArrayList<>();
    }

    public void setProf(Instructor instructor) {
        if (instructor.canTeach(courseCode)) {
            this.prof = instructor;
        } else {
            throw new IllegalArgumentException("The instructor cannot teach this course");
        }
    }

    public void setDayOfClass(DayOfWeek dayOfClass) {
        if (dayOfClass == DayOfWeek.SATURDAY || dayOfClass == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("There is no classes at Saturday or Sunday");
        } else {
            this.dayOfClass = dayOfClass;
        }
    }

    public void setMaxNumberOfStudents(int maxAllowedOfStudents) {
        if (maxAllowedOfStudents >= 10 && maxAllowedOfStudents <= 50) {
            this.maxNumberOfStudents = maxAllowedOfStudents;
        } else {
            throw new IllegalArgumentException("There should be 10-50 students in the class");
        }
    }

    public void setStartTime(LocalTime beginningOfClass) {
        LocalTime beginning = LocalTime.of(7, 59);
        LocalTime finishing = LocalTime.of(18, 1);

        if (beginningOfClass.isAfter(beginning) && beginningOfClass.isBefore(finishing)) {
            this.startTime = beginningOfClass;
        } else {
            throw new IllegalArgumentException("The class should be in range of 8:00 - 18:00");
        }
    }

    public void addStudent(Student student) throws InvalidStudentException {
        if (student.inGoodStanding() && listOfStudents.size() < maxNumberOfStudents) {
            listOfStudents.add(student);
        } else {
            throw new InvalidStudentException("The student cannot be added");
        }
    }

    public int getNumberOfStudentsEnrolled() {
        int counter = 0;
        for (Student student : listOfStudents) {
            counter++;
        }
        return counter;
    }

    public String showClassList() {
        String students = "";
        for (Student student : listOfStudents) {
            students += student.toString() + "%n";
        }
        return students.format(students);
    }

    public double averageStudentTimeAtCollege() {
        double allYears = 0;
        for (Student student : listOfStudents) {
            allYears += student.getYearsAtCollege();
        }
        double result = allYears / getNumberOfStudentsEnrolled();
        
        if(Double.isNaN(result)){
            result = 0;
        }

        return result;
    }

    @Override
    public String toString() {
        return courseName + " " + courseCode;
    }

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
