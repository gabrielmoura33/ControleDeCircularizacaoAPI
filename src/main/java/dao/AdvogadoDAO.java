package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Circularizacao.Advogado;

public class AdvogadoDAO implements DAO<Advogado, Integer> {

	private List<Advogado> advogados;

	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public AdvogadoDAO(String filename) throws IOException {
		advogados = new ArrayList<Advogado>();
		file = new File(filename);
		if (file.exists())
			readFromFile();
	}

	@Override
	public void add(Advogado advogado) {
		advogados.add(advogado);
		saveToFile();
	}

	@Override
	public Advogado get(Integer chave) {
		for (Advogado adv : advogados) {
			if (chave.intValue() == adv.getId()) {
				return adv;
			}
		}
		return null;

	}

	@Override
	public List<Advogado> getAll() {

		return advogados;
	}

	@Override
	public void update(Advogado advogado) {
		int index = advogados.indexOf(advogado);
		if (index != -1) {
			advogados.set(index, advogado);
			saveToFile();
		}
	}

	@Override
	public void remove(Advogado advogado) {
		int index = advogados.indexOf(advogado);
		if (index != -1) {
			advogados.remove(index);
		}
		saveToFile();

	}

	private void readFromFile() {
		Advogado advogado;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				advogado = (Advogado) inputFile.readObject();
				advogados.add(advogado);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler Advogado do disco!");
			e.printStackTrace();
		}
	}

	private void saveToFile() {
		try (FileOutputStream fos = new FileOutputStream(file, false);
				ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {

			for (Advogado p : advogados) {
				outputFile.writeObject(p);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Advogado no disco!");
			e.printStackTrace();
		}

	}

	private void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.close();
	}

}
