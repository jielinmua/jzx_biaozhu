package com.ruoyi.biaozhu.utils;

import io.minio.*;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MinioUtils {
    /**
     * minio地址
     */
    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * minio key
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * minio secret
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * bucket 桶
     */
    @Value("${minio.bucketName}")
    private String bucket;

    @Value("${minio.url}")
    private String url;


    private final static String separator = "/";
    /**
     * @param path     文件路径
     * @param filename yyyy/MM/dd/filename.jpg
     * @return String
     */
    private String buildFilePath(String path, String filename) {
        StringBuilder stringBuilder = new StringBuilder(50);
        if (path != null && !path.isEmpty()) {
            stringBuilder.append(path).append(separator);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String todayString = simpleDateFormat.format(new Date());
        stringBuilder.append(todayString)
                .append(separator)
                .append(filename);
        return stringBuilder.toString();
    }


    /**
     * 上传文件，由 MinIO 自动推断文件类型
     *
     * @param prefix      文件前缀
     * @param filename    文件名
     * @param inputStream 文件流
     * @return 文件全路径
     */
    public String uploadFile(String prefix, String filename, InputStream inputStream) {
        String filePath = buildFilePath(prefix, filename);
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();
        try {
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object(filePath)
                    .bucket(bucket).stream(inputStream, inputStream.available(), -1)
                    .build();
            minioClient.putObject(putObjectArgs);
            return endpoint + separator + bucket + separator + filePath;
        } catch (Exception e) {
            throw new RuntimeException("Minio put file error.");
        }
    }


    private String buildFilePathFixed(String path, String filename) {
        StringBuilder stringBuilder = new StringBuilder(50);
        if (path != null && !path.isEmpty()) {
            stringBuilder.append(path).append(separator);
        }

        stringBuilder.append(filename);
        return stringBuilder.toString();
    }
    /**
     * 上传文件，由 MinIO 自动推断文件类型
     *
     * @param path      文件路径
     * @param filename    文件名
     * @param inputStream 文件流
     * @return 文件全路径
     */
    public String uploadFileFixed(String path, String filename, InputStream inputStream) throws Exception {
        String filePath = buildFilePathFixed(path, filename);
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();

        //判断桶存在不存在，不存在就创建一个
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        } else {
            System.out.println("Bucket "+bucket+" already exists.");
        }

        //上传文件
        try {
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object(filePath)
                    .bucket(bucket).stream(inputStream, inputStream.available(), -1)
                    .contentType(getFileContentType(filename))
                    .build();
            minioClient.putObject(putObjectArgs);
            return url + separator + bucket + separator + filePath;


//            //限时url路径
//            Map<String, String> headersMap = new HashMap<>();
//            headersMap.put("Content-Disposition", "inline");
//            String presignedObjectUrl = minioClient.getPresignedObjectUrl(
//                    GetPresignedObjectUrlArgs.builder()
//                            .method(Method.GET)
//                            .bucket(bucket)
//                            .object(filePath)
//                            .extraHeaders(headersMap)
//                            .build()
//            );
//            return presignedObjectUrl;
        } catch (Exception e) {
            throw new RuntimeException("Minio put file error.");
        }
    }



    /**
     * 监听上传文件，由 MinIO 自动推断文件类型
     *
     * @param path      文件路径
     * @param filename    文件名
     * @param inputStream 文件流
     * @return 文件全路径
     */
    public String uploadFileMonitorFixed(String path, String filename, InputStream inputStream) throws Exception {
        String filePath = buildFilePathFixed(path, filename);
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();

        //判断桶存在不存在，不存在就创建一个
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        } else {
            System.out.println("Bucket "+bucket+" already exists.");
        }

        //上传文件
        try {
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object(filePath)
                    .bucket(bucket).stream(inputStream, inputStream.available(), -1)
                    .contentType(getFileContentType(filename))
                    .build();
            ObjectWriteResponse objectWriteResponse = minioClient.putObject(putObjectArgs);

//            minioClient.
            return url + separator + bucket + separator + filePath;

        } catch (Exception e) {
            throw new RuntimeException("Minio put file error.");
        }
    }

    private static String getFileContentType(String fileName){
        String returnFileName = fileName.substring(fileName.lastIndexOf("."));
        if(returnFileName != null){
            if(returnFileName.equals(".jpeg") || returnFileName.equals(".png") || returnFileName.equals(".jpg")){
                return "image/jpeg";
            }else if(returnFileName.equals(".mp4")){
                return "video/mp4";
            }else if(returnFileName.equals(".html")){
                return "text/html";
            }else if(returnFileName.equals(".css")){
                return "text/css";
            }else if(returnFileName.equals(".js")){
                return "application/javascript";
            }else if(returnFileName.equals(".pdf")){
                return "application/pdf";
            }else{
                return "application/octet-stream";
            }
        }
        return null;
    }
    /**
     * 判断文件是否存在
     * @param path
     * @param filename
     * @return
     */
    public boolean fileExists(String path, String filename) {
        // 构建文件路径
        String filePath = buildFilePathFixed(path, filename);
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();
        try {
            // 使用 statObject 方法检查文件是否存在
            minioClient.statObject(
                    StatObjectArgs.builder()
                            .bucket(bucket)   // 指定存储桶
                            .object(filePath) // 指定文件路径
                            .build()
            );
            // 如果没有抛出异常，说明文件存在
            return true;
        } catch (Exception e) {
            // 如果抛出异常，则说明文件不存在
            return false;
        }
    }
    /**
     * 判断文件是否存在
     * @param path
     * @param filename
     * @return
     */
    /**
     * 根据对象路径从 MinIO 获取文件的 GetObjectResponse。
     */
    public GetObjectResponse getObjectResponse(String objectPath) throws Exception {
        // 构建获取对象参数
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();
        GetObjectArgs getObjectArgs = GetObjectArgs.builder()
                .bucket(bucket)
                .object(objectPath)
                .build();
        try {
            // 从 MinIO 获取文件的 GetObjectResponse
            return minioClient.getObject(getObjectArgs);
        } catch (MinioException | IOException e) {
            throw new Exception("Error getting object from MinIO: " + e.getMessage(), e);
        }
    }


    /**
     * 封装文件路径
     * @param path
     * @param filename
     * @return
     */
    public String getFilePath(String path, String filename) {
        String filePath = buildFilePathFixed(path, filename);
        return url + separator + bucket + separator + filePath;
    }


}
