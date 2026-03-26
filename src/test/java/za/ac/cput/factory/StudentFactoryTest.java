package za.ac.cput.factory;

/*Author Ayren Villet
223120030
25 March 2026*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void createStudent() {
        Student student = StudentFactory.createStudent("123", "Ayren", "ayren@mail.com");
        assertNotNull(student);
        System.out.println(student.getName());
    }

    @Test
    void createStudentWithNullValues() {
        Student student = StudentFactory.createStudent("", "Ayren", "ayren@mail.com");
        assertNull(student);
    }
}