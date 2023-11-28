import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceManagementSystem {
    public static class Student {
        private String studentId;
        private String name;

        public Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getName() {
            return name;
        }
    }

    public static class Course {
        private String courseId;
        private String courseName;

        public Course(String courseId, String courseName) {
            this.courseId = courseId;
            this.courseName = courseName;
        }

        public String getCourseId() {
            return courseId;
        }

        public String getCourseName() {
            return courseName;
        }
    }

    public static class AttendanceRecord {
        private Student student;
        private Course course;
        private Date date;
        private boolean isPresent;

        public AttendanceRecord(Student student, Course course, Date date, boolean isPresent) {
            this.student = student;
            this.course = course;
            this.date = date;
            this.isPresent = isPresent;
        }

        public Student getStudent() {
            return student;
        }

        public Course getCourse() {
            return course;
        }

        public Date getDate() {
            return date;
        }

        public boolean isPresent() {
            return isPresent;
        }
    }

    private List<AttendanceRecord> attendanceRecords;

    public AttendanceManagementSystem() {
        this.attendanceRecords = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, Date date, boolean isPresent) {
        AttendanceRecord record = new AttendanceRecord(student, course, date, isPresent);
        attendanceRecords.add(record);
    }

    public void displayAttendance() {
        for (AttendanceRecord record : attendanceRecords) {
            System.out.println("Student: " + record.getStudent().getName() +
                    ", Course: " + record.getCourse().getCourseName() +
                    ", Date: " + record.getDate() +
                    ", Present: " + record.isPresent());
        }
    }

    public static void main(String[] args) {
        AttendanceManagementSystem attendanceSystem = new AttendanceManagementSystem();

        Student student1 = new Student("S101", "John Doe");
        Course course1 = new Course("C101", "Java Programming");

        attendanceSystem.markAttendance(student1, course1, new Date(), true);
        attendanceSystem.markAttendance(student1, course1, new Date(), false);

        attendanceSystem.displayAttendance();
    }
}
