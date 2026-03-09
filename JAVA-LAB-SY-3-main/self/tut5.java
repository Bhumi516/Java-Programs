
import java.util.Scanner;



//     public static void MyName(String name){
//         System.out.println(name);

//     }
//     public static void main(String[] args) {
//         Scanner cin =new Scanner(System.in);
//             String name=cin.next();
//             MyName(name);
//     }}

// make a function to insert two numbers and return sum

public class tut5{
    public static int Sum(int num1,int num2){
        int summ=num1+num2;
        return summ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        System.out.println(Sum(num1,num2));
    }
}