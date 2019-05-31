/**
 * Título da classe. Insira aqui uma pequena descrição sobre a mesma.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Apr 30, 2019 at 9:55:00 PM
 * @version 0.1
 */
package classes;

import java.util.Scanner;

public class MergeSort extends AlgoritmosOrdenacao {

    Scanner input = new Scanner(System.in);

    public MergeSort(int[] vetor) {
        super(vetor);
        long tempoInicial = System.currentTimeMillis();
        this.ordenaVetorMergeSort(0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        super.tempoTotal = tempoFinal - tempoInicial;
    }

    private void ordenaVetorMergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            ordenaVetorMergeSort(inicio, meio);
            ordenaVetorMergeSort(meio + 1, fim);
            this.merge(inicio, meio, fim);
        }
    }

    private void merge(int inicio, int meio, int fim) {
        int esquerda = meio - inicio + 1;
        int direita = fim - meio;
        int[] vetorEsq = new int[esquerda];
        int[] vetorDir = new int[direita];

        for (int i = 0; i < esquerda; i++) {
            vetorEsq[i] = super.getItem(inicio + 1);
        }
        for (int i = 0; i < direita; i++) {
            vetorDir[i] = super.getItem(meio + 1 + i);
        }

        int i = 0, j = 0;
        int k = inicio;

        while (i < esquerda && j < direita) {
            super.comparacoes++;
            if (vetorEsq[i] <= vetorDir[j]) {
                super.setItem(k, vetorEsq[i]);
                i++;
            } else {
                super.setItem(k, vetorDir[j]);
                j++;
            }
            k++;
        }
        while (i < esquerda) {
            super.setItem(k, vetorEsq[i]);
            i++;
            k++;
        }
        while (j < direita) {
            super.setItem(k, vetorDir[j]);
            j++;
            k++;
        }
    }

}
