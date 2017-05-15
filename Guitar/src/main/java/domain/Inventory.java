package domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars;

	 
	  public List<Guitar> getGuitars() {
		return guitars;
	}


	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public Inventory() {
		super();
	}


	public List<Guitar> search(GuitarSpec searchSpec) throws Exception {
	    List<Guitar> matchingGuitars = new LinkedList<Guitar>();
	    GuitarSpec guitarSpec;
	    Guitar guitar;
	    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
	      guitar = (Guitar)i.next();
	      guitarSpec = guitar.getGuitarSpec();
	      if (guitarSpec.match(searchSpec))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  }
}
