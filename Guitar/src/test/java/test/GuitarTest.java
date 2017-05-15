package test;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import domain.Guitar;
import domain.GuitarSpec;
import domain.Inventory;
import service.GuitarService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class GuitarTest {
	@Autowired
	private GuitarService guitarService;


	public void setGuitarServiceImpl(GuitarService guitarService) {
		this.guitarService = guitarService;
	}
	
	@Test
	public void test1() {
		GuitarSpec guitarSpec = new GuitarSpec("","","","alder","");
		Inventory inventroy = new Inventory();
        List<Guitar> guitarList = new ArrayList<Guitar>();
        guitarList = guitarService.getAll();
        inventroy.setGuitars(guitarList);
        List<Guitar> guitarList2 = new ArrayList<Guitar>();
		try {
			guitarList2 = inventroy.search(guitarSpec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        JSONArray jsonArray = new JSONArray();
		for(Guitar guitar : guitarList2){
			JSONObject jo = new JSONObject();
			jo.put("price", guitar.getPrice());
			jo.put("serialNumber", guitar.getSerialNumber());
			jo.put("backWood", guitar.getGuitarSpec().getBackWood());
			jo.put("builder", guitar.getGuitarSpec().getBuilder());
			jo.put("model", guitar.getGuitarSpec().getModel());
			jo.put("topWood", guitar.getGuitarSpec().getTopWood());
			jo.put("type", guitar.getGuitarSpec().getType());
			jsonArray.put(jo);
			System.out.println(jo.toString());
		}
	}

}
