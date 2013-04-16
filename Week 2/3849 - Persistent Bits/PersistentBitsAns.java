import java.util.Arrays;
 import java.util.Scanner;

 public class Main {

     int a;
     int b;
     int c;
     int s;
     int x;
     char[] result;
     int flg;
     boolean[] dup;

     public Main() {
         Scanner scan = new Scanner(System.in);
         while ((a = scan.nextInt()) != 0) {
             b = scan.nextInt();
             c = scan.nextInt();
             s = scan.nextInt();
             result = new char[16];
             Arrays.fill(result, '0');
             initFlg(Integer.toBinaryString(s));
             dup = new boolean[c];
             dup[s] = true;
             x = (a * s + b) % c;
             while (!dup[x]) {
                 dup[x] = true;
                 if (setFlg(Integer.toBinaryString(x))) {
                     break;
                 }
                 x = (a * x + b) % c;
             }
             System.out.println(result);
         }
     }

     public void initFlg(String str) {
         for (int i = 15, k = str.length() - 1; k >= 0; i--, k--) {
             if (str.charAt(k) == '1') {
                 result[i] = '1';
             }
         }
     }

     public boolean setFlg(String str) {
         flg = 0;
         for (int i = 15, k = str.length() - 1; k >= 0; i--, k--) {
             if (result[i] == '?') {
                 flg++;
                 if (flg == 16) {
                     return true;
                 }
                 continue;
             } else {
                 if (str.charAt(k) != result[i]) {
                     result[i] = '?';
                 }
             }
         }
         return false;
     }

     public static void main(String[] args) {
         new Main();
     }

 }