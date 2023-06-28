public class Exceptions_1 {
    public static class WrongLoginException extends Exception {
        public WrongLoginException() {
            super("Ошибка!");
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
            super("Ошибка!");
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
