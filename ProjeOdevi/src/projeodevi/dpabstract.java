/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeodevi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OKAN
 */
public abstract class  dpabstract extends giris {
    
    String pzt=null;
    String sali=null;
    String car=null;
    String per=null;
    String cuma=null;
    
     public void EEMbirdersleribastir() { //birinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
       consoltemizle();
        
       
       try {
            bf = new Scanner(new File("EEMderslistesi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EEMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
       while(sayac!=4){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         System.out.println("DersKodu "+DersKod+"DersAd "+Dersadi+"kredi "+kredi);
         
         
        }
        bf.close();
        System.out.println("---------------------------------------------------------------------------");
    }
     
     public void EEMikidersleribastir() { //ikinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        consoltemizle();
       
       try {
            bf = new Scanner(new File("EEMderslistesi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EEMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         while(sayac!=4){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         }
       
       while(bf.hasNext()){
         
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         System.out.println("DersKodu "+DersKod+"DersAd "+Dersadi+"kredi "+kredi);
         
         
        }
        bf.close();
        System.out.println("---------------------------------------------------------------------------");
    }

public void BMbirdersleribastir() { //birinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        consoltemizle();
       
       try {
            bf = new Scanner(new File("BMderslistesi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
       while(sayac!=4){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         System.out.println("DersKodu "+DersKod+"DersAd "+Dersadi+"kredi "+kredi);
         
         
        }
        bf.close();
        System.out.println("---------------------------------------------------------------------------");
    }
    
    public void BMikidersleribastir() { //ikinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        consoltemizle();
       
       try {
            bf = new Scanner(new File("BMderslistesi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         while(sayac!=4){
         sayac++;
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         }
       
       while(bf.hasNext()){
         
         String DersKod=bf.next();
         String Dersadi=bf.next();
         String kredi=bf.next();
         System.out.println("DersKodu "+DersKod+"DersAd "+Dersadi+"kredi "+kredi);
         
         
        }
        bf.close();
        System.out.println("---------------------------------------------------------------------------");
    }
    
public void MMbirdersleribastir() { //birinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        consoltemizle();
       
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
        System.out.println("---------------------------------------------------------------------------");
    }
    
    public void MMikidersleribastir() { //ikinci sınıf derslerini ekrana bastırır.
        int sayac=0;
       Scanner bf = null;
        consoltemizle();
       
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
        System.out.println("---------------------------------------------------------------------------");
    }

 public void consoltemizle() {
               System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }




}
