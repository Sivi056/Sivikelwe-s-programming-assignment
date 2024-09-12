package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    public void testStudentConstructor() {
        Student student = new Student("St10448374", "Tareeq Mathews", 19, "tmat73@gmail.com", "Computer Science");
        assertEquals("St10448374", student.getId());
        assertEquals("Tareeq Mathews", student.getName());
        assertEquals(19, student.getAge());
        assertEquals("tmat73@gmail.com", student.getEmail());
        assertEquals("Computer Science", student.getCourse());
    }

    @Test
    public void testToString() {
        Student student = new Student("St10448374", "Tareeq Mathews", 19, "tmat73@gmail.com", "Computer Science");
        String expected = "STUDENT ID: St10448374\n" +
                "STUDENT NAME: Tareeq Mathews\n" +
                "STUDENT AGE: 19\n" +
                "STUDENT EMAIL: tmat73@gmail.com\n" +
                "STUDENT COURSE: Computer Science\n";
        assertEquals(expected, student.toString());
    }

    @Test
    public void testFormattedReport() {
        Student student = new Student("St10448374", "Tareeq Mathews", 19, "tmat73@gmail.com", "Computer Science");
        String expected = "STUDENT 1\n" +
                "******************************\n" +
                "STUDENT ID: St10448374\n" +
                "STUDENT NAME: Tareeq Mathews\n" +
                "STUDENT AGE: 19\n" +
                "STUDENT EMAIL: tmat73@gmail.com\n" +
                "STUDENT COURSE: Computer Science\n";
        assertEquals(expected, student.formattedReport(1));
    }
}
