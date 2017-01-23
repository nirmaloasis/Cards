package com.allstate.services;

import com.allstate.entities.Statistics;
import com.allstate.entities.User;
import com.allstate.exceptions.BetException;
import com.allstate.models.Card;
import com.allstate.models.Player;
import com.allstate.repositories.IStatisticsRepository;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private IStatisticsRepository statisticsRepository;
    private IUserRepository userRepository;

    @Autowired
    public void setStatisticsRepository(IStatisticsRepository statisticsRepository){
        this.statisticsRepository = statisticsRepository;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Statistics bet(int userId, double betAmount) throws BetException{
        User user = this.userRepository.findOne(userId);
        double balance = user.getBalance();
        if(balance >= betAmount) {
            Card d1 = CardService.getRandomCard();
            Card d2 = CardService.getRandomCard();
            Player dealer = new Player(d1, d2);

            Card c1 = CardService.getRandomCard();
            Card c2 = CardService.getRandomCard();
            Player player = new Player(c1, c2);


        } else {
            throw new BetException("Insufficient Balance");
        }
    }


}
