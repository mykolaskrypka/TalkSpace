package com.challange.talkspace.AWS;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class S3Service {
//    private final AmazonS3 s3client;
//
//    public void createBucket() {
//        String bucketName = "buckettalk";
//
//        if (s3client.doesBucketExistV2(bucketName)) {
//            log.info("Bucket {} already exists, use a different name", bucketName);
//            return;
//        }
//
//        s3client.createBucket(bucketName);
//    }
//}
