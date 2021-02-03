import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;

	private VidioRentalManager vidioRentalManager = new VidioRentalManager();

	public void run() {
		boolean quit = false;

		while ( !quit ) {
			try {
				int command = showCommand() ;
				switch ( command ) {
					case 0: quit = true ; break ;
					case 1: listCustomers() ; break ;
					case 2: listVideos() ; break ;
					case 3: register("customer") ; break ;
					case 4: register("video") ; break ;
					case 5: rentVideo() ; break ;
					case 6: returnVideo() ; break ;
					case 7: getCustomerReport() ; break;
					case 8: clearRentals() ; break ;
					case -1: init() ; break ;
					default: break ;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Bye");
	}

	public void clearRentals() throws Exception {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next();

		String resultMessage = vidioRentalManager.clearRentals(customerName);
		System.out.println(resultMessage);
	}

	public void returnVideo() throws Exception {
		System.out.println("Enter customer name: ");
		String customerName = scanner.next();

		vidioRentalManager.findCustomer(customerName);

		System.out.println("Enter video title to return: ");
		String videoTitle = scanner.next();

		vidioRentalManager.returnVideo(customerName, videoTitle);
	}

	private void init() {
		vidioRentalManager.init();
	}

	public void listVideos() {
		System.out.println("List of videos");

		String ret = vidioRentalManager.getVideoList();
		System.out.println(ret);

		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");

		String ret = vidioRentalManager.getCustomerList();
		System.out.println(ret);

		System.out.println("End of list");
	}

	public void getCustomerReport() throws Exception {
		System.out.println("Enter customer name: ");
		String customerName = scanner.next();

		System.out.println(vidioRentalManager.getCustomerReport(customerName));
	}

	public void rentVideo()  throws Exception {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		vidioRentalManager.findCustomer(customerName);
		
		System.out.println("Enter video title to rent: ") ;
		String videoTitle = scanner.next() ;

		vidioRentalManager.rentVideo(customerName, videoTitle);
	}

	public void register(String object) {
		if ( object.equals("customer") ) {
			System.out.println("Enter customer name: ") ;
			String name = scanner.next();
			vidioRentalManager.registerCustomer(name);
		}
		else {
			System.out.println("Enter video title to register: ") ;
			String title = scanner.next() ;
			
			System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
			int videoType = scanner.nextInt();
			
			System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
			int priceCode = scanner.nextInt();

			vidioRentalManager.registerVideo(title, priceCode, videoType);
		}
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");
		
		int command = scanner.nextInt() ;
		
		return command ;
	}
}
