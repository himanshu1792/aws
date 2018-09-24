package aws_poc;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/**
 * Simple implementation of AWSCredentialsProvider that just wraps static AWSCredentials.
 */
public class AWSStaticCredentialsProvider implements AWSCredentialsProvider {

    private final AWSCredentials credentials;

    public AWSStaticCredentialsProvider(AWSCredentials credentials) {
        this.credentials = credentials;
    }

    public AWSCredentials getCredentials() {
        return credentials;
    }

    public void refresh() {
    }

}