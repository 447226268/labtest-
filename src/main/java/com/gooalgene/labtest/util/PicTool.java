package com.gooalgene.labtest.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class PicTool {
    public static String uploadFiles(MultipartFile file) {
        //文件上传
        if (!file.isEmpty()) {
            try {
//        图片命名
                String newCompanyImageName = file.getOriginalFilename();
                String ss[] = newCompanyImageName.split("\\.");
                String newPicName = UUID.randomUUID() + "." + ss[ss.length - 1];
                String localPath1 = "/pro/a/";
                String dir = System.getProperty("user.dir");
                String localPath = "\\src\\main\\resources\\static\\pro\\a\\";
                System.out.println(dir);
                System.out.println(dir + localPath + newPicName);
                File newFile = new File(dir + localPath + newPicName);

                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                System.out.print(localPath + newPicName);
                out.flush();
                out.close();
                return localPath1 + newPicName;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "";
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }
}