package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Muhammed Ali
 */
public class oyuncu {
    public char isaret;
    public boolean insanMi;
    public String isim;
    public String koordinat;

    public oyuncu(){
    this.isaret='X';
    this.insanMi=true;
        System.out.println("Adinizi giriniz : ");
        Scanner sc=new Scanner(System.in);
        this.isim=sc.nextLine();
    }
    
    public oyuncu(boolean kim){
        this.insanMi=kim;
        
        if(this.insanMi==true){
            this.isaret='X';
            System.out.println("Adinizi giriniz : ");
            Scanner sc=new Scanner(System.in);
            this.isim=sc.nextLine();
        }
        else {
            this.isaret='O';
            this.isim="Bilgisayar";
        }
    }
    
    public oyuncu(boolean kim, char kr){
        this.insanMi=kim;
        this.isaret=kr;
        if(this.insanMi){
        System.out.println("Adinizi giriniz : ");
        Scanner sc=new Scanner(System.in);
        this.isim=sc.nextLine();
        }
        else this.isim="Bilgisayar";
    }
    
    char krAl(){            //Oyuncunun karakterini dondur
    return this.isaret;
    } 
    
    boolean kimAl(){        //Oyuncunun insan olup olmadigini dondur
    return this.insanMi;
    }
    
    String hamleAl(){
        return this.koordinat;
    }
}
