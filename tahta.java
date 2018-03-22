package tictactoe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Muhammed Ali
 */
public class tahta {    public char[][] tahta;
    public int boyut=0;
    
    public tahta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public tahta(int boyut){
        System.out.println("Tahta bos.");
        this.tahta= new char[boyut][boyut];
        this.boyut=boyut;
        for(int i=0;i<boyut;i++){
            for(int j=0;j<boyut;j++)
                this.tahta[i][j]='_';
        } 
    }
   
    public tahta(char[][] oyunTahtasi, int boyut){
        this.tahta= new char[boyut][boyut];
        this.boyut=boyut;
        for(int i=0;i<boyut;i++){
            for(int j=0;j<boyut;j++)
                this.tahta[i][j]= oyunTahtasi[i][j];
        }   
    }

    char[][] tahtayiAl(){
        return this.tahta;
    }
    
    void tahtayiYaz(){
        for(int i=0;i<this.boyut;i++){
            for(int j=0;j<this.boyut;j++){
                System.out.print(this.tahta[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    boolean bosMu(int x,int y){
       return !(this.tahta[x][y] == 'X' || this.tahta[x][y] =='O');
    }
    
    String HamleYap(oyuncu p1){
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int x,y;
        
    if(p1.insanMi==true){     //İnsansa
        do{
        System.out.println("Hamle sirasi sizde");
        System.out.println("Hamle yapmak istediginiz yerin koordinatlarini giriniz :");
        System.out.println(" \"x y\" seklinde giriniz:");
        p1.koordinat=sc.nextLine();
        
        String[] splitt = p1.koordinat.split(" ");
        x=Integer.parseInt(splitt[0]);
        y=Integer.parseInt(splitt[1]);
        x--;y--;
        }while(  !(this.bosMu(x, y))  );
        this.tahta[x][y]=p1.isaret;
        
    }
    else if(p1.insanMi==false){                       //Bilgisayarsa
        do{
            x=r.nextInt(this.boyut);
            y=r.nextInt(this.boyut);
            p1.koordinat=""+x+y;
            
        }while( !( this.bosMu(x, y) )  );
        
        this.tahta[x][y]=p1.isaret;
    }
    return p1.koordinat;
    }
    
    public boolean berabereMi(){
        int sayac=0;
        for(int i=0;i<this.boyut;i++){
            for(int j=0;j<this.boyut;j++){
                if(this.tahta[i][j]=='X' || this.tahta[i][j]=='O'){
                    sayac++;
                }
            }
        }
    return ( (this.boyut) * (this.boyut) ) == sayac;
        
    }
   
    public boolean kazananMi(oyuncu p1){
        
        int sayac=0;
        String temp = new String();
        String temp2= new String();
        temp=""+p1.isaret;
        
        for(int i=0;i<this.boyut;i++){      //Yatay kontrol
            for(int j=0;j<this.boyut-2;j++){
                temp2=""+this.tahta[i][j];
                if( temp.equals(temp2) ){
                    temp2=""+this.tahta[i][j+1];
                    if( temp.equals(temp2) ){
                        temp2=""+this.tahta[i][j+2];
                        if( temp.equals(temp2) ){
                            System.out.println("Kazanan : "+p1.isim);
                            return true;
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<this.boyut-2;i++){  //Dikey Kontrol
            for(int j=0;j<this.boyut;j++){
            temp2=""+this.tahta[i][j];
                if( temp.equals(temp2) ){
                    temp2=""+this.tahta[i+1][j];
                    if(temp.equals(temp2)){
                        temp2=""+this.tahta[i+2][j];
                        if(temp.equals(temp2)){
                            System.out.println(p1.isim+" Kazandi");
                            return true;
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<this.boyut-2;i++){  //Carpraz Kontrol
            for(int j=0;j<this.boyut-2;j++){
             temp2=""+this.tahta[i][j];
                if( temp.equals(temp2) ){
                    temp2=""+this.tahta[i+1][j+1];
                    if(temp.equals(temp2)){
                        temp2=""+this.tahta[i+2][j+2];
                        if(temp.equals(temp2)){
                            System.out.println(p1.isim+" Kazandi");
                            return true;
                        }
                    }
                }
            }
        }
        
        
    
    return false;
    }
    
    public void kaydet(oyuncu p1)throws IOException{
    File fp = new File("kayitliOyun.txt");
    FileWriter fw = new FileWriter(fp);
        
        fw.write(this.tahta.length);
        
        
        for (int i = 0; i < this.tahta.length; i++) {
            for (int j = 0; j <this.tahta.length; j++) {
                fw.write(this.tahta[i][j]);
            }
        }
        fw.write("#");
        fw.write(p1.isaret);
        fw.close();
    }

    
}
