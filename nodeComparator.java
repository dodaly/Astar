package assignment04;
import java.util.*;
public class nodeComparator implements Comparator<node> {
	//code based on https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
	public int compare(node n1, node n2) { 
        if (n1.H + n1.D > n2.H + n2.D) 
            return 1; 
        else if(n1.H + n1.D < n2.H + n2.D)
            return -1; 
        else
        	return 0;
	}

}
