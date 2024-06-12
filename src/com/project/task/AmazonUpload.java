package com.project.task;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class AmazonUpload {

	private static final String SUFFIX = "/";
	
	private static String accessKey = "AKIAVRUVQG7B3BCXCXMN";
    private static String secretKey = "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";
    private static String region = "us-east-1";

    private static BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

	public static void uploadons3bucket(String bucketName, String filePath, String fileName) {

		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();

		s3Client.putObject(new PutObjectRequest(bucketName, fileName, new File(filePath))
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, 
				folderName + SUFFIX, emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}

	public static void deleteFileFromBucket(String bucketName, String keyName) {
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
		s3Client.deleteObject(new DeleteObjectRequest(bucketName, keyName));
	}

	public static void downloadFileFromS3(String filePathtobeStored, String bucketName, String key) {

		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
		// This is where the downloaded file will be saved
		File localFile = new File(filePathtobeStored);
		// This returns an ObjectMetadata file but you don't have to use this mandatory
		s3Client.getObject(new GetObjectRequest(bucketName, key), localFile);
	}
}
