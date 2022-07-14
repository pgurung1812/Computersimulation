package computerArchitecture;

public class Processor {
	private int reg[];
	private int PC=0;
	private int IR=0;
	private Memory M= new Memory();
	public Processor(Memory m4)
	{
		reg= new int[8];
		this.M=m4;


	}

	public boolean step()
	{
		IR=M.Read(this.PC);
		while(IR!=0)
		{
			int instr= IR;
			int op;
			op=IR>>8;
			IR=instr;
			int oper1;
			oper1=IR>>4;
			int operand1;
			operand1=oper1&15;
			IR=instr;
			int operand2;
			operand2=IR&15;

			int opcode;
			opcode=op & 15;
			switch(opcode) {

				case 0:

					return false;


				case 1:

					this.reg[operand1]= M.Read(this.reg[operand2]);
					PC++;
					return true;

				case 2:
					int a=this.PC+1;
					this.reg[operand1]= M.Read(a);
					a=a+1;
					PC=a;
					return true;
				case 3:
					M.write(this.reg[operand1], this.reg[operand2]);
					PC++;
					return true;
				case 4:
					this.reg[operand1]= this.reg[operand1]+this.reg[operand2];
					PC++;
					return true;
				case 5:
					this.reg[operand1]= this.reg[operand1]*this.reg[operand2];
					PC++;
					return true;
				case 6:
					this.reg[operand1]= this.reg[operand1]-this.reg[operand2];
					PC++;
					return true;
				case 7:
					this.reg[operand1]= this.reg[operand1]/this.reg[operand2];
					PC++;
					return true;
				case 8:
					if(this.reg[operand1]!=0 && this.reg[operand2]!=0)
					{
						this.reg[operand1]=1;

					}
					else
					{
						this.reg[operand1]=0;

					}
					PC++;
					return true;
				case 9:
					if(this.reg[operand1]!=0 || this.reg[operand2]!=0)
					{
						this.reg[operand1]=1;
					}
					else
					{
						this.reg[operand1]=0;
					}
					PC++;
					return true;
				case 10:
					if(this.reg[operand2]!=0)
					{
						this.reg[operand1]=0;
					}
					else
					{
						this.reg[operand1]=1;
					}
					PC++;
					return true;
				case 11:
					this.reg[operand1]=this.reg[operand2]<<1;
					PC++;
					return true;
				case 12:
					this.reg[operand1]=this.reg[operand2]>>1;
					PC++;
					return true;
				case 13:
					this.reg[operand1]=this.reg[operand1]&this.reg[operand2];
					PC++;
					return true;
				case 14:
					this.reg[operand1]=this.reg[operand1]|this.reg[operand2];
					PC++;
					return true;
				case 15:
					if(this.reg[operand1]!=0)
					{
						this.PC=this.reg[operand2];

					}
					else
					{
						PC++;
					}
					return true;
			}
		}

		return false;
	}

	public int[] dump()
	{
		int[]arr= new int[8];
		for(int i=0;i<8;i++)
		{
			arr[i]=this.reg[i];
		}
		return arr;
	}

	public void setMemory(Memory m)
	{
		this.M= m;
	}

	public void setPC(int a)
	{
		this.PC=a;
	}


}
