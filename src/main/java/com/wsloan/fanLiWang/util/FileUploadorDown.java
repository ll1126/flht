package com.wsloan.fanLiWang.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadorDown {
	
     public static void fileUpload(MultipartFile file ,String filename,String path) throws IOException{
    	 
				InputStream in=file.getInputStream();//数据大
				//保存文件
				//将文件保存到upload文件夹中
				File path1=new File(path);
				path1.mkdir();
				File file2=new File(path1,filename);
				FileOutputStream out=new FileOutputStream(file2);
				int b;
				while((b=in.read())!=-1){
					out.write(b);
					out.flush();
				}
				in.close();
			    out.close();
			    
     }
}
