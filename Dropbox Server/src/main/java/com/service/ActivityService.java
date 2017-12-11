package com.service;

import com.entity.Activity;
import com.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public void addActivity(Activity activity){
        activityRepository.save(activity);
    }

    public List<Activity> getUserActivity(String email){
        return activityRepository.findByEmailId(email);
    }

}






