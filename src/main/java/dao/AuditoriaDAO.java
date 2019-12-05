package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Circularizacao.Auditoria;

public class AuditoriaDAO implements DAO<Auditoria, Integer> {

	private List<Auditoria> auditorias;
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public AuditoriaDAO(String filename) throws IOException {
		auditorias = new ArrayList<Auditoria>();
		file = new File(filename);
		if (file.exists())
			readFromFile();	
	}

	@Override
	public void add(Auditoria auditoria) {
		auditorias.add(auditoria);
		saveToFile();
	}

	@Override
	public Auditoria get(Integer chave) {
		for (Auditoria adv : auditorias) {
			if (chave.intValue() == adv.getId()) {
				return adv;
			}
		}
		return null;

	}

	@Override
	public List<Auditoria> getAll() {

		return auditorias;
	}

	@Override
	public void update(Auditoria auditoria) {
		int index = auditorias.indexOf(auditoria);
		if (index != -1) {
			auditorias.set(index, auditoria);
			saveToFile();
		}
	}

	@Override
	public void remove(Auditoria auditoria) {
		int index = auditorias.indexOf(auditoria);
		if (index != -1) {
			auditorias.remove(index);
		}
		saveToFile();
	}

	private void readFromFile() {
		Auditoria auditoria;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				auditoria = (Auditoria) inputFile.readObject();
				auditorias.add(auditoria);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler Auditoria do disco!");
			e.printStackTrace();
		}
	}

	private void saveToFile() {
		try (FileOutputStream fos = new FileOutputStream(file, false);
				ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {

			for (Auditoria p : auditorias) {
				outputFile.writeObject(p);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar Auditoria no disco!");
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
