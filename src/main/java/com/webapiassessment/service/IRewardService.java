package com.webapiassessment.service;

import com.webapiassessment.model.Reward;

import java.time.Month;

public interface IRewardService {

    Reward totalPerCustomer(Integer id);
    Reward rewardByMonth(Integer id, Month month);

}