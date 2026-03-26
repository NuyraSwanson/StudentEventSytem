package za.ac.cput.domain;
/*Ayren Villet 223120030
* 24 March 2026*/
public class Student {

    private String studentId;
    private String name;
    private String email;

    private Student() {}

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.email = builder.email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String studentId;
        private String name;
        private String email;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.name = student.name;
            this.email = student.email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}