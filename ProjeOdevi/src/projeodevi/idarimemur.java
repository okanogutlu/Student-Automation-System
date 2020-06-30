/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author OKAN
 */
public class idarimemur extends bSınıfdp implements Mesaj{
    public String kadi;
    public String sifre;
    public idarimemur() {
        
        System.out.println("kullanıcı adı..:");
        Scanner k=new Scanner(System.in);
        this.kadi=k.next();
        System.out.println("Şifre..:");
        Scanner s=new Scanner(System.in);
        this.sifre=s.next();
        
        boolean girildimi=girisIM(kadi, sifre);
        while(!girildimi){
            System.out.println("kullanıcı adı veya şifre hatalı.\n lütfen tekrar deneyiniz");
            System.out.println("kullanıcı adı...:");

            Scanner sc=new Scanner(System.in);
             this.kadi=sc.next();
            System.out.println("Şifre...:");

            Scanner sc2=new Scanner(System.in);
            this.sifre=sc2.next();
            girildimi=girisIM(kadi,sifre);
        }
            
    } 
    void uyeonayı() throws FileNotFoundException, IOException{
        System.out.println("    Üye Onaylama Sistemi ");
        Scanner sc=new Scanner(System.in);
        String ad="";
        String cikis="2";
        Vector<String> numaralar=new Vector<String>();
        Vector<String> onaykadi=new Vector<String>();
        Vector<String> onaysifre=new Vector<String>();
        Scanner bf = new Scanner(new File("onay.txt"));
        while(bf.hasNext()){
            ad=bf.next();
            onaykadi.add(ad);
            System.out.println("Öğrenci Numarası:"+ad);
            if(bf.hasNext())
                ad=bf.next();
            
        }
        bf.close();
        
        while(!cikis.equals("1")){
        System.out.println("Onaylamak istediğiniz numaraları sırayla giriniz.Çıkış yapmak için 1 tuşlayınız");
        cikis=sc.next();
        if(!cikis.equals("1")){    
            for(int i=0;i<onaykadi.size();i++){
                if(onaykadi.get(i).equals(cikis)){
                    numaralar.add(cikis);
                    
                }
            }
        }
        }
        Scanner bf2 = new Scanner(new File("onay.txt"));
         for(int i=0;i<numaralar.size();i++){
             ad=bf2.next();
             if(ad.equals(numaralar.get(i))){
                 onaysifre.add(bf2.next());
             }
             
             
         }
        File file=new File("uyelikOGR.txt");
        FileWriter filewriter=new FileWriter(file,true);
        BufferedWriter wr=new BufferedWriter(filewriter); 
        for(int i=0;i<numaralar.size();i++){
        wr.append("\n");
        wr.append(numaralar.get(i));
        wr.append(" ");
        wr.append(onaysifre.get(i));
        wr.append("\n");
        }
    bf2.close();
    wr.close();
    }
   
    
    
    void uyesilme() throws FileNotFoundException, IOException{
    System.out.println("Silmek istediğiniz üye tipini seçiniz\n1-ÖĞRENCİ\n2-ÖĞRETİM GÖREVLİSİ");
    Scanner sc=new Scanner(System.in);
    String numara;
    int i=0;
    int secim=sc.nextInt();
    Vector<String>fileholder=new Vector<String>();
    if(secim==1){
        Scanner bf = null;
        bf = new Scanner(new File("uyelikOGR.txt"));
        System.out.println("----------Sistemdeki Öğrenciler------------");
        while(bf.hasNext()){
            System.out.println(bf.next());
            bf.next();
        }
        System.out.println("Lütfen silmek istediğiniz kullanıcıyı giriniz");
        numara=sc.next();
        bf.close();
        
          Scanner bf2 = null;
          bf2 = new Scanner(new File("uyelikOGR.txt"));
          String holderid,holderpass;
          while (bf2.hasNext()){
              System.out.println("hey");
              holderid=bf2.next();
              holderpass=bf2.next();
            if(!holderid.equals(numara)){
                System.out.println("hey");
                fileholder.add(holderid);
                fileholder.add(holderpass);
            }
          
          }
          
          bf2.close();
          File file=new File("uyelikOGR.txt");
          FileWriter filewriter=new FileWriter(file,false);
          BufferedWriter wr=new BufferedWriter(filewriter);
          System.out.println(fileholder.size());
          for( i=0;i<fileholder.size();i++){
              System.out.println(fileholder.get(i));
              wr.append(fileholder.get(i));
              wr.append(" ");
              wr.append(fileholder.get(++i));
              wr.append("\n");
          }
          wr.close();
    }
    else if(secim==2){
        Scanner bf = null;
        bf = new Scanner(new File("uyelikOU.txt"));
        System.out.println("----------Sistemdeki Öğretim Üyeleri------------");
        while(bf.hasNext()){
            System.out.println(bf.next());
            bf.next();
        }
        System.out.println("Lütfen silmek istediğiniz kullanıcıyı giriniz");
        numara=sc.next();
        bf.close();
        
          Scanner bf2 = null;
          bf2 = new Scanner(new File("uyelikOU.txt"));
          String holderid,holderpass;
          while (bf2.hasNext()){
              holderid=bf2.next();
              holderpass=bf2.next();
            if(!holderid.equals(numara)){
                fileholder.add(holderid);
                fileholder.add(holderpass);
            }
          
          }
          bf2.close();
          File file=new File("uyelikOU.txt");
          FileWriter filewriter=new FileWriter(file,false);
          BufferedWriter wr=new BufferedWriter(filewriter); 
          for( i=0;i<fileholder.size();i++){
              wr.append(fileholder.get(i));
              wr.append(" ");
              wr.append(fileholder.get(++i));
              wr.append("\n");
    }
   
    wr.close();
    }
}

    @Override
    public void mesajyaz() {
        String mesaj =null;
        String iletilecek=null;
        String gonderen=kadi;
        String cleaner;
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------İdari Memur Mesaj Gönderim Sayfası------------\n");
        System.out.println("Mesaj göndermek istediğiniz kişinin kullanıcı adı: ");
        iletilecek=sc.next();
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("Mesajınızı yazın: ");
        cleaner=sc.nextLine();
        mesaj=sc.nextLine();
        Scanner mes=new Scanner(mesaj);
        System.out.println("---------------------------------------------------------------\n");
        try {
             File file=new File("Mesaj.txt");
             FileWriter filewriter=new FileWriter(file,true);
             BufferedWriter wr=new BufferedWriter(filewriter);
             wr.append(iletilecek);
             wr.append(" ");
             System.out.println("checked");
             wr.append("Gonderen:");
             wr.append(gonderen);
             wr.append(" ");
             while(mes.hasNext()){
                 wr.append(mes.next());
                 wr.append(" ");
             }
             wr.append("\n");
             wr.close();
        } catch (IOException ex) {
            Logger.getLogger(ogretimuyesi.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   System.out.println("----------MESAJ İLETİLDİ------------");
    }

    @Override
    public void mesajgoruntule() {
         System.out.println(" GONDEREN "+"  ALICI "+" MESAJ");
        try {
            String reader=null;
            FileInputStream fstream=null;
            fstream = new FileInputStream("Mesaj.txt");
            
            DataInputStream in = new DataInputStream(fstream);        
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] tokens = strLine.split(" ");
                if(tokens[0].equals(kadi)){
                    System.out.println(strLine);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ogretimuyesi.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("-----------------------------");
    }

    @Override
    public void mesajsil() {
         mesajgoruntule();
        Scanner sc=new Scanner(System.in);
        String numara;
        int i=0;
        Vector<String>fileholder=new Vector<String>();
    
            try {
                Scanner bf2 = null;
                System.out.println("Silmek istediğiniz mesajın gönderen id'sini giriniz.");
                numara=sc.next();
                bf2 = new Scanner(new File("Mesaj.txt"));
                String holdernum1,holdernum2,holdermesaj;
                while (bf2.hasNext()){
                    holdernum1=bf2.next();
                    holdernum2=bf2.next();
                    holdermesaj=bf2.next();
                    if(!holdernum1.equals(numara)){
                        fileholder.add(holdernum1);
                        fileholder.add(holdernum2);
                        fileholder.add(holdermesaj);
                    }
                    
                }     bf2.close();
                File file=new File("Mesaj.txt");
                FileWriter filewriter=new FileWriter(file,true);
                BufferedWriter wr=new BufferedWriter(filewriter);
                for( i=0;i<fileholder.size();i++){
                    wr.append(fileholder.get(i));
                    wr.append(" ");
                    wr.append(fileholder.get(++i));
                    wr.append(" ");
                    wr.append(fileholder.get(++i));
                    wr.append("\n");
          }     wr.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ogretimuyesi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ogretimuyesi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}