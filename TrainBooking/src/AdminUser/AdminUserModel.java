package AdminUser;

import datalayer.TrainBookingDatabse;
import model.TrainRoutes;

import java.util.List;

public class AdminUserModel {
    private AdminUserView adminUserView;

    public AdminUserModel(AdminUserView adminUserView) {
        this.adminUserView=adminUserView;
    }

    public void addTrainRoutes(int trainNo, String name, String departure, String arrival, int seats, int fare, List<String> routes) {
        TrainRoutes trainRoutes=new TrainRoutes();
        trainRoutes.setTrainNo(trainNo);
        trainRoutes.setTrainName(name);
        trainRoutes.setDepartureTime(departure);
        trainRoutes.setArrivalTime(arrival);
        trainRoutes.setSeats(seats);
        trainRoutes.setFare(fare);
        trainRoutes.setRoutes(routes);
        TrainBookingDatabse.getInstance().addTrainroutes(trainRoutes);
    }

    public void getAvailabletrains(String from, String to) {
        List<TrainRoutes> availabletrains=TrainBookingDatabse.getInstance().getAvailabletrains(from,to);
        if(availabletrains.isEmpty()){
            adminUserView.showAlert("No trains found");
        }else{
            adminUserView.showAlert("\t\t\tAvailable trains");
            adminUserView.showTrains(availabletrains);
            adminUserView.getTrainNo(availabletrains);
        }
    }

    public void isvalidTrain(List<TrainRoutes> availabletrains, int trainNo) {
        for (TrainRoutes trainRoutes:availabletrains){
            if(trainRoutes.getTrainNo()==trainNo) {
                adminUserView.getpassengersCount(trainRoutes);
                return;
            }
        }
        adminUserView.showAlert("Train  no is wrong");
    }
}
