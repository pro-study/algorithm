import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	private static final int DATE_IDX = 0;
	private static final int TIME_IDX = 1;
	private static final int PROCESS_TIME_IDX = 2;

	public int solution(String[] lines) {

		List<Request> requests = Arrays.stream(lines).map(line -> {
			String[] splitLine = line.split(" ");
			return new Request(splitLine[DATE_IDX], splitLine[TIME_IDX], splitLine[PROCESS_TIME_IDX]);
		}).collect(Collectors.toList());

		List<Long> timestamps = requests.stream().flatMap(process -> Arrays.stream(process.getTimestamps()))
			.collect(Collectors.toList());

		return timestamps.stream().mapToInt(timestamp ->
			(int) requests.stream().filter(request -> request.isElapsedBetween(timestamp, timestamp + (1000L - 1L))).count()
		).max().orElse(0);
	}
}

class Request {
	
	private Long[] timestamps;

	private static final int START_TIMESTAMP_IDX = 0;
	private static final int END_TIMESTAMP_IDX = 1;

	Request(String date, String time, String processTime) {
		this.timestamps = generateTimestamps(date, time, processTime);
	}

	Long[] getTimestamps() {
		return Arrays.copyOf(timestamps, timestamps.length);
	}

	boolean isElapsedBetween(Long fromTimestamp, Long toTimestamp) {
		return toTimestamp >= timestamps[START_TIMESTAMP_IDX] && fromTimestamp <= timestamps[END_TIMESTAMP_IDX];
	}

	private Long[] generateTimestamps(String date, String time, String processTime) {
		Long[] timestamps = new Long[2];

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
		Calendar calendar = Calendar.getInstance();

		try {
			calendar.setTime(sdf.parse(date + ' ' + time));
		} catch (ParseException e) { }

		long timeInterval = (long)(Float.parseFloat(extractOnlyNumberAndDot(processTime)) * 1000);
		
		timestamps[START_TIMESTAMP_IDX] = calendar.getTimeInMillis() - timeInterval + 1L;
		timestamps[END_TIMESTAMP_IDX] = calendar.getTimeInMillis();

		return timestamps;
	}

	private String extractOnlyNumberAndDot(String s) {
		return s.replaceAll("(?!(\\d|\\.)).", "");
	}
}
