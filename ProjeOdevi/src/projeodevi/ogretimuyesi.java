
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


public class ogretimuyesi extends giris implements Mesaj{
    public String kadi;
    public String sifre;
    public ogretimuyesi() {
        
       System.out.println("kullanıcı adı..:");
        Scanner k=new Scanner(System.in);
        this.kadi=k.next();
        System.out.println("Şifre..:");
        Scanner s=new Scanner(System.in);
        this.sifre=s.next();
        
        boolean girildimi=girisOU(kadi, sifre);
        while(!girildimi){
            System.out.println("kullanıcı adı veya şifre hatalı.\n lütfen tekrar deneyiniz");
            System.out.println("kullanıcı adı...:");

            Scanner sc=new Scanner(System.in);
            this.kadi=sc.next();
            System.out.println("Şifre...:");

            Scanner sc2=new Scanner(System.in);
            this.sifre=sc2.next();
            girildimi=girisOU(kadi,sifre);
        }
            
    }

    
    
static int hangiBolum(String kadi){
    String x=kadi.substring(0,1);
                     //öğretmenin numarasından hangi bölüm olduğunu öğrenir.
    if(x.equals("1")){ //bilgisayar müh sınıf ise;
         return 1;
    }
    else if(x.equals("2")){//EEM muhendisliği
            return 2;
    }
    else{//MM muhendisliği
            return 3;
    }
   
}


void notgirme() throws FileNotFoundException, IOException{
    String not=null;
    Vector<String> nos=new Vector<String>();
    String kodcheck=null;
    boolean bulundumu=false; 
    String dersadi=null;
    //öğretmenin hangi bölümün hocası olduğunu bulacağız.
    int bolum=hangiBolum(this.kadi);
    //öğretmenin hangi dersi verdiğini bulacağız.
    
    if(bolum==1){//bilgisayar mühendisliği ise
        Scanner bf = null;
        bf = new Scanner(new File("BMderslistesi.txt"));
        String derskodu=kadi.substring(4,7);
        System.out.println(derskodu);
        while(bulundumu==false&&bf.hasNext()){
           kodcheck=bf.next();
           if(kodcheck.equals(derskodu)){
               bulundumu=true;
               dersadi=bf.next();
           }
        
           else{
               kodcheck=bf.next();
               kodcheck=bf.next();
           }
        }
    
          FileInputStream fstream = new FileInputStream("BMogrenci.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(" ");
            for(int i=0;i<tokens.length;i++){
              if(tokens[i].equals(kodcheck)){
                  nos.add(tokens[0]);
              }
              
          }
    
    
        }
        BufferedWriter wr=new BufferedWriter(new FileWriter("dersnotlari.txt",true));

        Scanner sc=new Scanner(System.in);
        // dersi alan öğrencileri bulduk. şimdi ise dersi alan öğrencilerin notlarını girme işlemi yapacağız.
        System.out.println(dersadi+" dersinin notlarını giriyorsunuz");
        for(int t=0;t<nos.size();t++){
            
              System.out.print(nos.elementAt(t)+" 'nolu öğrencinin notunu giriniz..:");
            wr.append(kodcheck);
            wr.append(" ");
            wr.append(nos.elementAt(t));
            wr.append(" ");
            not=sc.next();
            wr.append(not);
            wr.append("\n");
          }
            wr.close();

    }
    if(bolum==2){//EEM mühendisliği ise mühendisliği ise
        Scanner bf = null;
        bf = new Scanner(new File("EEMderslistesi.txt"));
        String derskodu=kadi.substring(4,6);
        while(bulundumu==false && bf.hasNext()){
           kodcheck=bf.next();
           if(kodcheck.equals(derskodu)){
               bulundumu=true;
               dersadi=bf.next();
           }
        
           else{
               kodcheck=bf.next();
               kodcheck=bf.next();
           }
        }
    
          FileInputStream fstream = new FileInputStream("EEMogrenci.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(" ");
            for(int i=0;i<tokens.length;i++){
              if(tokens[i].equals(kodcheck)){
                  nos.add(tokens[0]);
              }
              
          }
    
    
        }
        BufferedWriter wr=new BufferedWriter(new FileWriter("dersnotlari.txt",true)); 

        Scanner sc=new Scanner(System.in);
        // dersi alan öğrencileri bulduk. şimdi ise dersi alan öğrencilerin notlarını girme işlemi yapacağız.
                System.out.println(dersadi+" dersinin notlarını giriyorsunuz");
  
        for(int t=0;t<nos.size();t++){
            System.out.print(nos.elementAt(t)+" 'nolu öğrencinin notunu giriniz..:");

            wr.append(kodcheck);
            wr.append(" ");
            wr.append(nos.elementAt(t));
            wr.append(" ");
            not=sc.next();
            wr.append(not);
            wr.append("\n");
          }
          wr.close();
    }
    if(bolum==3){//makine mühendisliği ise
        Scanner bf = null;
        bf = new Scanner(new File("MMderslistesi.txt"));
        String derskodu=kadi.substring(4,6);
        while(bulundumu==false && bf.hasNext()){
           kodcheck=bf.next();
           if(kodcheck.equals(derskodu)){
               bulundumu=true;
               dersadi=bf.next();
           }
        
           else{
               kodcheck=bf.next();
               kodcheck=bf.next();
           }
        }
    
          FileInputStream fstream = new FileInputStream("MMogrenci.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          while ((strLine = br.readLine()) != null)   {
            String[] tokens = strLine.split(" ");
            for(int i=0;i<tokens.length;i++){
              if(tokens[i].equals(kodcheck)){
                  nos.add(tokens[0]);
              }
              
          }
    
    
        }
        Scanner sc=new Scanner(System.in);
        BufferedWriter wr=new BufferedWriter(new FileWriter("dersnotlari.txt",true)); 

        // dersi alan öğrencileri bulduk. şimdi ise dersi alan öğrencilerin notlarını girme işlemi yapacağız.
         System.out.println(dersadi+" dersinin notlarını giriyorsunuz");
  
        for(int t=0;t<nos.size();t++){
            System.out.print(nos.elementAt(t)+" 'nolu öğrencinin notunu giriniz..:");

            wr.append(kodcheck);
            wr.append(" ");
            wr.append(nos.elementAt(t));
            wr.append(" ");
            not=sc.next();
            wr.append(not);
            wr.append("\n");
          }
          wr.close();

    }


}



    void harfnotu() throws IOException{
        String derskodu=kadi.substring(4,7);
        String[] harfler={"F","DD","DC","CC","CB","BB","BA","AA"};
        String [] harfsınırı=new String[9];
        String holder;
        boolean sınırkontrolu=false;
        boolean onay=false;
        int kontrol=0;
        int karsılastırma=0;
        Scanner sc=new Scanner(System.in);
        harfsınırı[0]="0";
        while(onay!=true){
            for(int i=0;i<7;i++){
                System.out.println(harfler[i]+" harfinin üst sınırını belirleyin \n"+harfsınırı[i]+" - ?:");//burada hata var
                holder=sc.next();
                karsılastırma=Integer.parseInt(holder);
                if((Integer.parseInt(holder)<Integer.parseInt(harfsınırı[i]) ||Integer.parseInt(holder)==Integer.parseInt(harfsınırı[i])) || karsılastırma>100){
                    while(sınırkontrolu!=true){
                        System.out.println("Üst sınır alt sınırdan küçük olamaz!");

                        System.out.println(harfler[i]+" harfinin üst sınırını belirleyin \n"+harfsınırı[i]+" - ?:");
                        holder=sc.next();
                        karsılastırma=Integer.parseInt(holder);

                        if(Integer.parseInt(holder)>Integer.parseInt(harfsınırı[i]) &&Integer.parseInt(holder)!=Integer.parseInt(harfsınırı[i])&&karsılastırma<100){
                            sınırkontrolu=true;
                        }
                    }
                    sınırkontrolu=false;
                }
            
            harfsınırı[i+1]=holder;
            

        }
        harfsınırı[8]="100";
        System.out.println("Sınavın harf notları şu şekildedir;\n");
        for(int i=0;i<8;i++){
           System.out.println(harfler[i]+" :"+harfsınırı[i]+"-"+harfsınırı[i+1]);
  
        }
        System.out.println("\n Seçiminizi kaydetmek istiyorsanız 1 \n tekrar harf notunu düzenlemek için 2 tuşuna basınız");
        kontrol=sc.nextInt();
        if(kontrol==1){
            onay=true;
        }
        else{
            
        }
        }
        BufferedWriter wr=new BufferedWriter(new FileWriter("harfnotu.txt",true)); 
        wr.append(derskodu);
        for(int i=0;i<8;i++){
            wr.append(" ");
            wr.append(harfsınırı[i]);
            wr.append(" ");
            wr.append(harfler[i]);
        }
        wr.append(" ");
        wr.append(harfsınırı[8]);
        wr.append("\n");
        wr.close();


    }


void yoklamaal() throws FileNotFoundException, IOException{
    int hangibolum=hangiBolum(this.kadi);
    boolean kontrol1=false;
    Scanner sc=new Scanner(System.in);
    String numara=null;
    String tarih=null;
    String derskodu=null;
    if(hangibolum==1){
          
          FileInputStream fstream = new FileInputStream("BMogrenci.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          Vector<String> DersinOgrencileri=new Vector<String>();
          derskodu=kadi.substring(4);
          System.out.println("---Bilgisayar Mühendisliği "+derskodu+" Kod numaralı dersi alan öğrenci listesi---");
          while ((strLine = br.readLine()) != null) {
            String[] tokens = strLine.split(" ");
            for(int i=1;i<tokens.length;i++){
              if(tokens[i].equals(derskodu)){
                  DersinOgrencileri.add(tokens[0]);
                  System.out.println(tokens[0]);
              }
              
          }
    
    
        }
          br.close();
    while(!kontrol1){
          System.out.println("Derse gelmeyen öğrencinin numarasını giriniz");
    numara=sc.next();
    System.out.println("Derse gelmediği tarihi giriniz. GG.AA şeklinde giriniz.");
    tarih=sc.next();
    FileInputStream fstream2 = new FileInputStream("yoklama.txt");
    DataInputStream in2 = new DataInputStream(fstream2);
    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
    String strLine2;
     while ((strLine = br2.readLine()) != null) {
            String[] tokens = strLine.split(" ");
            if(tokens[0].equals(numara) && tokens[1].equals(derskodu) && tokens[2].equals(tarih)){
                System.out.println("Bu yoklama daha önce girilmiş!");
            }
            else{
                
                kontrol1=true;
            }
     }
     if( br2.readLine() == null){
         kontrol1=true;
     }
    }
    }
    else if(hangibolum==2){
        FileInputStream fstream = new FileInputStream("EEMogrenci.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          Vector<String> DersinOgrencileri=new Vector<String>();
          derskodu=kadi.substring(4);
          System.out.println("---Elektrik Elektronik Mühendisliği"+derskodu+" Kod numaralı dersi alan öğrenci listesi---");
          while ((strLine = br.readLine()) != null) {
            String[] tokens = strLine.split(" ");
            for(int i=1;i<tokens.length;i++){
              if(tokens[i].equals(derskodu)){
                  DersinOgrencileri.add(tokens[0]);
                  System.out.println(tokens[0]);
              }
              
          }
    
    
        }
          br.close();
    while(!kontrol1){
          System.out.println("Derse gelmeyen öğrencinin numarasını giriniz");
    numara=sc.next();
    System.out.println("Derse gelmediği tarihi giriniz. GG.AA şeklinde giriniz.");
    tarih=sc.next();
    FileInputStream fstream2 = new FileInputStream("yoklama.txt");
    DataInputStream in2 = new DataInputStream(fstream2);
    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
    String strLine2;
     while ((strLine = br2.readLine()) != null) {
            String[] tokens = strLine.split(" ");
            if(tokens[0].equals(numara) && tokens[1].equals(derskodu) && tokens[3].equals(tarih)){
                System.out.println("Bu yoklama daha önce girilmiş!");
            }
            else{
                kontrol1=true;
            }
            
     }
     if( br2.readLine() == null){
         kontrol1=true;
     }
    }
    }
    else if(hangibolum==3){
        FileInputStream fstream = new FileInputStream("MMogrenci.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          Vector<String> DersinOgrencileri=new Vector<String>();
          derskodu=kadi.substring(4);
          System.out.println("---Makine Mühendisliği"+derskodu+" Kod numaralı dersi alan öğrenci listesi---");
          while ((strLine = br.readLine()) != null) {
            String[] tokens = strLine.split(" ");
            for(int i=1;i<tokens.length;i++){
              if(tokens[i].equals(derskodu)){
                  DersinOgrencileri.add(tokens[0]);
                  System.out.println(tokens[0]);
              }
              
          }
    
    
        }
          br.close();
        while(!kontrol1){
            System.out.println("Derse gelmeyen öğrencinin numarasını giriniz");
            numara=sc.next();
            System.out.println("Derse gelmediği tarihi giriniz. GG.AA şeklinde giriniz.");
            tarih=sc.next();
            FileInputStream fstream2 = new FileInputStream("yoklama.txt");
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            while ((strLine = br2.readLine()) != null) {
                String[] tokens = strLine.split(" ");
                if(tokens[0].equals(numara) && tokens[1].equals(derskodu) && tokens[3].equals(tarih)){
                   System.out.println("Bu yoklama daha önce girilmiş!");
                }
                else{
                    kontrol1=true;
                }
            }
            if( br2.readLine() == null){
         kontrol1=true;
     }
        }
    }
    BufferedWriter wr=new BufferedWriter(new FileWriter("yoklama.txt",true));
    wr.append(numara);
    wr.append(" ");
    wr.append(derskodu);
    wr.append(" ");
    String s=String.valueOf(tarih);
    wr.append(s);
    wr.append("\n");
    wr.close();
}

void yoklamabastir() throws FileNotFoundException, IOException{
    String derskodu=kadi.substring(4);
    String dersismi=null;
    String holder=null;
    FileInputStream fstream = new FileInputStream("yoklama.txt");
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
     
    int hangibolum=hangiBolum(this.kadi);
    
    if(hangibolum==1){
    FileInputStream fstream2 = new FileInputStream("BMderslistesi.txt");
    DataInputStream in2 = new DataInputStream(fstream2);
    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
    String strLine2;
    
        while ((strLine2 = br2.readLine()) != null) {
            String[] tokens2 = strLine2.split(" ");
              if(tokens2[0].equals(derskodu)){
                  dersismi=tokens2[1];
              }
        }
    }
   
    else if(hangibolum==2){
    FileInputStream fstream2 = new FileInputStream("EEMderslitesi.txt");
    DataInputStream in2 = new DataInputStream(fstream2);
    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
    String strLine2;
        while ((strLine2 = br2.readLine()) != null) {
            String[] tokens2 = strLine2.split(" ");
              if(tokens2[0].equals(derskodu)){
                  dersismi=tokens2[1];
              }
        }
    }
    else if(hangibolum==3){
    FileInputStream fstream2 = new FileInputStream("MMderslitesi.txt");
    DataInputStream in2 = new DataInputStream(fstream2);
    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
    String strLine2;
        while ((strLine2 = br2.readLine()) != null) {
            String[] tokens2 = strLine2.split(" ");
              if(tokens2[0].equals(derskodu)){
                  dersismi=tokens2[1];
              }
        }
    }
    System.out.println("---------"+dersismi+" DERSİ YOKLAMA LİSTESİ-------");
    while ((strLine = br.readLine()) != null) {
        String[] tokens = strLine.split(" ");
        if(tokens[1].equals(derskodu)){
               System.out.println("NUMARA: "+tokens[0]+" GELMEDİĞİ TARİH: "+tokens[2]+".2019");
              }
              
        
    
    
        }
    System.out.println("-----------------------------------------");


}

    @Override
    public void mesajyaz() {
        String mesaj =null;
        String iletilecek=null;
        String gonderen=kadi;
        String cleaner;
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------Öğretim Üyesi Mesaj Gönderim Sayfası------------\n");
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
