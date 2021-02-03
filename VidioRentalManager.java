import java.util.*;

public class VidioRentalManager {

    private static Scanner scanner = new Scanner(System.in);

    private List<Customer> customers = new ArrayList<Customer>();

    private List<Video> videos = new ArrayList<Video>();

    public Customer findCustomer(String customerName) throws Exception {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer == null) {
            throw new Exception("No customer found");
        }

        return foundCustomer;
    }

    public String clearRentals(String customerName) throws Exception {

        Customer foundCustomer = findCustomer(customerName);

        String ret = foundCustomer.getRentalsInformation();

        List<Rental> rentals = new ArrayList<Rental>();
        foundCustomer.setRentals(rentals);

        return ret;
    }

    public void returnVideo(String customerName, String videoTitle) throws Exception {
        Customer foundCustomer = findCustomer(customerName);

        Rental rental = foundCustomer.getRental(videoTitle);
        rental.returnVideo();
    }

    public void rentVideo(String customerName, String videoName) throws Exception {
        Customer foundCustomer = findCustomer(customerName);

        Video foundVideo = null;
        for (Video video : videos) {
            if (video.getTitle().equals(videoName) && video.isRented() == false) {
                foundVideo = video;
                break;
            }
        }
        if (foundVideo == null) return;

        Rental rental = new Rental(foundVideo);
        foundVideo.setRented(true);

        foundCustomer.addRental(rental);
    }

    public Video registerVideo(String title, int priceCode, int videoType) {
        Video video = null;
        if (videoType == 1)
            video = new VHSVideo(title, priceCode, new Date());
        else if (videoType == 2)
            video = new CDVideo(title, priceCode, new Date());
        else if (videoType == 3)
            video = new DVDVideo(title, priceCode, new Date());
        else {
            new Exception("video type error");
        }

        videos.add(video);
        return video;
    }

    public Customer registerCustomer(String name) {
        Customer customer = new Customer(name);
        customers.add(customer);
        return customer;
    }

    public String getVideoList() {
        StringBuffer sb = new StringBuffer();
        for ( Video video: videos) {
            sb.append("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle() + "\n");
        }
        return sb.toString();
    }

    public String getCustomerList() {
        StringBuffer sb = new StringBuffer();
        for ( Customer customer: customers ) {
            sb.append("Name: " + customer.getName() +
                    "\tRentals: " + customer.getRentals().size() + "\n");
            for ( Rental rental: customer.getRentals() ) {
                sb.append("\tTitle: " + rental.getVideo().getTitle() + " ") ;
                sb.append("\tPrice Code: " + rental.getVideo().getPriceCode() + "\n") ;
            }
        }
        return sb.toString();
    }

    public void init() {
        Customer james = registerCustomer("James");
        registerCustomer("Brown");

        Video v1 = registerVideo("v1", Video.REGULAR, 2);
        Video v2 = registerVideo("v2", Video.NEW_RELEASE, 3);

        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);

        james.addRental(r1);
        james.addRental(r2);
    }

    public String getCustomerReport(String name) throws Exception {
        Customer customer = findCustomer(name);
        return customer.getReport();
    }
}
