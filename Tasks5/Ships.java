package Tasks5;


public class Ships {
    private String name;
    private String product;
    private int capacity;
    private int count;

    public Ships(String name, String product, int capacity) {
        setName(name);
        setProduct(product);
        setCapacity(capacity);
    }

    public void add(int count) {
        this.count += count;
    }

    public boolean countCheck() {
        if (count >= capacity) {
            return false;
        }
        return true;
    }

    void setName(String name) {
        if (name!=null) {
            this.name = name;
        }
    }

    String getName() {
        return name;
    }

    void setProduct(String product) {
            this.product = product;
    }

    String getProduct() {
        return product;
    }

    void setCapacity(int capacity) {
            this.capacity = capacity;
    }

    int getCapacity() {
        return capacity;
    }

}
