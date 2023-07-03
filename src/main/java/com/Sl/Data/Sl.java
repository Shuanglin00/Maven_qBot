package com.Sl.Data;

import java.io.*;

/**
 * @author Shuanglin
 * sava and load
 * 保存以及读取数据
 */
public class Sl {
	File file;
	File file1;

	public Sl(Long groupId) {
		file = new File("GroupDate\\" + groupId + ".bin");
		file1 = new File("GroupDate");
		if (file1.mkdirs()) {
			System.out.println("创建目录成功");
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sava(Object obj) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GroupData load(Long groupId) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			return (GroupData) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(groupId + "该群还没有记录!");
			return null;
		}
		return null;
	}
}
