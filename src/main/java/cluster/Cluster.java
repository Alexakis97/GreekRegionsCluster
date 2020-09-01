package cluster;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Cluster {

		
	HashMap<String,ArrayList<Boundary>> map;
	
	   private static Cluster instance = new Cluster();
	
	private Cluster ()
	{
		System.out.println("Cluster Created");

	}
	
	public static Cluster getInstance(){
	      return instance;
	   }
	
	
	public boolean loadCluster()
	{
		String path = "Periferies-LatLong.json";
		JSONObject allData;
		try {
		InputStream inputStream = null;
		Scanner sc = null;
		StringBuilder data = new StringBuilder();
		try {
			inputStream = getClass().getResourceAsStream(path);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				data.append(line);
				// System.out.println(line);
			}
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
			System.out.println("Cluster ready to be used");
			allData = new JSONObject(data.toString());

		}
		}catch(Exception e)
		{
			System.out.print(e);
			return false;
		}

		// JSONObject jsonData = new JSONObject(data);

		JSONArray features = (JSONArray) allData.get("features");

		
		map = new HashMap();

		for (Object periferies : features) {
			JSONObject periferia = (JSONObject) (periferies);

			JSONObject properties = periferia.getJSONObject("properties");

			String onomasiaPeriferias = (String) properties.get("PER");

			JSONObject geometry = periferia.getJSONObject("geometry");

			JSONArray coordinates = geometry.getJSONArray("coordinates");
			ArrayList<Boundary> b = new ArrayList<Boundary>();

			for (Object insideCoord : coordinates) {
				JSONArray incoord = (JSONArray) insideCoord;

				JSONArray zeroCoord = (JSONArray) incoord.get(0);
				
				Boundary boundary = new Boundary();
				boundary.initPointSize(zeroCoord.length());
				for (Object boun : zeroCoord) {
					JSONArray bound = (JSONArray) boun;

					double x = (Double) bound.get(1);
					double y = (Double) bound.get(0);

					Point p = new Point(x, y);

					boundary.loadPoint(p);
					
					// System.out.println(p);

				}
				b.add(boundary);
				

			}
			map.put(onomasiaPeriferias, b);
		}
		return true;
	}
	
	public String getClusterFeature(Point p)
	{
		
		 Iterator it = map.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        
		        ArrayList<Boundary> temp = (ArrayList<Boundary>) pair.getValue();
		        
		       	for(Boundary bound:temp)
		        	{
		        		if(bound.contains(p))
		        			return  (String) pair.getKey();
		        		
		        	
		        	}
		        
		    }
			return null;	
	}
	
	
	
	
	

}


