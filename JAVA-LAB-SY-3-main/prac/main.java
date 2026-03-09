import java.util.Scanner;

public class main{
    public static void main(String [] args){
        System.out.println("hello world");
        int age =19;
        System.out.println(age);
        System.out.println("THE AGE IS:" + age);

        boolean isStudent = true ;
        System.out.println(isStudent);

        if(isStudent){
            System.out.println("good student you are!");
        }

        String name ="atharv kate";
          System.out.println("hello" + name);

        Scanner scanner=new Scanner(System.in);

        System.out.println("ENTER AURA FARMED:");
        int aura=scanner.nextInt();
        System.out.println(aura); 

        //imp step to clear buffer 
        scanner.nextLine();

        System.out.println("ENTER BSTY :");
        String biatch=scanner.nextLine();
        System.out.println(biatch);


        scanner.close();
    }
}