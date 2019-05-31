/**
 * Título do projeto/aplicação. Insira aqui uma pequena descrição sobre o mesmo.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Apr 28, 2019 at 8:00:00 PM
 * @version 0.1
 */
package ordenacao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import classes.*;

public class Ordenacao {

    private final Scanner input = new Scanner(System.in);
    private final Random rand = new Random();

    /**
     * Menu principal que exibe os algoritmos de ordenação disponíveis e
     * preenchimento manual e aleatório de vetores.
     */
    public void showMenu() {
        System.out.println("\n\n\t----MENU PRINCIPAL----\n");
        System.out.println("1 - Imprimir vetor;");
        System.out.println("2 - Preencher vetor aleatoriamente;");
        System.out.println("3 - Preencher vetor manualmente;");
        System.out.println("4 - Insertion Sort;");
        System.out.println("5 - Merge Sort;");
        System.out.println("6 - Quick Sort;");
        System.out.println("7 - Mostrar resultados;");
        System.out.println("8 - Sair;");
        System.out.println("Insira aqui a opção desejada: ");
    }

    public void menu(int tam) {
        int[] vetor = new int[tam];
        int option = 0;

        do {
            this.showMenu();
            option = this.input.nextInt();

            switch (option) {
                case 1:
                    this.imprimeVetor(vetor, vetor.length);
                    break;
                case 2:
                    this.preencheVetorRandom(vetor);
                    break;
                case 3:
                    this.preencheVetorManual(vetor);
                    break;
                case 4:
                    System.out.println("\nINSERTION SORT:\n");
                    InsertionSort insertionSort = new InsertionSort(vetor);
                    System.out.println("Tempo total: " + insertionSort.getTempoTotal());
                    break;
                case 5:
                    System.out.println("\nMERGE SORT:\n");
                    MergeSort mergeSort = new MergeSort(vetor);
                    System.out.println("Tempo total: " + mergeSort.getTempoTotal());
                    break;
                case 6:
                    System.out.println("\nQUICK SORT:\n");
                    QuickSort quickSort = new QuickSort(vetor);
                    System.out.println("Tempo total: " + quickSort.getTempoTotal());
                    break;
                case 7:
                    this.imprimeResultados();
                    break;
                case 8:
                    System.out.println("Até +!\n");
                    break;
                default:
                    System.out.println("ERRO. Opção inválida.");
                    break;
            }

        } while (option != 8);
    }

    /**
     * Preenche um vetor manualmente.
     *
     * @param vetor : o vetor que será preenchido manualmente.
     * @return
     */
    public final int[] preencheVetorManual(int vetor[]) {
        System.out.println("Insira abaixo os " + vetor.length + " inteiros:");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = input.nextInt();
        }
        return vetor;
    }

    public final int[] preencheVetorRandom(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(99);
        }
        return vetor;
    }

    /**
     * Imprime os n elementos iniciais do vetor 'vetor'.
     *
     * @param n : o tamanho do vetor.
     * @param vetor : o vetor em questão.
     */
    public final void imprimeVetor(int vetor[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(vetor[i] + "  ");
        }
    }

    public void imprimeResultados() {
        int[] vetor30000 = new int[30000];
        int[] vetor10000 = new int[10000];
        int[] vetor5000 = new int[5000];

        ArrayList<int[]> lstVetores = new ArrayList();
        lstVetores.add(vetor30000);
        lstVetores.add(vetor10000);
        lstVetores.add(vetor5000);

        for (int[] v : lstVetores) {
            this.preencheVetorRandom(v);
        }

        this.montarResultado(vetor30000, vetor10000, vetor5000);
    }

    public void montarResultado(int[] v30000, int[] v10000, int[] v5000) {
        ArrayList<int[]> lstVetores = new ArrayList<>();
        ArrayList<InsertionSort> lstInsertion = new ArrayList<>();
        ArrayList<MergeSort> lstMerge = new ArrayList<>();
        ArrayList<QuickSort> lstQuick = new ArrayList<>();

        lstVetores.add(v30000);
        lstVetores.add(v10000);
        lstVetores.add(v5000);

        for (int i = 0; i < 3; i++) {
            InsertionSort insertion = new InsertionSort(lstVetores.get(i));
            lstInsertion.add(insertion);
            MergeSort merge = new MergeSort(lstVetores.get(i));
            lstMerge.add(merge);
            QuickSort quick = new QuickSort(lstVetores.get(i));
            lstQuick.add(quick);
        }

        System.out.println("\t\tORDENACAO \t\tVETOR");
        System.out.println("-------------------------------------\t---------------------------------------------------------------------");
        System.out.println("METODO \t\tTEMPO TOTAL (ms) \tACESSOS \t\tCOMPARACOES \t\tTROCAS");
        System.out.println("\t\t5000 \t10000 \t30000 \t5000 \t10000 \t30000 \t5000 \t10000 \t30000 \t5000 \t10000 \t30000");
        System.out.println("========== \t===== \t===== \t===== \t===== \t===== \t===== \t===== \t===== \t===== \t===== \t===== \t=====");

        System.out.printf("INSERTION \t%d \t%d \t%d ",
            lstInsertion.get(lstVetores.indexOf(v5000)).getTempoTotal(),
            lstInsertion.get(lstVetores.indexOf(v10000)).getTempoTotal(),
            lstInsertion.get(lstVetores.indexOf(v30000)).getTempoTotal());
        System.out.printf("\t%d  %d  %d",
            lstInsertion.get(lstVetores.indexOf(v5000)).getAcessos(),
            lstInsertion.get(lstVetores.indexOf(v10000)).getAcessos(),
            lstInsertion.get(lstVetores.indexOf(v30000)).getAcessos());

        System.out.printf("  %d  %d  %d",
            lstInsertion.get(lstVetores.indexOf(v5000)).getComparacoes(),
            lstInsertion.get(lstVetores.indexOf(v10000)).getComparacoes(),
            lstInsertion.get(lstVetores.indexOf(v30000)).getComparacoes());

        System.out.printf("  %d  %d  %d",
            lstInsertion.get(lstVetores.indexOf(v5000)).getTrocas(),
            lstInsertion.get(lstVetores.indexOf(v10000)).getTrocas(),
            lstInsertion.get(lstVetores.indexOf(v30000)).getTrocas());

        System.out.printf("  %d INSERÇÕES\n",
            lstInsertion.get(lstVetores.indexOf(v5000)).getInsercoes()
            + lstInsertion.get(lstVetores.indexOf(v10000)).getInsercoes()
            + lstInsertion.get(lstVetores.indexOf(v30000)).getInsercoes());

        System.out.printf("MERGE \t\t%d \t%d \t%d ",
            lstMerge.get(lstVetores.indexOf(v5000)).getTempoTotal(),
            lstMerge.get(lstVetores.indexOf(v10000)).getTempoTotal(),
            lstMerge.get(lstVetores.indexOf(v30000)).getTempoTotal());

        System.out.printf("\t%d \t%d \t%d",
            lstMerge.get(lstVetores.indexOf(v5000)).getAcessos(),
            lstMerge.get(lstVetores.indexOf(v10000)).getAcessos(),
            lstMerge.get(lstVetores.indexOf(v30000)).getAcessos());

        System.out.printf("\t%d \t%d \t%d",
            lstMerge.get(lstVetores.indexOf(v5000)).getComparacoes(),
            lstMerge.get(lstVetores.indexOf(v10000)).getComparacoes(),
            lstMerge.get(lstVetores.indexOf(v30000)).getComparacoes());

        System.out.printf("\t%d \t%d \t%d\n",
            lstMerge.get(lstVetores.indexOf(v5000)).getTrocas(),
            lstMerge.get(lstVetores.indexOf(v10000)).getTrocas(),
            lstMerge.get(lstVetores.indexOf(v30000)).getTrocas());

        System.out.printf("QUICK \t\t%d \t%d \t%d ",
            lstQuick.get(lstVetores.indexOf(v5000)).getTempoTotal(),
            lstQuick.get(lstVetores.indexOf(v10000)).getTempoTotal(),
            lstQuick.get(lstVetores.indexOf(v30000)).getTempoTotal());

        System.out.printf("\t%d \t%d \t%d",
            lstQuick.get(lstVetores.indexOf(v5000)).getAcessos(),
            lstQuick.get(lstVetores.indexOf(v10000)).getAcessos(),
            lstQuick.get(lstVetores.indexOf(v30000)).getAcessos());

        System.out.printf("\t%d \t%d \t%d",
            lstQuick.get(lstVetores.indexOf(v5000)).getComparacoes(),
            lstQuick.get(lstVetores.indexOf(v10000)).getComparacoes(),
            lstQuick.get(lstVetores.indexOf(v30000)).getComparacoes());

        System.out.printf("\t%d \t%d \t%d",
            lstQuick.get(lstVetores.indexOf(v5000)).getTrocas(),
            lstQuick.get(lstVetores.indexOf(v10000)).getTrocas(),
            lstQuick.get(lstVetores.indexOf(v30000)).getTrocas());

        System.out.printf("\t%d PIVÔS SELECIONADOS\n",
            lstQuick.get(lstVetores.indexOf(v5000)).getPivosSelecionados()
            + lstQuick.get(lstVetores.indexOf(v10000)).getPivosSelecionados()
            + lstQuick.get(lstVetores.indexOf(v30000)).getPivosSelecionados());

    }

    public static void main(String[] args) {
        Ordenacao main = new Ordenacao();
        int tam = 0;

        System.out.print("Qual será o tamanho do vetor? ");
        tam = main.input.nextInt();
        main.menu(tam);

    }

}
