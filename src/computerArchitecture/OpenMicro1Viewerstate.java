package computerArchitecture;

import java.io.File;
import java.util.Scanner;

public class OpenMicro1Viewerstate implements Micro1Viewerstate{
Micro1Viewer M;
Memory memory;
Processor cpu;


	
	public OpenMicro1Viewerstate(Micro1Viewer m,Memory m2,Processor p1){
		this.M=m;
		this.memory=m2;
		this.cpu=p1;
	}
	
	public void execute()
	{
		
		 boolean p=cpu.step();

		if(p==true)
		{
			this.M.changeState(new OpenMicro1Viewerstate(this.M,this.memory,this.cpu));
			
			
		}
		else
		{

			this.M.changeState(new ClosedMicro1Viewerstate(this.M,this.memory,this.cpu));
		}

		
	}
	
	
	public void memorydump()
	{

		double[] a= new double[256];
		a= memory.dump();
		String[] s= new String[256];
		for(int i=0;i<s.length;i++)
		{
			s[i]=String.valueOf(a[i]);
		}
		
		M.setvalue(s[100]);
		M.textField_9.setText(s[101]);
		M.textField_10.setText(s[102]);
		M.textField_11.setText(s[103]);


		this.M.changeState(new OpenMicro1Viewerstate(this.M,this.memory,this.cpu));
		
	}
	public void registerdump()
	{
		int[] a= new int[8];
		a= cpu.dump();
		String[] s= new String[8];
		for(int i=0;i<s.length;i++)
		{
			s[i]=String.valueOf(a[i]);
		}
		
		M.textField.setText(s[0]);
		M.textField_1.setText(s[1]);
		M.textField_2.setText(s[2]);
		M.textField_3.setText(s[3]);
		M.textField_4.setText(s[4]);
		M.textField_5.setText(s[5]);
		M.textField_6.setText(s[6]);
		M.textField_7.setText(s[7]);
		this.M.changeState(new OpenMicro1Viewerstate(this.M,this.memory,this.cpu));
		
	}

	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("Invalid button");
		this.M.changeState(new OpenMicro1Viewerstate(this.M,this.memory,this.cpu));
		
	}

	

}
