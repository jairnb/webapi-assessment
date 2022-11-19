package com.webapiassessment.service.impl;

import com.webapiassessment.dto.customer.CustomerOrderDTO;
import com.webapiassessment.entity.Customer;
import com.webapiassessment.entity.Order;
import com.webapiassessment.model.Reward;
import com.webapiassessment.repository.CustomerRepository;
import com.webapiassessment.repository.OrderRepository;
import com.webapiassessment.service.IRewardService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RewardService implements IRewardService {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    public Reward rewardByMonth(Integer customerId, Month month) {
        Customer customer = customerRepository.findById(customerId).get();
        List<Order> orders = orderRepository.findAllByCustomer(customer)
                .stream()
                .filter(o -> o.getDate().getMonth().equals(month))
                .collect(Collectors.toList());

        Reward r = new Reward();
        r.setPoints(calculatePoint(orders));
        r.setCustomer(modelMapper.map(customer, CustomerOrderDTO.class));

        return r;
    }

    @Override
    public Reward totalPerCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        List<Order> orders = orderRepository.findAllByCustomer(customer)
                .stream()
                .collect(Collectors.toList());

        Reward r = new Reward();
        r.setPoints(calculatePoint(orders));
        r.setCustomer(modelMapper.map(customer, CustomerOrderDTO.class));

        return r;
    }


    private int calculatePoint(List<Order> orders) {
        int totalPoint = 0;

        for (Order order : orders){
            if (order.getTotal() > 100){
                int point = (int) (Math.floor(order.getTotal()) - 100) * 2;
                totalPoint += point;
            }
            if (order.getTotal() <= 100 && order.getTotal() > 50){
                int point = (int) (Math.floor(order.getTotal()) - 50);
                totalPoint += point;
            }
        }
        return totalPoint;
    }
}