public class Student {

    private String name;
    private String studentId;
    private int score;

    public Student() {
        this("未命名", "00000000", 0);
    }

    public Student(String name, String studentId, int score) {
        this.name = name;
        this.studentId = studentId;
        setScore(score);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public int getScore() { return score; }
    public void setScore(int score) {
        if (score < 0 || score > 100) {
            System.out.println("成绩必须在 0-100 之间，已设为 0");
            this.score = 0;
        } else {
            this.score = score;
        }
    }

    public void introduce() {
        System.out.println("我是" + name + ", 学号" + studentId + ", 成绩" + score);
    }
}
