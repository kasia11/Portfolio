package butelka;

import java.util.Scanner;

public class Butelka {

   private double ileLitrow;
    
    Butelka()
    {
        
    }
    Butelka(double ileLitrow)
    {
           this.ileLitrow = ileLitrow;
    }
    double getIleLitrow()
    {
            return ileLitrow;  
    }
    void wlej (double ilosc)
    {
        this.ileLitrow += ilosc;  
    }
    void wylej (double ilosc)
    {
        if(ilosc < ileLitrow)
        {
            this.ileLitrow -= ilosc;
        }
        else
            System.out.println("Nie ma tyle w butelce. Spróbuj jeszcze raz.");
    }
    void przelej (double ilosc, Butelka gdziePrzelac)
    {
        if(ilosc < ileLitrow){
            this.wylej(ilosc);
            gdziePrzelac.wlej(ilosc);
        }
        else
            System.out.println("Nie ma tyle w butelce. Spróbuj jeszcze raz.");
    }
        
        
    public static void main(String[] args) {
        
        Butelka[] butelka = new Butelka[3];

        //Tworzymy tablice butelek z domyślną zawartością 0
        for(int i = 0; i < butelka.length; i++)
            {     
                butelka[i] = new Butelka();         
                System.out.println("Butelka nr " + (int)i + " ma " + butelka[i].getIleLitrow() + " litrow.");
            }

        while(1<2){    
        Scanner in = new Scanner(System.in); 

            System.out.println("Wybierz numer butelki od 0 do " + (butelka.length - 1) + ".");
                int i = in.nextInt();
            if(i < 0 || i > butelka.length - 1) {
                System.out.println("Błędne dane. Spróbuj jeszcze raz.");
                continue;
            } 
            else{
                System.out.println("Co chcesz zrobić? 0 - Zakończ program, 1 - Wlej, 2 - Wylej, 3 - Przelej.");
                    int wybor = in.nextInt();
                    
                switch (wybor)
                {  
                    case 0 -> {
                        System.out.println("Koniec programu.");
                        break;
                    }
                    case 1 -> {
                        System.out.println("Ile litrow chcesz wlać?");
                        butelka[i].wlej(in.nextDouble());
                    }
                    case 2 -> {
                        System.out.println("Ile litrow chcesz wylać?");
                        butelka[i].wylej(in.nextDouble());
                    }
                    case 3 -> {
                        System.out.println("Wybierz numer butelki do której chcesz przelać od 0 do " + (butelka.length - 1) + ".");
                        int j = in.nextInt();
                        if(j < 0 || j > butelka.length - 1) {
                            System.out.println("Błędne dane. Spróbuj jeszcze raz.");
                            continue;
                        }
                        else
                        {
                            System.out.println("Ile litrow chcesz przelać?");
                            butelka[i].przelej(in.nextDouble(), butelka[j]);
                        } 
                    }
                    default -> {
                        System.out.println("Błędne dane. Spróbuj jeszcze raz.");
                        continue;
                    }
                }
            }
//           

            //Wyświetla aktualną zawartość butelek
            for(i = 0; i < butelka.length; i++)
            {       
                System.out.println("Butelka nr " + (int)i + " ma " + butelka[i].getIleLitrow() + " litrow.");
            }

        }
    }

    
}
