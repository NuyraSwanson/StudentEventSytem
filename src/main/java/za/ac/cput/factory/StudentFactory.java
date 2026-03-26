package za.ac.cput.factory;

/*Author Ayren Villet
* 223120030
* 24 March 2026*/
import za.ac.cput.domain.Student;

public class StudentFactory {

    public static Student createStudent(String studentId, String name, String email) {

        if (studentId == null || studentId.isEmpty())
            return null;

        if (name == null || name.isEmpty())
            return null;

        if (email == null || email.isEmpty())
            return null;

        return new Student.Builder()
                .setStudentId(studentId)
                .setName(name)
                .setEmail(email)
                .build();
    }
}