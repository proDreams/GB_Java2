// Задание 2
// Задача: Эмуляция интернет-магазина
// 1. Написать классы
// - покупатель (ФИО, возраст, телефон);
// - товар (название, цена);
// - заказ (объект покупатель, объект товар, количество).
// 2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов)
// и массив заказов (пустой на 5 элементов).
// 3. Создать статический метод “совершить покупку” со строковыми параметрами, соответствующими полям объекта заказа.
// Метод должен вернуть объект заказа
// 4. Если в метод передан несуществующий покупатель - метод должен выбросить исключение CustomerException,
// если передан несуществующий товар, метод должен выбросить исключение ProductException,
// если было передано отрицательное или слишком большое значение количества (например, 100),
// метод должен выбросить исключение AmountException.
// Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями.
// Обработать исключения следующим образом (в этом порядке):
// - если был передан неверный товар - вывести в консоль сообщение об ошибке, не совершать данную покупку
// - если было передано неверное количество - купить товар в количестве 1
// - если был передан неверный пользователь - завершить работу приложения с исключением.
// Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.
//
// Домашнее задание
// Добавить перечисление с гендерами. В класс покупателя добавить свойство «пол» со значением созданного перечисления.
// Добавить геттеры, сеттеры.
//
// Добавить в приложение Магазин учет цены товара - в Заказ добавить поле стоимость.
// Добавить перечисление с размерами скидок - 0, 5, 10, 15, 20%.
// Написать метод, при вызове которого на переданный тип товара незначается рандомная скидка из перечисления (меняем значение поля price)
//
// ** Товарам добавить категорию. Задать категории Стандарт и Премиум.
// Если на товар категории Премиум назначилась скидка более 15%, выбросить исключение TooMuchSaleException(msg),
// сообщение с ошибкой вывести в консоль, цену товара не менять.

import java.util.Random;
import java.util.Scanner;

public class Main_4_2 {
    static Customer[] customers;
    static Product[] products;
    static Order[] orders;
    static Customer.Gender male = Customer.Gender.male;

    enum Discount {
        zero(0), five(5), ten(10), fifteen(15), twenty(20);

        private final int discount;

        Discount(int discount) {
            this.discount = discount;
        }

        public int getDiscount() {
            return discount;
        }
    }

    public static void main(String[] args) {
        Customer first_customer = new Customer("Ivan Ivanov", 30, "+7123456789", male);
        Customer second_customer = new Customer("Petr Petrov", 45, "+7987654321", male);
        customers = new Customer[]{first_customer, second_customer};

        Product first_product = new Product("Apple", 100, Product.Category.standard);
        Product second_product = new Product("Orange", 120, Product.Category.standard);
        Product third_product = new Product("Banana", 80, Product.Category.standard);
        Product fourth_product = new Product("Kiwi", 150, Product.Category.premium);
        Product fifth_product = new Product("Watermelon", 85, Product.Category.premium);
        products = new Product[]{first_product, second_product, third_product, fourth_product, fifth_product};

        Order[] orders = new Order[5];

        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите ФИО покупателя, товар и  количество через запятую: ");
                String[] order = scanner.nextLine().split(", ");
                int amount = Integer.parseInt(order[2]);
                Order newOrder = null;
                try {
                    newOrder = createOrder(order[0], order[1], amount);
                } catch (Exceptions_2.CustomerException e) {
                    e.printStackTrace();
                } catch (Exceptions_2.ProductException e) {
                    System.out.println(e.getMessage());
                } catch (Exceptions_2.AmountException e) {
                    System.out.println(e.getMessage());
                    amount = 1;
                    newOrder = createOrder(order[0], order[1], amount);
                } catch (Exceptions_2.TooMuchSaleException e){
                    System.out.println(e.getMessage());
                    newOrder = createOrder(order[0], order[1], amount);
                }
                if (newOrder != null) {
                    orders[i] = newOrder;
                    break;
                }
            }
        }

        printOrders(orders);
    }

    private static Order createOrder(String customerFIO, String productTitle, Integer productAmount) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getFIO().equals(customerFIO)) {
                customer = c;
                break;
            }
        }
        if (customer == null) {
            throw new Exceptions_2.CustomerException();
        }

        Product product = null;
        for (Product p : products) {
            if (p.getTitle().equals(productTitle)) {
                product = p;
                break;
            }
        }
        if (product == null) {
            throw new Exceptions_2.ProductException();
        }

        if (productAmount < 1 || productAmount > 100) {
            throw new Exceptions_2.AmountException();
        }

        int disc = randomDiscount().getDiscount();
        float newPrice = productAmount * product.getPrice();

        if (product.getCategory() == Product.Category.premium && disc > 15){
            throw new Exceptions_2.TooMuchSaleException();
        } else {
            float price = productAmount * product.getPrice();
            newPrice = price - (price / 100 * disc);
        }
        return new Order(customer, product, productAmount, newPrice);
    }

    private static void printOrders(Order[] orderArray) {
        for (int i = 0; i < orderArray.length; i++) {
            System.out.println("Заказ номер: " + (i + 1) + '\n'
                    + orderArray[i] + '\n');
        }
    }

    private static Discount randomDiscount() {
        int pick = new Random().nextInt(Discount.values().length);
        return Discount.values()[pick];
    }
}
