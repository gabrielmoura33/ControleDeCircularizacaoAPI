package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Circularizacao.Laudo;

public class LaudoDAO implements DAO<Laudo, Integer> {

	private List<Laudo> laudos;

	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public LaudoDAO(String filename) throws IOException {
		laudos = new ArrayList<Laudo>();
		file = new File(filename);
		if (file.exists())
			readFromFile();
		
		int maxId = 0;
		for (Laudo la : laudos) 
			if (la.getId() > maxId)
			maxId = la.getId();
		
		Laudo.setMaxId(maxId++);
	}

	
	public void maiorId() {
		
		
		
	}
	
	
	@Override
	public void add(Laudo laudo) {
		laudos.add(laudo);
		saveToFile();
	}

	@Override
	public Laudo get(Integer chave) {
		for (Laudo adv : laudos) {
			if (chave.intValue() == adv.getId()) {
				return adv;
			}
		}
		return null;
	}

	@Override
	public List<Laudo> getAll() {

		return laudos;
	}

	@Override
	public void update(Laudo laudo) {
		int index = laudos.indexOf(laudo);
		if (index != -1) {
			laudos.set(index, laudo);
			saveToFile();
		}
	}

	@Override
	public void remove(Laudo laudo) {
		int index = laudos.indexOf(laudo);
		if (index != -1) {
			laudos.remove(index);
		}
		saveToFile();
	}

	private void readFromFile() {
		Laudo laudo;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				laudo = (Laudo) inputFile.readObject();
				laudos.add(laudo);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler Laudo do disco!");
			e.printStackTrace();
		}
	}

	private void saveToFile() {
		try (FileOutputStream fos = new FileOutputStream(file, false);
				ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {

			for (Laudo p : laudos) {
				outputFile.writeObject(p);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Laudo no disco!");
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
