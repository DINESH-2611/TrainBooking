package AdminUser;

import model.TrainRoutes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminUserView {
    Scanner scanner=new Scanner(System.in);
    private AdminUserModel adminUserModel;
    public AdminUserView(){
        adminUserModel=new AdminUserModel(this);
    }

    public void adminPage() {
        System.out.println("Do you want to add Train routes?\nYes\nNo");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter no of train routes");
            int routes=Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < routes; i++) {
                System.out.println("Enter train number(In numbers)");
                int trainNo=Integer.parseInt(scanner.nextLine());
                System.out.println("Enter train name");
                String name=scanner.nextLine();
                System.out.println("Enter departure time in 'HH:MM' format");
                String departure=scanner.nextLine();
                System.out.println("Enter arrival time in 'HH:MM' format");
                String arrival=scanner.nextLine();
                System.out.println("Enter no of seats in the train(In numbers)");
                int seats=Integer.parseInt(scanner.nextLine());
                System.out.println("Enter fare(In numbers)");
                int fare=Integer.parseInt(scanner.nextLine());
                System.out.println("Enter no of stops for the routes(In numbers)");
                int stop=Integer.parseInt(scanner.nextLine());
                List<String> stops=new ArrayList<>();
                for (int j = 0; j < stop; j++) {
                    System.out.println("Enter stop name");
                    stops.add(scanner.nextLine());
                }
                adminUserModel.addTrainRoutes(trainNo,name,departure,arrival,seats,fare,stops);
            }
            showAlert(routes+"train routes added succesfully");
        }else if(choice.equalsIgnoreCase("no")){
            showAlert("Thank you for login");
        }else{
            showAlert("Invalid choice,Enter valid choice");
            adminPage();
        }
    }

     void showAlert(String s) {
        System.out.println(s);
    }

    public void userPage() {
        while (true){
            System.out.println("1.Booking\n2.Get PNR status\n3.Booked Tickets\n4.Cancel Tickets\n5.Search Passengers\n6.List Train routes\n7.Back to Home page\nEnter the choice");
            String choice=scanner.nextLine();
            switch (choice){
                case "1":
                    getStatEndpoint();
                    break;
                case "2":break;
                case "3":break;
                case "4":break;
                case "5":break;
                case "6":break;
                case "7":break;
                default:showAlert("Invalid choice,Enter valid choice");
            }
        }
    }

    private void getStatEndpoint() {
        System.out.println("Enter from station");
        String from=scanner.nextLine();
        System.out.println("Enter from station");
        String to=scanner.nextLine();
        adminUserModel.getAvailabletrains(from,to);
    }

    public void showTrains(List<TrainRoutes> availabletrains) {
        for (TrainRoutes trainRoutes:availabletrains)
            System.out.println(trainRoutes);
    }

    public void getTrainNo(List<TrainRoutes> availabletrains) {
        System.out.println("Enter train number");
        int trainNo=Integer.parseInt(scanner.nextLine());
        adminUserModel.isvalidTrain(availabletrains,trainNo);


        }

    public void getpassengersCount(TrainRoutes trainRoutes) {
        System.out.println("Enter no of passengers");
        int passengers=Integer.parseInt(scanner.nextLine());
        if(trainRoutes.getSeats()<=passengers){
            getpassengersDetails(trainRoutes,passengers);
        }else{
            showAlert("Passengers exceeds the train seat availability");
            getpassengersCount(trainRoutes);
        }
    }

    private void getpassengersDetails(TrainRoutes trainRoutes, int passengers) {
        for (int i = 0; i < passengers; i++) {
            System.out.println("Enter passengers "+(i+1)+" details");
            System.out.println("Enter passenger name");
            String name=scanner.nextLine();
            System.out.println("Enter age");
            int age=Integer.parseInt(scanner.nextLine());
            System.out.println("Enter gender");
            String gender=scanner.nextLine();
            System.out.println("Enter id");
            int id=Integer.parseInt(scanner.nextLine());
        }
    }
}

