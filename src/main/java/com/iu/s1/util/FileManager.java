package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
   
   //File을 HDD에 저장
   public String fileSave(MultipartFile multipartFile, String path) throws Exception {
      //1. 어디에 저장할 것인가?
      //      /resources/upload/bankbook/...
      //2. 저장관리는 운영체제가 담당
      
      // 저장할 폴더의 정보를 가지고 있는 자바 객체 선언
      File file = new File(path);
      //폴더가 존재 하지 않으면 폴더 만들기
      if(!file.exists()) {
         file.mkdirs();
      }
      
      //3. 중복되지 않는 파일명 생성
      //Calendar calendar = Calendar.getInstance();
      //calendar.getTimeInMillis();
      String name = UUID.randomUUID().toString();

      //4. 확장자 추가
      //OriginalName에서 subString을 이용해서 확장자를 추출
      name = name + "_" + multipartFile.getOriginalFilename();

      //5. 파일 저장
      file = new File(file, name);
      
      //   1) multipartFile 객체의 transferTo() 사용
      //multipartFile.transferTo(file);
      //   2) Spring API FileCopyUtils 객체의 copy() 사용
      FileCopyUtils.copy(multipartFile.getBytes(), file);
      
      return name;
   }

}
