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
public class  uyeol extends giris {
    boolean dogrumu=false;
    boolean onay=false;
      uyeol() throws IOException{
        System.out.println("Lütfen öğrenci numaranızı girin");
        Scanner sc=new Scanner(System.in);
        String kadi=sc.next();
        
        System.out.println("Lütfen bir şifre berlileyin.Şifreniz en az 6 rakamdan oluşmalıdır ");
        Scanner bsifre=new Scanner(System.in);
        String sifre1=bsifre.next();
        
        System.out.println("Şifreyi tekrar girin ");
         Scanner isifre=new Scanner(System.in);
         String sifre2=isifre.next();
        
         while(!dogrumu) //şifrenin kurallara uygunluğunu test eder.
            if(sifre1.equals(sifre2)&& sifre1.length()>=6){
                File file=new File("onay.txt");
                FileWriter filewriter=new FileWriter(file,true);
                BufferedWriter wr=new BufferedWriter(filewriter); 
                wr.append(kadi);
                wr.append(" "+sifre1);
                System.out.println("\n\n");
                System.out.println("Üyelik başvurunuz idari birime iletilmiştir.");
                 System.out.println("\n");
                wr.close();
                dogrumu=true;
            }
        
            else{ //uygun değilse şiifreyi tekrar alır.
                System.out.println("şifreniz kabul edilmedi!");
                System.out.println("Lütfen bir şifre berlileyin.Şifreniz en az 6 rakamdan oluşmalıdır ");
                Scanner ysifre=new Scanner(System.in);
                sifre1=ysifre.next();
                System.out.println("Şifreyi tekrar girin ");
                Scanner iysifre=new Scanner(System.in);
                sifre2=iysifre.next();
        }
    }

      uyeol(String dogrulama) throws IOException{ //öğretim üyesi için üye olma.
         Scanner bf = null;
          try {
            bf = new Scanner(new File("uyeolmasifresi.txt"));
            String kod=bf.next();
            while(onay==false){
            if(kod.equals(bf)){ //onay kodu doğruysa öğretim üyesine kayıt olma şansı verir.
                System.out.println("Lütfen kullanıcıadınızı girin");
                Scanner sc=new Scanner(System.in);
                String kadi=sc.next();
                System.out.println("Lütfen bir şifre berlileyin.Şifreniz en az 6 rakamdan oluşmalıdır ");
                Scanner tsifre=new Scanner(System.in);
                String sifrey=tsifre.next();
                System.out.println("Şifreyi tekrar girin ");
                Scanner isifre=new Scanner(System.in);
                String sifre2oy=isifre.next();
                
                while(dogrumu!=true){
                    if(sifrey.equals(sifre2oy)&& sifrey.length()>=6){
                        BufferedWriter wr=new BufferedWriter(new FileWriter("uyelik.txt",true)); 
                        wr.append("\n");
                        wr.append(kadi);
                        wr.append(" "+sifre2oy);
                        System.out.println("\n\n");
                        System.out.println("Başarıyla üye oldunuz!");
                        System.out.println("\n");
                        wr.close();
                        dogrumu=true;
                        onay=true;
                        super.girisOU(kadi,sifrey);
                    }
                    else{
                        System.out.println("şifreniz kabul edilmedi!");
                        System.out.println("Lütfen bir şifre berlileyin.Şifreniz en az 6 rakamdan oluşmalıdır ");
                        Scanner oysifre=new Scanner(System.in);
                         sifrey=oysifre.next();
                        System.out.println("Şifreyi tekrar girin ");
                        Scanner iysifre=new Scanner(System.in);
                        sifre2oy=iysifre.next();
                    }
                }
            }
            else{
                System.out.println("Doğrulama kodu hatalı!");
                System.out.println("Lütfen doğrulama kodunu bir daha girin..:");
               
                Scanner k=new Scanner(System.in);
                kod=k.next();
                
                
            }
            }
            
       } catch (FileNotFoundException ex) {
            Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
      uyeol(String dogrulama,boolean test) throws IOException{ //İdari memur üye olma fonksiyonu.
          boolean doğruluk=false;
          boolean onaylık=false;
        Scanner bf = null;
          try {
            bf = new Scanner(new File("uyeolmasifresi.txt"));
            String kod=bf.next();
            kod=bf.next();
            while(onay==false){
            if(kod.equals(dogrulama)){ //doğrulama kodu doğruluğunu test eder.
                System.out.println("Lütfen kullanıcıadınızı girin");
                Scanner sc=new Scanner(System.in);
                String kadi=sc.next();
                System.out.println("Lütfen bir şifre berlileyin.Şifreniz en az 6 rakamdan oluşmalıdır ");
                Scanner tsifre=new Scanner(System.in);
                String sifrey=tsifre.next();
                System.out.println("Şifreyi tekrar girin ");
                Scanner isifre=new Scanner(System.in);
                String sifre2oy=isifre.next();
                while(!doğruluk){
                    if(sifrey.equals(sifre2oy)&& sifrey.length()>=6){
                        BufferedWriter wr=new BufferedWriter(new FileWriter("uyelik.txt",true)); 
                        wr.append("\n");
                        wr.append(kadi);
                        wr.append(" "+sifre2oy);
                        System.out.println("\n\n");
                        System.out.println("Başarıyla üye oldunuz!");
                        System.out.println("\n");
                        wr.close();
                        doğruluk=true;
                        onay=true;
                        super.girisIM(kadi,sifrey);
                    }
                    else{
                        System.out.println("şifreniz kabul edilmedi!");
                        System.out.println("Lütfen bir şifre berlileyin.Şifreniz en az 6 rakamdan oluşmalıdır ");
                        Scanner oysifre=new Scanner(System.in);
                         sifrey=oysifre.next();
                        System.out.println("Şifreyi tekrar girin ");
                        Scanner iysifre=new Scanner(System.in);
                        sifre2oy=iysifre.next();
                    }
                }
            }
            else{
                System.out.println("Doğrulama kodu hatalı!");
               
            }
            }
       } catch (FileNotFoundException ex) {
            Logger.getLogger(BMbolumu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }


}
