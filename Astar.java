package assignment04;
import java.util.*;
enum Status 
{
	WALL, START, GOAL, PATH, AGENT, EMPTY
}
public class Astar {

	public static void main(String[] args) {
		// Auto-generated method stub
		
		node[][] nodes = new node[15][15];
		// code from https://www.w3schools.com/java/java_user_input.asp
		Scanner in = new Scanner(System.in);  // Create a Scanner object
	    System.out.print("Enter start x: ");
		int startX = in.nextInt();
		System.out.print("Enter start y: ");
		int startY = in.nextInt();
		System.out.print("Enter goal x : ");
		int goalX = in.nextInt();
		System.out.print("Enter goal y : ");
		int goalY = in.nextInt();
		in.close();
		int X = startX;
		int Y = startY;
		node goalNode = null;
		node tempNode = null;
		PriorityQueue<node> pq = new 
	             PriorityQueue<node>(11, new nodeComparator());
		//populate all nodes and find start/goal/walls
		for(int i = 0; i <= 14; i++)
		{
			for (int j = 0; j <= 14; j++)
			{
				nodes[j][i] = new node(j, i);
				nodes[j][i].H = Math.abs(goalX - j) + Math.abs(goalY - i);
				int R = (int) (Math.random() * 10);
				if (R >=9)
				{
					nodes[j][i].status = Status.WALL;
				}else {
					nodes[j][i].status = Status.EMPTY;
				}
			}
		}
		//user input for start and end
		nodes[goalX][goalY].status = Status.GOAL;
		nodes[X][Y].status = Status.START;
		//implements A*
		boolean pathFound = false;
		boolean noPath = false;
		pq.add(nodes[X][Y]);
		drawGrid(nodes);
		
		while(!noPath && !pathFound) {
			
			node searchedNode = pq.poll();
			if (searchedNode.status == Status.GOAL) {
				pathFound = true;
				goalNode = searchedNode;
			}
			
			if (!pathFound) {
				searchedNode.status = Status.AGENT;
				drawGrid(nodes);
				searchedNode.status = Status.EMPTY;
			}
			X = searchedNode.X;
			Y = searchedNode.Y;
			if (X-1 >=0 && nodes[X-1][Y].status != Status.WALL) {
				tempNode = nodes[X-1][Y];
				if (!tempNode.visited) {
					tempNode.lastNode = searchedNode;
					tempNode.D = searchedNode.D + 1;
					//tempNode.D = g;
					tempNode.visited = true;
					pq.add(tempNode);
				}
			}
			if (X+1 <= 14 && nodes[X+1][Y].status != Status.WALL) {
				tempNode = nodes[X+1][Y];
				if (!tempNode.visited) {
					tempNode.lastNode = searchedNode;
					tempNode.D = searchedNode.D + 1;
					//tempNode.D = g;
					tempNode.visited = true;
					pq.add(tempNode);
				}
			}
			if (Y-1 >=0 && nodes[X][Y-1].status != Status.WALL) {
				tempNode = nodes[X][Y-1];
				if (!tempNode.visited) {
					tempNode.lastNode = searchedNode;
					tempNode.D = searchedNode.D + 1;
					//tempNode.D = g;
					tempNode.visited = true;
					pq.add(tempNode);
				}
			}
			if (Y+1 <=14 && nodes[X][Y+1].status != Status.WALL) {
				tempNode = nodes[X][Y+1];
				if (!tempNode.visited) {
					tempNode.lastNode = searchedNode;
					tempNode.D = searchedNode.D + 1;
					//tempNode.D = g;
					tempNode.visited = true;
					pq.add(tempNode);
				}
			}
			if (pq.isEmpty()) {
				noPath = true;
			}
		}
		//prints path if one was found
		if (pathFound) {
			while (goalNode.X != startX || goalNode.Y != startY) {
				goalNode.lastNode.status = Status.PATH;
				goalNode = goalNode.lastNode;
			}
			System.out.println();
			drawGrid(nodes);
		} else {
			System.out.println("no path found");
		}
	}
	public static void drawGrid(node[][] nodes) {
		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				if (nodes[j][i].status == Status.WALL)
				{
					System.out.print("W ");
				}
				else if(nodes[j][i].status == Status.START)
				{
					System.out.print("S ");
				}
				else if(nodes[j][i].status == Status.GOAL)
				{
					System.out.print("G ");
				}
				else if(nodes[j][i].status == Status.PATH)
				{
					System.out.print("* ");
				}
				else if(nodes[j][i].status == Status.AGENT)
				{
					System.out.print("A ");
				}
				else if(nodes[j][i].status == Status.EMPTY)
				{
					System.out.print("E ");
				}
			}
			System.out.println();
		}
		

		System.out.println();
		System.out.println();
		System.out.println();
	}


}