package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import domain.Guitar;
import domain.GuitarSpec;
import domain.Inventory;
import service.GuitarService;


public class searchAction extends ActionSupport {
		private GuitarService guitarService;
		private String model;
		private String type;
		private String backWood;
		private String topWood;
		private String builder;
		private InputStream inputStream;
		

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getBackWood() {
			return backWood;
		}

		public void setBackWood(String backWood) {
			this.backWood = backWood;
		}

		public String getTopWood() {
			return topWood;
		}

		public void setTopWood(String topWood) {
			this.topWood = topWood;
		}

		public String getBuilder() {
			return builder;
		}

		public void setBuilder(String builder) {
			this.builder = builder;
		}

		public void setGuitarService(GuitarService guitarService) {
			this.guitarService = guitarService;
		}
		
		public InputStream getResult()
		{
			return inputStream;
		}

		public String search() throws Exception{
			HttpServletResponse response=ServletActionContext.getResponse();  
	        response.setContentType("text/html");
	        response.setContentType("text/plain; charset=utf-8");
//	        Inventory inventroy = new Inventory();
//	        List<Guitar> guitarList = guitarService.getAll();
//	        inventroy.setGuitars(guitarList);
//	        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood);
//	        List<Guitar> guitarList2 =  inventroy.search(guitarSpec);
//	        JSONArray jsonArray = new JSONArray();
//			for(Guitar guitar : guitarList2){
//				JSONObject jo = new JSONObject();
//				jo.put("price", guitar.getPrice());
//				jo.put("serialNumber", guitar.getSerialNumber());
//				jo.put("backWood", guitar.getGuitarSpec().getBackWood());
//				jo.put("builder", guitar.getGuitarSpec().getBuilder());
//				jo.put("model", guitar.getGuitarSpec().getModel());
//				jo.put("topWood", guitar.getGuitarSpec().getTopWood());
//				jo.put("type", guitar.getGuitarSpec().getType());
//				jsonArray.put(jo);
//			}
	        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood);
	        JSONArray jsonArray = guitarService.search(guitarSpec);
			inputStream =new ByteArrayInputStream(jsonArray.toString()
					.getBytes("UTF-8"));
			return SUCCESS;
		}

		
		
}
