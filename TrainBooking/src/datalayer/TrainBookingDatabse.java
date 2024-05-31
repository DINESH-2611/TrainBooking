package datalayer;

import model.Credential;
import model.Passenger;
import model.TrainRoutes;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class TrainBookingDatabse {
    private String appName;
    private  static TrainBookingDatabse trainBookingDatabse;
    private List<TrainRoutes> trainRoutesList =new ArrayList<>();
    private List<Passenger> passengerList=new ArrayList<>();
    private List<Credential> credentialList=new ArrayList<>();
    private List<User> userList=new ArrayList<>();
    public static TrainBookingDatabse  getInstance(){
        if(trainBookingDatabse==null){
            trainBookingDatabse=new TrainBookingDatabse();
        }
        return trainBookingDatabse;
    }
    public String getAppName() {
        return appName;
    }

    public void createCredentails() {
        if(credentialList.isEmpty()){
            Credential credential=new Credential();
            credential.setUserName("zsgs");
            credential.setPassword("admin");
            credential.setRole(1);
            credentialList.add(credential);
        }
        appName="IRCTC";
    }

    public boolean isUserExist(String userName, String password) {
        for (User user:userList){
            if(user.getName().equals(userName))
                return false;
        }
        return true;
    }

    public void adduser(String userName, String password) {
        User user=new User();
        user.setName(userName);
        user.setPassword(password);
        userList.add(user);
        Credential credential=new Credential();
        credential.setUserName(userName);
        credential.setPassword(password);
        credentialList.add(credential);
    }

    public void addTrainroutes(TrainRoutes trainRoutes) {
        trainRoutesList.add(trainRoutes);
    }

    public List<TrainRoutes> getAvailabletrains(String from, String to) {
        List<TrainRoutes> availabletrains=new ArrayList<>();
        int start=-1,end=-1;
        for (TrainRoutes trainRoutes:trainRoutesList) {
            List<String> train=trainRoutes.getRoutes();
            for (int j = 0; j < train.size(); j++) {
                if(train.get(j).equals(from)){
                    start=j;
                }
                if(train.get(j).equals(to)){
                    end=j;
                }
            }
            if(start!=-1 && end!=-1 && start<end)
                availabletrains.add(trainRoutes);
        }
        return availabletrains;
    }
}
