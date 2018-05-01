
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

	int b[3];/*bilgisayarýn ürettigi sayilari basamaklarýna ayrýlýp tutuldugu dizi*/     
	int k[3];/*kullanýcýnýn girdigi sayýlarý basamaklarýna ayýrýp tutan dizi*/
	int tahmin;       

	int d=0;
	while(d<9)/*ana while*/
     {
		d++;       
        
		int e=0;

		while(e<100)/*bu kýsým 4 basamaklý sayýnýn uretýldýgý kýsým*/
	 {     
	e++;      
        
	int rastgele=1000+rand()%9000;     
	b[0]=(rastgele/1000);
	b[1]=(rastgele/100)%10;    
	b[2]=(rastgele/10)%10;     
	b[3]=rastgele%10;     

	
	if(b[0]!=b[1] && b[0]!=b[2] && b[0]!=b[3] && b[1]!=b[2] && b[1]!=b[3] && b[2]!=b[3])/*burasý üretilen sayýnýn rakamlarýnýn*/ 
	                                                                                     /*farklý olmasý için*/   
	if(b[0]!=0 && b[1]!=0 && b[2]!=0 && b[3]!=0 )/*bu kýsýmda sýfýr üretilmemesi icin*/
	break;                                       /*cunku bazý hatalara yol acýyor*/
}         
          
int sayac=0;
for(int i=1;i<9;i++)/*ana for*/
{
        
sayac++;/*bu sayac tutulan tahminleri daha sonra forla kullanýrken for dongusunu kontrol icin*/
  int tahmin[8];/*bu dizi kullanýcý tahmýnlerýný tutmak icin*/

printf("\n%d.TAHMiNiNiZi GiRÝNÝZ=",i);
  scanf("%d",&tahmin[i]);     
  

t[0]=tahmin[i]/1000;   /*kullanýcýnýn girdigi sayýlarýn basamaklarýna ayrýldýgý kýsým*/                               
t[1]=(tahmin[i]/100)%10;    
t[2]=(tahmin[i]/10)%10;     
t[3]=tahmin[i]%10;     


if(s[0]==t[0])/*burdaký kýsým ise kullanýcý ile býlgýsayarýn ürettði sayýlarýn kontrol*/
{              /*edýlýp ona gore ekrena **** 23** gibi cýktýlarýn yapýldýgý kýsým*/
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

  printf("  ip ucu listesi=");/*ip ucu listesinin olusturuldugu kýsým*/       
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

if(s[0]==t[0]&&s[1]==t[1]&&s[2]==t[2]&&s[3]==t[3])/*bu kýsým kullanýcýnýn dogru sayýyý girip girmedigini kontrol eder */
{
printf("\n\n<<BRAVO SAYiYi BULDUNUZ>>");                                                  
printf("\n\nSAYi %d%d%d%d idi",s[0],s[1],s[2],s[3]);
printf("\n\nTAHMiNLERiNiZ\n");


for(int a=1;a<=sayac;a++)   /*bu kýsým tahmin[] dizisinde tutmus oldugum dizileri yazdýrmak icin*/
{                          /*burada sayac kullanmamým sebebý eger kullanýcý sayýyý 2 3 tahmýnde býldýý zaman dizinin
                           diger elemanlarýna, kendi deger atatýgý için boyle bi cozum buldum*/
printf("\n%d",tahmin[a]);/*dizide tutulan tahminlerin yazdýrýldýgý yer*/
}
printf("\n\nSAYiYi %d DENEMEDE BULDUNUZ",i);
printf("\n\n\n---YENi SAYi URETiLDi---");
break;
}

if(i>7)/*bu kýsým kullanýcý sayýyý bulamazsa devreye girer*/
{
printf("\n\n!!MAALESEF SAYiYBULAMADiNiZ!!");
printf("\n\nSAYi %d%d%d%d idi",s[0],s[1],s[2],s[3]);
printf("\n\n\n---YENi SAYi URETiLDi---");
break;
}

}/*ana for un*/                                       
}/*ana whileninin parantezi*/
}/*fonksiyonun parantezi*/






