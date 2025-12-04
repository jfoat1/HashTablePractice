package driver;

public class HashTable 
{	
	public HashValue[] list;
	public int size; 
	
	public HashTable(int size)
	{
		this.list = new HashValue[size];
		this.size = size; 
		for(int i = 0; i < this.size; i++)
		{
			list[i] = new HashValue(); 
		}
	}
	
	public void print()
	{
		System.out.print(this.list[0].getValue());
		for(int i = 1; i < this.size; i++)
		{
			System.out.print("," + this.list[i].getValue());
		}
		System.out.println();
	}
	
	public int getHashing(int value)
	{
		return value % this.size; 
	}
	
	public void resize()
	{
		int counter = 0;
		for(int i = 0; i < this.size; i++)
		{
			if(list[i].getState() == HashValue.State.full)
			{
				counter++;
			}
		}
		if(counter > size * 0.7)
		{
			HashValue[] oldlist = this.list;
			int oldsize = size;
			this.size = size * 2;
			HashValue[] newlist = new HashValue[size];
			for(int i = 0; i < this.size; i++)
			{
				newlist[i] = new HashValue(); 
			}
			this.list = newlist;  
			for(int i = 0; i < oldsize; i++)
			{
				if(oldlist[i].getState() == HashValue.State.full)
				{
					this.add(oldlist[i].getValue());
				}
			}
		} 
	}
	
	public void add(int value)
	{
		int index = this.getHashing(value);
		int temp = index; 
		if(this.list[index].getState() == HashValue.State.empty_since_start || this.list[index].getState() == HashValue.State.empty_after_delete)
		{
			list[index].setValue(value);
			list[index].setState(HashValue.State.full);
			this.resize();
		}
		else
		{
			index++; 
			while(index != temp)
			{
				if(index == size)
				{
					index = 0; 
				}
				if(this.list[index].getState() == HashValue.State.empty_since_start || this.list[index].getState() == HashValue.State.empty_after_delete)
				{
					list[index].setValue(value);
					list[index].setState(HashValue.State.full);
					this.resize();
					return;
				}
				index++;
			}
		}
	}
	
	public int get(int value)
	{
		int index = this.getHashing(value);
		int temp = index; 
		if(this.list[index].getState() == HashValue.State.empty_since_start)
		{
			System.out.println("not on list");
			return -1; 
		}
		else if(this.list[index].getValue() == value)
		{
			return index; 
		}
		else
		{
			if(index == size - 1)
			{
				index = 0; 
			}
			else 
			{
				index++; 
			}
			while(!(this.list[index].getState() == HashValue.State.empty_since_start))
			{
				if(this.list[index].getValue() == value)
				{
					return index; 
				}
				if(index == size - 1)
				{
					index = 0; 
				}
				else
				{
					index++;
				}
			}
			System.out.println("not on list");
			return -1; 
		}
	}
	
	public void remove(int value)
	{
		int index = this.get(value);
		if(index != -1)
		{
			this.list[index].setValue(0);
			this.list[index].setState(HashValue.State.empty_after_delete);
		}
	}
}
