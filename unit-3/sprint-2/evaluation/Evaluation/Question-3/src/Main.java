import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of booking:");
        int noOfBookings=sc.nextInt();
        System.out.println("Enter number of available tickets:");
        int availableTickets=sc.nextInt();
        Ticket.availableTickets=availableTickets;

        for(int i=0;i<noOfBookings;i++){
            System.out.println("Enter tickets:");
            int ticketId=sc.nextInt();
            System.out.println("Enter the Price:");
            int price=sc.nextInt();
            System.out.println("Enter number of tickets:");
            int noOfTickets=sc.nextInt();

            Ticket t=new Ticket(ticketId,price);
            int totalAmount=t.calculateTicketCost(noOfTickets);
            System.out.println("Total Amount:"+totalAmount);
        }
    }

}