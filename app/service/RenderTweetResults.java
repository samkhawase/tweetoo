package service;

import play.Logger;
import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class RenderTweetResults extends StatusAdapter {

	// private static String jsonText =
	// "{'id':'0001', 'name':'testUser', 'records': [{'subRecordId':'0001', 'subValue':'subValue1'}, {'subRecordId':'0002', 'subValue':'subValue2'},{'subRecordId':'0003', 'subValue':'subValue3'}]}";

	public static void getResult() {

		TwitterStream stream = new TwitterStreamFactory().getInstance();

		StatusListener listener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
				Logger.info("Exception! "+ arg0.getMessage());
			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				Logger.info("Track Limitation Notice!");
			}

			@Override
			public void onStatus(Status status) {
				Logger.info("@" + status.getUser().getScreenName() + "-->\n" + status.getText());
				Logger.info("\n-----------------------------------------------\n");
				
			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				Logger.info("WTF!? scrubGeo");
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				Logger.info("deletion Notice");
			}
		};
		
		FilterQuery fq = new FilterQuery();
		String[] query = {"hiring"};
		fq.track(query);
		
		stream.addListener(listener);
		stream.filter(fq);
		
	}
}
