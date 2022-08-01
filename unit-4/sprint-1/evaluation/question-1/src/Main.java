import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Map<Employee,Integer> map=new TreeMap<>();
        Employee e1=new Employee(1,"Pushpam","Patna");
        Employee e2=new Employee(3,"Deepak","Patna");

        map.put(e1,9000);
        map.put(e2,8000);
        for (Employee employee:map.keySet()) {
            System.out.println("Employee: "+employee.getEmpId()+" "+employee.getName()+" "+employee.getAddress()+"Salary: "+map.get(employee));

        }

    }
}