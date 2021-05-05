package com.lihal.demo.util;

import java.io.File;
import java.net.URL;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Bucket {

	AmazonS3 client;
	private AWSCredentials credentials = new BasicAWSCredentials("userAccess", "SecuirtyKey");
	public String bucketName;
	public static void main(String[] args) {
		new S3Bucket().start();
	}
	
	void start() {
		readAllBuckets();
		uploadObject();
//		getAllObjects();
	}
	
	public   AmazonS3 clientBuilder() {
		 client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		System.out.println(client);
		return client;
	}
	
	void getConnection() {
		client =  clientBuilder();
		if(client == null) {
			System.out.println("Failed to provide Client");
		}else {
			System.out.println("Client created successfully");
		}
	}
	
	public void readAllBuckets() {
		
		if(client == null)
			clientBuilder();
		
		List<Bucket> buckets = client.listBuckets();
		if(buckets != null && buckets.size() > 0) {
			System.out.println(buckets.get(0).getName());
			bucketName = buckets.get(0).getName();
			System.out.println(buckets.get(0).getName()+ " BN "+bucketName);
		}else {
			System.out.println("No Buckets Found");
		}
		
		
	}
	
	void uploadObject() {
		try {
			//BucketName, File Name alias into bucket, Local file location
			if(client != null) {
				client.putObject("lihal", "Apple_Air_Tag", new File("C:\\Users\\Public\\Pictures\\lihal.txt"));
			}else {
				getConnection();
				uploadObject();
			}
		}catch(AmazonServiceException e){
			e.printStackTrace();
		}catch(SdkClientException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void getAllObjects() {
		if(client != null) {
			ObjectListing listing = client.listObjects("nersuko");
			for(S3ObjectSummary obj: listing.getObjectSummaries()) {
			    System.out.println(obj.getKey());
			}
			 URL url2 = client.generatePresignedUrl(new GeneratePresignedUrlRequest("nersuko/nersuko_estate", "Hulu Logo"));
			 System.out.println(""+url2);
		}else {
			getConnection();
			getAllObjects();
		}
	

	}
}
