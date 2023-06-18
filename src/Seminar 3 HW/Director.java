import java.util.ArrayList;

public class Director extends Employee {
    public Director(String fio, String position, String tel, int salary, int age) {
        super(fio, position, tel, salary, age);
    }

    public static void salaryUp(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getAge() > 45 && !(employee instanceof Director)) {
                employee.setSalary(employee.getSalary() + 5000);
            }
        }
    }
}
