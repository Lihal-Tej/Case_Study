package com.testlabs.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.mysql.cj.xdevapi.Client;
import com.testlabs.dao.Dao;
import com.testlabs.model.CandidateMaster;
import com.testlabs.model.ClientMaster;
import com.testlabs.model.Product;
import com.testlabs.model.Resume;
import com.testlabs.model.SkillMaster;
import com.testlabs.model.User;

@Controller
@SessionAttributes("user")
public class MainControllers {
	
	@Autowired
	Dao dao;
	
	@RequestMapping(value="/Candidate",method =RequestMethod.POST)
	@ResponseBody
	public String candidateData( @ModelAttribute("user") User user,@RequestParam String data) {
		
		String result ="";
		try {
			System.out.println(data);
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			CandidateMaster candidateMaster = gson.fromJson(data,CandidateMaster.class);
			System.out.println(candidateMaster);
			MultipartFile file = candidateMaster.getFileModel();
				
		
			result = dao.newCandidate(candidateMaster,candidateMaster.getSkill()); 
			//String res =dao.candSkills(candidateMaster.getSkill(), user.getUser_id());
			System.out.println("Candidate Id :"+result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping(value="/Client",method= RequestMethod.POST)
	@ResponseBody
	public String clientData(String data) {
		
		String result = "";
		try {
			System.out.println(data);
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			ClientMaster clientMaster = gson.fromJson(data, ClientMaster.class);
			result = dao.newClient(clientMaster);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping(value="/Skills",method= RequestMethod.GET)
	@ResponseBody
	public String skill() {
		
		String result ="";
		
		try {
			
			List<SkillMaster> skills = new ArrayList<SkillMaster>();
			skills = dao.getSkills();
			Gson gson = new Gson();
			result = gson.toJson(skills);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/searchClient",method= RequestMethod.GET)
	@ResponseBody
	public String searchClinet(String clientName,String skill,String experiance) {
		
		String result = "";
		
		try {
			
			List<ClientMaster> clientList = new ArrayList<>();
			
			clientList = dao.searchClients(clientName, skill, experiance);
			
			Gson gson = new Gson();
			
			result =gson.toJson(clientList);
			
			System.out.println(result);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	@RequestMapping(value="/updateClient",method= RequestMethod.POST)
	@ResponseBody
	public String updateClientDetails(@RequestParam String data) {
		
		String result = "";
		
		try {
			
			System.out.println(data);
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			ClientMaster clientMaster = gson.fromJson(data, ClientMaster.class);
			result = dao.UpdateClient(clientMaster);
			
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/searchCandidte",method= RequestMethod.GET)
	@ResponseBody
	public String searchCandidate(String candidateName,String candidateLocation,String skillId){
		
		String result  = "";
		
		try {
			List<CandidateMaster> candidateList = new ArrayList<>();
		candidateList = dao.candidateSearch(candidateName, candidateLocation, skillId);
		Gson gson = new Gson();
		result = gson.toJson(candidateList);
		
		System.out.println(result);
		if(result == null) {
			result = "";
		}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
		
		
		
	}
	
	@RequestMapping(value="/updateCandidte",method= RequestMethod.POST)
	@ResponseBody
	public String updateCandidate(String data) {
		
		String result = "";
		
		try {
			
			Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
			CandidateMaster candidateMaster = new CandidateMaster();
			candidateMaster = gson.fromJson(data, CandidateMaster.class);
			System.out.println(candidateMaster);
			
			result  = dao.updateCandidate(candidateMaster);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	@RequestMapping(value="/uploadResume",method= RequestMethod.POST)
	@ResponseBody
	public ModelAndView uploadResume(HttpServletRequest servletRequest,@ModelAttribute Resume resume,Model model) {
		
		String result = "Failed to upload resume , Please try again";
		ModelAndView modelAndView = new ModelAndView(result);
		
		try {
			
			System.out.println("222");
			
			MultipartFile file =  resume.getFile();
			if(file != null) {
			
				System.out.println("227");
				String fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				Blob blob = new SerialBlob(bytes);
				String fileType  = file.getContentType();
				
				 result = dao.uploadResume(fileName, blob, fileType, resume.getCandidateId());
				System.out.println(result);
				if(result.equalsIgnoreCase("Success")) {
					modelAndView = new ModelAndView("home");
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
		
	}
	
	
	
	@RequestMapping(value ="/save-product",method =RequestMethod.POST)
	@ResponseBody
    public String uploadResources( HttpServletRequest servletRequest,
                                 @ModelAttribute
                                 Product product,
                                 Model model)
    {
        //Get the uploaded files and store them
        //List<MultipartFile> files = product.getImages();
		MultipartFile file = product.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != file)
        {
          
 
                String fileName = file.getOriginalFilename();
               // fileNames.add(fileName);
 
              //  File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                try
                {
                    //file.transferTo(imageFile);
                    
                 //   FileInputStream fileInput = new FileInputStream(imageFile);
                    
                    byte[] bytes =file.getBytes();
                    
                    
                    
                    
                    
                    try {
                    	String fileType  = file.getContentType();
						Blob  blob = new SerialBlob(bytes);
						
					
						//String result  = dao.uploadResume(fileName,blob,fileType);
						
						//System.out.println("Result : "+result);
						
					} catch (SerialException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
                    
                    //OutputBlob blobOutput = new OutputBlob(fileInput, imageFile.length());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            
        }
 
        // Here, you can save the product details in database
         
        model.addAttribute("product", product);
        return "viewProductDetail";
    }
	
	
	@RequestMapping(value ="/download",method =RequestMethod.GET)
	public void downlodResume(HttpServletRequest request,HttpServletResponse response,@RequestParam String resumeId) {
		
		File file = null;
		try {
//			String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
//	        Path file = Paths.get(dataDirectory, "test");
		 file= dao.getFile(resumeId);
		
		InputStream targetStream = new FileInputStream(file);
		  org.apache.commons.io.IOUtils.copy(targetStream, response.getOutputStream());
		  //response.setContentType("application/pdf");
	     // response.flushBuffer();
		
		  response.setContentType("application/txt");
		  response.setContentLength((int)file.length());
		  response.setHeader("Content-Disposition", "attachment; filename=\"\""); 
		  //response.flushBuffer();
		  
		  FileCopyUtils.copy(targetStream, response.getOutputStream());
		
//		if (Files.exists(file))
//        {
//            response.setContentType("application/pdf");
//            response.addHeader("Content-Disposition", "attachment; filename="+"test");
//            try
//            {
//            	// Uti.downloadFileProperties(request, response, "C:\\Work\\eclipse-workspace", file);
//            	Files.copy(file, response.getOutputStream());
//                response.getOutputStream().flush();
//            }
//            catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }else {
//        	Files.copy(file, response.getOutputStream());
//            response.getOutputStream().flush();
//        }
			
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@RequestMapping(value ="/newSkill",method =RequestMethod.POST)
	@ResponseBody
	public String newSkill(@RequestParam String skillName) {
		
		String result = "";
		try {
			
			result = dao.newSkill(skillName);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping(value="/impClients",method = RequestMethod.GET)
	@ResponseBody
	public String impClients() {
		
		String result ="";
		
		try {
			
			List<ClientMaster> clients = dao.getImpClient();
			
			Gson gson = new Gson();
			
			result = gson.toJson(clients);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
