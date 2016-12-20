package singlemodel;

import java.util.*;
public class MapTest {

	Map<String,String> map=new HashMap<String, String>();
	
	Map<String, String> maps=Collections.synchronizedMap(new HashMap<String, String>());
    Hashtable< String, String> h=new Hashtable<String, String>();	
    
    public static void main(String[] args) {
    	final Map<String,String> map=new HashMap<String, String>();
    	for(int i=0;i<1000;i++){
    		map.put(""+i, "aaa"+i);
    	}	
    	final Iterator<String> iterator=map.keySet().iterator();
    	new Thread(
    			new Runnable() {
					
					@Override
					public void run() {
						while(iterator.hasNext()){
				    		//map.put("a", "bbb");
				    		String key=iterator.next();
				    		String value=map.get(key);
				    		System.out.println("key="+key+"  value="+value);
				    	}	
						
					}
				}
    			);
    	
    
    	
    	final Hashtable<String,String> table=new Hashtable<String, String>();
    	for(int i=0;i<1000;i++){
    		table.put(""+i, "bbb"+i);
    	}	
    	final Iterator<String> iterator2=table.keySet().iterator();
    	MyThread myThread=new MyThread();
    	
    	new Thread(
    			new Runnable() {
					
					@Override
					public void run() {
    	while(iterator2.hasNext()){
    		String key=iterator2.next();
    		String value=table.get(key);
    		System.out.println("key="+key+"  value="+value);
    	}
	}
					}
				
    			).start();
    
}
    
    
}
class MyThread extends Thread{
	@Override
	public void run() {
		
	}
	
}


