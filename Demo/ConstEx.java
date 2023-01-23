package com.java.Demo;

 class Examplee{
	String channel;
	Examplee(){
		channel="Telugu Web Guru";
		
	}
	Examplee(String s){
		channel="s";
		
	}
}


 class ConstEx {
	public static void main(String[] args) {
		Examplee e = new Examplee();
		System.out.println("channel name in e object is :" +e.channel);
		
		Examplee e1 = new Examplee("santhosh");
		System.out.println("channel name e1 object is :" +e1.channel);
			
	}

}
