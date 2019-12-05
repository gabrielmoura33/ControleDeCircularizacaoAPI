package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Circularizacao.Cooperativa;

public class CooperativaDAO implements DAO<Cooperativa, Integer> {

	private List<Cooperativa> cooperativas;

	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public CooperativaDAO(String filename) throws IOException {
		cooperativas = new ArrayList<Cooperativa>();
		file = new File(filename);
		if (file.exists())
			readFromFile();
	}

	@Override
	public void add(Cooperativa cooperativa) {
		cooperativas.add(cooperativa);
		saveToFile();
	}

	@Override
	public Cooperativa get(Integer chave) {
		for (Cooperativa adv : cooperativas) {
			if (chave.intValue() == adv.getId()) {
				return adv;
			}
		}
		return null;

	}

	@Override
	public List<Cooperativa> getAll() {

		return cooperativas;
	}

	@Override
	public void update(Cooperativa cooperativa) {
		int index = cooperativas.indexOf(cooperativa);
		if (index != -1) {
			cooperativas.set(index, cooperativa);
			saveToFile();
		}
	}

	@Override
	public void remove(Cooperativa cooperativa) {
		int index = cooperativas.indexOf(cooperativa);
		if (index != -1) {
			cooperativas.remove(index);
		}
		saveToFile();

	}

	private void readFromFile() {
		Cooperativa cooperativa;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				cooperativa = (Cooperativa) inputFile.readObject();
				cooperativas.add(cooperativa);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler Cooperativa do disco!");
			e.printStackTrace();
		}
	}

	private void saveToFile() {
		try (FileOutputStream fos = new FileOutputStream(file, false);
				ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {

			for (Cooperativa p : cooperativas) {
				outputFile.writeObject(p);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Cooperativa no disco!");
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
