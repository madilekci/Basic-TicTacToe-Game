package tictactoe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Muhammed Ali
 */
public class TicTacToe {
    public static char [][] kayitliOyunAc()throws IOException{
        int boyut=0;
        char harf;
        File fp = new File("kayitliOyun.txt");
        BufferedReader rd = new BufferedReader( new FileReader(fp) );
        boyut=rd.read();
        String text=rd.readLine();
        
        char[][] tablo= new char[boyut][boyut];
        
        rd.close();
        
        int k=0;
        for (int i = 0; i < tablo.length; i++) {
            for (int j = 0; j <tablo.length; j++) {
                tablo[i][j]=text.charAt(k);
                k++;
            }
        }

    return tablo;
    }
    public static void main(String[] args) throws IOException {Scanner sc=new Scanner(System.in);
        int boyut=0;
       tahta t1=null;
       oyuncu o1= null;
       oyuncu b1= null;
       
       if(1==1){        //(1==1) Kayitli dosya varsa diye degistirilmeli.
       System.out.println("Kayitli oyundan devam etmek icin 1 yeni oyun icin 2 giriniz :");
       
        if(sc.nextInt()==1){    //Kayitli oyun icin
            char[][] tablo=kayitliOyunAc();
            System.out.println("Kayitli Oyun Acildi.");
            t1 = new tahta(tablo,tablo.length);
            
            File fp = new File("kayitliOyun.txt");
            BufferedReader rd = new BufferedReader( new FileReader(fp) );
            String text= rd.readLine();
            String[] splitt = text.split("#");
            char harf;
           harf = splitt[1].charAt(0);
            System.out.println("Harfiniz : \" "+harf+" \" ");

            o1=new oyuncu(true,splitt[1].charAt(0));
            if( splitt[1].equals("X") ) {
                splitt[0]="O";
            }
            else {
            splitt[0]="X";
            }
            b1=new oyuncu(false,splitt[0].charAt(0));
        }
        else{                   //Yeni Oyun İcin
            do{
                System.out.println("Tahta boyutunu giriniz : ");
                boyut=sc.nextInt();
                sc.nextLine();
                }while(  (boyut !=3) && (boyut !=5) && (boyut !=7) );
            
                System.out.println(" \"X\" veya \"O\" , istemiyorsanız 1 giriniz.");
                String harf =sc.nextLine();
                
                if( harf.equals("X") || harf.equals("O") ){
                    if( harf.equals("X") ){
                    o1 = new oyuncu(true,'X');
                    b1 = new oyuncu(false,'O');
                    }
                    if( harf.equals("O") ){
                    o1= new oyuncu(true,'O');
                    b1= new oyuncu(false,'X');
                    }
                }
                
                else{
                o1=new oyuncu();
                b1=new oyuncu(false);
                    
                }
            t1 = new tahta(boyut);
        } 
       }
           
        t1.tahtayiYaz(); 
            
       boolean abc=true;
        while( abc ){
            System.out.println("Cikis icin -1 devam etmek icin herhangi baska sayi giriniz : ");
            
            if( sc.nextInt()==-1 ){
            t1.kaydet(o1);
            System.exit(0);
            }
            
            t1.HamleYap(o1);
            System.out.println("Tahta :");
            t1.tahtayiYaz();
            if( (t1.kazananMi(o1)) ){
                break;
            }
            if( t1.berabereMi() ){
                System.out.println("Berabere !");
                break;
            }
        
            t1.HamleYap(b1);
            System.out.println("Tahta :");
            t1.tahtayiYaz();
            if( (t1.kazananMi(b1)) ){
                break;
            }
            if( t1.berabereMi() ){
                System.out.println("Berabere !");
                break;
            }
        }
    }
    
}