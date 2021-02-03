import java.util.Date;

public class CDVideo extends Video {

	private int penalty = 2; // CD

	private int limit = 3; // CD

	public CDVideo(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
	}

	public int getLateReturnPointPenalty() {
		return penalty;
	}

	public int getLimit() {
		return limit;
	}
}
