#include<stdlib.h>
#include<stdio.h>

void EscreverResistencia(int[4]);

int main()
{
    int iCor[4];
    int iIndice,iRet;
   
    printf("Preto: 0\tMarrom: 1\tVermelho: 2\nLaranja: 3\tAmarelo: 4\tVerde: 5\nAzul: 6  \tVioleta: 7\tCinza: 8\nBranco: 9\tOuro: 10\tPrata: 11\n\n");
   
    for(iIndice = 0; iIndice < 3; iIndice++)
    {
        do
        {
            printf("Entre com a %d° cor: ",(iIndice+1));
            iRet = scanf("%d",&iCor[iIndice]);
           
            if(iCor[iIndice] < 0 || iCor[iIndice] > 9)
                printf("Digite um valor válido para a %d° cor!\n",(iIndice + 1));
           
        }while(iCor[iIndice] < 0 || iCor[iIndice] > 9);
    } 
   
    while(1)
    {
        printf("Entre com a 4° cor: ");
            iRet = scanf("%d",&iCor[3]);
       
        if((iCor[3] < 12 && iCor[3] > 9) || (iCor[3] > 0 && iCor[3] < 5))
            break;
        else
            printf("Digite um valor válido para a 4° cor!\n");
    }
    EscreverResistencia(iCor);
}

void EscreverResistencia(int pResistor[4])
{
    printf("\n %d%d", pResistor[0], pResistor[1] );
   
    int iIndice;
    for(iIndice = 0;iIndice < pResistor[2];iIndice ++)
    {
        printf("0");
    }
   
    printf("Ω");
    char cVariacao[2];
    switch(pResistor[3])
    {
        case 10:
            cVariacao[0] = '5';
            break;
        case 11:
            cVariacao[0] = '1';
            cVariacao[1] = '0';
            break;
        default:
            cVariacao[0] = pResistor[3];
            break;
    }
   
    printf(" %s \%",cVariacao);
}

/*char[6] BuscarMultiplicador(int pCor)
{
    char cRetorno[6];
    int iIndice;
    for(iIndice;iIndice < pCor;pIndice ++)
    {
        cRetorno[iIndice] = '0';
    }
    return cRetorno;
}*/