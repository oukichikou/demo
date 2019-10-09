package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import entity.Type;
import service.TypeService;
import utils.ReturnInfo;
import utils.ReturnJson;

@Controller
@Scope(scopeName = "session")
public class Test {
	@Autowired
	TypeService service;
	
	
	List<Type> list = new ArrayList<Type>();

	@RequestMapping("Test/list")
	@ResponseBody
	public ReturnInfo list() {
		return   new ReturnInfo( list);
	}
	
	@RequestMapping("Test/save")
	@ResponseBody
	public ReturnJson save(String ids) {
		for(int i=0;i<list.size();i++) {
			String id=","+list.get(i).getId()+",";
			if(ids.indexOf(id)<0)  continue;
			service.insert(list.get(i));
			list.get(i).setUploadstatus(1);
		}
		return   new ReturnJson(1);
	}

	@RequestMapping("upload")
	@ResponseBody
	public ReturnJson upload(@RequestParam("file") MultipartFile file) {
		list = new Vector<Type>();

		try {
			InputStream input = file.getInputStream();

			Workbook wb = new HSSFWorkbook(input);

			Sheet sheet = wb.getSheetAt(0);

			int rowNum = sheet.getLastRowNum() + 1;

			for (int i = 1; i < rowNum; i++) {
				Type t = new Type();
				Row row = sheet.getRow(i);

				// ÈÝÆ÷Ãû³Æ
				Cell containerCell = row.getCell(0);
				String val = containerCell.getStringCellValue();
				t.setName(val);
				t.setId(i-1);
				list.add(t);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return  new ReturnJson(1);
	}

}
