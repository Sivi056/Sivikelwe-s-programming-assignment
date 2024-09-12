package assignment1;


class Student {
    String id;
    String name;
    int age;
    String email;
    String course;

    // Constructor to initialize Student object
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Method to display student information
    @Override
    public String toString() {
        return "STUDENT ID: " + id + "\n" +
                "STUDENT NAME: " + name + "\n" +
                "STUDENT AGE: " + age + "\n" +
                "STUDENT EMAIL: " + email + "\n" +
                "STUDENT COURSE: " + course + "\n";
    }

    // Method to format student report
    public String formattedReport(int studentNumber) {
        return "STUDENT " + studentNumber + "\n" +
                "******************************\n" +
                "STUDENT ID: " + id + "\n" +
                "STUDENT NAME: " + name + "\n" +
                "STUDENT AGE: " + age + "\n" +
                "STUDENT EMAIL: " + email + "\n" +
                "STUDENT COURSE: " + course + "\n";
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return null;
    }

    public int getAge() {
        return 0;
    }

    public String getEmail() {
        return null;
    }

    public String getCourse() {
        return null;
    }
}


