package service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import domain.Guitar;
import domain.GuitarSpec;
import domain.Inventory;
import service.GuitarService;
import service.impl.GuitarServiceImpl;

public class GuitarTest {

	@Test
	public void test() {
		GuitarSpec guitarSpec = new GuitarSpec("","","","alder","");
		Inventory inventroy = new Inventory();
        List<Guitar> guitarList = new ArrayList<Guitar>();
        guitarList.add(new Guitar("11277", 3999.95, 
        	      new GuitarSpec("COLLINGS", "CJ", "ACOUSTIC", 
                          "INDIAN_ROSEWOOD", "SITKA")));
        guitarList.add(new Guitar("V95693", 1499.95, 
        	      new GuitarSpec("FENDER", "Stratocastor", "ELECTRIC",
                          "ALDER", "ALDER")));
        guitarList.add(new Guitar("V9512", 1549.95, 
        	      new GuitarSpec("FENDER", "Stratocastor", "ELECTRIC",
                          "ALDER", "ALDER")));
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
