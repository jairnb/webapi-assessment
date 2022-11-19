package com.webapiassessment.controller;

import com.webapiassessment.service.IRewardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;

@RestController
@RequestMapping("/rewards")
@AllArgsConstructor
public class RewardController {

    private IRewardService rewardService;

    @GetMapping("/{customerId}")
    public ResponseEntity<?> findAllReward(@PathVariable Integer customerId){
        return new ResponseEntity<>(rewardService.totalPerCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping("/{customerId}/{month}")
    public ResponseEntity<?> findMonthReward(@PathVariable Integer customerId, @PathVariable int month){
        Month m = Month.of(month);
        return new ResponseEntity<>(rewardService.rewardByMonth(customerId, m), HttpStatus.OK);
    }
}