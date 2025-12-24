package Exception_Handling;
import java.io.FileReader;
public class basic_problem {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        // System.out.println(4 / 0); // runtime exception....
        System.out.println(5);
        System.out.println(6);

        int [] arr = {1,2};
        // FileReader f1;
        // try {
        //     // FileReader f1 = new FileReader("abc.txt"); // compile time exception....

        //     System.out.println(4/0);
        // } catch(ArithmeticException ae){
        //     System.out.println(ae);
        // } catch(Exception e){ // parent class
        //     System.out.println(e);
        // }

//         // multi-catch block concept
//         try {
//             // FileReader f1 = new FileReader("abc.txt"); // compile time exception....

//             // System.out.println(4/0);
//             System.out.println(arr[3]);
//         } catch(ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e){
//             System.out.println(e);
//         }

//         // }catch(Exception e){
//         //     System.out.println(e.getMessage());
//         // }finally{
//         //     // f1.close;
//         //     System.out.println("Hi I am finally! ");
//         // }



//         // int [] arr = {1,2};
//         // System.out.println(arr[3]);

//         String l = null;
//         System.out.println(l.length());
        
//         // Error 
//         // ArrayList<Integer>ai = new ArrayList<>();
//         // while(true) {
//         //    ai.add(1);
//         // }
//     }
// }
























// package Exception_Handling;
// import java.io.BufferedReader;
// import java.io.FileReader;
// public class basic_problem {
//     public static void main(String[] args) {
//         System.out.println(1);
//         System.out.println(2);
//         System.out.println(3);
//         // System.out.println(4 / 0); // runtime exception....
//         System.out.println(5);
//         System.out.println(6);

//         int [] arr = {1,2};
//         // multi-catch block concept
//         //
//         try(FileReader f1 = new FileReader("abc.txt");
//             BufferedReader bf = new BufferedReader(f1)){
//                 String line;
//                 while((line = bf.readLine())!=null){
//                     System.out.println(line);
//                 }
//             // System.out.println(4/0);
//             System.out.println(arr[3]);
//         } catch(Exception e){
//             System.out.println(e);
//         }

//         // }catch(Exception e){
//         //     System.out.println(e.getMessage());
//         // }finally{
//         //     // f1.close;
//         //     System.out.println("Hi I am finally! ");
//         // }



//         // int [] arr = {1,2};
//         // System.out.println(arr[3]);

//         // String l = null;
//         // System.out.println(l.length());
        
//         // Error 
//         // ArrayList<Integer>ai = new ArrayList<>();
//         // while(true) {
//         //    ai.add(1);
//         // }
//     }
// }











// Use of throw

// package Exception_Handling;
// import java.io.FileReader;
// class MyException extends Exception{
//     MyException(String msg){
//         super(msg);
//     }
// }

// class Papu{
//     static void fail(int marks) throws MyException{
//         if(marks<30){
//             throw new MyException("Papu fail ho gya!!");
//         }
//     }
// }
// public class basic_problem {
//     public static void FileRead() throws Exception{
//         FileReader f1 = new FileReader("abc.txt");
//     }
//     public static void main(String[] args) throws Exception{
//         System.out.println(1);
//         System.out.println(2);
//         System.out.println(3);
//         // System.out.println(4 / 0); // runtime exception....
//         System.out.println(5);
//         System.out.println(6);

//         // throw new Exception("Ha bhai,aukat me rhna ka!!");

//         try {
//             Papu.fail(20);
//         }catch(MyException e){
//             System.out.println(e);
//         }

        // Papu.fail(20);
        // int [] arr = {1,2};
        // FileReader f1 = new FileReader("abc.txt");
        // multi-catch block concept
        //
        // try(FileReader f1 = new FileReader("abc.txt");
        //     BufferedReader bf = new BufferedReader(f1)){
        //         String line;
        //         while((line = bf.readLine())!=null){
        //             System.out.println(line);
        //         }
        //     // System.out.println(4/0);
        //     System.out.println(arr[3]);
        // } catch(Exception e){
        //     System.out.println(e);
        // }

        // }catch(Exception e){
        //     System.out.println(e.getMessage());
        // }finally{
        //     // f1.close;
        //     System.out.println("Hi I am finally! ");
        // }



        // int [] arr = {1,2};
        // System.out.println(arr[3]);

        // String l = null;
        // System.out.println(l.length());
        
        // Error 
        // ArrayList<Integer>ai = new ArrayList<>();
        // while(true) {
        //    ai.add(1);
        // }
    }
}

