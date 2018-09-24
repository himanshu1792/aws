package aws_poc;

import java.io.File;
import java.io.IOException;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class DownloadPdfS3 {
	
	public static void main(String[] args) throws IOException {
		
		String bucketName = "pwcrhi";
		String fileObjKeyName = "fileTest";
		String fileName = "C:\\notes\\aws\\s3\\image.png";

		try {
			BasicSessionCredentials basicSessionCredentials = new BasicSessionCredentials("ASIAUHYZ4RKDKSBKD5V6",
					"zzoV0OWd03yKDsASAFz4ontiv5OX3h9KM5N/FBp1",
					"AgoGb3JpZ2luEG8aCXVzLWVhc3QtMSKAAjNKvv+ryAh618rxT+oCc6khvUHFDlmnibuXJ8DLqMGnL39eqNjNnt744ByCGa4xumn8k/DCl0/6Ykg51m4agXwT6vFtNZtiLa6xfXYIv5dvHU5RjNGBvnRD2+0Phs0HFT39WCK7IWhadOt+KIw4nfB3KGCfOJDjK+aWzIAc+cHrPB1hM9xIw1YbOz20m45Pg6SWmBM3p8SnqEyEdS6h+uTTDO7dD5bPRXZBOwEzXJSsy6A30eZMiBFts5vYmBfua0IL0iQaueAnxV+fTgXJ+DaRpxph7XUEQAjqme60DS8wO+vUH4eqJKujK92pyUSrwImfpW2cWrSl1TTXThVf5P0qzQQIpP//////////ARAAGgwyOTE1NzUyMDQ0ODYiDPwMkwLF6VLGY0PylyqhBM6onpNyydej+BZMRedtzE3E/VPsziEfcsmkoetqFW0RGH8Gnji2ZYQibjD/MKpG3hhOmBG2R6GOgJ62VU7/wIao2VlKgB43yU4uSNogtaczG8esE2AH7u6DduDSPcMbKUOKrxBmdlGhJyhvjbsXr3wPYEaXiI2XlpPcBn6qq7XwCop+sfqqM37T0uWe+Qw5jyKgjaTbqRpYAp4Pjse26SnXxVnr/MQFsvc2ij3dGFC3b9rPQKOdPuVc8hmb0+uDwcMWrQIDHYKcQlBF7jJwhtAsdQ0OlTVIykK3eJWuGnwDWbOQeHYdOKF7Vk7FDlRcG3RbVUllIPCz/UgmLJJ2+6EViRrEvHerW5JaxKSPOeCR+7vNQCxKaVfAJ0Yb8QeWab4kZ8i3mbl67o9zr1sQ8IMNBfjfyhQZKoRpUu1iYObfNIBJMbMmSIt5jHGuWdAu4+xUxCA6iG6jMslHbA0oasTln3Z4G9R0+vC3USL1kp45bvAp9+0IksgxSXTbhaguhwaOlBT/SmzdROu+pPEEfwXlDntjnfbPlq2xsKUiXpzYjfmDLVGWnmTxqOkUNoCmmG7/VqMlEu1PCZoPgsiQzWL+7LFGwkFSlXOMXIeX26Hprqo0i85yG/+CXeAwOfASl1gH7//yuZ9a1TGlOftvzDyvRLYcFtcGkwE2u53KCcq5JQtqch2QrX3M9hMUtytPnkr6wnwK7ftWOwaBWZGHUOb2MPyHo90F");
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(basicSessionCredentials)).withRegion(Regions.US_EAST_1)
					.build();
			//This is where the downloaded file will be saved
			File localFile = new File(fileName);
			
			//This returns an ObjectMetadata file but you don't have to use this if you don't want 
			if(s3Client.doesBucketExistV2(bucketName))
			   s3Client.getObject(new GetObjectRequest(bucketName, fileObjKeyName), localFile);
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
