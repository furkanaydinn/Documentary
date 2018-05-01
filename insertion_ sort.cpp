#include <stdio.h>

int main()
{
  int n, i, k, temp,artim=0;

  printf("Girilecek eleman sayisi\n");
  scanf("%d", &n);
  int dizi[n];


  for (i = 0; i < n; i++) {
  printf("Sayi gir\n");
    scanf("%d", &dizi[i]);
  }

  for (i = 1 ; i <= n - 1; i++) {
    k = i;

    while ( k > 0 && dizi[k] < dizi[k-1]) {
       temp       = dizi[k];
      dizi[k]     = dizi[k-1];
      dizi[k-1]   = temp;
  k--;
  artim++;
   printf("\n\n     %d. adim\n\n",artim);
    for(int j=0;j<=n-1;j++){
     printf("%d-",dizi[j]);
 }
    }
    

  }

  printf("\nDizinin siralanmis hali :\n");

  for (i = 0; i <= n - 1; i++) {
    printf("%d\n", dizi[i]);
  }

  return 0;
}
