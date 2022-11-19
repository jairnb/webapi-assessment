package com.webapiassessment.service.impl;

import com.webapiassessment.dto.OrderDTO;
import com.webapiassessment.dto.OrderListDTO;
import com.webapiassessment.dto.OrderSaveDTO;
import com.webapiassessment.entity.Customer;
import com.webapiassessment.entity.Order;
import com.webapiassessment.entity.Product;
import com.webapiassessment.repository.CustomerRepository;
import com.webapiassessment.repository.OrderRepository;
import com.webapiassessment.repository.ProductRepository;
import com.webapiassessment.service.IOrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    public Order save(OrderSaveDTO order) {
        Order o = modelMapper.map(order, Order.class);
        o.setCustomer(order.getCustomer());
        o.setProducts(order.getProducts());
        o.setTotal(calculateTotal(o.getProducts()));
        o.setDate(LocalDate.now());

        System.out.println(o.getTotal());
        return orderRepository.save(o);
    }

    @Override
    @Transactional
    public Order update(Integer id, Order o) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()){
            order.get().setDate(LocalDate.now());
            order.get().setCustomer(o.getCustomer());
            order.get().setTotal(calculateTotal(o.getProducts()));
            order.get().setProducts(o.getProducts());
            orderRepository.save(order.get());
            return order.get();
        }
        return null;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public OrderListDTO findAll() {
        List<Order> orderList = orderRepository.findAll();
        OrderListDTO orderListDTO = new OrderListDTO();
        orderListDTO.setOrders(orderList.stream().map(o -> modelMapper.map(o, OrderDTO.class)).toList());
        return orderListDTO;
    }

    private double calculateTotal(List<Product> products){
        return products.stream().map(p -> productRepository.findById(p.getId()).get()).collect(Collectors.summingDouble(Product::getPrice));
    }


    public void createDummyOrder(){
        Customer c = customerRepository.findById(1).get();
        Product p1 = productRepository.findById(1).get();
        Product p3 = productRepository.findById(5).get();
        Product p2 = productRepository.findById(4).get();

        List<Product> products = List.of(p1, p2, p3);

        Order order = new Order();
        order.setProducts(products);
        order.setCustomer(c);
        order.setDate(LocalDate.now());
        order.setTotal(calculateTotal(products));

        Customer c1 = customerRepository.findById(2).get();
        Product p11 = productRepository.findById(2).get();
        Product p31 = productRepository.findById(3).get();
        Product p21 = productRepository.findById(5).get();

        List<Product> products1 = List.of(p11, p21, p31);

        Order order1 = new Order();
        order1.setProducts(products1);
        order1.setCustomer(c1);
        order1.setDate(LocalDate.now());
        order1.setTotal(calculateTotal(products1));

        orderRepository.save(order);
        orderRepository.save(order1);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            createDummyOrder();
        };
    }
}