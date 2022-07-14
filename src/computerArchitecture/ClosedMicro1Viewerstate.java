package computerArchitecture;



import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public  class ClosedMicro1Viewerstate implements  Micro1Viewerstate {
	Micro1Viewer M;
	Memory memory;
	Processor cpu;
	String line = "";

	//StringBuilder sb;
	public ClosedMicro1Viewerstate(Micro1Viewer m, Memory m1, Processor p) {
		this.M = m;
		this.memory = m1;
		this.cpu = p;
	}

	public void execute() {
		System.out.println("Invalid button");

	}

	public void memorydump() {
		double[] a = new double[256];
		a = memory.dump();
		String[] s = new String[256];
		for (int i = 0; i < s.length; i++) {
			s[i] = String.valueOf(a[i]);
		}

		M.setvalue(s[100]);
		M.textField_9.setText(s[101]);
		M.textField_10.setText(s[102]);
		M.textField_11.setText(s[103]);


	}

	public void registerdump() {
		int[] a = new int[8];
		a = cpu.dump();
		String[] s = new String[8];
		for (int i = 0; i < s.length; i++) {
			s[i] = String.valueOf(a[i]);
		}

		M.textField.setText(s[0]);
		M.textField_1.setText(s[1]);
		M.textField_2.setText(s[2]);
		M.textField_3.setText(s[3]);
		M.textField_4.setText(s[4]);
		M.textField_5.setText(s[5]);
		M.textField_6.setText(s[6]);
		M.textField_7.setText(s[7]);


	}

	public void load() {
		// TODO Auto-generated method stub

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(M);
		if (result == JFileChooser.APPROVE_OPTION) {
			File fileName = fileChooser.getSelectedFile();

			int i = 0;
			StringBuilder sb;
			// File fileName=selectedFile;

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

				sb = new StringBuilder();

				String line;
				while ((line = br.readLine()) != null) {

					sb.append(line);

					if (line != null) {
						sb.append(System.lineSeparator());
					}
				}

				System.out.println(sb);
				String[] lines = sb.toString().split("\\n");
				for (String s : lines) {
					String[] arr= s.split(" ");
					switch(arr[0]) {
						case "load":
							int[] b = {0,0,0,0,0,1,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb2 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b.length; k++) {
								String hexString = Integer.toHexString(b[k]);
								sb2.append(hexString);
							}
							int t= Integer.parseInt(sb2.toString(),16);


							memory.write(i, t);
							i++;
							break;
						case "loadc":

							int[] b0 = {0,0,0,0,0,2,Integer.parseInt(arr[1]),0};
							StringBuffer sb1 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b0.length; k++) {
								String hexString = Integer.toHexString(b0[k]);
								sb1.append(hexString);
							}
							int t0= Integer.parseInt(sb1.toString(),16);
							memory.write(i, t0);
							i++;
							break;
						case "store":
							int[] b1 = {0,0,0,0,0,3,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb3 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b1.length; k++) {
								String hexString = Integer.toHexString(b1[k]);
								sb3.append(hexString);
							}
							int t1= Integer.parseInt(sb3.toString(),16);


							memory.write(i, t1);
							i++;
							break;
						case "add":
							int[] b2 = {0,0,0,0,0,4,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb4 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b2.length; k++) {
								String hexString = Integer.toHexString(b2[k]);
								sb4.append(hexString);
							}
							int t2= Integer.parseInt(sb4.toString(),16);


							memory.write(i, t2);
							i++;
							break;
						case "mul":
							int[] b3 = {0,0,0,0,0,5,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb5 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b3.length; k++) {
								String hexString = Integer.toHexString(b3[k]);
								sb5.append(hexString);
							}
							int t3= Integer.parseInt(sb5.toString(),16);


							memory.write(i, t3);
							i++;
							break;
						case "sub":
							int[] b4 = {0,0,0,0,0,6,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb6 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b4.length; k++) {
								String hexString = Integer.toHexString(b4[k]);
								sb6.append(hexString);
							}
							int t4= Integer.parseInt(sb6.toString(),16);
							memory.write(i, t4);
							i++;
							break;
						case "div":
							int[] b5 = {0,0,0,0,0,7,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb7 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b5.length; k++) {
								String hexString = Integer.toHexString(b5[k]);
								sb7.append(hexString);
							}
							int t5= Integer.parseInt(sb7.toString(),16);
							memory.write(i, t5);
							i++;
							break;
						case "and":
							int[] b6 = {0,0,0,0,0,8,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb8 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b6.length; k++) {
								String hexString = Integer.toHexString(b6[k]);
								sb8.append(hexString);
							}
							int t6= Integer.parseInt(sb8.toString(),16);
							memory.write(i, t6);
							i++;
							break;
						case "or":
							int[] b7 = {0,0,0,0,0,9,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb9 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b7.length; k++) {
								String hexString = Integer.toHexString(b7[k]);
								sb9.append(hexString);
							}
							int t7= Integer.parseInt(sb9.toString(),16);
							memory.write(i, t7);
							i++;
							break;
						case "not":
							int[] b8 = {0,0,0,0,0,10,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb10 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b8.length; k++) {
								String hexString = Integer.toHexString(b8[k]);
								sb10.append(hexString);
							}
							int t8= Integer.parseInt(sb10.toString(),16);
							memory.write(i, t8);
							i++;
							break;
						case "lshift":
							int[] b9 = {0,0,0,0,0,11,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb11 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b9.length; k++) {
								String hexString = Integer.toHexString(b9[k]);
								sb11.append(hexString);
							}
							int t9= Integer.parseInt(sb11.toString(),16);
							memory.write(i, t9);
							i++;
							break;
						case "rshift":
							int[] b10 = {0,0,0,0,0,12,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb12 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b10.length; k++) {
								String hexString = Integer.toHexString(b10[k]);
								sb12.append(hexString);
							}
							int t10= Integer.parseInt(sb12.toString(),16);
							memory.write(i, t10);
							i++;
							break;
						case "bwc":
							int[] b11 = {0,0,0,0,0,13,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb13 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b11.length; k++) {
								String hexString = Integer.toHexString(b11[k]);
								sb13.append(hexString);
							}
							int t11= Integer.parseInt(sb13.toString(),16);
							memory.write(i, t11);
							i++;
							break;
						case "bwd":
							int[] b12 = {0,0,0,0,0,14,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb14 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b12.length; k++) {
								String hexString = Integer.toHexString(b12[k]);
								sb14.append(hexString);
							}
							int t12= Integer.parseInt(sb14.toString(),16);
							memory.write(i, t12);
							i++;
							break;
						case "if":
							int[] b13 = {0,0,0,0,0,15,Integer.parseInt(arr[1]),Integer.parseInt(arr[2])};
							StringBuffer sb15 = new StringBuffer();
							//Converting string to character array
							//char ch[] = b0.toCharArray();
							for(int k = 0; k < b13.length; k++) {
								String hexString = Integer.toHexString(b13[k]);
								sb15.append(hexString);
							}
							int t13= Integer.parseInt(sb15.toString(),16);


							memory.write(i, t13);
							i++;
							break;
						default:
							memory.write(i,Integer.parseInt(s,16));
							i++;
							continue;
					}
				}

			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		//System.out.println(sb);
		this.M.changeState(new OpenMicro1Viewerstate(this.M,this.memory,this.cpu));
	}


}

















