package cluster;

import java.util.Arrays;

public class Boundary {
	
	public Boundary()
	{
	}
    private  Point[] points ; // Points making up the boundary
    private int point_counter=0;
    public boolean contains(Point test) {
      int i;
      int j;
      boolean result = false;
      for (i = 0, j = points.length - 1; i < points.length; j = i++) {
        if ((points[i].y > test.y) != (points[j].y > test.y) &&
            (test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
          result = !result;
         }
      }
      return result;
    }
    
    public boolean initPointSize(int size)
    {
    	points = new Point[size];
    	return true;
    }
    
    public boolean loadPoint(Point point)
    {
    	points[point_counter] = point;
    	point_counter++;
    	//System.out.println("Point Loaded: "+point);
    	return true;
    }
    
    public Point[] getPoints()
    {
    	return points;
    }

	@Override
	public String toString() {
		return "Boundary [points=" + Arrays.toString(points) + ", point_counter=" + point_counter + "]";
	}
    
    
    
    
}