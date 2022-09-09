package jpql.UseCase;

import java.util.List;
import java.util.Scanner;

import jpql.interfac.EmployeeException;
import jpql.interfac.JpqlImplementation;
import table.classs.Employee;

public class GetEmployeeBysalary {

	public static void main(String[] args) throws EmployeeException {
		JpqlImplementation objectImplementation=new JpqlImplementation();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter salary to find Employee:  ");
		String salary =scanner.next();
		Object employee1=objectImplementation.getEmployeesByAddress(salary);
		Employee employee=(Employee) employee1;

			System.out.println("EmployeeI - "+employee.getEmpID()+", Employee name - "
		+employee.getName()+" , Employee address -  "
					+employee.getAddress()+" ,  Employee salary - "
		+employee.getSalary());
		

	}

}
