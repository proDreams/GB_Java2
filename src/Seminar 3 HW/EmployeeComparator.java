import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalary() == o2.getSalary()) {
            if (o1.getAge() == o2.getAge()) {
                return 0;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            } else {
                return -1;
            }
        }
        if ((o1.getSalary() > o2.getSalary())) {
            if (o1.getAge() > o2.getAge() || o1.getAge() == o2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }
        else {
            return -1;
        }
    }

}
