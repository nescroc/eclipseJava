package com.sen.awtpractice;

import java.awt.FileDialog;
import java.awt.Frame;

public class FileDialogEx extends Frame {

	private static final long serialVersionUID = 1L;
	FileDialog fd =new FileDialog(this,"≥ª≤®¿˙¿Â",FileDialog.SAVE);
	public FileDialogEx() {
		super("FileDialogEx");
		setSize(300,200);
		setVisible(true);
		fd.setVisible(true);
		System.out.println(fd.getFile());
		System.out.println(fd.getDirectory());
	}
	public static void main(String[] args) {	
		//FileDialogEx fde = new FileDialogEx();
	}

}
