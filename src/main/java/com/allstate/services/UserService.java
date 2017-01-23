package com.allstate.services;

import com.allstate.entities.User;
import com.allstate.repositories.IStatisticsRepository;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private IUserRepository userRepository;
    private IStatisticsRepository statisticsRepository;

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setStatisticsRepository(IStatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public User create(String userName, double balance){
        return this.userRepository.save(new User(userName, balance));
    }

    public Iterable<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findById(int id){
        Optional<User> oUser = Optional.ofNullable(this.userRepository.findOne(id));
        if(oUser.isPresent()) {
            return oUser.get();
        }else{
            throw new IllegalArgumentException("User ID not found");
        }

    }
}
