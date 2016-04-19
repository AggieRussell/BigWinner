package predictor;

import predictor.spi.Predictor;
import java.util.ArrayList;
import java.util.HashMap;

public class Team {
	
	private String name;
	private int id;
	private double homeRating;
	private double awayRating;
	private double pdh;
	private double pda;
	
	Team(String n, int i, double homeR, double awayR, double pHome, double pAway){
		name = n;
		id = i;
		homeRating = homeR;
		awayRating = awayR;
		pdh = pHome;
		pda = pAway;
	}
	
	Team(Team b){
		this.name = b.getName();
		this.id = b.getID();
		this.homeRating = b.getHomeRating();
		this.awayRating = b.getAwayRating();
		this.pdh = b.getPDH();
		this.pda = b.getPDA();
	}
	
	public String getName() {return name;}
	public int getID() {return id;}
	public double getHomeRating() {return homeRating;}
	public double getAwayRating() {return awayRating;}
	public double getPDH() {return pdh;}
	public double getPDA() {return pda;}
	
	public void setName(String n) {name = n;}
	public void setID(int i) {id = i;}
	public void setHomeRating(double homeR) {homeRating = homeR;}
	public void setAwayRating(double awayR) {awayRating = awayR;}
	public void setPDH(double pHome) {pdh = pHome;}
	public void setPDA(double pAway) {pda = pAway;}
}