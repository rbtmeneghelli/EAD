import java.util.Random;
import java.util.Scanner;

class QSort
{

	static int numTrocas=0;
	static int numComp=0;

	public void troca(int array[], int i, int j)
	{
		int aux = array[i]; // é usada uma variável aux para a troca
		array[i] = array[j]; // de posições.
		array[j] = aux;
	}

	public void quicksort(int p, int q, int array[])
	{
		if (p < q)
		{
			int x = particao(p, q, array); // chama o método para divisão do vetor
			quicksort(p, x - 1, array); // executa o quicksort na metade esquerda
			quicksort(x + 1, q, array); // executa o quicksort na metade direita
		}
	}


	public int particao(int p, int q, int array[])
	{
		int temp1=0,temp2=0;
		int j = p - 1;
		int aux = array[q];

			for (int i = p; i <= q; i++)
			{
				temp2++;
				if (array[i] <= aux)
				{
					troca(array, i, ++j);
					temp1++;
				}
			}

		numTrocas+=temp1;
		numComp+=temp2;
		return j;
	}

	public static void main(String arguments[])
	{

		QSort qcksort = new QSort();

		Scanner scan = new Scanner (System.in);
		System.out.print("Entre com o numero de posições do Vetor : ");

		int value = scan.nextInt() ;

		int[] vetor = new int [value];

		for(int i=0; i < vetor.length; i++)
      	{
        	 Random rnd = new Random();
         	vetor[i] = rnd.nextInt(value);
      	}

		System.out.println("Vetor original: ");
		System.out.print ("[");

		for (int i=0;i<vetor.length;i++)

		System.out.print(vetor[i]+" ");
		System.out.println("]\n");

		qcksort.quicksort (0,vetor.length-1,vetor);

		System.out.println ("Vetor ordenado:");
		System.out.print ("[");

		for (int i=0;i<vetor.length;i++)

		System.out.print(vetor[i]+" ");
		System.out.println ("]\n");

		System.out.println ("Numero de troca de posicoes = "+numTrocas);
		System.out.println ("Numero de comparacoes de valores = "+numComp);
	}
}