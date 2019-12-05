package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Circularizacao.ProcessoAuditoria;

public class processoAuditoriaDAO implements DAO<ProcessoAuditoria, Integer>{

	private List<ProcessoAuditoria> processos;

	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public processoAuditoriaDAO(String filename) throws IOException {
		processos = new ArrayList<ProcessoAuditoria>();
		file = new File(filename);
		if (file.exists())
			readFromFile();
	
	}

	@Override
	public void add(ProcessoAuditoria processo) {
		processos.add(processo);
		saveToFile();
	}

	@Override
	public ProcessoAuditoria get(Integer chave) {
		for (ProcessoAuditoria adv : processos) {
			if (chave.intValue() == adv.getIdProcesso()) {
				return adv;
			}
		}
		return null;

	}

	@Override
	public List<ProcessoAuditoria> getAll() {

		return processos;
	}

	@Override
	public void update(ProcessoAuditoria processo) {
		int index = processos.indexOf(processo);
		if (index != -1) {
			processos.set(index, processo);
			saveToFile();
		}
	}

	@Override
	public void remove(ProcessoAuditoria processo) {
		int index = processos.indexOf(processo);
		if (index != -1) {
			processos.remove(index);
		}
		saveToFile();

	}

	private void readFromFile() {
		ProcessoAuditoria processo;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream inputFile = new ObjectInputStream(fis)) {

			while (fis.available() > 0) {
				processo = (ProcessoAuditoria) inputFile.readObject();
				processos.add(processo);
			}
		} catch (Exception e) {
			System.out.println("ERRO ao ler ProcessoAuditoria do disco!");
			e.printStackTrace();
		}
	}

	private void saveToFile() {
		try (FileOutputStream fos = new FileOutputStream(file, false);
				ObjectOutputStream outputFile = new ObjectOutputStream(fos)) {

			for (ProcessoAuditoria p : processos) {
				outputFile.writeObject(p);
			}
			outputFile.flush();
		} catch (Exception e) {
			System.out.println("ERRO ao gravar ProcessoAuditoria no disco!");
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
