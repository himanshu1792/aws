package aws_poc;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.Credentials;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;

public class AWSTempCredentials {
	
	public static void main(String[] args) {
	String cognitoIdentityId = "us-east-1:b13977f8-12dc-42ef-8f0a-3b008fdd8fec";
	String openIdToken = "eyJraWQiOiJ1cy1lYXN0LTExIiwidHlwIjoiSldTIiwiYWxnIjoiUlM1MTIifQ.eyJzdWIiOiJ1cy1lYXN0LTE6YjEzOTc3ZjgtMTJkYy00MmVmLThmMGEtM2IwMDhmZGQ4ZmVjIiwiYXVkIjoidXMtZWFzdC0xOjAwMWNjNjdlLTM0OTktNGViMi1hMjVhLWJiYjllZjg3NjBlYiIsImFtciI6WyJhdXRoZW50aWNhdGVkIiwiUHdjIiwiUHdjOnVzLWVhc3QtMTowMDFjYzY3ZS0zNDk5LTRlYjItYTI1YS1iYmI5ZWY4NzYwZWI6bmVoYWNoYW5kYWsiXSwiaXNzIjoiaHR0cHM6Ly9jb2duaXRvLWlkZW50aXR5LmFtYXpvbmF3cy5jb20iLCJleHAiOjE1Mzc3ODc4NDcsImlhdCI6MTUzNzc4Njg0N30.NwItr5YSf1STuslfrHvb8bA61T_J7vQIdCTJioFHEyf4o6V1CcirFWtD074OIJU_t2s6FjESFXGflOxAklDNd8_ZfpkrR_yl7E3xk7qw_ig5ZwpOAsUfxZSLnj3P3HKMP-7_0EU_l5XtMzx9J5Wr5kR2VT7V-Dnw3RAgniPKpPzzR36_NTmyQnH3VW7Q4TVduD15aRDgW3gXAu20tALhBLri2U-FbsgWSOvcmzNbTdb4duDsbEWs8dqPnOCDK5aE-vxMU0rpVN2wmEKDGyX-6QjWCyH8Rg8Gfz2AMWekXAme8PJrGijryWeFp-JkZytC_egkr21mTJL8GrquAYd-mg";

	Map<String,String> logins = new HashMap<>();
	logins.put("cognito-identity.amazonaws.com", openIdToken);
	GetCredentialsForIdentityRequest getCredentialsRequest =
	    new GetCredentialsForIdentityRequest()
	    .withIdentityId(cognitoIdentityId)
	    .withLogins(logins);
	AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAIJNHK6W6M3XAT45A", "PbwI5rbTK7FAGRmTXVBm0acHC0cjLRmXt91ODwyE");
	AmazonCognitoIdentityClient cognitoIdentityClient = new AmazonCognitoIdentityClient(awsCredentials);
	GetCredentialsForIdentityResult getCredentialsResult = cognitoIdentityClient.getCredentialsForIdentity(getCredentialsRequest);
	Credentials credentials = getCredentialsResult.getCredentials();
	AWSSessionCredentials sessionCredentials = new BasicSessionCredentials(
	    credentials.getAccessKeyId(),
	    credentials.getSecretKey(),
	    credentials.getSessionToken()
	);
	System.out.println("sessionCredentials.getAWSAccessKeyId ---"+sessionCredentials.getAWSAccessKeyId()+"\nsessionCredentials.getAWSSecretKey---"+sessionCredentials.getAWSSecretKey()+"\nsessionCredentials.getSessionToken()-----"+sessionCredentials.getSessionToken());
	
	}

}
