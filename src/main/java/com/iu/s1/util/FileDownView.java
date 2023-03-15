package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s1.board.BoardFileDTO;

@Component("fileDownView")
public class FileDownView extends AbstractView{
	
	//한개만 오버라이딩 하면 됨
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			System.out.println("FileDownView");
			
			BoardFileDTO boardFileDTO = (BoardFileDTO) model.get("boardFile");
//			System.out.println(boardFileDTO.getFileNum());
//			System.out.println(boardFileDTO.getFileName());
			
			Iterator<String> it =  model.keySet().iterator();
			
			//boardFile에 @ModelAttribute(boardName), 매개변수 앞에는 @ModelAttribute가 생략되어있기에 key로 꺼내짐
//			while(it.hasNext()) {
//				String key =  it.next();
//				System.out.println("Key : " + key);
//			}
			
			//Key : boardName, boardFile
			
			//경로 준비
			String path =(String) model.get("boardName");
			path = "resources/upload/" + path + "/";
			
			//String타입
			path =  request.getSession().getServletContext().getRealPath(path);
			
			
			File file = new File(path, boardFileDTO.getFileName());
			
			//응답 시 한글 Encoding 처리
			response.setCharacterEncoding("UTF-8");
			
			//응답 시 파일의 크기
			response.setContentLength((int)file.length());
			
			//다운 시 파일이름을 지정하고 한글일 수도 있기에 인코딩 설정
			String downName = boardFileDTO.getOriName();
			downName = URLEncoder.encode(downName, "UTF-8");
			
			//Header 정보 설정(클리어언트가 받을 때 어떤 파일을 받을 껀지 준비 해주는 과정)
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + downName +"\""  );
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			//전송(0과1로 바꾸기)
			//Stream -> 빨대 (읽을 준비)
			FileInputStream fi = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			
			//보내기
			FileCopyUtils.copy(fi, os);
			
			//자원 해제
			os.close();
			fi.close();
			
			
	}
	
}
