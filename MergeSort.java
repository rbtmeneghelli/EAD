import java.util.Scanner;
import java.util.Random;

public class MergeSort
{
    private int[] data;
    private static Random generator = new Random();
    private long comp = 0;
    private long trocas = 0;

	public MergeSort(int size)
    {
        data = new int[size];
		System.out.println("Vetor original: ");
		System.out.print ("[");
        for (int i = 0; i < size; i++)
        {
            data[i] = generator.nextInt(size);
			System.out.print(data[i]+" ");
		}
		System.out.println("]\n");
    }

    public long getComp() {
        return comp;
    }

    public void setComp(long comp) {
        this.comp = comp;
    }

    public long getTrocas() {
        return trocas;
    }

    public void setTrocas(long trocas) {
        this.trocas = trocas;
    }

    public void sort()
    {
        sortArray(0, data.length - 1);
    }

    public void sort(int[] a)
    {
        data = a;
        sort();
    }

    private void sortArray(int esq, int dir)
    {
        if ((dir - esq) >= 1)
        {
            int meio1 = (esq + dir) / 2;
            int meio2 = meio1 + 1;

            sortArray(esq, meio1);
            sortArray(meio2, dir);

            merge(esq, meio1, meio2, dir);
        }
    }

    private void merge(int esq, int meio1, int meio2, int dir)
    {
        int iEsq = esq;
        int iDir = meio2;
        int indice = esq;
        int[] combinacao = new int[data.length];

        while (iEsq <= meio1 && iDir <= dir)
        {
            comp++;
            if (data[iEsq] <= data[iDir])
            {
                combinacao[indice++] = data[iEsq++];
                trocas++;
            }
            else
            {
                combinacao[indice++] = data[iDir++];
                trocas++;
            }
        }

        if (iEsq == meio2)
        {
            comp++;
            while (iDir <= dir)
            {
                combinacao[indice++] = data[iDir++];
                trocas++;
            }
        }
        else
        {
            while (iEsq <= meio1)
            {
                combinacao[indice++] = data[iEsq++];
                trocas++;
            }
        }

        for (int i = esq; i <= dir; i++)
        {
            data[i] = combinacao[i];
            trocas++;
        }
    }

	public void Result()
	{
		System.out.println ("Vetor ordenado:");
		System.out.print ("[");
        for(int i=0; i < data.length; i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println("]\n");
	}

    public String subvetor(int esq, int dir)
    {
        StringBuffer temp = new StringBuffer();

        for (int i = 0; i < esq; i++)
        {
            temp.append("   ");
        }

        for (int i = esq; i <= dir; i++)
        {
            temp.append(" " + data[i]);
        }

        return temp.toString();
    }


    public String toString()
    {
        return subvetor(0, data.length - 1);
    }

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner (System.in);
		System.out.print("Entre com o numero de posições do Vetor : ");

		int value = scan.nextInt() ;

        MergeSort srt = new MergeSort(value);
        srt.sort();
        srt.Result();
       	System.out.println ("Numero de troca de posicoes = "+ srt.getTrocas());
		System.out.println ("Numero de comparacoes de valores = " + srt.getComp());

    }
}
