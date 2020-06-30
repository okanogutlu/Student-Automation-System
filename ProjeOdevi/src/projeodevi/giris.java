/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeodevi;

import java.io.File;
import java.util.Scanner;


public  abstract class giris  {
     private String ad="";
     private String sif=""; 
     char Ead;
    boolean girisOGR(String kadi, String sifre){  
       
        try{
       Scanner bf = new Scanner(new File("uyelikOGR.txt"));
       

         ad=bf.next();
         sif=bf.next();
         while(bf.hasNext()){
              
        if(kadi.equals(ad)&&sifre.equals(sif)){
            System.out.println("basarili bir sekilde sisteme giris yaptiniz");
            this.ad=kadi;
            this.sif=sifre;
            bf.close();
          return true;
          
        }
        else{
          
            ad=bf.next();
            sif=bf.next();
            
         }
        }}catch(Exception e){
        e.printStackTrace();return false;

        }
        
       
        return false;
    }
    boolean girisOU(String kadi, String sifre){  
       
        try{
       Scanner bf = new Scanner(new File("uyelikOU.txt"));
       

         ad=bf.next();
         sif=bf.next();
         while(bf.hasNext()){
        if(kadi.equals(ad)&&sifre.equals(sif)){
            System.out.println("basarili bir sekilde sisteme giris yaptiniz");
            this.ad=kadi;
            this.sif=sifre;
            bf.close();
          return true;
          
        }
        else{
          
            ad=bf.next();
            sif=bf.next();
            
         }
        }}catch(Exception e){
        e.printStackTrace();return false;

        }
        
       
        return false;
    }
    boolean girisIM(String kadi, String sifre){  
      
        try{
       Scanner bf = new Scanner(new File("uyelikIM.txt"));
       

         ad=bf.next();
         sif=bf.next();
         while(bf.hasNext()){
              
        if(kadi.equals(ad)&&sifre.equals(sif)){
            System.out.println("basarili bir sekilde sisteme giris yaptiniz");
            this.ad=kadi;
            this.sif=sifre;
            bf.close();
          return true;
          
        }
        else{
          
            ad=bf.next();
            sif=bf.next();
            
         }
        }}catch(Exception e){
        e.printStackTrace();return false;

        }
        
       
        return false;
    }
    
    
    
}

