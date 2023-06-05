package cobaspringapi.cobaspringapi.api;


import cobaspringapi.cobaspringapi.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {

    // Get HTTP method
    @GetMapping("/hello-world")
    public String HelloWorld() {
        return "Hello World";
    }

    // read and create 1 data
    @GetMapping("/my-name")
    public Student getStudent() {
        return new Student("Rayhan", "Putra");
    }

    // list
    @GetMapping("list-name")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Budi", "Hartono"));
        students.add(new Student("Mei", "Mei"));
        return students;
    }


    @GetMapping("{firstName}/{lastName}")
    public Student findStudent(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return new Student(firstName, lastName);
    }
}
