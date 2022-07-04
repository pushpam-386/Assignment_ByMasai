public class Ticket {
        int ticketId;
        int price;

        public  Ticket(int ticketId,int price){
            this.ticketId=ticketId;
            this.price=price;
        }
        static int availableTickets;

        public int calculateTicketCost(int noOfTickets){
            System.out.println("Number of Tickets available:"+availableTickets);
            if(availableTickets>noOfTickets){
                availableTickets-=noOfTickets;
                int totalAmount=noOfTickets*price;
                System.out.println("Number of Tickets available after booking:"+ availableTickets);
                return totalAmount;
            }
            return -1;
        }


}
