
package projeodevi;

import java.io.IOException;
import java.util.Scanner;


public class ProjeOdevi {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) throws IOException {
       int s1;
       Scanner secim1=new Scanner(System.in);
        boolean devammı=true; 
        boolean devammıogr=true;
        do{
           
        System.out.println("          ÖĞRENCİ OTOMASYONU        \n          Hoşgeldiniz\n\n üye olmak için    1\n giriş yapmak için 2 \nÇIKIŞ              0 tuşlayınız");
        
         s1=secim1.nextInt();
            
        if(s1==1){
           
            System.out.println("Üyelik biçiminizi seçiniz: Öğrenci üyeliği için 4\n öğretim görevlisi üyeliği için 5\n idari memur üyeliği için 6 tuşlayınız");
            s1=secim1.nextInt();
            
        }
        else if(s1==2){
            System.out.println("Öğrenci girişi için        1\nÖğretim üyesi girişi için  2\nİdari memur girişi için    3 tuşlayınız");
            s1=secim1.nextInt();
        }
        //1=öğrenci girişi 2=öğretim üyesi girişi 3= idari memur girişi 4=öğrenci üyeliği 5=öğretim üyesi üyeliği 6=idari memur üyeliği
        
        
        switch(s1){
            //-----------------------öğrenci girişi başlangıç---------------------
            case 1: 
                
                    ogrenci ogr1=new ogrenci();
                
                    int bolum=ogr1.hangibolum();
                   
                    if(bolum==1){
                         
                        BMbolumu ogrenci1=new BMbolumu(ogr1);
                        do{
                        System.out.println("\nDers Seçme işlemi için               1\n"+ "notlarınızı görüntülemek için        2");
                        System.out.println( "ders Programınızı görüntülemek için  3\n"
                                + "Yoklama Sorgusu için                 4 \nMesaj Yazmak için                    5\nMesajlarınızı görüntülemek için      6\nMesaj silme işlemi için              7\n"
                                + "Üst menü için                        0 tuşlayınız");
                       
                        Scanner sc2=new Scanner(System.in);
                        int secim2=sc2.nextInt();
                        
                        switch(secim2){
                        case 1:
                            ogrenci1.dersSec(ogr1.kadi);
                            break;
                            
                        case 2:
                            ogrenci1.notgorme();
                            break;
                        case 3:
                            ogrenci1.dersprogrami();
                            break;
                        case 4:
                            ogr1.yoklamasorgula();
                            break;
                        case 5:
                            ogr1.mesajyaz();
                            break;
                            
                        case 6:
                            ogr1.mesajgoruntule();
                            break;
                        case 7:
                            ogr1.mesajsil();
                            break;
                        case 0:
                            devammıogr=false;
                            break;
                     
                        }
                        }while(devammıogr);
                    }
                    else if(bolum==2){
                         
                         EEMbolumu ogrenci1=new EEMbolumu(ogr1);
                          do{
                       System.out.println("\nDers Seçme işlemi için               1\n"+ "notlarınızı görüntülemek için        2");
                        System.out.println( "ders Programınızı görüntülemek için  3\n"
                                + "Yoklama Sorgusu için                 4 \nMesaj Yazmak için                    5\nMesajlarınızı görüntülemek için      6\nMesaj silme işlemi için              7\n"
                                + "Üst menü için                        0 tuşlayınız");
                       
                        Scanner sc2=new Scanner(System.in);
                        int secim2=sc2.nextInt();
                        switch(secim2){
                        case 1:
                            ogrenci1.dersSec(ogr1.kadi);
                        case 2:
                            ogrenci1.notgorme();
                            break;
                        case 3:
                            ogrenci1.dersprogrami();
                            break;
                        case 4:
                            ogr1.yoklamasorgula();
                            break;
                        case 5:
                            ogr1.mesajyaz();
                            break;
                            
                        case 6:
                            ogr1.mesajgoruntule();
                            break;
                        case 7:
                            ogr1.mesajsil();
                            break;
                        case 0:devammıogr=false;
                            break;
                      
                        }
                    }while(devammıogr);
                        }
                    
                    else {
                        MMbolumu ogrenci1=new MMbolumu(ogr1);
                        do{
                        System.out.println("\nDers Seçme işlemi için               1\n"+ "notlarınızı görüntülemek için        2");
                        System.out.println( "ders Programınızı görüntülemek için  3\n"
                                + "Yoklama Sorgusu için                 4 \nMesaj Yazmak için                    5\nMesajlarınızı görüntülemek için      6\nMesaj silme işlemi için              7\n"
                                + "Üst menü için                        0 tuşlayınız");
                        
                        Scanner sc2=new Scanner(System.in);
                        int secim2=sc2.nextInt();
                        switch(secim2){
                        case 1:
                            ogrenci1.dersSec(ogr1.kadi);
                        case 2:
                            ogrenci1.notgorme();
                            break;
                        case 3:
                            ogrenci1.dersprogrami();
                            break;
                       case 4:
                            ogr1.yoklamasorgula();
                            break;
                       case 5:
                            ogr1.mesajyaz();
                            break;
                            
                        case 6:
                            ogr1.mesajgoruntule();
                            break;
                        case 7:
                            ogr1.mesajsil();
                            break; 
                       case 0:devammıogr=false;
                            break;
                        }
                    }while(devammıogr);
                        }
                break;
                
                //--------------öğrenci girişi bitiş------------
                
                //------------öğretim üyesi giriş başlangıç--------------
            case 2: 
                        ogretimuyesi ou1=new ogretimuyesi();
                        do{
                        System.out.println("not girme işlemi için           1 \nHarf notu belirlemek için       2 \nYoklama almak için              3 \nYoklama görüntülemek için       4 \n"
                                + "Mesaj Yazmak için               5\nMesajlarınızı görüntülemek için 6\nMesaj silme işlemi için         7\nÇıkış    için                   0 tuşlayınız");
                        
                        Scanner scdeneme=new Scanner(System.in);
                        int secim2=scdeneme.nextInt();
                        switch(secim2){
                            case 1:
                                ou1.notgirme();
                                break;
                        
                            case 2:
                                ou1.harfnotu();
                                break;
                            case 3:
                                ou1.yoklamaal();
                                break;
                            case 4:
                                ou1.yoklamabastir();
                                break;
                            
                            case 5:
                                ou1.mesajyaz();
                                break;
                            case 6:
                                ou1.mesajgoruntule();
                                break;
                            case 7:
                                ou1.mesajsil();
                                break;
                                case 0:
                                devammıogr=false;
                                break;
                        }
                        }while(devammıogr);
                            break;
            //------------------öğretim üyesi giriş bitiş--------------
                
                //---------------------idarimemur girişi başlangıç-------------
            case 3:    idarimemur im1=new idarimemur();
                       do{
                        System.out.println("Ders Programı hazırlamak için     1 \n"
                                + "Üye kaydı Silme işlemi için       4 \n"
                               + "Öğrenci Üyelik Onay Sistemi için  5 \n"
                                + "Mesaj Yazmak için                 6\nMesajlarınızı görüntülemek için   7\nMesaj silme işlemi için           8\nÇıkış için                        0 tuşlayınız");
                       Scanner scdeneme2=new Scanner(System.in);
                       int secim3=scdeneme2.nextInt();
                       if(secim3==1){
                           System.out.println("\n\n1.Sınıf ders programı hazırlamak için 2\n"
                                   + "2.Sınıf ders programı hazırlamak için 3\nÇıkış için                            0 tuşlayınız");
                           
                           secim3=scdeneme2.nextInt();
                       }
                       switch(secim3){
                            case 2:
                               im1.dphazirla1(false);
                               break;
                            case 3:
                               im1.dphazirla1(true);
                               break;
                            case 4:
                               im1.uyesilme();
                               break;
                            case 5:
                               im1.uyeonayı();
                               break;
                                case 6:
                               im1.mesajyaz();
                               break;
                            case 7:
                               im1.mesajgoruntule();
                               break;
                            case 8:
                               im1.mesajsil();
                               break;
                            case 0:
                               devammıogr=false;
                               break;
                       }
                       }while(devammıogr);
                       
                       break;
                //----------------idari memur girişi bitiş--------------
                
                //------------------öğrenci üyeliği başlangıç----------------
            case 4:    uyeol uyelikogr=new uyeol();
                       break;
            //------------------------öğrenci üyeliği bitiş--------------
                
                //--------------------öğretim üyesi üye başlangıç------------
                
            case 5: System.out.println("Lütfen doğrulama kodunuzu giriniz");
                    String doğrulama;
                    Scanner sc=new Scanner(System.in);
                    doğrulama=sc.next();
                    uyeol uyelikou=new uyeol(doğrulama); 
                    break;
                //-----------------öğretim üyesi üye bitiş----------------
                
                //-----------------idarimemur üye başlangıç------------------
            case 6: System.out.println("Lütfen doğrulama kodunuzu giriniz");
                    String doğrulama2;
                    Scanner sc2=new Scanner(System.in);
                    doğrulama2=sc2.next();
                    uyeol uyelikim=new uyeol(doğrulama2,true); 
                    break;
                //---------------idarimemur üye bitiş----------------
            case 0:
                System.out.println("ÇIKIŞ ");
                devammı=false;
        }
    
       }while(devammı);
    }
    
}
