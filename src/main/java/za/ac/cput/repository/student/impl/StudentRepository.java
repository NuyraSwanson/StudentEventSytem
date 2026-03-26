package za.ac.cput.repository.student.impl;
/*Ayren Villet 223120030
25 March 2026
 */
import za.ac.cput.domain.Student;
import za.ac.cput.repository.student.IStudentRepository;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository implements IStudentRepository {

    private static StudentRepository repository = null;
    private Map<String, Student> studentTable;

    private StudentRepository() {
        studentTable = new HashMap<>();
    }

    public static StudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public Student create(Student student) {
        studentTable.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public Student read(String studentId) {
        return studentTable.get(studentId);
    }

    @Override
    public Student update(Student student) {
        studentTable.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public boolean delete(String studentId) {
        studentTable.remove(studentId);
        return true;
    }
}