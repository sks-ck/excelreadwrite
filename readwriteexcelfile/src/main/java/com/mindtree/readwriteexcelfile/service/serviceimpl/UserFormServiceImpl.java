package com.mindtree.readwriteexcelfile.service.serviceimpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.readwriteexcelfile.entity.UserForm;
import com.mindtree.readwriteexcelfile.repository.UserFormRepository;
import com.mindtree.readwriteexcelfile.service.UserFormService;

@Service
public class UserFormServiceImpl implements UserFormService {

	@Autowired
	UserFormRepository repository;

	@Override
	public void insertFormToDB(UserForm userForm) {

		 repository.save(userForm);
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
          
        Row headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("ID");
    	headRow.createCell(1).setCellValue("NAME");
    	headRow.createCell(2).setCellValue("DESIGNATION");
    	headRow.createCell(3).setCellValue("MOBILE");
    	headRow.createCell(4).setCellValue("EMAIL");
    	headRow.createCell(5).setCellValue("GENDER");
        
        int rowNum=1;
        for(UserForm user:repository.findAll()) {
        	Row row = sheet.createRow(rowNum++);
        	row.createCell(0).setCellValue(user.getUserId());
        	row.createCell(1).setCellValue(user.getUserName());
        	row.createCell(2).setCellValue(user.getDesignation());
        	row.createCell(3).setCellValue(user.getMobile());
        	row.createCell(4).setCellValue(user.getEmail());
        	row.createCell(5).setCellValue(user.getGender());
        	
        }
        
        try
      {
          //Write the workbook in file system
          FileOutputStream out = new FileOutputStream("employee.xlsx");
          workbook.write(out);
          out.close();
          System.out.println("employee.xlsx written successfully on disk.");
      } 
      catch (Exception e) 
      {
          e.printStackTrace();
      }
       
        
    }

	@Override
	public List<UserForm> readFromFile() {
		FileInputStream f = null;
		try {
			f = new FileInputStream("employee.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<UserForm>  users = new ArrayList<UserForm>();
	       //	Workbook workbookWrite = WorkbookFactory.create(new File("employee.xlsx"));
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Workbook has : "+workbook.getNumberOfSheets()+" sheets.");
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			int count = 0;
			
				for(Row row : sheet) {
					if(count>0) {
				UserForm user = new UserForm();
				user.setUserId((int) row.getCell(0).getNumericCellValue());
				user.setUserName(row.getCell(1).getStringCellValue());
				user.setDesignation(row.getCell(2).getStringCellValue());
				user.setMobile((long) row.getCell(3).getNumericCellValue());
				user.setEmail(row.getCell(4).getStringCellValue());
				user.setGender(row.getCell(5).getStringCellValue());
				users.add(user);
					}
					count++;
			}
				return users;
	}

		
	}

