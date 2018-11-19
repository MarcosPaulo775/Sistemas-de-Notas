package projeto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import projeto.objetos.Aluno;
import projeto.objetos.Boletim;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim();

		aluno.boletim = boletim;

		System.out.println("Digite o nome do aluno: ");
		aluno.nome = scan.next();

		System.out.println("Digite a disciplina: ");
		aluno.boletim.disciplina = scan.next();

		System.out.println("Digite a nota processual de N1: ");
		aluno.boletim.processualN1 = scan.nextDouble();
		System.out.println("Digite a nota formal N1: ");
		aluno.boletim.formalN1 = scan.nextDouble();

		System.out.println("Digite a nota processual de N2: ");
		aluno.boletim.processualN2 = scan.nextDouble();
		System.out.println("Digite a nota formal de N2: ");
		aluno.boletim.formalN2 = scan.nextDouble();

		aluno.boletim.N1 = ((aluno.boletim.processualN1 * 0.2) + (aluno.boletim.formalN1 * 0.8));
		aluno.boletim.N2 = ((aluno.boletim.processualN2 * 0.2) + (aluno.boletim.formalN2 * 0.8));
		aluno.boletim.mediaN1N2 = (aluno.boletim.N1 + aluno.boletim.N2) / 2;
		System.out.println("A nota da N1 é: " + aluno.boletim.N1);
		System.out.println("A nota da N2 é: " + aluno.boletim.N2);
		System.out.println("A média da N1 + N2 é: " + aluno.boletim.mediaN1N2);

		if (aluno.boletim.mediaN1N2 >= 8) {
			System.out.println("");
			System.out.println("O aluno " + aluno.nome + " está aprovado com a média de: " + aluno.boletim.mediaN1N2);

		} else if (aluno.boletim.mediaN1N2 >= 3 && aluno.boletim.mediaN1N2 < 8) {
			System.out.println("");
			System.out.println("O aluno " + aluno.nome + " deverá fazer N3!");

			System.out.println("Digite a nota da N3: ");
			aluno.boletim.N3 = scan.nextDouble();

			aluno.boletim.mediaN1N2N3 = (aluno.boletim.N1 + aluno.boletim.N2 + aluno.boletim.N3) / 3;
			System.out.println("A média da N3 é: " + aluno.boletim.mediaN1N2N3);

			if (aluno.boletim.mediaN1N2N3 >= 6) {
				System.out.println("");
				System.out.println(
						"O aluno " + aluno.nome + " está aprovado com a média de: " + aluno.boletim.mediaN1N2N3);

			} else if (aluno.boletim.mediaN1N2N3 >= 3 && aluno.boletim.mediaN1N2N3 < 6) {
				System.out.println("");
				System.out.println("O aluno deverá fazer N4!");

				System.out.println("Digite a nota da N4: ");
				aluno.boletim.N4 = scan.nextDouble();
				aluno.boletim.mediaFinal = (aluno.boletim.mediaN1N2N3 + aluno.boletim.N4) / 2;

				if (aluno.boletim.mediaFinal >= 6) {
					System.out.println("");
					System.out.println(
							"O aluno " + aluno.nome + " está aprovado com a média de: " + aluno.boletim.mediaFinal);
				} else {
					System.out.println("");
					System.out.println("O aluno está reprovado!");
				}

			} else {
				System.out.println("");
				System.out.println("O aluno está reprovado!");
			}

		} else {
			System.out.println("");
			System.out.println("O aluno está reprovado!");
		}

		File dir = new File("C:/Users/Marcos Paulo/Desktop");
		File arq = new File(dir, "Dados.txt");

		try {
			FileWriter fileWriter = new FileWriter(arq, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.println("***************************");
			printWriter.println("ALUNO: " + aluno.nome);
			printWriter.println("DISCIPLINA: " + aluno.boletim.disciplina);
			printWriter.println("--------- BOLETIM ---------");
			printWriter.printf("N1: %.2f %n", aluno.boletim.N1);
			printWriter.printf("N2: %.2f %n", aluno.boletim.N2);
			printWriter.printf("Media N1 + N2: %.2f %n", aluno.boletim.mediaN1N2);

			if (aluno.boletim.mediaN1N2 >= 3 && aluno.boletim.mediaN1N2 < 8) {
				printWriter.println("");
				printWriter.printf("N3: %.2f %n", aluno.boletim.N3);
				printWriter.printf("Media N1 + N2 + N3: %.2f %n", aluno.boletim.mediaN1N2N3);

				if (aluno.boletim.mediaN1N2N3 >= 3 && aluno.boletim.mediaN1N2N3 < 6) {
					printWriter.println("");
					printWriter.printf("N4: %.2f %n", aluno.boletim.N4);
					printWriter.printf("Media final: %.2f %n", aluno.boletim.mediaFinal);
				}
			}

			printWriter.println("***************************");
			printWriter.flush();
			printWriter.close();

		} catch (Exception erro) {
			System.out.println("ERRO AO GRAVAR NO ARQUIVO !!");
		}

	}

}