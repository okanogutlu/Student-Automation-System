package projeodevi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static projeodevi.ogrenciBolumu.kredi;
public class MMbolumu extends ogrenci implements ogrenciBolumu{
   static String gunler[]={"paz","sali","cars","pers","cuma"};
   static String saatler[]={"08-09","09-10","10-11","11-12","13-14","14-15","15-16"};
   static int gun=5;
   static int saat=6;
   String pzt=null;
   String sali=null;
   String car=null;
   String per=null;
   String cuma=null;
   public String kullaniciadi;
   
   public MMbolumu(ogrenci ogr){
       super(true);
       kullaniciadi=ogr.kadi;
   }
    
    
    @Override
    public void birdersleribastir() { //birinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        
       
       try {
            bf = new Scanner(new File("MMderslistesi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
       while(sayac!=4){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         System.out.println("DersKodu "+DersKod+"DersAd "+Dersadi+"kredi "+kredi);
         
         
        }
        bf.close();
    }
     @Override
    public void ikidersleribastir() { //ikinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        
       
       try {
            bf = new Scanner(new File("MMderslistesi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         while(sayac!=4){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         }
       
       while(bf.hasNext()){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         System.out.println("DersKodu "+DersKod+"DersAd "+Dersadi+"kredi "+kredi);
         
         
        }
        bf.close();
    }
    
    
    @Override
    public void dersSec(String no) {
        //öğrenci numarasına göre dersleri listeler.ders kodlarını tek tek alır,öğrencinin kendi bölümüne ait dosyaya öğrenci numarası ile birlikte kaydeder.       
       Scanner sc=new Scanner(System.in);
        int sayac=0;
        int tkredi=kredi;
        int i=0;
        int derssayac=0;
        
        String temp="";
        String kgelen="";
        
        String [] krediler=new String[4]; //ders kredilerini tutar.
        String [] secilendersler=new String[4]; //secilen dersleri dosyaya atmak için tutar.
        
        String x=no.substring(6,7);//öğrencinin numarasından hangi sınıf olduğunu öğrenir.
        if(x.equals("1")){ //birinci sınıf ise;
            birdersleribastir();
            System.out.print(" dersleri arasından 10 krediyi geçmeyecek şekilde \n ders kodu girerek sıra ile seçim yapınız");
        }
        else{
            ikidersleribastir();//ikinci sınıf ise;
            System.out.print(" dersleri arasından 10 krediyi geçmeyecek şekilde \n ders kodu girerek sıra ile seçim yapınız");
        }
        //silme başlangıcı
                  
         FileInputStream fstream = null;
       try {
           fstream = new FileInputStream("MMderslistesi.txt");
       } catch (FileNotFoundException ex) {
           Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
       }
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          
          String strLine;
       try {
           br.mark(1);
           while(tkredi>2){
               temp=sc.next();
               
               while ((strLine = br.readLine()) != null)   {
                   String[] tokens = strLine.split(" ");
                   if(temp.equals(tokens[0])){
                       tkredi-=Integer.parseInt(tokens[2]);
                       secilendersler[derssayac++]=tokens[0];
                       br.reset();
                       break;
                   }

           }
               System.out.println("Kalan kredi.."+tkredi);
           }
               } catch (IOException ex) {
           Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
       } 
            //silme bitişi
           
            try {
                BufferedWriter wr=new BufferedWriter(new FileWriter("MMogrenci.txt",true)); //ders kodlarını ilgili dosyaya aktarır.
                wr.append(no);
                 wr.append(" ");
                for(int k=0;k<derssayac;k++){
                    wr.append(secilendersler[k]);
                    wr.append(" ");
                }
                wr.write("\n");
                wr.close();
            } catch (IOException ex) {
                Logger.getLogger(MMbolumu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void notgorme() {
        int i=0;
        Vector<String> derskodlari=new Vector<String>(); //ders kodunu tutacağız.
        Vector<Integer> notlar=new Vector<Integer>(); //notları tutacağız.
        Vector<String> harfler=new Vector<String>(); //harf notlarını tutacağız
        Vector<String> dersadi=new Vector<String>();
       
        FileInputStream fstream = null;
        FileInputStream fstream2 = null;
        FileInputStream fstream3 = null;
       try {
           fstream = new FileInputStream("dersnotlari.txt");
           fstream2 = new FileInputStream("harfnotu.txt");
           fstream3 = new FileInputStream("MMderslistesi.txt");
       } catch (FileNotFoundException ex) {
           Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
       }
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          DataInputStream in2 = new DataInputStream(fstream2);
          BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
          String strLine2;
          DataInputStream in3 = new DataInputStream(fstream3);
          BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
          String strLine3;
       try {
          
           
           while ((strLine = br.readLine()) != null)   {
               String[] tokens = strLine.split(" ");
                       System.out.println(tokens[1]);
                       


                   if(tokens[1].equals(kullaniciadi)){
                       derskodlari.add(tokens[0]);
                       notlar.add(Integer.parseInt(tokens[2]));
                   }   
           }
           
           while ((strLine2 = br2.readLine()) != null)   {
               String[] tokens2 = strLine2.split(" ");
                   if(tokens2[0].equals(derskodlari.get(i))){
                       i++;
                       System.out.println(i);
                       for(int y=0;y<notlar.size();y++){
                       for(int t=1;t<tokens2.length;t=t+2){
                           if(notlar.get(y)>Integer.parseInt(tokens2[t]) && notlar.get(y)<Integer.parseInt(tokens2[t+2])){
                               harfler.add(tokens2[t+1]);
                               }
                       }
                       
                   }   }
           }
            for(int r=0;r<derskodlari.size();r++){
           while ((strLine3 = br3.readLine()) != null)   {
               String[] tokens3 = strLine3.split(" ");
                   
                if(tokens3[0].equals(derskodlari.get(r))){ //tokens burada derslistesinden aldığımız derskodudur.
                      dersadi.add(tokens3[1]);
                   }   
           }
           }
           
           br.close();
           String leftAlignFormat = "%-17s | %-10s | %-10s | %-10s |%-10s|%n";
           System.out.format(leftAlignFormat, " ","ders kodu","ders adı","puan","harf notu");
           for(int o=0;o<derskodlari.size();o++){
               System.out.format(leftAlignFormat, " ",derskodlari.get(0),dersadi.get(0),notlar.get(0),harfler.get(0));
           }
            br.close();
            br2.close();
            br3.close();
       } catch (IOException ex) {
           Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   
    
    }
public void dersprogrami() {
           System.out.println("------------------------------------------------------------------------------------");
         String x=kullaniciadi.substring(6,7);//öğrencinin numarasından hangi sınıf olduğunu öğrenir.
        //birinci sınıf ise;
        if(x.equals("1")){
        String leftAlignFormat = "%-17s | %-10s | %-10s | %-10s |%-10s| %-10s |%n";
        System.out.format(leftAlignFormat, " ","pazartesi","sali","carsamba","persembe","cuma");
        String pzt;
        String sali;
        String car;
        String per;
        String cuma;
        try {
                
            Scanner dp=new Scanner(new File("1.MM.txt"));
                
            leftAlignFormat = "| %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |%n";
            for(int i=0;i<saat-5;i++){
                for(int t=0;t<gun;t++){
                    pzt=dp.next();
                    sali=dp.next();
                    car=dp.next();
                    per=dp.next();
                    cuma=dp.next();
                    System.out.format(leftAlignFormat, saatler[i],pzt,sali,car,per,cuma);
                }
            }
                
                
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(bSınıfdp.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         //ikinci sınıf ise;
         else if(x.equals("2")){
            String leftAlignFormat = "%-17s | %-10s | %-10s | %-10s |%-10s| %-10s |%n";
            System.out.format(leftAlignFormat, " ","pazartesi","sali","carsamba","persembe","cuma");
            String pzt;
            String sali;
            String car;
            String per;
            String cuma;
            try {
                
                Scanner dp=new Scanner(new File("2.MM.txt"));
                
                leftAlignFormat = "| %-15s | %-10s | %-10s | %-10s | %-10s | %-10s |%n";
                for(int i=0;i<saat-5;i++){
                    for(int t=0;t<gun;t++){
                        pzt=dp.next();
                        sali=dp.next();
                        car=dp.next();
                        per=dp.next();
                        cuma=dp.next();
                        System.out.format(leftAlignFormat, saatler[i],pzt,sali,car,per,cuma);
                    }
                }
                
                
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(bSınıfdp.class.getName()).log(Level.SEVERE, null, ex);
              }
            
       }
    System.out.println("------------------------------------------------------------------------------------");
    }
}
