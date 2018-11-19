package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projeto.objetos.Aluno;
import projeto.objetos.Boletim;

public class Main {

	public static void cadastraBoletim() {

		Scanner scan = new Scanner(System.in);

		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim();

		aluno.boletim = boletim;

		System.out.println("Digite o nome do aluno: ");
		aluno.nome = scan.next();

		System.out.println("Digite a matricula do aluno: ");
		aluno.matricula = scan.next();

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

			if (aluno.boletim.mediaN1N2 >= 3 && aluno.boletim.mediaN1N2 < 8) {
				System.out.println("");
				System.out.printf("N3: %.2f %n", aluno.boletim.N3);
				System.out.printf("Media N1 + N2 + N3: %.2f %n", aluno.boletim.mediaN1N2N3);

				if (aluno.boletim.mediaN1N2N3 >= 3 && aluno.boletim.mediaN1N2N3 < 6) {
					System.out.println("");
					System.out.printf("N4: %.2f %n", aluno.boletim.N4);
					System.out.printf("Media final: %.2f %n", aluno.boletim.mediaFinal);
				}
			}

			printWriter.printf("%s;%s;%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f %n", aluno.nome,
					aluno.matricula, aluno.boletim.disciplina, aluno.boletim.processualN1, aluno.boletim.formalN1,
					aluno.boletim.N1, aluno.boletim.processualN2, aluno.boletim.formalN2, aluno.boletim.N2,
					aluno.boletim.mediaN1N2, aluno.boletim.N3, aluno.boletim.mediaN1N2N3, aluno.boletim.N4,
					aluno.boletim.mediaFinal);

			printWriter.flush();
			printWriter.close();
			System.out.println("");
			System.out.println("");
		} catch (Exception erro) {
			System.out.println("ERRO AO GRAVAR NO ARQUIVO !!");
		}

	}

	public static void getAlunoByMatricula(String matricula) {

		File dir = new File("C:/Users/Marcos Paulo/Desktop");
		File arq = new File(dir, "Dados.txt");

		try {
			FileReader fileReader = new FileReader(arq);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";

			List<String> result = new ArrayList();

			while ((linha = bufferedReader.readLine()) != null) {
				if (linha != null && !linha.isEmpty()) {
					result.add(linha);
				}
			}

			fileReader.close();
			bufferedReader.close();

			for (int i = 0; i < result.size(); i++) {

				String[] linhaI = result.get(i).split(";");

				if (linhaI[1].equals(matricula)) {
					System.out.println("");
					System.out.println("");

					System.out.println("***************************");
					System.out.println("Aluno: " + linhaI[0]);
					System.out.println("Matricula: " + linhaI[1]);
					System.out.println("Disciplina: " + linhaI[2]);
					System.out.println("********* BOLETIM *********");
					System.out.println("Processual N1: " + linhaI[3]);
					System.out.println("Formal N1: " + linhaI[4]);
					System.out.println("Nota N1: " + linhaI[5]);
					System.out.println("---------------------------");
					System.out.println("Processual N2: " + linhaI[6]);
					System.out.println("Formal N2: " + linhaI[7]);
					System.out.println("Nota N2: " + linhaI[8]);
					System.out.println("---------------------------");
					System.out.println("Media N1 + N2: " + linhaI[9]);

					if (!linhaI[10].equals("0,00")) {
						System.out.println("---------------------------");
						System.out.println("Nota N3: " + linhaI[10]);
						System.out.println("---------------------------");
						System.out.println("Media N1 + N2 + N3: " + linhaI[11]);

						if (!linhaI[12].equals("0,00")) {
							System.out.println("---------------------------");
							System.out.println("Nota N4: " + linhaI[12]);
							System.out.println("---------------------------");
							System.out.println("Media Final: " + linhaI[13]);
						}
					}

					System.out.println("***************************");
					System.out.println("");
					System.out.println("");

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean cond = true;
		int resp = 0;

		do {
			System.out.println("QUAL OPERAÇÃO DESEJA FAZER?");
			System.out.println("1- Cadastrar novo boletim;");
			System.out.println("2- Procurar boletim apartir da matricula do aluno;");
			System.out.println("3- Sair;");
			resp = scan.nextInt();

			if (resp == 1) {
				cadastraBoletim();
			} else if (resp == 2) {
				String matricula;
				System.out.println("");
				System.out.println("Digite o numero da matricula: ");
				matricula = scan.next();

				getAlunoByMatricula(matricula);
			} else if (resp == 3) {
				cond = false;
			} else {
				System.err.println("RESPOSTA INVALIDA");
			}

		} while (cond);

	}

}