public class StudentTest {
    public static void main(String[] args) {

        System.out.println(" 任务一：3 个 Student 对象 ");
        Student s1 = new Student();
        s1.setName("李四");
        s1.setStudentId("20260001");
        s1.setScore(88);

        Student s2 = new Student("王五", "20260002", 95);
        Student s3 = new Student("赵六", "20260003", 120);   // 非法成绩，验证校验

        s1.introduce();
        s2.introduce();
        s3.introduce();

        System.out.println();
        System.out.println("s2 的姓名是：" + s2.getName() + "，成绩是：" + s2.getScore());

        System.out.println();
        System.out.println(" 任务二：继承与多态 ");
        GraduateStudent g = new GraduateStudent("钱七", "20260004", 92, "王教授");
        g.introduce();
        g.research();

        System.out.println();
        System.out.println(" 父类引用指向子类对象 ");
        Student p = new GraduateStudent("孙八", "20260005", 90, "李教授");
        p.introduce();
        // p.resarch();

        System.out.println();
        System.out.println(" 强转成子类引用就能调 research() ");
        GraduateStudent q = (GraduateStudent) p;
        q.research();
        System.out.println("改导师后：");
        q.setAdvisor("周教授");
        q.introduce();
    }
}
