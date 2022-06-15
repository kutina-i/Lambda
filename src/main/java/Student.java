import java.util.Objects;

public class Student extends Human {
    private String university;
    private String faculty;
    private String specialization;

    public Student(String surname, String name, String patronymic, int age, Gender gender, String university, String faculty,String specialization){
        super(surname, name, patronymic, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.specialization = specialization;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecialization() {
        return specialization;
    }
    @Override
    public String getSurname() {return super.getSurname();}
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public String getPatronymic() {
        return super.getPatronymic();
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public Gender getGender(){return super.getGender();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university) && Objects.equals(faculty, student.faculty) && Objects.equals(specialization, student.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, faculty, specialization);
    }
}
