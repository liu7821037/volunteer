package com.oss;

import java.io.File;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
  
/** 
 * 对OSS服务器进行上传删除等的处理 
* @ClassName: OSSManageUtil  
* @Description:   
 */  
public class OSSManageUtil {  
	
	
	private static OSSClient ossClient;
	
	public static OSSClient getOSSClient(OSSConfigure ossConfigure){
		if(ossClient == null){
			ossClient=new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret()); 
		}
		return ossClient;
	}
    /** 
     * 上传OSS服务器文件 
    * @Title: uploadFile  
    * @Description:  
    * @param @param ossConfigure 
    * @param @param file 
    * @param @param remotePath 
    * @param @return 
    * @param @throws Exception    设定文件  
    * @return String    返回类型  
    * @throws 
     */  
    public static String uploadFile(OSSConfigure ossConfigure,MultipartFile file,String remotePath) throws Exception{  
        InputStream fileContent=null;  
        fileContent=file.getInputStream();  
        
        remotePath = remotePath.trim();  
        File tempFile =new File(remotePath);  
        String fileName =tempFile.getName();
//        OSSClient ossClient=new OSSClient(ossConfigure.getEndpoint(), ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());
        OSSClient ossClient = OSSManageUtil.getOSSClient(ossConfigure);
        
        remotePath = ossConfigure.getDir() + remotePath;
        
        String remoteFilePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/");  
         
        //创建上传Object的Metadata  
        ObjectMetadata objectMetadata=new ObjectMetadata();  
        objectMetadata.setContentLength(fileContent.available());  
        objectMetadata.setCacheControl("no-cache");  
        objectMetadata.setHeader("Pragma", "no-cache");  
        objectMetadata.setContentType(contentType(fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase()));  
        objectMetadata.setContentDisposition("inline;filename=" + fileName);  
        //上传文件  
        ossClient.putObject(ossConfigure.getBucketName(), remoteFilePath, fileContent, objectMetadata);  
        System.out.println(ossConfigure.getAccessUrl()+"/" +remoteFilePath);  
        return ossConfigure.getAccessUrl()+"/" +remoteFilePath;  
    }  
      
      
    /** 
     * 根据key删除OSS服务器上的文件 
    * @Title: deleteFile  
    * @Description:  
    * @param @param ossConfigure 
    * @param @param filePath    设定文件  
    * @return void    返回类型  
    * @throws 
     */  
    public static void deleteFile(OSSConfigure ossConfigure,String filePath){  
        OSSClient ossClient = new OSSClient(ossConfigure.getEndpoint(),ossConfigure.getAccessKeyId(), ossConfigure.getAccessKeySecret());  
        ossClient.deleteObject(ossConfigure.getBucketName(), filePath);  
          
    }  
      
     /** 
     * Description: 判断OSS服务文件上传时文件的contentType 
     * @Version1.0 
     * @param FilenameExtension 文件后缀 
     * @return String  
     */  
     public static String contentType(String FilenameExtension){  
        if(FilenameExtension.equals("BMP")||FilenameExtension.equals("bmp")){return "image/bmp";}  
        if(FilenameExtension.equals("GIF")||FilenameExtension.equals("gif")){return "image/gif";}  
        if(FilenameExtension.equals("JPEG")||FilenameExtension.equals("jpeg")||  
           FilenameExtension.equals("JPG")||FilenameExtension.equals("jpg")||     
           FilenameExtension.equals("PNG")||FilenameExtension.equals("png")){return "image/jpeg";}  
        if(FilenameExtension.equals("HTML")||FilenameExtension.equals("html")){return "text/html";}  
        if(FilenameExtension.equals("TXT")||FilenameExtension.equals("txt")){return "text/plain";}  
        if(FilenameExtension.equals("VSD")||FilenameExtension.equals("vsd")){return "application/vnd.visio";}  
        if(FilenameExtension.equals("PPTX")||FilenameExtension.equals("pptx")||  
            FilenameExtension.equals("PPT")||FilenameExtension.equals("ppt")){return "application/vnd.ms-powerpoint";}  
        if(FilenameExtension.equals("DOCX")||FilenameExtension.equals("docx")||  
            FilenameExtension.equals("DOC")||FilenameExtension.equals("doc")){return "application/msword";}  
        if(FilenameExtension.equals("XML")||FilenameExtension.equals("xml")){return "text/xml";}  
        return "text/html";  
     }  
}  