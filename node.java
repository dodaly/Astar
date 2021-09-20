package assignment04;

public class node {
	//Status status;
	Status status;
	node lastNode;
	boolean visited;
	int X;
	int Y;
	int H;
	int D = 0;
	public node(int x, int y)
	{
		X = x;
		Y = y;
	}
}
