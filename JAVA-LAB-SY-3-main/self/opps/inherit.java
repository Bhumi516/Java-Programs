
import java.lang.classfile.constantpool.ConstantPoolBuilder;

class shape{
    String colour;
    shape(){
    System.out.println(colour);
}}

class triangle extends shape{
    int len;
    int ht;
    // int bth;
    public void area(int len, int ht){
        System.out.println(0.5*len*ht);
    }
}

public class inherit{
    public static void main(String[] args){
        triangle t1 = new triangle();
        t1.colour="red";
        t1.ht=12;
        t1.len=14;
        t1.area(t1.len,t1.ht);
    }
}