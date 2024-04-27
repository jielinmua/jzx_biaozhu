package com.ruoyi.biaozhu.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileUploadUtils {


    //@Value("${ruoyi.url}")
    private String url="https://jzx.mindyard.cn/uploadPath";


    //@Value("${ruoyi.profile}")
    private String proFile="/home/chenpeng/workspace/system/jzx/uploadPath/";

    public String uploadImgUrl(MultipartFile file,String location,String phone){
        try {
            LocalDate now = LocalDate.now();
            String time = now.toString();
            String front = saveFile(file,location,phone,time);
            String[] fronts = front.split("uploadPath");
            return url+fronts[1];
        }catch (Exception e){
            return null;
        }

    }

    private String saveFile(MultipartFile file, String location, String userId, String time) {


        try {
            String f = file.getOriginalFilename();
            int dotIndex = f.lastIndexOf('.');
            String extension="";
            if (dotIndex > 0 && dotIndex < f.length() - 1) {
                extension = f.substring(dotIndex + 1).toLowerCase();
                // 这里假设你只关心 JPEG 和 PNG 图片格式，如果需要支持更多格式需要自行修改判断条件
                if (extension.equals("jpg") || extension.equals("jpeg")) {
                    extension = ".jpg";
                } else if (extension.equals("png")) {
                    extension = ".png";
                } else {
                    extension = "";
                }
            }
            // Generate a unique file name based on the current time
            String fileName = System.currentTimeMillis() + "-" + location;
//            String mainDir="E:/saveImg/";
            File dir = new File(proFile+userId+"/"+time+"/");
            if(!dir.exists()){
                boolean mkdirs = dir.mkdirs();
            }
            Path path = Paths.get( proFile+userId+"/"+time+"/" + "/" + fileName + extension);
            // Save the file to disk
            Files.write(path, file.getBytes());
            // Return the file path
            return path.toString();
        } catch (IOException e) {
          return null;
        }
    }

    public Boolean deleteFile(String img){
        String[] fronts = img.split("uploadPath");
        File file = new File(proFile+fronts[1]);
        return file.delete();
    }
    public  String uploadFileUrl(MultipartFile file){
        String front = saveFile(file);
        if(front==null){
            return null;
        }
        String[] fronts = front.split("uploadPath");
        return url+fronts[1];
    }
    public Map<String,String> mapUploadFileUrl(MultipartFile file){
        String front = saveFile(file);
        if(front==null){
            return null;
        }
        String[] fronts = front.split("uploadPath");
        Map<String,String> map = new HashMap<>();
        map.put("fileUrl",url+fronts[1]);
        map.put("fileName",fronts[1]);
        return map;
    }
    private String saveFile(MultipartFile file) {
        try {
            String extension=".mp4";
            String fileName = String.valueOf(System.currentTimeMillis());
            File dir = new File(proFile+"/");
            if(!dir.exists()){
                dir.mkdirs();
            }
            Path path = Paths.get( proFile+"/"+ fileName + extension);
            Files.write(path, file.getBytes());
            return path.toString();
        } catch (IOException e) {
            return null;
        }
    }

}
