import java.util.HashSet;

public class LearningCenter {
    private HashSet<Student> studentList = new HashSet<Student>();

    public void  addStudent(Student student) {
        this.studentList.add(student);
    }
}
