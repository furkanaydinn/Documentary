#include <stdio.h>
#include <stdlib.h>
int main(void)
{
int siralanacak_dizi[100],a,b,k,yedek;
    printf("Siralanacak Dizinin Eleman Sayisini Giriniz..:"); scanf("%d",&k);
    for(a=0;a<k;a++)
    {
        printf("%d. Sayiyi Giriniz..:",a+1); scanf("%d",&siralanacak_dizi[a]);
    }
    for(a=0;a<k;a++)
    {
        for(b=0;b<(k-1);b++)
        {
            if(siralanacak_dizi[a]>siralanacak_dizi[b])
            {
                yedek=siralanacak_dizi[a];
                siralanacak_dizi[a]=siralanacak_dizi[b];
               siralanacak_dizi[b]=yedek;
            }
        }
    }
    for(a=0;a<k;a++)
    {
        printf("%d ",siralanacak_dizi[a]);
    }
}
