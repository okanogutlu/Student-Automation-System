/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeodevi;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OKAN
 */
public class bSınıfdp extends iSınıfdp implements dphazirla {

    
    @Override
    public void dphazirla1(boolean hangisi) {
        if(hangisi==true){
            super.dphazirla2();
        }
        else{
        FileWriter filewriter = null;
        
        System.out.println("Hangi Bölümün ders programını hazırlamak istiyorsunuz?\n"
                + "Bilgisayar Müh. için 1\n"
                + "Makine Müh. için 2 \n"
                + "Elektrik Elektronik Müh. için 3 tuşuna basınız.");
        
        Scanner sc=new Scanner(System.in);
        int secim=sc.nextInt();
        
        while(secim!=1 && secim!=2 && secim!=3){
            System.out.println("yanlış seçim yaptınız.Tekrar deneyin.");
            secim=sc.nextInt();
        }
        
                
        System.out.println("Lütfen size belirtilen gün ve saatte istediğiniz dersi yazınız."
                + "Belirtilen zamanı es geçmek istiyorsanız Enter tuşuna basabilirsiniz");
        
        if(secim==1){
            BMbirdersleribastir();
            
            File file=new File("1.BM.txt");
                
            try {
                
                filewriter = new FileWriter(file,false);
                Scanner dersal=new Scanner(System.in);
                String ders=null;
                
                for(int i=0;i<saat;i++){
                    for (int t=0;t<gun;t++){
                        
                        System.out.println(saatler[i]+" "+gunler[t]);
                        ders=dersal.nextLine();
                        if(ders.isEmpty()){
                            ders="boş";
                        }
                         if(t!=saat&&t!=0){
                            filewriter.append(" ");
                        }
                        filewriter.append(ders);
                        dersal=new Scanner(System.in);
                       
            
                    }
                    filewriter.append("\n");
                }
             filewriter.close();
            } catch (IOException ex) {
                Logger.getLogger(bSınıfdp.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        
        }
    
        else if(secim==2){
            MMbirdersleribastir();
           
                File file=new File("1.MM.txt");
                
            try {
                
                filewriter = new FileWriter(file,false);
                Scanner dersal=new Scanner(System.in);
                String ders=null;
                
                for(int i=0;i<saat;i++){
                    for (int t=0;t<gun;t++){
                        
                        System.out.println(saatler[i]+" "+gunler[t]);
                        ders=dersal.nextLine();
                        if(ders.isEmpty()){
                            ders="boş";
                        }
                         if(t!=saat&&t!=0){
                            filewriter.append(" ");
                        }
                        filewriter.append(ders);
                        dersal=new Scanner(System.in);
                       
            
                    }
                    filewriter.append("\n");
                }
             filewriter.close();
            } catch (IOException ex) {
                Logger.getLogger(bSınıfdp.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        
        }
    
    
        else if(secim==3){
            EEMbirdersleribastir();
            
               File file=new File("1.EEM.txt");
                
            try {
                
                filewriter = new FileWriter(file,false);
                Scanner dersal=new Scanner(System.in);
                String ders=null;
                
                for(int i=0;i<saat;i++){
                    for (int t=0;t<gun;t++){
                        
                        System.out.println(saatler[i]+" "+gunler[t]);
                        ders=dersal.nextLine();
                        if(ders.isEmpty()){
                            ders="boş";
                        }
                         if(t!=saat&&t!=0){
                            filewriter.append(" ");
                        }
                        filewriter.append(ders);
                        dersal=new Scanner(System.in);
                       
            
                    }
                    filewriter.append("\n");
                }
             filewriter.close();
            } catch (IOException ex) {
                Logger.getLogger(bSınıfdp.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        
        }

    }
}

    @Override
    public void dpguncelle() {
        
    }

    @Override
    public void dpbastir(int bolum) {
        while(bolum!=1&&bolum!=2&&bolum!=3){
            System.out.println("yanlış seçim yaptınız! Bilgisayar Müh için 1\n"
                    + "Elektrik Elektronik Müh. için 2\n"
                    + "Makine Müh. için 3 tuşuna basınız.");
            Scanner sc=new Scanner(System.in);
            bolum=sc.nextInt();
        }
        consoltemizle();
        String leftAlignFormat = "%-17s | %-4s | %-4s | %-4s |%-4s| %-6s |%n";
        System.out.format(leftAlignFormat, " ","pazartesi","sali","carsamba","persembe","cuma");
      
        if(bolum==1){
            
            try {
                
                Scanner dp=new Scanner(new File("1.BM.txt"));
                
                leftAlignFormat = "| %-15s | %-9s | %-6s | %-6s | %-6s | %-6s |%n";
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
        else if(bolum==2){
             try {
                
                Scanner dp=new Scanner(new File("1.EEM.txt"));
                
                leftAlignFormat = "| %-15s | %-9s | %-6s | %-6s | %-6s | %-6s |%n";
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
        else if(bolum==3){
             try {
                
                Scanner dp=new Scanner(new File("1.MM.txt"));
                
                leftAlignFormat = "| %-15s | %-9s | %-6s | %-6s | %-6s | %-6s |%n";
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
    }

    @Override
    public void dphazirla2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
