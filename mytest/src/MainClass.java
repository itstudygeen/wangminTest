import java.util.HashMap;
import java.util.Iterator;

public class MainClass {
     
   public static final HashMap<String, String> firstHashMap=new HashMap<String, String>();
   
    public static void main(String[] args) throws InterruptedException {
        
        //�߳�һ
        Thread t1=new Thread(){
            public void run() {
                for(int i=0;i<25;i++){
                  firstHashMap.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };
       
        //�̶߳�
        Thread t2=new Thread(){
            public void run() {
                for(int j=25;j<50;j++){
                    firstHashMap.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };
       
        t1.start();
        t2.start();
        
        //���߳�����1���ӣ��Ա�t1��t2�����߳̽�firstHashMap��װ��ϡ�
       Thread.currentThread().sleep(1000);
        
        for(int l=0;l<50;l++){
            //���key��value��ͬ��˵���������߳�put�Ĺ����г����쳣��
        	 System.out.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
            if(!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))){
               System.err.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
            }
        }
        int i=0;
       
       Iterator<String> iterator=firstHashMap.keySet().iterator();
       while (iterator.hasNext()) {
    	  ++ i;
		String string =  iterator.next();
		String mString = firstHashMap.get(string);
		System.out.println("key="+string+  "   value="+mString);
	}
        System.out.println("i="+i);
    }

}