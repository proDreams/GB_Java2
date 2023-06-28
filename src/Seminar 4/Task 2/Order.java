public class Order {
    private Customer customer;
    private Product product;
    private Integer amount;
    private float totalPrice;


    public Order(Customer customer, Product product, Integer amount, float totalPrice) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Покупатель: " + customer + '\n' +
                "Товар: " + product + '\n' +
                "Количество: " + amount + '\n' +
                "Цена: " + totalPrice;
    }
}
