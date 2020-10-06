package com.hfy.flyhotel.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("image")MultipartFile file, HttpServletRequest request) throws IOException {
        //文件保存路径，默认为根目录下
        String Path = "src/main/resources/static/images/";
        String fileName =  file.getOriginalFilename();
        String filePath = Path + fileName;
        String fileURL = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + "/"
                + Path.substring(Path.lastIndexOf('i')) + fileName ;
        System.out.println(fileURL);
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            return fileURL;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }
}
