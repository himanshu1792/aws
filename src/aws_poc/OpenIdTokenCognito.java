package aws_poc;

import java.util.HashMap;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult;

public class OpenIdTokenCognito {
	
	public static void main(String[] args) {
		
		AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAIJNHK6W6M3XAT45A", "PbwI5rbTK7FAGRmTXVBm0acHC0cjLRmXt91ODwyE");
		@SuppressWarnings("deprecation")
		AmazonCognitoIdentityClient client = 
				new AmazonCognitoIdentityClient(awsCredentials);
				GetOpenIdTokenForDeveloperIdentityRequest tokenRequest = 
				  new GetOpenIdTokenForDeveloperIdentityRequest();
				tokenRequest.setIdentityPoolId("us-east-1:001cc67e-3499-4eb2-a25a-bbb9ef8760eb");
				HashMap<String, String> map = new HashMap<String, String>();

				//Key -> Developer Provider Name used when creating the identity pool
				//Value -> Unique identifier of the user in your backend
				map.put("Pwc", "nehachandak");

				//Duration of the generated OpenID Connect Token
				tokenRequest.setLogins(map); tokenRequest.setTokenDuration(1000l);

				GetOpenIdTokenForDeveloperIdentityResult result 
				   = client.getOpenIdTokenForDeveloperIdentity(tokenRequest);
				String identityId = result.getIdentityId();
				String token = result.getToken();
				
				System.out.println("identityId---"+identityId+"token ---------"+token);
	}

}
