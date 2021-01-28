
import static java.lang.System.exit;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIKS
 */
public class task4 {
   static int mutex=1,full=0,empty=3,x=0;
    
    public static void main(String[] args) {
         int n;
         Scanner sc =new Scanner(System.in);
        System.out.println("\\n 1.Producer \\n 2.Consumer \\n 3.Exit");
       //000 while(1){
            System.out.println("\\n Enter your choice:");
        //}
         n = sc.nextInt();
        switch(n)
      {
          case 1:
              if((mutex==1)&&(empty!=0)){
                  producer();
              }
              else
                  System.out.println("Buffer is full");
          break;
          case 2:
              if((mutex==1)&&(full!=0)){
                  consumer();
              }
                  
              else
                  System.out.println("Buffer is empty");
          break;
         case 3:
             exit(0);
             break;
      }
    }
    
static int wait(int s){
    return (--s);
}
static int signal(int s){
    return(++s);
}
static void producer()
{
    mutex=wait(mutex);
    full=signal(full);
    empty=wait(empty);
    x++;
    System.out.println("\n Producer produces the item %d"+x);
    mutex=signal(mutex);
    
}
static void consumer()
{
    mutex=wait(mutex);
    full=wait(full);
    empty=signal(empty);
    System.out.println("\n Consumer consumes item %d"+x);
    x--;
    mutex=signal(mutex);
    
}
 task4(){ }
}
