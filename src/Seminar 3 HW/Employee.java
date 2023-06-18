public class Employee {
    private String FIO;
    private String Position;
    private String Tel;
    private int Salary;
    private int Age;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Employee(String fio, String position, String tel, int salary, int age) {
        this.FIO = fio;
        this.Position = position;
        this.Tel = tel;
        this.Salary = salary;
        this.Age = age;
    }

    @Override
    public String toString() {
        return "ФИО: " + FIO + '\n' +
                "Должность: " + Position + '\n' +
                "Телефон: " + Tel + '\n' +
                "Зарплата: " + Salary + '\n' +
                "Возраст: " + Age;
    }
}
