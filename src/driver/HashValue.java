package driver;

public class HashValue {
	
	public enum State
	{
		empty_since_start,
		empty_after_delete,
		full
	}
	
	private int value;
	private State state;
	
	public HashValue()
	{
		this.value = 0;
		this.state = State.empty_since_start;
	}
	
	public void setValue(int value)
	{
		this.value = value;  
	}
	
	public void setState(State state)
	{
		this.state = state; 
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public State getState()
	{
		return this.state;
	}
}
