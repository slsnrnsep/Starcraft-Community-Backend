package com.mini.miniproject.controller;

import com.mini.miniproject.dbSet.SetTestDb;
import com.mini.miniproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Controller
public class HomeController {
    //★LSJ★//
    //★이컨트롤러는 리액트랑 연동되면★//
    //★안쓰일 컨트롤러임★//
    //★그냥 Test용 Controller★//
    private final SetTestDb  setTestDb;
    private Boolean a = true;
    @GetMapping("/")
    public String test()
    {
        return "index.html";
    }

    @GetMapping("/test")
    public String test2(@AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        return "index.html";
    }

    @GetMapping("/dbSet")
    public String test33()
    {
        if (a) {
            a = false;
            setTestDb.dbset();
        }
        return "index.html";
    }

    @GetMapping("/dbSet2")
    public String test343()
    {
        setTestDb.commentSet();
        return "index.html";
    }

//    @GetMapping("display")
//    public ResponseEntity<Resource> display(
//            @Param("filename") String filename
//            )
//    {
//        String path = "C:\\git\\week04\\Starcraft-Community-Backend\\miniproject\\src\\main\\resources\\image";
//        FileSystemResource resource = new FileSystemResource(path + filename);
//        if(!resource.exists())
//        {
//            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
//        }
//        HttpHeaders header = new HttpHeaders();
//        Path filePath = null;
//        try{
//            filePath = Paths.get(path+filename);
//            header.add("content-type", Files.probeContentType(filePath));
//        }
//        catch(IOException e)
//        {
//            return null;
//        }
//        return new ResponseEntity<Resource> (resource,header,HttpStatus.OK);
//
//    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/display/{file}")
    public ResponseEntity<org.springframework.core.io.Resource> display(
            @PathVariable String file
    ) {
        String path = System.getProperty("user.dir")+"/images/"+file; // 이경로는 우분투랑 윈도우랑 다르니까 주의해야댐 우분투 : / 윈도우 \\ 인것같음.
        String folder = "";
        org.springframework.core.io.Resource resource = new FileSystemResource(path);
        if (!resource.exists())
            return new ResponseEntity<org.springframework.core.io.Resource>(HttpStatus.NOT_FOUND);
        HttpHeaders header = new HttpHeaders();
        Path filePath = null;
        try {
            filePath = Paths.get(path);
            header.add("Content-Type", Files.probeContentType(filePath));
        } catch (IOException e) {
            return null;
        }
        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }
}
