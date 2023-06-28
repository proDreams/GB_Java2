public class Customer {
    private String FIO;
    private Integer age;
    private String phone;
    private Gender gender;


    enum Gender {male, female}

    public Customer(String FIO, Integer age, String phone, Gender gender) {
        this.FIO = FIO;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ФИО: " + FIO + ", возраст: " + age + ", телефон:" + phone;
    }
}
