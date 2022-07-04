import java.lang.reflect.Array;
import java.util.Scanner;
public class Main extends Student{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Students you want to enter");
        int n=sc.nextInt();
        Student[] students-new Stdents[n];
        for(int i=1;i<=n;i++){
            String name=sc.next();
            int rollNo=sc.nextInt();
            int marks =sc.nextInt();
            Student s=new Student(rollNo,name,marks);
            array.set(students,i,s);
        }

    }
}
