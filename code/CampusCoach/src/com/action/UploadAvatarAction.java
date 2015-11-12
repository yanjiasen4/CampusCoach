package com.action;

import java.io.File;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Map;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.manager.LearnerManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sina.sae.storage.SaeStorage;
import com.sina.sae.util.SaeUserInfo;

public class UploadAvatarAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8677673256561492336L;
	
	private String uploadDir;   
	private LearnerManager learnerManager;
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	public LearnerManager getLearnerManager() {
		return learnerManager;
	}
	public void setLearnerManager(LearnerManager learnerManager) {
		this.learnerManager = learnerManager;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	public String execute() throws FileNotFoundException, IOException{
		ActionContext actionContext = ActionContext.getContext();
        Map<String,Object> session = actionContext.getSession();
        String username = (String) session.get("user");
        int learnerID = (Integer) session.get("id");
        SaeStorage ss = new SaeStorage();
        FileInputStream stream = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
        byte[] b = new byte[1000];
        for (int n;(n = stream.read(b)) != -1;) {
        	out.write(b, 0, n);
        }
        stream.close();
        out.close();
        String newFileName = username + "-avatar" + fileFileName.substring(fileFileName.indexOf('.'));
        ss.write("xiaoyuanjiaolian", "/photo"+newFileName, out.toByteArray());
        String filePath = ss.getUrl("xiaoyuanjiaolian", newFileName);
        learnerManager.updateAvatar(learnerID, filePath);
        session.put("avatar", filePath);
        
        
        //SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss"); 
        //java.util.Date date=new java.util.Date();  
        //String str=format.format(date); 
        //String newFileName = username + '-' + str +  fileFileName.substring(fileFileName.indexOf('.'));
		//String savePath = uploadFile(newFileName,learnerID);
		//learnerManager.updateAvatar(learnerID, path);
		//session.put("avatar", savePath); // ��ͷ��·������session���Ա��ϴ�ͷ���ˢ��ʱ����ͷ��
		return SUCCESS;
	}
	
	/*public String uploadFile(String newFileName, int learnerID) throws FileNotFoundException, IOException {
		String realPath = ServletActionContext.getServletContext().getRealPath("upload");
		File uploadFile = new File(realPath);
		//�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
		if (!uploadFile.exists() && !uploadFile.isDirectory()) {
			System.out.println(realPath+"Ŀ¼�����ڣ���Ҫ����");
			//����Ŀ¼
			uploadFile.mkdir();
		}
		String userStr = ((Integer)learnerID).toString();
		File userDir = new File(uploadFile.getPath()+'/'+userStr);
		if(!userDir.exists() && !userDir.isDirectory()) {
			System.out.println(uploadFile.getPath()+"�û�Ŀ¼�����ڣ���Ҫ����");
			userDir.mkdir();
		}
		String savePath = userDir + "/" + newFileName;
	    FileInputStream input = new FileInputStream(file);  
		FileOutputStream out = new FileOutputStream(savePath);  
		try {  
		    byte[] b =new byte[1024];  
		    int i = 0;  
		    while ((i=input.read(b))>0) {  
		        out.write(b, 0, i);  
		    }  
	    } catch (Exception e) {  
		    e.printStackTrace();  
		} finally {  
		    //�ر����롢�����  
		  input.close();  
		  out.close();  
		  //ɾ����ʱ�ļ�  
		  file.delete(); 
	    }   
		System.out.println("upload"+"/"+((Integer)learnerID).toString() + "/" + newFileName);
		return "upload"+"/"+((Integer)learnerID).toString() + "/" + newFileName; 
	}*/

}