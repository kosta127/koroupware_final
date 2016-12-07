package com.koroupware.doc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koroupware.common.util.MediaUtils;
import com.koroupware.common.util.UploadFileUtils;


@Controller
public class UploadController {
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value="/uploadForm",method=RequestMethod.GET)
	public void uploadForm(){
		
	}
	
	@RequestMapping(value="/uploadForm",method=RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model) throws Exception{
		String saveName = uploadFile(file.getOriginalFilename(), file.getBytes());
		model.addAttribute("saveName",saveName);
		
		return "uploadResult";
	}
	
	private String uploadFile(String originalName,byte[] fileData) throws Exception
	{
		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath,saveName);
		FileCopyUtils.copy(fileData, target);
		return saveName;
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax(){}
	
	
	@ResponseBody
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST,
					produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),HttpStatus.CREATED);
	}
	
	/*@ResponseBody
	@RequestMapping("displayFile")
	public ResponseEntity<byte[]> displayFile(String filename) throws Exception{
		ResponseEntity<byte[]> entity = null;
		
		return entity;
	}*/
	 @ResponseBody
	  @RequestMapping("/displayFile")
	  public ResponseEntity<byte[]>  displayFile(@RequestParam("fileName") String fileName)throws Exception{
	    
	    InputStream in = null; 
	    ResponseEntity<byte[]> entity = null;
	    
	    //logger.info("FILE NAME: " + fileName);
	    
	    try{
	      
	      String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	      
	      MediaType mType = MediaUtils.getMediaType(formatName);	
	      
	      HttpHeaders headers = new HttpHeaders();
	      
	      in = new FileInputStream(uploadPath+ "\\"+ fileName);
	      
	      if(mType != null){	//이미지 파일인 경우
	        headers.setContentType(mType);
	      }else{	//이미지 파일이 아닌 경우
	        
	        fileName = fileName.substring(fileName.indexOf("_")+1);       
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition", "attachment; filename=\""+ 
	          new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	      }

	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), 
	          headers, 
	          HttpStatus.CREATED);
	    }catch(Exception e){
	      e.printStackTrace();
	      entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally{
	      if(in != null) in.close();
	    }
	      return entity;    
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/deleteFile",method=RequestMethod.POST)
	  public ResponseEntity<String> deleteFile(String fileName){
		 String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		    
		    MediaType mType = MediaUtils.getMediaType(formatName);
		    
		    if(mType != null){      
		      
		      String front = fileName.substring(0,12);
		      String end = fileName.substring(14);
		      
		      System.out.println(front + " : " + end);
		      new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
		    }
		    
		    new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		    
		    return new ResponseEntity<String>("deleted", HttpStatus.OK);
	  }
	  
	  @ResponseBody
	  	@RequestMapping(value="/deleteAllFiles",method=RequestMethod.POST)
	  	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files){
		  if(files == null || files.length == 0) {
			  return new ResponseEntity<String>("deleted",HttpStatus.OK);
		  }
		  for(String fileName : files) {
			  String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			  MediaType mType = MediaUtils.getMediaType(formatName);
			  if(mType != null){
				  String front = fileName.substring(0, 12);
				  String end = fileName.substring(14);
				  new File(uploadPath+(front+end).replace('/', File.separatorChar)).delete();
			  }
			   new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		  }
		  return new ResponseEntity<String>("deleted", HttpStatus.OK);
	  }

	
}
