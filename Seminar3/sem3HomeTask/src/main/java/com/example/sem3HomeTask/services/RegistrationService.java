package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;


    private NotificationService notificationService=new NotificationService();

    private UserService userService=new UserService(notificationService);

   public void processRegistration(String name, int age, String email){
       processRegistration(userService.createUser(name,age,email));
   }
    public void processRegistration(User user){
        dataProcessingService.addUserToList(user);
          notificationService.notifyUser(user);
    }



}
