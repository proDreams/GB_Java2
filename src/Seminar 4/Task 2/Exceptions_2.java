public class Exceptions_2 {
    public static class CustomerException extends RuntimeException {
        public CustomerException() {
            super("Customer not found");
        }
    }

    public static class ProductException extends RuntimeException {
        public ProductException() {
            super("Product not found");
        }
    }

    public static class AmountException extends RuntimeException {
        public AmountException() {
            super("Wrong amount, set to 1");
        }
    }

    public static class TooMuchSaleException extends RuntimeException {
        public TooMuchSaleException() {
            super("Too much discount!!!");
        }
    }
}
