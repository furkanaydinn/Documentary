
#include<stdio.h>/*PROGRAMCI=MEHMET TOPCU*/
#include<stdlib.h>/*PROGRAM=SAYI BULMA OYUNU*/
#include<time.h>
               

void sayibul(void);


int main()
{
srand(time(NULL));     
printf("4 basamakli sayi giriniz ");


sayibul();
     
system("PAUSE");
return 0;
}    

void sayibul(void)
{

	int b[3];/*bilgisayar�n �rettigi sayilari basamaklar�na ayr�l�p tutuldugu dizi*/     
	int k[3];/*kullan�c�n�n girdigi say�lar� basamaklar�na ay�r�p tutan dizi*/
	int tahmin;       

	int d=0;
	while(d<9)/*ana while*/
     {
		d++;       
        
		int e=0;

		while(e<100)/*bu k�s�m 4 basamakl� say�n�n uret�ld�g� k�s�m*/
	 {     
	e++;      
        
	int rastgele=1000+rand()%9000;     
	b[0]=(rastgele/1000);
	b[1]=(rastgele/100)%10;    
	b[2]=(rastgele/10)%10;     
	b[3]=rastgele%10;     

	
	if(b[0]!=b[1] && b[0]!=b[2] && b[0]!=b[3] && b[1]!=b[2] && b[1]!=b[3] && b[2]!=b[3])/*buras� �retilen say�n�n rakamlar�n�n*/ 
	                                                                                     /*farkl� olmas� i�in*/   
	if(b[0]!=0 && b[1]!=0 && b[2]!=0 && b[3]!=0 )/*bu k�s�mda s�f�r �retilmemesi icin*/
	break;                                       /*cunku baz� hatalara yol ac�yor*/
}         
          
int sayac=0;
for(int i=1;i<9;i++)/*ana for*/
{
        
sayac++;/*bu sayac tutulan tahminleri daha sonra forla kullan�rken for dongusunu kontrol icin*/
  int tahmin[8];/*bu dizi kullan�c� tahm�nler�n� tutmak icin*/

printf("\n%d.TAHMiNiNiZi GiR�N�Z=",i);
  scanf("%d",&tahmin[i]);     
  

t[0]=tahmin[i]/1000;   /*kullan�c�n�n girdigi say�lar�n basamaklar�na ayr�ld�g� k�s�m*/                               
t[1]=(tahmin[i]/100)%10;    
t[2]=(tahmin[i]/10)%10;     
t[3]=tahmin[i]%10;     


if(s[0]==t[0])/*burdak� k�s�m ise kullan�c� ile b�lg�sayar�n �rett�i say�lar�n kontrol*/
{              /*ed�l�p ona gore ekrena **** 23** gibi c�kt�lar�n yap�ld�g� k�s�m*/
printf("%d",s[0]);
}
else
{
printf("*");
}
if(s[1]==t[1])
{
printf("%d",s[1]);
}
else
{
printf("*");
}
if(s[2]==t[2])
{
printf("%d",s[2]);
}
else
{
printf("*");
}    
if(s[3]==t[3])
{
printf("%d",s[3]);
}
else
{
printf("*");
}

  printf("  ip ucu listesi=");/*ip ucu listesinin olusturuldugu k�s�m*/       
   if(s[3]==t[0])   
     printf("%d",t[0]); 
      if(s[0]==t[2])
       printf("%d",t[2]);
        if(s[0]==t[3])  
         printf("%d",t[3]); 
          if(s[1]==t[0])
           printf("%d",t[0]);
            if(s[3]==t[2])   
              printf("%d",t[2]); 
               if(s[1]==t[2])
                printf("%d",t[2]);
                 if(s[1]==t[3])
                  printf("%d",t[3]);
                   if(s[2]==t[0])   
                    printf("%d",t[0]);
                     if(s[3]==t[1])   
                      printf("%d",t[1]);  
                       if(s[2]==t[1])   
                        printf("%d",t[1]);  
                         if(s[2]==t[3])   
                          printf("%d",t[3]);  
                           if(s[0]==t[1])       
                            printf("%d",t[1]);

if(s[0]==t[0]&&s[1]==t[1]&&s[2]==t[2]&&s[3]==t[3])/*bu k�s�m kullan�c�n�n dogru say�y� girip girmedigini kontrol eder */
{
printf("\n\n<<BRAVO SAYiYi BULDUNUZ>>");                                                  
printf("\n\nSAYi %d%d%d%d idi",s[0],s[1],s[2],s[3]);
printf("\n\nTAHMiNLERiNiZ\n");


for(int a=1;a<=sayac;a++)   /*bu k�s�m tahmin[] dizisinde tutmus oldugum dizileri yazd�rmak icin*/
{                          /*burada sayac kullanmam�m sebeb� eger kullan�c� say�y� 2 3 tahm�nde b�ld�� zaman dizinin
                           diger elemanlar�na, kendi deger atat�g� i�in boyle bi cozum buldum*/
printf("\n%d",tahmin[a]);/*dizide tutulan tahminlerin yazd�r�ld�g� yer*/
}
printf("\n\nSAYiYi %d DENEMEDE BULDUNUZ",i);
printf("\n\n\n---YENi SAYi URETiLDi---");
break;
}

if(i>7)/*bu k�s�m kullan�c� say�y� bulamazsa devreye girer*/
{
printf("\n\n!!MAALESEF SAYiYBULAMADiNiZ!!");
printf("\n\nSAYi %d%d%d%d idi",s[0],s[1],s[2],s[3]);
printf("\n\n\n---YENi SAYi URETiLDi---");
break;
}

}/*ana for un*/                                       
}/*ana whileninin parantezi*/
}/*fonksiyonun parantezi*/






