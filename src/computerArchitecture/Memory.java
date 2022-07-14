package computerArchitecture;

import java.util.*;

public class Memory {
int[] cell;

public Memory(int CAP)
{
	
	 cell= new int[CAP];
}

public Memory()
{
	cell= new int[256];
}
public int Read(int addr)
{

	return this.cell[addr];


}
public void write(int addr, int data)
{

	this.cell[addr]=data;
	
}

public double[] dump()
{
	double[]arr= new double[256];
	for(int i=0;i< arr.length;i++)
	{
			arr[i]=this.cell[i];
	}
	return arr;
}


}
