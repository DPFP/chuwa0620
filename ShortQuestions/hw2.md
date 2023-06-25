# 1
1. Encapsulation
```
public class Test{
	private String userName;
	private String password;

	public String getName(){
		return userName;
	}

	public String setName(String name){
		userName = name;
	}

	public String getPW(){
		return userName;
	}

	public String setPW(String pw){
		userName = name;
	}
}
```

2. Polymorphism
```
	class Animal{
		public String name;
		public int age;
		public void shout() {
			System.out.println("aaa");
		}
	}
	
	class cat extends Animal{
		@Override
		public void shout() {
			System.out.println("meow");
		}
	}
```

3. Inheritance
```
	class Animal{
		public String name;
		public int age;

	}
	
	class cat extends Animal{

		public void shout() {
			System.out.println("meow");
		}
	}
```

# 2
Wrapper classes provide a way to use primitive data types ( int , boolean , etc..) as objects.  
Wrapper classes helps Java be completely object-oriented.  

# 3
