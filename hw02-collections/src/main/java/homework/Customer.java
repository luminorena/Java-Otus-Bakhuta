package homework;


import java.util.Objects;


public class Customer implements Cloneable {
    private final long id;
    private String name;
    private long scores;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

    // todo: 1. в этом классе надо исправить ошибки

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public static Customer copyOf(Customer customer) {
        return new Customer(customer.getId(), customer.getName(), customer.getScores());
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", scores=" + scores + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
