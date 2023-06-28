// Задание 1
// Задача:   Проверка логина и пароля
// 1. Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
// 2. Длина login должна быть меньше 20 символов.
// Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
// 3. Длина password должна быть меньше 20 символов.
// Также password и confirmPassword должны быть равны.
// Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
// 4. WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами –
// один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
// 5. В основном классе программы необходимо по-разному обработать исключения.
// 6. Метод возвращает true, если значения верны или false в другом случае.


public class Main4_1 {
    public static void main(String[] args) {
        try {
            System.out.println(check_credentials("aaaaaaaaa", "pass1", "pass"));
        } catch (Exceptions_1.WrongLoginException | Exceptions_1.WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Boolean check_credentials(String login, String password, String confirm_password)
            throws Exceptions_1.WrongLoginException, Exceptions_1.WrongPasswordException {
        if (login.length() > 20) {
            throw new Exceptions_1.WrongLoginException("Поле login не может быть больше 20ти символов!");
        } else if (password.length() > 20) {
            throw new Exceptions_1.WrongPasswordException("Поле password не может быть больше 20ти символов!");
        } else if (!password.equals(confirm_password)) {
            throw new Exceptions_1.WrongPasswordException("Поле password и confirm_password не совпадают!");
        }
        return true;
    }
}
