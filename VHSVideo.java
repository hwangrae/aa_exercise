import java.util.Date;

public class VHSVideo extends Video {

	private int penalty = 1; // VHS

	private int limit = 5; // VHS

	public VHSVideo(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
	}

	public int getLateReturnPointPenalty() {
		return penalty;
	}

	public int getLimit() {
		return limit;
	}
}
