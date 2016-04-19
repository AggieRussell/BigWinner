package predictor;

import predictor.spi.Predictor;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class PowerRanking implements Predictor {
	
	private HashMap< String,ArrayList<ArrayList<String>> > season2011 = 
		new HashMap< String,ArrayList<ArrayList<String>> >();
	private HashMap< String,ArrayList<ArrayList<String>> > season2012 = 
		new HashMap< String,ArrayList<ArrayList<String>> >();
	private HashMap< String,ArrayList<ArrayList<String>> > season2013 = 
		new HashMap< String,ArrayList<ArrayList<String>> >();
	private HashMap< String,ArrayList<ArrayList<String>> > season2014 = 
		new HashMap< String,ArrayList<ArrayList<String>> >();
	private HashMap< String,ArrayList<ArrayList<String>> > season2015 = 
		new HashMap< String,ArrayList<ArrayList<String>> >();
		
	private ArrayList<String> years = new ArrayList<String>();
	
	private String name1 = "";
	private String name2 = "";
	
	// Load static data
    public PowerRanking() {
		name1 = "PowerRanking";
		name2 = "Power Ranking";
		years.add("2011");
		years.add("2012");
		years.add("2013");
		years.add("2014");
		years.add("2015");
		load2011SeasonData();
		load2012SeasonData();
		load2013SeasonData();
		load2014SeasonData();
		load2015SeasonData();
    }
	
	@Override
    public ArrayList<ArrayList<String>> getPrediction(int year, int week, String algorithm) {
		// Only return prediction if algorithm matches name
		boolean correctName = name1.equals(algorithm) || name2.equals(algorithm);
		if(correctName){
			if(years.contains("" + year + "")){
				HashMap< String, ArrayList<ArrayList<String>> >  season = null;
				switch("" + year + ""){
					case "2011": season = season2011; break;
					case "2012": season = season2012; break;
					case "2013": season = season2013; break;					
					case "2014": season = season2014; break;
					case "2015": season = season2015; break;
					default: System.out.println("Error selecting season[2011-2015]"); break;
				}
				return season.get("" + week + "");
			}
			return null;
		}
		else
			return null;
    }
	
	private void load2011SeasonData() {
		for(int week=1;week<18;++week){
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
			data.add(new ArrayList<String>()); // Column 0 = Home
			data.add(new ArrayList<String>()); // Column 1 = Away
			data.add(new ArrayList<String>()); // Column 2 = Prediction
			ArrayList<String> entries = new ArrayList<String>();
			switch(week){
				case 1:
					entries.add("Cardinals Panthers Cardinals");
					entries.add("Ravens Steelers Ravens");
					entries.add("Bears Falcons Bears");
					entries.add("Browns Bengals Browns");
					entries.add("Broncos Raiders Broncos");
					entries.add("Packers Saints Packers");
					entries.add("Texans Colts Texans");
					entries.add("Jaguars Titans Titans");
					entries.add("Chiefs Bills Chiefs");
					entries.add("Dolphins Patriots Patriots");
					entries.add("Jets Cowboys Jets");
					entries.add("Chargers Vikings Vikings");
					entries.add("49ers Seahawks Seahawks");
					entries.add("Rams Eagles Eagles");
					entries.add("Buccaneers Lions Lions");
					entries.add("Redskins Giants Redskins"); break;
				case 2:
					entries.add("Falcons Eagles Eagles");
					entries.add("Bills Raiders Bills");
					entries.add("Panthers Packers Panthers");
					entries.add("Broncos Bengals Broncos");
					entries.add("Lions Chiefs Lions");
					entries.add("Colts Browns Browns");
					entries.add("Dolphins Texans Dolphins");
					entries.add("Vikings Buccaneers Vikings");
					entries.add("Patriots Chargers Patriots");
					entries.add("Saints Bears Bears");
					entries.add("Giants Rams Giants");
					entries.add("Jets Jaguars Jets");
					entries.add("Steelers Seahawks Steelers");
					entries.add("49ers Cowboys Cowboys");
					entries.add("Titans Ravens Titans");
					entries.add("Redskins Cardinals Redskins"); break;
				case 3:
					entries.add("Bills Patriots Patriots");
					entries.add("Panthers Jaguars Panthers");
					entries.add("Bears Packers Bears");
					entries.add("Bengals 49ers Bengals");
					entries.add("Browns Dolphins Browns");
					entries.add("Cowboys Redskins Redskins");
					entries.add("Colts Steelers Steelers");
					entries.add("Vikings Lions Lions");
					entries.add("Saints Texans Texans");
					entries.add("Raiders Jets Jets");
					entries.add("Eagles Giants Eagles");
					entries.add("Chargers Chiefs Chargers");
					entries.add("Seahawks Cardinals Seahawks");
					entries.add("Rams Ravens Ravens");
					entries.add("Buccaneers Falcons Buccaneers");
					entries.add("Titans Broncos Titans"); break;
				case 4:
					entries.add("Cardinals Giants Giants");
					entries.add("Ravens Jets Ravens");
					entries.add("Bears Panthers Bears");
					entries.add("Bengals Bills Bengals");
					entries.add("Browns Titans Titans");
					entries.add("Cowboys Lions Lions");
					entries.add("Packers Broncos Packers");
					entries.add("Texans Steelers Steelers");
					entries.add("Jaguars Saints Saints");
					entries.add("Chiefs Vikings Vikings");
					entries.add("Raiders Patriots Patriots");
					entries.add("Eagles 49ers Eagles");
					entries.add("Chargers Dolphins Dolphins");
					entries.add("Seahawks Falcons Seahawks");
					entries.add("Rams Redskins Redskins");
					entries.add("Buccaneers Colts Buccaneers"); break;
				case 5:
					entries.add("Falcons Packers Falcons");
					entries.add("Bills Eagles Eagles");
					entries.add("Panthers Saints Panthers");
					entries.add("Broncos Chargers Broncos");
					entries.add("Lions Bears Lions");
					entries.add("Texans Raiders Texans");
					entries.add("Colts Chiefs Colts");
					entries.add("Jaguars Bengals Jaguars");
					entries.add("Vikings Cardinals Vikings");
					entries.add("Patriots Jets Patriots");
					entries.add("Giants Seahawks Giants");
					entries.add("Steelers Titans Steelers");
					entries.add("49ers Buccaneers Buccaneers"); break;
				case 6:
					entries.add("Falcons Panthers Falcons");
					entries.add("Ravens Texans Ravens");
					entries.add("Bears Vikings Vikings");
					entries.add("Bengals Colts Bengals");
					entries.add("Lions 49ers Lions");
					entries.add("Packers Rams Rams");
					entries.add("Patriots Cowboys Patriots");
					entries.add("Giants Bills Giants");
					entries.add("Jets Dolphins Jets");
					entries.add("Raiders Browns Browns");
					entries.add("Steelers Jaguars Steelers");
					entries.add("Buccaneers Saints Buccaneers");
					entries.add("Redskins Eagles Redskins"); break;
				case 7:
					entries.add("Cardinals Steelers Steelers");
					entries.add("Panthers Redskins Redskins");
					entries.add("Browns Seahawks Browns");
					entries.add("Cowboys Rams Rams");
					entries.add("Lions Falcons Lions");
					entries.add("Jaguars Ravens Ravens");
					entries.add("Dolphins Broncos Dolphins");
					entries.add("Vikings Packers Vikings");
					entries.add("Saints Colts Saints");
					entries.add("Jets Chargers Jets");
					entries.add("Raiders Chiefs Chiefs");
					entries.add("Buccaneers Bears Buccaneers");
					entries.add("Titans Texans Titans"); break;
				case 8:
					entries.add("Ravens Cardinals Ravens");
					entries.add("Bills Redskins Redskins");
					entries.add("Panthers Vikings Vikings");
					entries.add("Broncos Lions Lions");
					entries.add("Texans Jaguars Texans");
					entries.add("Chiefs Chargers Chiefs");
					entries.add("Giants Dolphins Giants");
					entries.add("Eagles Cowboys Eagles");
					entries.add("Steelers Patriots Steelers");
					entries.add("49ers Browns Browns");
					entries.add("Seahawks Bengals Seahawks");
					entries.add("Rams Saints Rams");
					entries.add("Titans Colts Titans"); break;
				case 9:
					entries.add("Cardinals Rams Rams");
					entries.add("Bills Jets Jets");
					entries.add("Cowboys Seahawks Cowboys");
					entries.add("Texans Browns Texans");
					entries.add("Colts Falcons Colts");
					entries.add("Chiefs Dolphins Dolphins");
					entries.add("Patriots Giants Patriots");
					entries.add("Saints Buccaneers Buccaneers");
					entries.add("Raiders Broncos Broncos");
					entries.add("Eagles Bears Eagles");
					entries.add("Steelers Ravens Steelers");
					entries.add("Chargers Packers Chargers");
					entries.add("Titans Bengals Titans");
					entries.add("Redskins 49ers Redskins"); break;
				case 10:
					entries.add("Falcons Saints Falcons");
					entries.add("Panthers Titans Titans");
					entries.add("Bears Lions Lions");
					entries.add("Bengals Steelers Steelers");
					entries.add("Browns Rams Browns");
					entries.add("Cowboys Bills Cowboys");
					entries.add("Packers Vikings Vikings");
					entries.add("Colts Jaguars Colts");
					entries.add("Chiefs Broncos Chiefs");
					entries.add("Dolphins Redskins Redskins");
					entries.add("Jets Patriots Patriots");
					entries.add("Eagles Cardinals Eagles");
					entries.add("Chargers Raiders Chargers");
					entries.add("49ers Giants Giants");
					entries.add("Seahawks Ravens Ravens");
					entries.add("Buccaneers Texans Buccaneers"); break;
				case 11:
					entries.add("Falcons Titans Titans");
					entries.add("Ravens Bengals Ravens");
					entries.add("Bears Chargers Bears");
					entries.add("Browns Jaguars Browns");
					entries.add("Broncos Jets Jets");
					entries.add("Lions Panthers Lions");
					entries.add("Packers Buccaneers Buccaneers");
					entries.add("Dolphins Bills Dolphins");
					entries.add("Vikings Raiders Vikings");
					entries.add("Patriots Chiefs Patriots");
					entries.add("Giants Eagles Eagles");
					entries.add("49ers Cardinals Cardinals");
					entries.add("Rams Seahawks Rams");
					entries.add("Redskins Cowboys Redskins"); break;
				case 12:
					entries.add("Falcons Vikings Vikings");
					entries.add("Ravens 49ers Ravens");
					entries.add("Bengals Browns Browns");
					entries.add("Cowboys Dolphins Dolphins");
					entries.add("Lions Packers Lions");
					entries.add("Colts Panthers Panthers");
					entries.add("Jaguars Texans Texans");
					entries.add("Chiefs Steelers Steelers");
					entries.add("Saints Giants Giants");
					entries.add("Jets Bills Jets");
					entries.add("Raiders Bears Bears");
					entries.add("Eagles Patriots Eagles");
					entries.add("Chargers Broncos Chargers");
					entries.add("Seahawks Redskins Redskins");
					entries.add("Rams Cardinals Rams");
					entries.add("Titans Buccaneers Titans"); break;
				case 13:
					entries.add("Cardinals Cowboys Cardinals");
					entries.add("Bills Titans Titans");
					entries.add("Bears Chiefs Bears");
					entries.add("Browns Ravens Ravens");
					entries.add("Texans Falcons Texans");
					entries.add("Jaguars Chargers Chargers");
					entries.add("Dolphins Raiders Dolphins");
					entries.add("Vikings Broncos Vikings");
					entries.add("Patriots Colts Patriots");
					entries.add("Saints Lions Lions");
					entries.add("Giants Packers Giants");
					entries.add("Steelers Bengals Steelers");
					entries.add("49ers Rams Rams");
					entries.add("Seahawks Eagles Eagles");
					entries.add("Buccaneers Panthers Buccaneers");
					entries.add("Redskins Jets Redskins"); break;
				case 14:
					entries.add("Cardinals 49ers Cardinals");
					entries.add("Ravens Colts Ravens");
					entries.add("Panthers Falcons Panthers");
					entries.add("Bengals Texans Texans");
					entries.add("Cowboys Giants Giants");
					entries.add("Broncos Bears Bears");
					entries.add("Lions Vikings Lions");
					entries.add("Packers Raiders Packers");
					entries.add("Jaguars Buccaneers Buccaneers");
					entries.add("Dolphins Eagles Eagles");
					entries.add("Jets Chiefs Jets");
					entries.add("Steelers Browns Steelers");
					entries.add("Chargers Bills Chargers");
					entries.add("Seahawks Rams Rams");
					entries.add("Titans Saints Titans");
					entries.add("Redskins Patriots Redskins"); break;
				case 15:
					entries.add("Cardinals Browns Browns");
					entries.add("Falcons Jaguars Falcons");
					entries.add("Bills Dolphins Dolphins");
					entries.add("Bears Seahawks Bears");
					entries.add("Broncos Patriots Patriots");
					entries.add("Texans Panthers Texans");
					entries.add("Colts Titans Titans");
					entries.add("Chiefs Packers Packers");
					entries.add("Vikings Saints Vikings");
					entries.add("Giants Redskins Redskins");
					entries.add("Raiders Lions Lions");
					entries.add("Eagles Jets Eagles");
					entries.add("Chargers Ravens Ravens");
					entries.add("49ers Steelers Steelers");
					entries.add("Rams Bengals Rams");
					entries.add("Buccaneers Cowboys Buccaneers"); break;
				case 16:
					entries.add("Ravens Browns Ravens");
					entries.add("Bills Broncos Bills");
					entries.add("Panthers Buccaneers Buccaneers");
					entries.add("Bengals Cardinals Bengals");
					entries.add("Cowboys Eagles Eagles");
					entries.add("Lions Chargers Lions");
					entries.add("Packers Bears Bears");
					entries.add("Colts Texans Texans");
					entries.add("Chiefs Raiders Chiefs");
					entries.add("Patriots Dolphins Patriots");
					entries.add("Saints Falcons Saints");
					entries.add("Jets Giants Jets");
					entries.add("Steelers Rams Steelers");
					entries.add("Seahawks 49ers Seahawks");
					entries.add("Titans Jaguars Titans");
					entries.add("Redskins Vikings Redskins"); break;
				case 17:
					entries.add("Cardinals Seahawks Cardinals");
					entries.add("Falcons Buccaneers Buccaneers");
					entries.add("Bengals Ravens Ravens");
					entries.add("Browns Steelers Steelers");
					entries.add("Broncos Chiefs Broncos");
					entries.add("Packers Lions Lions");
					entries.add("Texans Titans Titans");
					entries.add("Jaguars Colts Jaguars");
					entries.add("Dolphins Jets Jets");
					entries.add("Vikings Bears Vikings");
					entries.add("Patriots Bills Patriots");
					entries.add("Saints Panthers Saints");
					entries.add("Giants Cowboys Giants");
					entries.add("Raiders Chargers Chargers");
					entries.add("Eagles Redskins Eagles");
					entries.add("Rams 49ers Rams"); break;
				default: System.out.println("ERROR: Season2011Data"); break;
			}
			
			Collections.sort(entries);
					
			for(int i=0; i<entries.size(); ++i){
				String entry = entries.get(i);
				String[] splitEntry = entry.split(" ");
				data.get(0).add(splitEntry[0]);
				data.get(1).add(splitEntry[1]);
				data.get(2).add(splitEntry[2]);				
			}
			entries.clear();
			season2011.put(""+week+"",data);
		}		
	}
	
	private void load2012SeasonData() {
		for(int week=1;week<18;++week){
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
			data.add(new ArrayList<String>()); // Column 0 = Home
			data.add(new ArrayList<String>()); // Column 1 = Away
			data.add(new ArrayList<String>()); // Column 2 = Prediction
			ArrayList<String> entries = new ArrayList<String>();
			switch(week){
				case 1:
					entries.add("Cardinals Seahawks Seahawks");
					entries.add("Ravens Bengals Ravens");
					entries.add("Bears Colts Colts");
					entries.add("Browns Eagles Eagles");
					entries.add("Broncos Steelers Broncos");
					entries.add("Lions Rams Lions");
					entries.add("Packers 49ers 49ers");
					entries.add("Texans Dolphins Texans");
					entries.add("Chiefs Falcons Chiefs");
					entries.add("Vikings Jaguars Vikings");
					entries.add("Saints Redskins Redskins");
					entries.add("Giants Cowboys Giants");
					entries.add("Jets Bills Bills");
					entries.add("Raiders Chargers Raiders");
					entries.add("Buccaneers Panthers Panthers");
					entries.add("Titans Patriots Titans"); break;
				case 2:
					entries.add("Falcons Broncos Broncos");
					entries.add("Bills Chiefs Bills");
					entries.add("Panthers Saints Saints");
					entries.add("Bengals Browns Browns");
					entries.add("Packers Bears Bears");
					entries.add("Colts Vikings Colts");
					entries.add("Jaguars Texans Texans");
					entries.add("Dolphins Raiders Raiders");
					entries.add("Patriots Cardinals Patriots");
					entries.add("Giants Buccaneers Giants");
					entries.add("Eagles Ravens Eagles");
					entries.add("Steelers Jets Steelers");
					entries.add("Chargers Titans Titans");
					entries.add("49ers Lions 49ers");
					entries.add("Seahawks Cowboys Seahawks");
					entries.add("Rams Redskins Redskins"); break;
				case 3:
					entries.add("Cardinals Eagles Eagles");
					entries.add("Ravens Patriots Ravens");
					entries.add("Panthers Giants Giants");
					entries.add("Bears Rams Bears");
					entries.add("Browns Bills Browns");
					entries.add("Cowboys Buccaneers Cowboys");
					entries.add("Broncos Texans Broncos");
					entries.add("Colts Jaguars Colts");
					entries.add("Dolphins Jets Jets");
					entries.add("Vikings 49ers 49ers");
					entries.add("Saints Chiefs Saints");
					entries.add("Raiders Steelers Steelers");
					entries.add("Chargers Falcons Chargers");
					entries.add("Seahawks Packers Seahawks");
					entries.add("Titans Lions Titans");
					entries.add("Redskins Bengals Redskins"); break;
				case 4:
					entries.add("Cardinals Dolphins Cardinals");
					entries.add("Falcons Panthers Panthers");
					entries.add("Ravens Browns Browns");
					entries.add("Bills Patriots Patriots");
					entries.add("Cowboys Bears Bears");
					entries.add("Broncos Raiders Broncos");
					entries.add("Lions Vikings Vikings");
					entries.add("Packers Saints Saints");
					entries.add("Texans Titans Texans");
					entries.add("Jaguars Bengals Jaguars");
					entries.add("Chiefs Chargers Chargers");
					entries.add("Jets 49ers 49ers");
					entries.add("Eagles Giants Eagles");
					entries.add("Rams Seahawks Seahawks");
					entries.add("Buccaneers Redskins Redskins"); break;
				case 5:
					entries.add("Panthers Seahawks Seahawks");
					entries.add("Bengals Dolphins Bengals");
					entries.add("Colts Packers Colts");
					entries.add("Jaguars Bears Bears");
					entries.add("Chiefs Ravens Ravens");
					entries.add("Vikings Titans Titans");
					entries.add("Patriots Broncos Broncos");
					entries.add("Saints Chargers Saints");
					entries.add("Giants Browns Browns");
					entries.add("Jets Texans Texans");
					entries.add("Steelers Eagles Steelers");
					entries.add("49ers Bills 49ers");
					entries.add("Rams Cardinals Rams");
					entries.add("Redskins Falcons Redskins"); break;
				case 6:
					entries.add("Cardinals Bills Cardinals");
					entries.add("Falcons Raiders Raiders");
					entries.add("Ravens Cowboys Ravens");
					entries.add("Browns Bengals Browns");
					entries.add("Texans Packers Texans");
					entries.add("Dolphins Rams Rams");
					entries.add("Jets Colts Colts");
					entries.add("Eagles Lions Eagles");
					entries.add("Chargers Broncos Broncos");
					entries.add("49ers Giants 49ers");
					entries.add("Seahawks Patriots Seahawks");
					entries.add("Buccaneers Chiefs Buccaneers");
					entries.add("Titans Steelers Titans");
					entries.add("Redskins Vikings Redskins"); break;
				case 7:
					entries.add("Bills Titans Titans");
					entries.add("Panthers Cowboys Panthers");
					entries.add("Bears Lions Bears");
					entries.add("Bengals Steelers Steelers");
					entries.add("Texans Ravens Texans");
					entries.add("Colts Browns Colts");
					entries.add("Vikings Cardinals Vikings");
					entries.add("Patriots Jets Patriots");
					entries.add("Giants Redskins Redskins");
					entries.add("Raiders Jaguars Raiders");
					entries.add("49ers Seahawks Seahawks");
					entries.add("Rams Packers Rams");
					entries.add("Buccaneers Saints Saints"); break;
				case 8:
					entries.add("Cardinals 49ers 49ers");
					entries.add("Bears Panthers Bears");
					entries.add("Browns Chargers Browns");
					entries.add("Cowboys Giants Cowboys");
					entries.add("Broncos Saints Broncos");
					entries.add("Lions Seahawks Seahawks");
					entries.add("Packers Jaguars Packers");
					entries.add("Chiefs Raiders Raiders");
					entries.add("Vikings Buccaneers Vikings");
					entries.add("Jets Dolphins Jets");
					entries.add("Eagles Falcons Eagles");
					entries.add("Steelers Redskins Steelers");
					entries.add("Rams Patriots Rams");
					entries.add("Titans Colts Titans"); break;
				case 9:
					entries.add("Falcons Cowboys Cowboys");
					entries.add("Bengals Broncos Broncos");
					entries.add("Browns Ravens Browns");
					entries.add("Packers Cardinals Packers");
					entries.add("Texans Bills Texans");
					entries.add("Colts Dolphins Colts");
					entries.add("Jaguars Lions Lions");
					entries.add("Saints Eagles Eagles");
					entries.add("Giants Steelers Steelers");
					entries.add("Raiders Buccaneers Raiders");
					entries.add("Chargers Chiefs Chargers");
					entries.add("Seahawks Vikings Seahawks");
					entries.add("Titans Bears Titans");
					entries.add("Redskins Panthers Redskins"); break;
				case 10:
					entries.add("Ravens Raiders Raiders");
					entries.add("Panthers Broncos Broncos");
					entries.add("Bears Texans Texans");
					entries.add("Bengals Giants Giants");
					entries.add("Jaguars Colts Colts");
					entries.add("Dolphins Titans Titans");
					entries.add("Vikings Lions Vikings");
					entries.add("Patriots Bills Patriots");
					entries.add("Saints Falcons Saints");
					entries.add("Eagles Cowboys Eagles");
					entries.add("Steelers Chiefs Steelers");
					entries.add("49ers Rams 49ers");
					entries.add("Seahawks Jets Seahawks");
					entries.add("Buccaneers Chargers Chargers"); break;
				case 11:
					entries.add("Falcons Cardinals Cardinals");
					entries.add("Bills Dolphins Bills");
					entries.add("Panthers Buccaneers Panthers");
					entries.add("Cowboys Browns Browns");
					entries.add("Broncos Chargers Broncos");
					entries.add("Lions Packers Lions");
					entries.add("Texans Jaguars Texans");
					entries.add("Chiefs Bengals Bengals");
					entries.add("Patriots Colts Colts");
					entries.add("Raiders Saints Raiders");
					entries.add("Steelers Ravens Steelers");
					entries.add("49ers Bears 49ers");
					entries.add("Rams Jets Rams");
					entries.add("Redskins Eagles Eagles"); break;
				case 12:
					entries.add("Cardinals Rams Cardinals");
					entries.add("Bears Vikings Vikings");
					entries.add("Bengals Raiders Raiders");
					entries.add("Browns Steelers Steelers");
					entries.add("Cowboys Redskins Redskins");
					entries.add("Lions Texans Texans");
					entries.add("Colts Bills Colts");
					entries.add("Jaguars Titans Titans");
					entries.add("Chiefs Broncos Broncos");
					entries.add("Dolphins Seahawks Seahawks");
					entries.add("Saints 49ers 49ers");
					entries.add("Giants Packers Giants");
					entries.add("Jets Patriots Patriots");
					entries.add("Eagles Panthers Eagles");
					entries.add("Chargers Ravens Chargers");
					entries.add("Buccaneers Falcons Buccaneers"); break;
				case 13:
					entries.add("Falcons Saints Saints");
					entries.add("Ravens Steelers Steelers");
					entries.add("Bills Jaguars Bills");
					entries.add("Bears Seahawks Seahawks");
					entries.add("Cowboys Eagles Eagles");
					entries.add("Broncos Buccaneers Broncos");
					entries.add("Lions Colts Colts");
					entries.add("Packers Vikings Vikings");
					entries.add("Chiefs Panthers Panthers");
					entries.add("Dolphins Patriots Patriots");
					entries.add("Jets Cardinals Cardinals");
					entries.add("Raiders Browns Raiders");
					entries.add("Chargers Bengals Chargers");
					entries.add("Rams 49ers 49ers");
					entries.add("Titans Texans Titans");
					entries.add("Redskins Giants Redskins"); break;
				case 14:
					entries.add("Bills Rams Rams");
					entries.add("Panthers Falcons Panthers");
					entries.add("Bengals Cowboys Cowboys");
					entries.add("Browns Chiefs Browns");
					entries.add("Packers Lions Packers");
					entries.add("Colts Titans Colts");
					entries.add("Jaguars Jets Jaguars");
					entries.add("Vikings Bears Vikings");
					entries.add("Patriots Texans Texans");
					entries.add("Giants Saints Giants");
					entries.add("Raiders Broncos Broncos");
					entries.add("Steelers Chargers Steelers");
					entries.add("49ers Dolphins 49ers");
					entries.add("Seahawks Cardinals Seahawks");
					entries.add("Buccaneers Eagles Eagles");
					entries.add("Redskins Ravens Redskins"); break;
				case 15:
					entries.add("Cardinals Lions Cardinals");
					entries.add("Falcons Giants Giants");
					entries.add("Ravens Broncos Broncos");
					entries.add("Bills Seahawks Seahawks");
					entries.add("Bears Packers Bears");
					entries.add("Browns Redskins Redskins");
					entries.add("Cowboys Steelers Steelers");
					entries.add("Texans Colts Texans");
					entries.add("Dolphins Jaguars Jaguars");
					entries.add("Patriots 49ers 49ers");
					entries.add("Saints Buccaneers Saints");
					entries.add("Raiders Chiefs Raiders");
					entries.add("Eagles Bengals Eagles");
					entries.add("Chargers Panthers Chargers");
					entries.add("Rams Vikings Vikings");
					entries.add("Titans Jets Titans"); break;
				case 16:
					entries.add("Cardinals Bears Cardinals");
					entries.add("Ravens Giants Ravens");
					entries.add("Panthers Raiders Raiders");
					entries.add("Cowboys Saints Saints");
					entries.add("Broncos Browns Broncos");
					entries.add("Lions Falcons Lions");
					entries.add("Packers Titans Titans");
					entries.add("Texans Vikings Texans");
					entries.add("Jaguars Patriots Patriots");
					entries.add("Chiefs Colts Colts");
					entries.add("Dolphins Bills Bills");
					entries.add("Jets Chargers Chargers");
					entries.add("Eagles Redskins Eagles");
					entries.add("Steelers Bengals Steelers");
					entries.add("Seahawks 49ers Seahawks");
					entries.add("Buccaneers Rams Rams"); break;
				case 17:
					entries.add("Falcons Buccaneers Falcons");
					entries.add("Bills Jets Bills");
					entries.add("Bengals Ravens Ravens");
					entries.add("Broncos Chiefs Broncos");
					entries.add("Lions Bears Lions");
					entries.add("Colts Texans Colts");
					entries.add("Vikings Packers Vikings");
					entries.add("Patriots Dolphins Patriots");
					entries.add("Saints Panthers Saints");
					entries.add("Giants Eagles Eagles");
					entries.add("Steelers Browns Steelers");
					entries.add("Chargers Raiders Chargers");
					entries.add("49ers Cardinals 49ers");
					entries.add("Seahawks Rams Seahawks");
					entries.add("Titans Jaguars Titans");
					entries.add("Redskins Cowboys Redskins"); break;
				default: System.out.println("ERROR: Season2012Data"); break;
			}
			
			Collections.sort(entries);
					
			for(int i=0; i<entries.size(); ++i){
				String entry = entries.get(i);
				String[] splitEntry = entry.split(" ");
				data.get(0).add(splitEntry[0]);
				data.get(1).add(splitEntry[1]);
				data.get(2).add(splitEntry[2]);				
			}
			entries.clear();
			season2012.put(""+week+"",data);
		}		
	}
	
	private void load2013SeasonData() {
		for(int week=1;week<18;++week){
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
			data.add(new ArrayList<String>()); // Column 0 = Home
			data.add(new ArrayList<String>()); // Column 1 = Away
			data.add(new ArrayList<String>()); // Column 2 = Prediction
			ArrayList<String> entries = new ArrayList<String>();
			switch(week){
				case 1:
					entries.add("Bills Patriots Bills");
					entries.add("Panthers Seahawks Seahawks");
					entries.add("Bears Bengals Bengals");
					entries.add("Browns Dolphins Browns");
					entries.add("Cowboys Giants Cowboys");
					entries.add("Broncos Ravens Broncos");
					entries.add("Lions Vikings Lions");
					entries.add("Colts Raiders Colts");
					entries.add("Jaguars Chiefs Chiefs");
					entries.add("Saints Falcons Saints");
					entries.add("Jets Buccaneers Jets");
					entries.add("Steelers Titans Titans");
					entries.add("Chargers Texans Texans");
					entries.add("49ers Packers 49ers");
					entries.add("Rams Cardinals Cardinals");
					entries.add("Redskins Eagles Redskins"); break;
				case 2:
					entries.add("Cardinals Lions Lions");
					entries.add("Falcons Rams Rams");
					entries.add("Ravens Browns Browns");
					entries.add("Bills Panthers Panthers");
					entries.add("Bears Vikings Bears");
					entries.add("Bengals Steelers Bengals");
					entries.add("Packers Redskins Redskins");
					entries.add("Texans Titans Texans");
					entries.add("Colts Dolphins Dolphins");
					entries.add("Chiefs Cowboys Chiefs");
					entries.add("Patriots Jets Jets");
					entries.add("Giants Broncos Broncos");
					entries.add("Raiders Jaguars Raiders");
					entries.add("Eagles Chargers Eagles");
					entries.add("Seahawks 49ers Seahawks");
					entries.add("Buccaneers Saints Saints"); break;
				case 3:
					entries.add("Ravens Texans Texans");
					entries.add("Panthers Giants Panthers");
					entries.add("Bengals Packers Bengals");
					entries.add("Cowboys Rams Cowboys");
					entries.add("Broncos Raiders Broncos");
					entries.add("Dolphins Falcons Dolphins");
					entries.add("Vikings Browns Browns");
					entries.add("Patriots Buccaneers Patriots");
					entries.add("Saints Cardinals Saints");
					entries.add("Jets Bills Jets");
					entries.add("Eagles Chiefs Chiefs");
					entries.add("Steelers Bears Bears");
					entries.add("49ers Colts 49ers");
					entries.add("Seahawks Jaguars Seahawks");
					entries.add("Titans Chargers Titans");
					entries.add("Redskins Lions Redskins"); break;
				case 4:
					entries.add("Falcons Patriots Patriots");
					entries.add("Bills Ravens Bills");
					entries.add("Browns Bengals Bengals");
					entries.add("Broncos Eagles Broncos");
					entries.add("Lions Bears Lions");
					entries.add("Texans Seahawks Seahawks");
					entries.add("Jaguars Colts Colts");
					entries.add("Chiefs Giants Chiefs");
					entries.add("Vikings Steelers Vikings");
					entries.add("Saints Dolphins Saints");
					entries.add("Raiders Redskins Redskins");
					entries.add("Chargers Cowboys Chargers");
					entries.add("Rams 49ers 49ers");
					entries.add("Buccaneers Cardinals Cardinals");
					entries.add("Titans Jets Titans"); break;
				case 5:
					entries.add("Cardinals Panthers Cardinals");
					entries.add("Falcons Jets Jets");
					entries.add("Bears Saints Saints");
					entries.add("Bengals Patriots Bengals");
					entries.add("Browns Bills Browns");
					entries.add("Cowboys Broncos Cowboys");
					entries.add("Packers Lions Lions");
					entries.add("Colts Seahawks Seahawks");
					entries.add("Dolphins Ravens Dolphins");
					entries.add("Giants Eagles Giants");
					entries.add("Raiders Chargers Raiders");
					entries.add("49ers Texans 49ers");
					entries.add("Rams Jaguars Rams");
					entries.add("Titans Chiefs Chiefs"); break;
				case 6:
					entries.add("Ravens Packers Ravens");
					entries.add("Bills Bengals Bengals");
					entries.add("Bears Giants Bears");
					entries.add("Browns Lions Lions");
					entries.add("Cowboys Redskins Redskins");
					entries.add("Broncos Jaguars Broncos");
					entries.add("Texans Rams Texans");
					entries.add("Chiefs Raiders Chiefs");
					entries.add("Vikings Panthers Panthers");
					entries.add("Patriots Saints Saints");
					entries.add("Jets Steelers Jets");
					entries.add("Chargers Colts Chargers");
					entries.add("49ers Cardinals 49ers");
					entries.add("Seahawks Titans Seahawks");
					entries.add("Buccaneers Eagles Eagles"); break;
				case 7:
					entries.add("Cardinals Seahawks Seahawks");
					entries.add("Falcons Buccaneers Falcons");
					entries.add("Panthers Rams Panthers");
					entries.add("Lions Bengals Lions");
					entries.add("Packers Browns Browns");
					entries.add("Colts Broncos Colts");
					entries.add("Jaguars Chargers Chargers");
					entries.add("Chiefs Texans Chiefs");
					entries.add("Dolphins Bills Dolphins");
					entries.add("Giants Vikings Giants");
					entries.add("Jets Patriots Jets");
					entries.add("Eagles Cowboys Cowboys");
					entries.add("Steelers Ravens Ravens");
					entries.add("Titans 49ers 49ers");
					entries.add("Redskins Bears Redskins"); break;
				case 8:
					entries.add("Cardinals Falcons Cardinals");
					entries.add("Bengals Jets Bengals");
					entries.add("Broncos Redskins Redskins");
					entries.add("Lions Cowboys Lions");
					entries.add("Jaguars 49ers 49ers");
					entries.add("Chiefs Browns Chiefs");
					entries.add("Vikings Packers Vikings");
					entries.add("Patriots Dolphins Dolphins");
					entries.add("Saints Bills Saints");
					entries.add("Raiders Steelers Raiders");
					entries.add("Eagles Giants Eagles");
					entries.add("Rams Seahawks Seahawks");
					entries.add("Buccaneers Panthers Panthers"); break;
				case 9:
					entries.add("Bills Chiefs Chiefs");
					entries.add("Panthers Falcons Panthers");
					entries.add("Browns Ravens Browns");
					entries.add("Cowboys Vikings Cowboys");
					entries.add("Packers Bears Bears");
					entries.add("Texans Colts Texans");
					entries.add("Dolphins Bengals Bengals");
					entries.add("Patriots Steelers Patriots");
					entries.add("Jets Saints Saints");
					entries.add("Raiders Eagles Raiders");
					entries.add("Seahawks Buccaneers Seahawks");
					entries.add("Rams Titans Titans");
					entries.add("Redskins Chargers Redskins"); break;
				case 10:
					entries.add("Cardinals Texans Texans");
					entries.add("Falcons Seahawks Seahawks");
					entries.add("Ravens Bengals Bengals");
					entries.add("Bears Lions Lions");
					entries.add("Packers Eagles Packers");
					entries.add("Colts Rams Colts");
					entries.add("Vikings Redskins Redskins");
					entries.add("Saints Cowboys Saints");
					entries.add("Giants Raiders Raiders");
					entries.add("Steelers Bills Bills");
					entries.add("Chargers Broncos Chargers");
					entries.add("49ers Panthers 49ers");
					entries.add("Buccaneers Dolphins Dolphins");
					entries.add("Titans Jaguars Titans"); break;
				case 11:
					entries.add("Bills Jets Bills");
					entries.add("Panthers Patriots Panthers");
					entries.add("Bears Ravens Bears");
					entries.add("Bengals Browns Bengals");
					entries.add("Broncos Chiefs Chiefs");
					entries.add("Texans Raiders Texans");
					entries.add("Jaguars Cardinals Cardinals");
					entries.add("Dolphins Chargers Dolphins");
					entries.add("Saints 49ers 49ers");
					entries.add("Giants Packers Packers");
					entries.add("Eagles Redskins Redskins");
					entries.add("Steelers Lions Lions");
					entries.add("Seahawks Vikings Seahawks");
					entries.add("Buccaneers Falcons Buccaneers");
					entries.add("Titans Colts Titans"); break;
				case 12:
					entries.add("Cardinals Colts Cardinals");
					entries.add("Falcons Saints Saints");
					entries.add("Ravens Jets Jets");
					entries.add("Browns Steelers Browns");
					entries.add("Lions Buccaneers Lions");
					entries.add("Packers Vikings Packers");
					entries.add("Texans Jaguars Texans");
					entries.add("Chiefs Chargers Chiefs");
					entries.add("Dolphins Panthers Dolphins");
					entries.add("Patriots Broncos Broncos");
					entries.add("Giants Cowboys Cowboys");
					entries.add("Raiders Titans Raiders");
					entries.add("Rams Bears Bears");
					entries.add("Redskins 49ers 49ers"); break;
				case 13:
					entries.add("Ravens Steelers Ravens");
					entries.add("Bills Falcons Bills");
					entries.add("Panthers Buccaneers Panthers");
					entries.add("Browns Jaguars Browns");
					entries.add("Cowboys Raiders Cowboys");
					entries.add("Lions Packers Lions");
					entries.add("Texans Patriots Texans");
					entries.add("Colts Titans Colts");
					entries.add("Chiefs Broncos Chiefs");
					entries.add("Vikings Bears Bears");
					entries.add("Jets Dolphins Jets");
					entries.add("Eagles Cardinals Cardinals");
					entries.add("Chargers Bengals Bengals");
					entries.add("49ers Rams 49ers");
					entries.add("Seahawks Saints Seahawks");
					entries.add("Redskins Giants Redskins"); break;
				case 14:
					entries.add("Cardinals Rams Cardinals");
					entries.add("Ravens Vikings Ravens");
					entries.add("Bears Cowboys Bears");
					entries.add("Bengals Colts Bengals");
					entries.add("Broncos Titans Broncos");
					entries.add("Packers Falcons Packers");
					entries.add("Jaguars Texans Texans");
					entries.add("Patriots Browns Browns");
					entries.add("Saints Panthers Saints");
					entries.add("Jets Raiders Jets");
					entries.add("Eagles Lions Lions");
					entries.add("Steelers Dolphins Dolphins");
					entries.add("Chargers Giants Chargers");
					entries.add("49ers Seahawks 49ers");
					entries.add("Buccaneers Bills Bills");
					entries.add("Redskins Chiefs Redskins"); break;
				case 15:
					entries.add("Falcons Redskins Redskins");
					entries.add("Panthers Jets Panthers");
					entries.add("Browns Bears Browns");
					entries.add("Cowboys Packers Cowboys");
					entries.add("Broncos Chargers Broncos");
					entries.add("Lions Ravens Lions");
					entries.add("Colts Texans Texans");
					entries.add("Jaguars Bills Bills");
					entries.add("Dolphins Patriots Dolphins");
					entries.add("Vikings Eagles Vikings");
					entries.add("Giants Seahawks Seahawks");
					entries.add("Raiders Chiefs Chiefs");
					entries.add("Steelers Bengals Bengals");
					entries.add("Rams Saints Saints");
					entries.add("Buccaneers 49ers 49ers");
					entries.add("Titans Cardinals Titans"); break;
				case 16:
					entries.add("Ravens Patriots Ravens");
					entries.add("Bills Dolphins Dolphins");
					entries.add("Panthers Saints Saints");
					entries.add("Bengals Vikings Bengals");
					entries.add("Lions Giants Lions");
					entries.add("Packers Steelers Packers");
					entries.add("Texans Broncos Texans");
					entries.add("Jaguars Titans Titans");
					entries.add("Chiefs Colts Chiefs");
					entries.add("Jets Browns Jets");
					entries.add("Eagles Bears Bears");
					entries.add("Chargers Raiders Chargers");
					entries.add("49ers Falcons 49ers");
					entries.add("Seahawks Cardinals Seahawks");
					entries.add("Rams Buccaneers Rams");
					entries.add("Redskins Cowboys Redskins"); break;
				case 17:
					entries.add("Cardinals 49ers 49ers");
					entries.add("Falcons Panthers Panthers");
					entries.add("Bears Packers Bears");
					entries.add("Bengals Ravens Bengals");
					entries.add("Cowboys Eagles Cowboys");
					entries.add("Colts Jaguars Colts");
					entries.add("Dolphins Jets Dolphins");
					entries.add("Vikings Lions Lions");
					entries.add("Patriots Bills Bills");
					entries.add("Saints Buccaneers Saints");
					entries.add("Giants Redskins Redskins");
					entries.add("Raiders Broncos Raiders");
					entries.add("Steelers Browns Browns");
					entries.add("Chargers Chiefs Chiefs");
					entries.add("Seahawks Rams Seahawks");
					entries.add("Titans Texans Texans"); break;
				default: System.out.println("ERROR: Season2013Data"); break;
			}
			
			Collections.sort(entries);
					
			for(int i=0; i<entries.size(); ++i){
				String entry = entries.get(i);
				String[] splitEntry = entry.split(" ");
				data.get(0).add(splitEntry[0]);
				data.get(1).add(splitEntry[1]);
				data.get(2).add(splitEntry[2]);				
			}
			entries.clear();
			season2013.put(""+week+"",data);
		}		
	}
	
	private void load2014SeasonData() {
		for(int week=1;week<18;++week){
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
			data.add(new ArrayList<String>()); // Column 0 = Home
			data.add(new ArrayList<String>()); // Column 1 = Away
			data.add(new ArrayList<String>()); // Column 2 = Prediction
			ArrayList<String> entries = new ArrayList<String>();
			switch(week){
				case 1:
					entries.add("Cardinals Chargers Cardinals");
					entries.add("Falcons Saints Saints");
					entries.add("Ravens Bengals Ravens");
					entries.add("Bears Bills Bears");
					entries.add("Cowboys 49ers 49ers");
					entries.add("Broncos Colts Broncos");
					entries.add("Lions Giants Lions");
					entries.add("Texans Redskins Redskins");
					entries.add("Chiefs Titans Titans");
					entries.add("Dolphins Patriots Patriots");
					entries.add("Jets Raiders Raiders");
					entries.add("Eagles Jaguars Eagles");
					entries.add("Steelers Browns Browns");
					entries.add("Seahawks Packers Seahawks");
					entries.add("Rams Vikings Vikings");
					entries.add("Buccaneers Panthers Buccaneers"); break;
				case 2:
					entries.add("Ravens Steelers Ravens");
					entries.add("Bills Dolphins Dolphins");
					entries.add("Panthers Lions Lions");
					entries.add("Bengals Falcons Bengals");
					entries.add("Browns Saints Browns");
					entries.add("Broncos Chiefs Broncos");
					entries.add("Packers Jets Packers");
					entries.add("Colts Eagles Eagles");
					entries.add("Vikings Patriots Vikings");
					entries.add("Giants Cardinals Cardinals");
					entries.add("Raiders Texans Raiders");
					entries.add("Chargers Seahawks Seahawks");
					entries.add("49ers Bears 49ers");
					entries.add("Buccaneers Rams Rams");
					entries.add("Titans Cowboys Titans");
					entries.add("Redskins Jaguars Redskins"); break;
				case 3:
					entries.add("Cardinals 49ers Cardinals");
					entries.add("Falcons Buccaneers Falcons");
					entries.add("Bills Chargers Chargers");
					entries.add("Panthers Steelers Panthers");
					entries.add("Bengals Titans Titans");
					entries.add("Browns Ravens Ravens");
					entries.add("Lions Packers Packers");
					entries.add("Jaguars Colts Jaguars");
					entries.add("Dolphins Chiefs Dolphins");
					entries.add("Patriots Raiders Raiders");
					entries.add("Saints Vikings Vikings");
					entries.add("Giants Texans Giants");
					entries.add("Jets Bears Bears");
					entries.add("Eagles Redskins Redskins");
					entries.add("Seahawks Broncos Seahawks");
					entries.add("Rams Cowboys Rams"); break;
				case 4:
					entries.add("Ravens Panthers Ravens");
					entries.add("Bears Packers Packers");
					entries.add("Cowboys Saints Saints");
					entries.add("Texans Bills Texans");
					entries.add("Colts Titans Titans");
					entries.add("Chiefs Patriots Patriots");
					entries.add("Vikings Falcons Vikings");
					entries.add("Jets Lions Lions");
					entries.add("Raiders Dolphins Raiders");
					entries.add("Steelers Buccaneers Buccaneers");
					entries.add("Chargers Jaguars Chargers");
					entries.add("49ers Eagles 49ers");
					entries.add("Redskins Giants Redskins"); break;
				case 5:
					entries.add("Panthers Bears Panthers");
					entries.add("Cowboys Texans Texans");
					entries.add("Broncos Cardinals Broncos");
					entries.add("Lions Bills Lions");
					entries.add("Packers Vikings Packers");
					entries.add("Colts Ravens Ravens");
					entries.add("Jaguars Steelers Jaguars");
					entries.add("Patriots Bengals Patriots");
					entries.add("Saints Buccaneers Saints");
					entries.add("Giants Falcons Giants");
					entries.add("Eagles Rams Rams");
					entries.add("Chargers Jets Chargers");
					entries.add("49ers Chiefs 49ers");
					entries.add("Titans Browns Titans");
					entries.add("Redskins Seahawks Seahawks"); break;
				case 6: 
					entries.add("Cardinals Redskins Cardinals");
					entries.add("Falcons Bears Falcons");
					entries.add("Bills Patriots Patriots");
					entries.add("Bengals Panthers Bengals");
					entries.add("Browns Steelers Browns");
					entries.add("Texans Colts Texans");
					entries.add("Dolphins Packers Packers");
					entries.add("Vikings Lions Vikings");
					entries.add("Jets Broncos Broncos");
					entries.add("Raiders Chargers Raiders");
					entries.add("Eagles Giants Eagles");
					entries.add("Seahawks Cowboys Seahawks");
					entries.add("Rams 49ers Rams");
					entries.add("Buccaneers Ravens Ravens");
					entries.add("Titans Jaguars Titans"); break;
				case 7: 
					entries.add("Ravens Falcons Ravens");
					entries.add("Bills Vikings Vikings");
					entries.add("Bears Dolphins Dolphins");
					entries.add("Cowboys Giants Cowboys");
					entries.add("Broncos 49ers Broncos");
					entries.add("Lions Saints Lions");
					entries.add("Packers Panthers Packers");
					entries.add("Colts Bengals Bengals");
					entries.add("Jaguars Browns Browns");
					entries.add("Patriots Jets Patriots");
					entries.add("Raiders Cardinals Raiders");
					entries.add("Steelers Texans Texans");
					entries.add("Chargers Chiefs Chargers");
					entries.add("Rams Seahawks Seahawks");
					entries.add("Redskins Titans Redskins"); break;
				case 8: 
					entries.add("Cardinals Eagles Cardinals");
					entries.add("Falcons Lions Lions");
					entries.add("Panthers Seahawks Seahawks");
					entries.add("Bengals Ravens Ravens");
					entries.add("Browns Raiders Raiders");
					entries.add("Cowboys Redskins Redskins");
					entries.add("Broncos Chargers Broncos");
					entries.add("Jaguars Dolphins Dolphins");
					entries.add("Chiefs Rams Rams");
					entries.add("Patriots Bears Patriots");
					entries.add("Saints Packers Packers");
					entries.add("Jets Bills Jets");
					entries.add("Steelers Colts Steelers");
					entries.add("Buccaneers Vikings Vikings");
					entries.add("Titans Texans Titans"); break;
				case 9: 
					entries.add("Panthers Saints Saints");
					entries.add("Bengals Jaguars Bengals");
					entries.add("Browns Buccaneers Browns");
					entries.add("Cowboys Cardinals Cardinals");
					entries.add("Texans Eagles Texans");
					entries.add("Chiefs Jets Chiefs");
					entries.add("Dolphins Chargers Chargers");
					entries.add("Vikings Redskins Vikings");
					entries.add("Patriots Broncos Broncos");
					entries.add("Giants Colts Giants");
					entries.add("Steelers Ravens Ravens");
					entries.add("49ers Rams 49ers");
					entries.add("Seahawks Raiders Seahawks"); break;
				case 10: 
					entries.add("Cardinals Rams Cardinals");
					entries.add("Ravens Titans Ravens");
					entries.add("Bills Chiefs Chiefs");
					entries.add("Bengals Browns Bengals");
					entries.add("Lions Dolphins Lions");
					entries.add("Packers Bears Packers");
					entries.add("Jaguars Cowboys Jaguars");
					entries.add("Saints 49ers Saints");
					entries.add("Jets Steelers Jets");
					entries.add("Raiders Broncos Broncos");
					entries.add("Eagles Panthers Eagles");
					entries.add("Seahawks Giants Seahawks");
					entries.add("Buccaneers Falcons Buccaneers"); break;
				case 11:
					entries.add("Cardinals Lions Cardinals");
					entries.add("Panthers Falcons Falcons");
					entries.add("Bears Vikings Vikings");
					entries.add("Browns Texans Browns");
					entries.add("Packers Eagles Packers");
					entries.add("Colts Patriots Patriots");
					entries.add("Chiefs Seahawks Seahawks");
					entries.add("Dolphins Bills Dolphins");
					entries.add("Saints Bengals Saints");
					entries.add("Giants 49ers 49ers");
					entries.add("Chargers Raiders Raiders");
					entries.add("Rams Broncos Broncos");
					entries.add("Titans Steelers Titans");
					entries.add("Redskins Buccaneers Redskins"); break;
				case 12: 
					entries.add("Falcons Browns Browns");
					entries.add("Bills Jets Jets");
					entries.add("Bears Buccaneers Bears");
					entries.add("Broncos Dolphins Broncos");
					entries.add("Texans Bengals Texans");
					entries.add("Colts Jaguars Jaguars");
					entries.add("Vikings Packers Vikings");
					entries.add("Patriots Lions Lions");
					entries.add("Saints Ravens Ravens");
					entries.add("Giants Cowboys Giants");
					entries.add("Raiders Chiefs Raiders");
					entries.add("Eagles Titans Titans");
					entries.add("Chargers Rams Rams");
					entries.add("49ers Redskins Redskins");
					entries.add("Seahawks Cardinals Seahawks"); break;
				case 13: 
					entries.add("Falcons Cardinals Cardinals");
					entries.add("Ravens Chargers Ravens");
					entries.add("Bills Browns Browns");
					entries.add("Cowboys Eagles Eagles");
					entries.add("Lions Bears Lions");
					entries.add("Packers Patriots Packers");
					entries.add("Texans Titans Titans");
					entries.add("Colts Redskins Redskins");
					entries.add("Jaguars Giants Jaguars");
					entries.add("Chiefs Broncos Broncos");
					entries.add("Vikings Panthers Vikings");
					entries.add("Jets Dolphins Dolphins");
					entries.add("Steelers Saints Saints");
					entries.add("49ers Seahawks Seahawks");
					entries.add("Rams Raiders Raiders");
					entries.add("Buccaneers Bengals Bengals"); break;
				case 14: 
					entries.add("Cardinals Chiefs Cardinals");
					entries.add("Bears Cowboys Bears");
					entries.add("Bengals Steelers Bengals");
					entries.add("Browns Colts Browns");
					entries.add("Broncos Bills Broncos");
					entries.add("Lions Buccaneers Lions");
					entries.add("Packers Falcons Packers");
					entries.add("Jaguars Texans Texans");
					entries.add("Dolphins Ravens Ravens");
					entries.add("Vikings Jets Vikings");
					entries.add("Saints Panthers Saints");
					entries.add("Raiders 49ers Raiders");
					entries.add("Eagles Seahawks Seahawks");
					entries.add("Chargers Patriots Chargers");
					entries.add("Titans Giants Titans");
					entries.add("Redskins Rams Redskins"); break;
				case 15: 
					entries.add("Falcons Steelers Falcons");
					entries.add("Ravens Jaguars Ravens");
					entries.add("Bills Packers Packers");
					entries.add("Panthers Buccaneers Panthers");
					entries.add("Bears Saints Saints");
					entries.add("Browns Bengals Browns");
					entries.add("Lions Vikings Vikings");
					entries.add("Colts Texans Texans");
					entries.add("Chiefs Raiders Raiders");
					entries.add("Patriots Dolphins Patriots");
					entries.add("Giants Redskins Redskins");
					entries.add("Eagles Cowboys Eagles");
					entries.add("Chargers Broncos Broncos");
					entries.add("Seahawks 49ers Seahawks");
					entries.add("Rams Cardinals Cardinals");
					entries.add("Titans Jets Titans"); break;
				case 16: 
					entries.add("Cardinals Seahawks Seahawks");
					entries.add("Panthers Browns Browns");
					entries.add("Bears Lions Lions");
					entries.add("Bengals Broncos Broncos");
					entries.add("Cowboys Colts Cowboys");
					entries.add("Texans Ravens Ravens");
					entries.add("Jaguars Titans Titans");
					entries.add("Dolphins Vikings Vikings");
					entries.add("Saints Falcons Saints");
					entries.add("Jets Patriots Patriots");
					entries.add("Raiders Bills Raiders");
					entries.add("Steelers Chiefs Chiefs");
					entries.add("49ers Chargers 49ers");
					entries.add("Rams Giants Rams");
					entries.add("Buccaneers Packers Packers");
					entries.add("Redskins Eagles Redskins"); break;
				case 17: 
					entries.add("Falcons Panthers Falcons");
					entries.add("Ravens Browns Ravens");
					entries.add("Broncos Raiders Broncos");
					entries.add("Packers Lions Packers");
					entries.add("Texans Jaguars Texans");
					entries.add("Chiefs Chargers Chargers");
					entries.add("Dolphins Jets Dolphins");
					entries.add("Vikings Bears Vikings");
					entries.add("Patriots Bills Patriots");
					entries.add("Giants Eagles Eagles");
					entries.add("Steelers Bengals Bengals");
					entries.add("49ers Cardinals Cardinals");
					entries.add("Seahawks Rams Seahawks");
					entries.add("Buccaneers Saints Saints");
					entries.add("Titans Colts Titans");
					entries.add("Redskins Cowboys Redskins"); break;
				default: System.out.println("ERROR: Season2014Data"); break;
			}
			
			Collections.sort(entries);
					
			for(int i=0; i<entries.size(); ++i){
				String entry = entries.get(i);
				String[] splitEntry = entry.split(" ");
				data.get(0).add(splitEntry[0]);
				data.get(1).add(splitEntry[1]);
				data.get(2).add(splitEntry[2]);				
			}
			entries.clear();
			season2014.put(""+week+"",data);
		}		
	}
	
	private void load2015SeasonData() {
		for(int week=1;week<18;++week){
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
			data.add(new ArrayList<String>()); // Column 0 = Home
			data.add(new ArrayList<String>()); // Column 1 = Away
			data.add(new ArrayList<String>()); // Column 2 = Prediction
			ArrayList<String> entries = new ArrayList<String>();
			switch(week){
				case 1:
					entries.add("Cardinals Saints Cardinals");
					entries.add("Falcons Eagles Eagles");
					entries.add("Bills Colts Bills");
					entries.add("Bears Packers Bears");
					entries.add("Cowboys Giants Giants");
					entries.add("Broncos Ravens Broncos");
					entries.add("Texans Chiefs Chiefs");
					entries.add("Jaguars Panthers Jaguars");
					entries.add("Patriots Steelers Patriots");
					entries.add("Jets Browns Jets");
					entries.add("Raiders Bengals Bengals");
					entries.add("Chargers Lions Lions");
					entries.add("49ers Vikings Vikings");
					entries.add("Rams Seahawks Seahawks");
					entries.add("Buccaneers Titans Buccaneers");
					entries.add("Redskins Dolphins Redskins"); break;
				case 2:
					entries.add("Bills Patriots Bills");
					entries.add("Panthers Texans Panthers");
					entries.add("Bears Cardinals Bears");
					entries.add("Bengals Chargers Bengals");
					entries.add("Browns Titans Browns");
					entries.add("Packers Seahawks Packers");
					entries.add("Colts Jets Jets");
					entries.add("Jaguars Dolphins Jaguars");
					entries.add("Chiefs Broncos Chiefs");
					entries.add("Vikings Lions Lions");
					entries.add("Saints Buccaneers Buccaneers");
					entries.add("Giants Falcons Giants");
					entries.add("Raiders Ravens Raiders");
					entries.add("Eagles Cowboys Eagles");
					entries.add("Steelers 49ers 49ers");
					entries.add("Redskins Rams Redskins"); break;
				case 3:
					entries.add("Cardinals 49ers Cardinals");
					entries.add("Ravens Bengals Bengals");
					entries.add("Panthers Saints Panthers");
					entries.add("Browns Raiders Browns");
					entries.add("Cowboys Falcons Falcons");
					entries.add("Lions Broncos Lions");
					entries.add("Packers Chiefs Chiefs");
					entries.add("Texans Buccaneers Texans");
					entries.add("Dolphins Bills Bills");
					entries.add("Vikings Chargers Vikings");
					entries.add("Patriots Jaguars Jaguars");
					entries.add("Giants Redskins Redskins");
					entries.add("Jets Eagles Eagles");
					entries.add("Seahawks Bears Bears");
					entries.add("Rams Steelers Steelers");
					entries.add("Titans Colts Titans"); break;
				case 4:
					entries.add("Cardinals Rams Cardinals");
					entries.add("Falcons Texans Falcons");
					entries.add("Bills Giants Bills");
					entries.add("Bears Raiders Bears");
					entries.add("Bengals Chiefs Chiefs");
					entries.add("Broncos Vikings Broncos");
					entries.add("Colts Jaguars Jaguars");
					entries.add("Dolphins Jets Jets");
					entries.add("Saints Cowboys Cowboys");
					entries.add("Steelers Ravens Steelers");
					entries.add("Chargers Browns Browns");
					entries.add("49ers Packers Packers");
					entries.add("Seahawks Lions Lions");
					entries.add("Buccaneers Panthers Panthers");
					entries.add("Redskins Eagles Eagles"); break;
				case 5:
					entries.add("Falcons Redskins Redskins");
					entries.add("Ravens Browns Browns");
					entries.add("Bengals Seahawks Bengals");
					entries.add("Cowboys Patriots Patriots");
					entries.add("Lions Cardinals Lions");
					entries.add("Packers Rams Packers");
					entries.add("Texans Colts Texans");
					entries.add("Chiefs Bears Bears");
					entries.add("Giants 49ers Giants");
					entries.add("Raiders Broncos Broncos");
					entries.add("Eagles Saints Eagles");
					entries.add("Chargers Steelers Chargers");
					entries.add("Buccaneers Jaguars Buccaneers");
					entries.add("Titans Bills Bills"); break;
				case 6:
					entries.add("Bills Bengals Bills");
					entries.add("Browns Broncos Browns");
					entries.add("Lions Bears Lions");
					entries.add("Packers Chargers Packers");
					entries.add("Colts Patriots Colts");
					entries.add("Jaguars Texans Jaguars");
					entries.add("Vikings Chiefs Chiefs");
					entries.add("Saints Falcons Falcons");
					entries.add("Jets Redskins Jets");
					entries.add("Eagles Giants Eagles");
					entries.add("Steelers Cardinals Cardinals");
					entries.add("49ers Ravens 49ers");
					entries.add("Seahawks Panthers Seahawks");
					entries.add("Titans Dolphins Titans"); break;
				case 7:
					entries.add("Cardinals Ravens Cardinals");
					entries.add("Panthers Eagles Eagles");
					entries.add("Lions Vikings Lions");
					entries.add("Colts Saints Colts");
					entries.add("Jaguars Bills Bills");
					entries.add("Chiefs Steelers Chiefs");
					entries.add("Dolphins Texans Dolphins");
					entries.add("Patriots Jets Jets");
					entries.add("Giants Cowboys Giants");
					entries.add("Chargers Raiders Chargers");
					entries.add("49ers Seahawks Seahawks");
					entries.add("Rams Browns Browns");
					entries.add("Titans Falcons Titans");
					entries.add("Redskins Buccaneers Redskins"); break;
				case 8:
					entries.add("Falcons Buccaneers Falcons");
					entries.add("Ravens Chargers Chargers");
					entries.add("Panthers Colts Panthers");
					entries.add("Bears Vikings Bears");
					entries.add("Browns Cardinals Browns");
					entries.add("Cowboys Seahawks Seahawks");
					entries.add("Broncos Packers Broncos");
					entries.add("Texans Titans Texans");
					entries.add("Chiefs Lions Lions");
					entries.add("Patriots Dolphins Dolphins");
					entries.add("Saints Giants Giants");
					entries.add("Raiders Jets Jets");
					entries.add("Steelers Bengals Bengals");
					entries.add("Rams 49ers 49ers"); break;
				case 9:
					entries.add("Bills Dolphins Bills");
					entries.add("Panthers Packers Panthers");
					entries.add("Bengals Browns Bengals");
					entries.add("Cowboys Eagles Eagles");
					entries.add("Colts Broncos Broncos");
					entries.add("Vikings Rams Vikings");
					entries.add("Patriots Redskins Redskins");
					entries.add("Saints Titans Titans");
					entries.add("Jets Jaguars Jets");
					entries.add("Steelers Raiders Steelers");
					entries.add("Chargers Bears Bears");
					entries.add("49ers Falcons 49ers");
					entries.add("Buccaneers Giants Buccaneers"); break;
				case 10:
					entries.add("Ravens Jaguars Jaguars");
					entries.add("Bengals Texans Bengals");
					entries.add("Broncos Chiefs Chiefs");
					entries.add("Packers Lions Lions");
					entries.add("Giants Patriots Giants");
					entries.add("Jets Bills Jets");
					entries.add("Raiders Vikings Vikings");
					entries.add("Eagles Dolphins Eagles");
					entries.add("Steelers Browns Browns");
					entries.add("Seahawks Cardinals Seahawks");
					entries.add("Rams Bears Bears");
					entries.add("Buccaneers Cowboys Buccaneers");
					entries.add("Titans Panthers Panthers");
					entries.add("Redskins Saints Redskins"); break;
				case 11:
					entries.add("Cardinals Bengals Bengals");
					entries.add("Falcons Colts Falcons");
					entries.add("Ravens Rams Ravens");
					entries.add("Panthers Redskins Redskins");
					entries.add("Bears Broncos Bears");
					entries.add("Lions Raiders Lions");
					entries.add("Texans Jets Jets");
					entries.add("Jaguars Titans Jaguars");
					entries.add("Dolphins Cowboys Dolphins");
					entries.add("Vikings Packers Vikings");
					entries.add("Patriots Bills Bills");
					entries.add("Eagles Buccaneers Eagles");
					entries.add("Chargers Chiefs Chiefs");
					entries.add("Seahawks 49ers Seahawks"); break;
				case 12:
					entries.add("Falcons Vikings Vikings");
					entries.add("Bengals Rams Bengals");
					entries.add("Browns Ravens Browns");
					entries.add("Cowboys Panthers Panthers");
					entries.add("Broncos Patriots Broncos");
					entries.add("Lions Eagles Lions");
					entries.add("Packers Bears Bears");
					entries.add("Texans Saints Texans");
					entries.add("Colts Buccaneers Colts");
					entries.add("Jaguars Chargers Jaguars");
					entries.add("Chiefs Bills Chiefs");
					entries.add("Jets Dolphins Jets");
					entries.add("49ers Cardinals 49ers");
					entries.add("Seahawks Steelers Seahawks");
					entries.add("Titans Raiders Titans");
					entries.add("Redskins Giants Redskins"); break;
				case 13:
					entries.add("Bills Texans Bills");
					entries.add("Bears 49ers Bears");
					entries.add("Browns Bengals Browns");
					entries.add("Lions Packers Lions");
					entries.add("Dolphins Ravens Dolphins");
					entries.add("Vikings Seahawks Vikings");
					entries.add("Patriots Eagles Eagles");
					entries.add("Saints Panthers Panthers");
					entries.add("Giants Jets Jets");
					entries.add("Raiders Chiefs Chiefs");
					entries.add("Steelers Colts Steelers");
					entries.add("Chargers Broncos Chargers");
					entries.add("Rams Cardinals Cardinals");
					entries.add("Buccaneers Falcons Buccaneers");
					entries.add("Titans Jaguars Jaguars");
					entries.add("Redskins Cowboys Redskins"); break;
				case 14:
					entries.add("Cardinals Vikings Cardinals");
					entries.add("Ravens Seahawks Seahawks");
					entries.add("Panthers Falcons Panthers");
					entries.add("Bears Redskins Bears");
					entries.add("Bengals Steelers Bengals");
					entries.add("Browns 49ers Browns");
					entries.add("Broncos Raiders Broncos");
					entries.add("Packers Cowboys Packers");
					entries.add("Texans Patriots Texans");
					entries.add("Jaguars Colts Jaguars");
					entries.add("Chiefs Chargers Chiefs");
					entries.add("Dolphins Giants Dolphins");
					entries.add("Jets Titans Jets");
					entries.add("Eagles Bills Eagles");
					entries.add("Rams Lions Lions");
					entries.add("Buccaneers Saints Buccaneers"); break;
				case 15:
					entries.add("Ravens Chiefs Chiefs");
					entries.add("Cowboys Jets Jets");
					entries.add("Colts Texans Colts");
					entries.add("Jaguars Falcons Jaguars");
					entries.add("Vikings Bears Bears");
					entries.add("Patriots Titans Patriots");
					entries.add("Saints Lions Lions");
					entries.add("Giants Panthers Panthers");
					entries.add("Raiders Packers Packers");
					entries.add("Eagles Cardinals Eagles");
					entries.add("Steelers Broncos Broncos");
					entries.add("Chargers Dolphins Chargers");
					entries.add("49ers Bengals Bengals");
					entries.add("Seahawks Browns Seahawks");
					entries.add("Rams Buccaneers Buccaneers");
					entries.add("Redskins Bills Redskins"); break;
				case 16:
					entries.add("Cardinals Packers Cardinals");
					entries.add("Falcons Panthers Panthers");
					entries.add("Ravens Steelers Ravens");
					entries.add("Bills Cowboys Bills");
					entries.add("Broncos Bengals Broncos");
					entries.add("Lions 49ers Lions");
					entries.add("Chiefs Browns Chiefs");
					entries.add("Dolphins Colts Dolphins");
					entries.add("Vikings Giants Vikings");
					entries.add("Saints Jaguars Jaguars");
					entries.add("Jets Patriots Jets");
					entries.add("Raiders Chargers Chargers");
					entries.add("Eagles Redskins Eagles");
					entries.add("Seahawks Rams Seahawks");
					entries.add("Buccaneers Bears Bears");
					entries.add("Titans Texans Titans"); break;
				case 17:
					entries.add("Cardinals Seahawks Seahawks");
					entries.add("Falcons Saints Falcons");
					entries.add("Bills Jets Bills");
					entries.add("Panthers Buccaneers Panthers");
					entries.add("Bears Lions Bears");
					entries.add("Bengals Ravens Bengals");
					entries.add("Browns Steelers Browns");
					entries.add("Cowboys Redskins Redskins");
					entries.add("Broncos Chargers Broncos");
					entries.add("Packers Vikings Packers");
					entries.add("Texans Jaguars Texans");
					entries.add("Colts Titans Colts");
					entries.add("Chiefs Raiders Chiefs");
					entries.add("Dolphins Patriots Dolphins");
					entries.add("Giants Eagles Eagles");
					entries.add("49ers Rams 49ers"); break;
				default: System.out.println("ERROR: Season2015Data"); break;
			}
			
			Collections.sort(entries);
					
			for(int i=0; i<entries.size(); ++i){
				String entry = entries.get(i);
				String[] splitEntry = entry.split(" ");
				data.get(0).add(splitEntry[0]);
				data.get(1).add(splitEntry[1]);
				data.get(2).add(splitEntry[2]);				
			}
			entries.clear();
			season2015.put(""+week+"",data);
		}		
	}
}