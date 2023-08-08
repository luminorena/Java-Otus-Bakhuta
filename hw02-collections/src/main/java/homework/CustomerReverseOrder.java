package homework;

import java.util.*;

public class CustomerReverseOrder {

    // todo: 2. надо реализовать методы этого класса
    // надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"

    Deque<Customer> deque = new ArrayDeque<>();

    public void add(Customer customer) {
        deque.offerLast(customer);

    }

    public Customer take() {
        return deque.removeLast();


    }


    public static void main(String[] args) {
        CustomerReverseOrder order = new CustomerReverseOrder();
        Customer customer1 = new Customer(1, "Ivan", 233);
        Customer customer2 = new Customer(2, "Ivannna", 123);
        order.add(customer1);
        order.add(customer2);
        System.out.println(order.take());
    }
}
