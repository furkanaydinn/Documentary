#include <stdio.h>
#include <stdlib.h>
#include <time.h>
 
int main(){
	srand(time(NULL));
	int siralanacak_dizi[100],n,*ikinciDizi,enKucuk,enBuyuk,fark;
	
	// öncelikle dizi boyutunu girelim....
	
	printf("Siralanacak olan Dizininin  boyutunu girin :"); 
	scanf("%d",&n);
	for(int a=0;a<n;a++){
	
		
		  siralanacak_dizi[a]=rand()%1000; 
    	  
	
	}
	

	
	printf("\nRasgele Olusturulmus olan Dizi : "); //rastgele dizi oluþturuyoruz....
	for(int a=0;a<n;a++){
		printf("%d ",siralanacak_dizi[a]);
	}
	
	// en kücük ve en büyük sayýlar bulunur dizide counting sort algoritmasý baþlangýcý için......
	
	 
	for(int a=0;a<n;a++){
		if(siralanacak_dizi[enKucuk]>siralanacak_dizi[a]){
			enKucuk=a;
		}else if(siralanacak_dizi[enBuyuk]<siralanacak_dizi[a]){
			enBuyuk=a;
		}
	}
	
	printf("\nDizinin En kucuk elemani : %d\nDizinin En buyuk elemani : %d",siralanacak_dizi[enKucuk],siralanacak_dizi[enBuyuk]);
	
	fark=siralanacak_dizi[enBuyuk]-siralanacak_dizi[enKucuk];
	
	ikinciDizi=(int *)malloc((fark+1)*sizeof(int));
	for(int a=0;a<=fark;a++){
		ikinciDizi[a]=0;
	}
	

	
	for(int a=0;a<n;a++){
		ikinciDizi[siralanacak_dizi[a]-siralanacak_dizi[enKucuk]]++;
	}
	
	
	
 
	
 
	printf("\n\nSiralanmis Dizi: ");
	for(int a=0;a<=fark;a++){
		for(int j=0;j<ikinciDizi[a];j++){
			printf("%d ",a+siralanacak_dizi[enKucuk]);
		}
	}
	return 0;
}
