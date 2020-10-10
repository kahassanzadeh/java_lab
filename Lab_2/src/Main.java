public class Main {

    public static void main(String[] args) {
        Student std1 = new Student("Ehsan","Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");

        /*Student[] stda = new Student[3];
        stda[0] = std1;
        stda[1] = std2;*/

        Lab lab = new Lab(20,"monday");
        lab.setStudents(new Student[5]);
        lab.enrollStudent(std1);
        lab.enrollStudent(std2);
        lab.enrollStudent(std3);

        lab.print();
    }
}
