/*Bu program bir sayi tahmin  oyunudur.Oyunumuz şu şekildedir sayılarımız rastgele üretilir ve oyunucunun bu sayıyı bilmesi istenir.
Oyuncunun girdiği sayılara karşılık,oyun içinde her bir adımda girilen rakamların ne kadarının doğru girildiğini ve
tahmin edilen sayının girilen rakamlarının ne kadarının doğru ve yanlış yerde bulunduğuna dair bilgiler veriyor.  
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>

struct n {    // n veri yapısını oluştur
	double puan ;
        char* isim;
	n* next;
};
typedef n node; // n veri yapısını tekrar tekrar kullan (typedefinetional)


   
void bastir(node*r);          
node* ekleSirali(node*r,double puan,char* isim );      //sıralı bir biçimde puanı ve onunla beraber puan sahibini ekle
double puanf(int arti, int eski,int hak);
void sayiuret (void);
void sayial(int i);
int uretilen[4];
int girilen[4];


int main(){
	node* root;
	root=NULL;
fromhere :
	int secenek =0 ; 
    printf("\n\n\n 				 ********  menu  ******** \n");  /** menü oluşumu **/
    printf("1- oyunu baslamak icin 1 giriniz .\n");
    printf("2- skor tablusunu gostermek icin 2 giriniz .\n");
    printf("3- oyundan cikmak  icin 3 giriniz .\n");
    scanf("%d",&secenek);     
    
    //Oluşturduğumuz menü için şart bloklarıyla seçeneklerimizi kontrol ediyoruz.
    if(secenek==1){
    	char isim[256] ; 
    	printf("\nisminizi giriniz : \n");
    	
    	scanf ("\n%[^\n]%*c",&isim);
    
     	       
		srand(time(NULL)); 
	    sayiuret(); 
	    //printf("\n : %d %d %d %d  ",uretilen[0],uretilen[1],uretilen[2],uretilen[3]);  üretilen sayıyı gösteriyor.
	    for(int hak =1 ; hak<11 ; hak++){ //kaç kullanım hakkında bilindiğine dair bilgi veren bölüm
			int dogru  = 0 ; 
			int yanlis = 0 ;
		    sayial(hak);
		        //üretilen sayının ve her bir adımdaki girilen sayının rakamlarının herbir indisi için birbirine eşitliklerini kontrol et
			for(int i=0 ; i<=3 ; i++){
			    for(int j=0 ; j<=3 ; j++){
				    if (uretilen[i]==girilen[j]){		    
				    	if(i==j){
				    		dogru++;
				    		break;
						}
						else{
							yanlis++;
						}
					}	
		    	}
		    }
		
		    if(dogru==4){
		    double puan = 0;
		    puan=puanf( dogru,  yanlis , hak); //puanımızı girilen sayının doğru,yanlış ve hak parametrelerine göre belirliyoruz.
		    printf("\ntahmininiz dogrudur : %d %d %d %d =>  -%d  +%d   puaniniz: %.15g  :) ",girilen[0],girilen[1],girilen[2],girilen[3],yanlis,dogru,puan);
		    
		    root=ekleSirali(root,puan,isim);
		    goto fromhere;
			}
			
			else{
				if(hak==10){
					double puan = 0;
					
		            if(dogru==0 && yanlis==0){
		            	puan=0;
					}
		            else{
		           
		            puan=puanf( dogru,  yanlis , hak);
					}
					
		            	printf("\n\n");
						printf("				 -----------------------");
						printf("\n");
						printf("				| maalesef bilemediniz  |");
						printf("\n");
						printf(" 				 -----------------------");
		            printf("\ntahmininiz : %d %d %d %d =>  -%d  +%d   puaniniz: %.15g  :) ",girilen[0],girilen[1],girilen[2],girilen[3],yanlis,dogru,puan);
		            printf("\n tahmin edemediginiz sayi = %d %d %d %d  ",uretilen[0],uretilen[1],uretilen[2],uretilen[3]);
		            root=ekleSirali(root,puan,isim);
		            goto fromhere;
				}
			printf("\ntahmininiz : %d %d %d %d =>  -%d  +%d ",girilen[0],girilen[1],girilen[2],girilen[3],yanlis,dogru);
			printf("\n");
			}	
		}
	

	}
	
	else if(secenek==2){
	 bastir(root);
	 printf("\n");
	goto fromhere;
	}
	
	 else if(secenek==3){
	  return 0 ;
	 } 
	 else {
	 printf("yanlis bir secenek girdiniz ");
	 goto fromhere;
	 }
	 
	 
}
void sayiuret (void){ //sayi üretilen fonksiyon
	    int e = 0 ; 
		while(e<100)
		{       
			int rastgele=1000+rand()%9000;     
			uretilen[0]=(rastgele/1000);
			uretilen[1]=(rastgele/100)%10;    
			uretilen[2]=(rastgele/10)%10;     
			uretilen[3]=rastgele%10;  
			if(uretilen[0]!=uretilen[1] && uretilen[0]!=uretilen[2] && uretilen[0]!=uretilen[3] && uretilen[1]!=uretilen[2] && uretilen[1]!=uretilen[3] && uretilen[2]!=uretilen[3])
			break; 	
			e++;                           
		}         
}
void sayial(int i ){ //kullanıcının her bir adımında üreteceği sayının kullanıldığı fonksiyon
	sayial:
     		int tahmin = 0; 
     		int basamak =0 ; 
			printf("\n %d : (4)basamakli tahmininizi giriniz=",i);
		
			scanf("%d",&tahmin); 
			
		  
			
			if(tahmin<1000||tahmin>9999){
			printf("\n		******** hatali bir giris yaptiniz ********");
			goto sayial;
			}
	                //herbir üretilen sayının rakamları ilgili basamak değerlerine böl ve girilen sayının indislerine eşitle
			girilen[0]=tahmin/1000;                              
			girilen[1]=(tahmin/100)%10;    
			girilen[2]=(tahmin/10)%10;     
			girilen[3]=tahmin%10;  
			

}
		  		    
			

// puan tahmini için oluşturduğumuz ölçüm metriği
double puanf(int arti, int eksi,int hak){
	double puan =0 ; 
	puan = (10*arti)+(5*eksi)+(1000/hak)-((arti*eksi)/(arti+eksi)) ;
	return puan ;
}

node* ekleSirali(node*r,double puan,char* isim){
	if (r==NULL){
	r=(node*)malloc(sizeof(node)); // bellekten bir yer ayır
	r->next=NULL;
	r->puan=puan;
	r->isim=strdup(isim);
	return r;
	}
	if(r->puan<puan){
	node*temp=(node*)malloc(sizeof(node));
	temp->isim=strdup(isim);
	temp->puan=puan;
	temp->next=r;
	
	return temp;  // geçici değişkeni döndür
	}
	node*iter=r; // r linked listini itere ata
	while(iter->next!=NULL && iter->next->puan>puan){
		iter=iter->next;
	}
	node*temp=(node*)malloc(sizeof(node));
	temp->next=iter->next;  //ilk değişkeni kaybetmemek için veri yapısındaki bir sonraki başka bir değişkene aktarıyoruz 
	iter->next=temp;
	temp->puan=puan;
	temp->isim=strdup(isim); // char değişkenini bir başka char değişkenine atamak için
	return r;
}

	void bastir(node*r){ // nulla eşit olmadığı zaman tüm elemanları göster
	
		for(int i=1 ;r!=NULL ;i++ ){
			if(i==11){
				break ; 
			}
			
			printf("%d: isim:  %s => %g\n",i,r->isim,r->puan);
			r=r->next;
		}
    
	}

