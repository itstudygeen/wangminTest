import java.util.Hashtable;

public class TableClass {
     
   public static final Hashtable<String, String> firstHashtable=new Hashtable<String, String>();
   
    public static void main(String[] args) throws InterruptedException {
        
        //�߳�һ
        Thread t1=new Thread(){
            public void run() {
                for(int i=0;i<25;i++){
                  firstHashtable.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };
       
        //�̶߳�
        Thread t2=new Thread(){
            public void run() {
                for(int j=25;j<50;j++){
                    firstHashtable.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };
       
        t1.start();
        t2.start();
        
        //���߳�����1���ӣ��Ա�t1��t2�����߳̽�firstHashtable��װ��ϡ�
       Thread.currentThread().sleep(1000);
        
        for(int l=0;l<50;l++){
            //���key��value��ͬ��˵���������߳�put�Ĺ����г����쳣��
            if(!String.valueOf(l).equals(firstHashtable.get(String.valueOf(l)))){
               System.err.println(String.valueOf(l)+":"+firstHashtable.get(String.valueOf(l)));
            }
        }
        
    }

}