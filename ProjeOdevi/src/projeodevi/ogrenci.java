
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


public class ogrenci extends giris implements Mesaj{
    public String kadi;
    public String sifre;
    public ogrenci(boolean test){
        
    }
    public  ogrenci() {
        System.out.println("kullanıcı adı..:");
        Scanner k=new Scanner(System.in);
        this.kadi=k.next();
        System.out.println("Şifre..:");
        Scanner s=new Scanner(System.in);
        this.sifre=s.next();
        
        
        
        boolean girildimi=girisOGR(this.kadi, this.sifre);
        while(!girildimi){
            System.out.println("kullanıcı adı veya şifre hatalı.\n lütfen tekrar deneyiniz");
            System.out.println("kullanıcı adı...:");

            Scanner sc=new Scanner(System.in);
            this.kadi=sc.next();
            System.out.println("Şifre...:");

            Scanner sc2=new Scanner(System.in);
            this.sifre=sc2.next();
            girildimi=girisOGR(kadi,sifre);
        }
           
    }
    
    public int hangibolum(){
       
        String x=this.kadi.substring(kadi.length()-1);
                //öğrencinin numarasından hangi bölüm olduğunu öğrenir.
        if(x.equals("1")){ //bilgisayar müh sınıf ise;
         return 1;
        }
        else if(x.equals("2")){ //EEM
            return 2;
        }
        else{ //MM
            return 3;
        }
}
    
 void yoklamasorgula() throws FileNotFoundException, IOException{
     
     int hangibolum=hangibolum();
     Vector<String>dersisimleri=new Vector<String>();
     Vector<String>derskodlari=new Vector<String>();
     FileInputStream fstream = new FileInputStream("yoklama.txt");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
     String strLine;
    
    while ((strLine = br.readLine()) != null) {
        String[] tokens = strLine.split(" ");
        if(tokens[0].equals(this.kadi)){
            derskodlari.add(tokens[1]);
        }
    }

    if(hangibolum==1){
        
        FileInputStream fstream2 = new FileInputStream("BMderslistesi.txt");
        DataInputStream in2 = new DataInputStream(fstream2);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String strLine2;
    
        while ((strLine2 = br2.readLine()) != null) {
            String[] tokens2 = strLine2.split(" ");
            for(int i=0;i<derskodlari.size();i++){
                if(tokens2[0].equals(derskodlari.get(i))){  
                dersisimleri.add(tokens2[1]);
                
                }
            }
        }
     br2.close();
    }
    if(hangibolum==2){
        FileInputStream fstream2 = new FileInputStream("EEMderslistesi.txt");
        DataInputStream in2 = new DataInputStream(fstream2);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String strLine2;
    
        while ((strLine2 = br2.readLine()) != null) {
            String[] tokens2 = strLine2.split(" ");
            for(int i=0;i<derskodlari.size();i++){
                if(tokens2[1].equals(derskodlari.get(i))){  
                dersisimleri.add(tokens2[1]);
                }
            }
        }
     br2.close();
    }
    if(hangibolum==3){
        FileInputStream fstream2 = new FileInputStream("MMderslistesi.txt");
        DataInputStream in2 = new DataInputStream(fstream2);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String strLine2;
    
        while ((strLine2 = br2.readLine()) != null) {
            String[] tokens2 = strLine2.split(" ");
            for(int i=0;i<derskodlari.size();i++){
                if(tokens2[1].equals(derskodlari.get(i))){  
                dersisimleri.add(tokens2[1]);
                }
            }
        }
    br2.close(); 
    }
         
 br.close();
  FileInputStream fstream3 = new FileInputStream("yoklama.txt");
        DataInputStream in3 = new DataInputStream(fstream3);
        BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
        String strLine3=null;
        for (int t=0;t<dersisimleri.size();t++) {
            strLine3 = br3.readLine();
            String[] tokens3 = strLine3.split(" ");
            System.out.println("Ders Kodu:"+tokens3[1]+" Ders Adı:"+dersisimleri.get(t)+" Tarih:"+tokens3[2]+".2019");
        t++;
        }
 
 }

    @Override
    public void mesajyaz() {
        String mesaj =null;
        String iletilecek=null;
        String gonderen=kadi;
        String cleaner;
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------Öğrenci Mesaj Gönderim Sayfası------------\n");
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
             //wr.append("Gonderen:");
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