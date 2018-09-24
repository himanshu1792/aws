package aws_poc;

import java.io.File;
import java.io.IOException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class UploadPdfS3 {

	public static void main(String[] args) throws IOException {

		String bucketName = "pwcrhi";
		String stringObjKeyName = "stringTest";
		String fileObjKeyName = "fileTest";
		String fileName = "C:\\Users\\Lenovo\\Downloads\\image.png";

		try {
			BasicSessionCredentials basicSessionCredentials = new BasicSessionCredentials("ASIAUHYZ4RKDJSWYH3YC",
					"vyu3j/ImHUIoA/gNjU3muN9r2EUusmwlGYOtpLmo",
					"AgoGb3JpZ2luEG4aCXVzLWVhc3QtMSKAAmk6554zf9TF7yuSEX9WtprzKeU27t2u5gZG3URFE00GRd55L9EyN5Hwx8hRBG1H9bUksa4rDg6UHGkUgS8KurT3TEeTlHeWNIgUaSfrmHK9yQGW2gDRGlEwL9hLblgBSbF+5ew22KpPZCSL2/tAjKnmJCxeF+mmpMqkXGwcsaEEpgoke14qR+vnAAEY5p/gv9+T7nUx01ViNI/YQ+dCi1UTk9vDytpWhq114Gn7iMPiFSeQ3ybxBVTzzeyjbGMF/Tbbr2a63NdEjADEscigRtEk+QFsxBQBsaro9yk8lRJxGqLBQS2Q3tD/ie8uUP9mpflNvHy60Yoco1Bl1vyWVE8qzQQIo///////////ARAAGgwyOTE1NzUyMDQ0ODYiDIG8vVD7qJkeR05VryqhBCvfjZvP147o7R9lcF9Q1T2JaEDvXtVhuFE6m4Ol90j5ZfiqVNV8TbayxPDL5P75uDXTQ67sB6tqeaTogQniyGyGo8WxnGe8jXnDnhDhTljfuXx43Dq1hADi7HtNIMtmSpHarQedT7Y2SdAi3a6AFSQuDFn2P4QYanmOoqv9UGrobQOJqc4H4uCNxBckFsMqHTe5QPm/5CBpb3QohnJSYHSttZfEPsAbnd9Q/0i7UvQf35sAN5GlcOArJ/R1XbfT23KqjsX/M8zSLN4vvcDEDshKaeLGQrXcFJ7qNupqmZ4avPTI07+zvvnJop0E23uMpBQa9XzB7gHQ2h7qpgiX/mXR2AQG923rOBjKbgehHMBk3tlrMqEEIalplus0jwmKOKLH4FfJnCoSA7FpQIET+QSuidDmW79ZDQ+yv6epqdmNp3csrkihy3sr1V/LH3Ar6GDfcuJA21YLXm4GtnmnPQ0bskDMzkGaUJbJZ6Kbrq3DI0b8iwNzVNC761PCcP97XkQIQlfplDefQQbsmvBY+xk3/DFwLg/EOuLS0Oi6kz59bJza4sLiAjTixTNWv9nXaeLdACivWldrlBuwnDBrjXYc+wCmB+i90ssW7csOWqBEJqY4Q2x70dsL3TMw25VTmz7wgbYu8oJFNeB6EzCvh2kCvEbhVwDPQGxk9ww7g3yfr5zq7BYhwJPpcQ4jgs1Fv8bFjEePhHcP6aN8E1B7JBUMMN7pot0F");
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(basicSessionCredentials)).withRegion(Regions.US_EAST_1)
					.build();
			
			// Upload a text string as a new object.
			s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

			// Upload a file as a new object with ContentType and title specified.
			PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType("plain/text");
			metadata.addUserMetadata("x-amz-meta-title", "someTitle");
			request.setMetadata(metadata);
			s3Client.putObject(request);
		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process
			// it, so it returned an error response.
			e.printStackTrace();
		} catch (SdkClientException e) {
			// Amazon S3 couldn't be contacted for a response, or the client
			// couldn't parse the response from Amazon S3.
			e.printStackTrace();
		}
	}
}