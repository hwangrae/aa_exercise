import java.util.Date;

public class DVDVideo extends Video {

	private int penalty = 3; // DVD

	private int limit = 2; // DVD

	public DVDVideo(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
	}

	public int getLateReturnPointPenalty() {
		return penalty;
	}

	public int getLimit() {
		return limit;
	}
}
