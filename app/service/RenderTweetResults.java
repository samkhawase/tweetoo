package service;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import play.Logger;


public class RenderTweetResults {

//	private static String jsonText = "{'id':'0001', 'name':'testUser', 'records': [{'subRecordId':'0001', 'subValue':'subValue1'}, {'subRecordId':'0002', 'subValue':'subValue2'},{'subRecordId':'0003', 'subValue':'subValue3'}]}";
	private static final String apiKey = "FcECcg9fsyb5GOnTCnS0g";
	private static final String apiSecret = "9brKG7tb20xpWyxI0rrLhGGPIXS4ak9J3hPf22ZXIs";
	
	public static void getResult() {
		
//		Data data = new Gson().fromJson(jsonText, Data.class);
//		Logger.info(data.toString());
		
		OAuthService service = new ServiceBuilder()
									.provider(TwitterApi.class)
									.apiKey(apiKey)
									.apiSecret(apiSecret)
									.build();
		
		Scanner in = new Scanner(System.in);
		
		Logger.info("======== starting the twitter transaction =======\n");
		
		Logger.info("Fetching request Token");
		Token requestToken = service.getRequestToken();
		Logger.info("Request token received");
		
		Logger.info("authorizing the application");
		Logger.info(service.getAuthorizationUrl(requestToken));
		Logger.info("Verifier is: ");
		Verifier verifier = new Verifier("3876562");	// 3876562
		
		
		Logger.info("trade request token for accessToken");
		Token accessToken = service.getAccessToken(requestToken, verifier);
		Logger.info("Access token is: "+accessToken);
		
		Logger.info("get some data");
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://stream.twitter.com/1/statuses/sample.json url");
		
		request.addBodyParameter("status", "India");
		service.signRequest(accessToken, request);
		Response response = request.send();
		
		Logger.info("Response is: ");
		Logger.info(response.getBody());
		
	}
}
