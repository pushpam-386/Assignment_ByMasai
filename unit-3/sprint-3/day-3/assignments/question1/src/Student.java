public class Student {
    private int roll;
    private String name;
    private int marks;
    private char grade;

    public Student(){

    }
    public Student(int roll, String name,int marks,char grade){
        this.roll=roll;
        this.name=name;
        this.marks=marks;
        this.grade=grade;
    }

    public void displayDetails(){

    }
    private void calculateGrade(){
        if (marks >=500) {
            grade="A";
        }
        if (marks <= 500&& marks>= 400) {
            grade="B";
        }
        if (marks <400) {
            grade="C";
        }
    }
}
