package homework;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class CustomerService {

    // todo: 3. надо реализовать методы этого класса

    TreeMap<Customer, String> map =
            new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() throws CloneNotSupportedException {
        Map.Entry<Customer, String> entry = map.firstEntry();
         return Map.entry(Customer.copyOf(entry.getKey()), entry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
           Map.Entry<Customer, String> entry = map.higherEntry(customer);
     return  (entry == null) ? null : Map.entry(Customer.copyOf(entry.getKey()), entry.getValue());
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }

//    public static void main(String[] args) {
//        CustomerService customerService = new CustomerService();
//        System.out.println(customerService.getNext(new Customer(1, "Ivan", 233)));
//
//
//    }

}
