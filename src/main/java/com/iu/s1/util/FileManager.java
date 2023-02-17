package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
   
   //File�� HDD�� ����
   public String fileSave(MultipartFile multipartFile, String path) throws Exception {
      //1. ��� ������ ���ΰ�?
      //      /resources/upload/bankbook/...
      //2. ���� ������ � ü���� ���
      
      //������ ������ ������ ������ �ִ� �ڹ� ��ü�� ����
      File file = new File(path);
      //������ �������� ������ ���� ����
      if(!file.exists()) {
         file.mkdirs();
      }
      
      //3. �ߺ����� �ʴ� ���ϸ� ����
      //Calendar calendar = Calendar.getInstance();
      //calendar.getTimeInMillis();
      String name = UUID.randomUUID().toString();

      //4. Ȯ���� �߰�
      //OriginalName���� subString�� �̿��ؼ� Ȯ���ڸ� ����
      name = name + "_" + multipartFile.getOriginalFilename();

      //5. ���� ����
      file = new File(file, name);
      
      //   1) multipartFile ��ü�� transferTo() ���
      //multipartFile.transferTo(file);
      //   2) Spring API FileCopyUtils ��ü�� copy() ���
      FileCopyUtils.copy(multipartFile.getBytes(), file);
      
      return name;
   }

}
