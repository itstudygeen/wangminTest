package singlemodel;

public class SingleModel {
private static SingleModel singleModel;
private SingleModel(){}
public static synchronized SingleModel getSingleModel(){
	if(singleModel==null){
		singleModel=new SingleModel();	
	}
	return singleModel;
}
}
