package metier;
import service.*;

import java.util.ArrayList;
import java.util.List;


public class Agence {

	private String id;
	private String openDate;
	private Director currentDirector;
	private List<Adviser>	currentListOfAdviser = new ArrayList<Adviser>();
	

	public Agence(String openDate) {
		this.id = ActorService.genIdAgence();
		this.openDate = openDate;
		ActorService.addAgenceToBDD(this);
	}


	public Director getCurrentDirector() {
		return currentDirector;
	}


	public void setCurrentDirector(Director currentDirector) {
		this.currentDirector = currentDirector;
	}


	public List<Adviser> getCurrentListOfAdviser() {
		return currentListOfAdviser;
	}


	public void AddAdviser(Adviser newAd) {
		this.currentListOfAdviser.add(newAd);
	}


	public String getId() {
		return id;
	}


	public String getOpenDate() {
		return openDate;
	}
	
	
}
