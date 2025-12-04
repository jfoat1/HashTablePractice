package driver;

public class Main {

	public static void main(String[] args) 
	{
		HashTable hash = new HashTable(10);
		System.out.println("Empty hash table of size 10:");
		hash.print();
		hash.add(68);
		hash.add(78);
		hash.add(77);
		hash.add(118);
		hash.add(128);
		hash.add(133);
		hash.add(144);
		System.out.println("After adding 68, 78, 77, 118, 128, 133, 144:");
		hash.print();
		hash.add(144);
		System.out.println("After adding 157 and resizing as a result:");
		hash.print();
		System.out.println("After getting 68:");
		System.out.println(hash.get(68));
		System.out.println("After getting 10000:");
		System.out.println(hash.get(10000));
		hash.remove(118);
		System.out.println("After removing 118:");
		hash.print();
		hash.get(78);
		System.out.println("After getting 78, it should be at index 18 but will read");
		System.out.println("empty_after_delete and continue looking:");
		System.out.println(hash.get(78));
	}

}
