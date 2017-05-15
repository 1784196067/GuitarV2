package service;

import java.util.List;

import org.json.JSONArray;

import domain.Guitar;
import domain.GuitarSpec;

public interface GuitarService {
	public JSONArray search(GuitarSpec guitarSpec);
}
