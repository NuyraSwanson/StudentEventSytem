package za.ac.cput.repository;
/*
Author: Ayren Villet (223120030)
Date: 26 March 2026
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.student.impl.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private static StudentRepository repository = StudentRepository.getRepository();

    private Student student = StudentFactory.createStudent(
            "123",
            "Ayren",
            "ayren@mail.com"
    );

    @Test
    void create() {
        Student created = repository.create(student);
        assertNotNull(created);
    }

    @Test
    void read() {
        repository.create(student);
        Student read = repository.read(student.getStudentId());
        assertNotNull(read);
    }

    @Test
    void update() {
        repository.create(student);

        Student updated = new Student.Builder()
                .copy(student)
                .setName("Updated Name")
                .build();

        Student result = repository.update(updated);
        assertNotNull(result);
    }

    @Test
    void delete() {
        repository.create(student);

        boolean success = repository.delete(student.getStudentId());
        assertTrue(success);
    }
}