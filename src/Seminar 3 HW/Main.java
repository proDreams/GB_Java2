//Опишите класс руководителя, наследник от сотрудника.
//Перенесите статический метод повышения зарплаты (сделать статическим) в класс руководителя,
// модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
// В основной программе создайте руководителя и поместите его в общий массив сотрудников.
// Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
//
// Сделать компараторы для Сотрудников на основе ЗП и Возраста

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        Employee First = new Employee("Ivan", "Admin", "+7123456789", 6000, 30);
        Employee Second = new Employee("Kristina", "Secretary", "+7123456789", 6000, 35);
        Employee Third = new Employee("Yurii", "Frontend", "+7123456789", 500, 55);
        Employee Third2 = new Employee("Yurii2", "Frontend", "+7123456789", 500, 45);
        Employee Fourth = new Director("Anrey", "Director", "+7123456789", 10000, 65);

        employeeList.add(First);
        employeeList.add(Second);
        employeeList.add(Third);
        employeeList.add(Third2);
        employeeList.add(Fourth);

        printEmployees(employeeList);
        Director.salaryUp(employeeList);
        System.out.println("===================================");

        EmployeeComparator myEmployeeComparator = new EmployeeComparator();
        employeeList.sort(myEmployeeComparator);

        printEmployees(employeeList);

    }

    public static void printEmployees(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("\n" + employee);
        }
    }
}
