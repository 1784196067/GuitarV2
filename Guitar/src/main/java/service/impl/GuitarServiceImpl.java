package service.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.GuitarDao;
import domain.Guitar;
import domain.GuitarSpec;
import domain.Inventory;
import service.GuitarService;

public class GuitarServiceImpl implements GuitarService{
	private GuitarDao guitarDao;

	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}

	@Override
	public JSONArray search(GuitarSpec guitarSpec) {
		Inventory inventroy = new Inventory();
        List<Guitar> guitarList = (List<Guitar>)guitarDao.findAll(Guitar.class);
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
		}
		return jsonArray;
	}

	
	
}
