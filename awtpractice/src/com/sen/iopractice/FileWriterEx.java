package com.sen.iopractice;

import java.io.FileWriter;

public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter writer =null;
		try {
			//督析拭 廃 庚切 舘是稽 奄系拝 呪 赤澗 FileWriter梓端持失
			writer = new FileWriter("C:\\Users\\nes05\\OneDrive\\郊伝 鉢檎\\呪穣\\Hello.txt");
			//writer澗 庚切伸聖 郊稽 奄系拝 呪 赤陥.
			String str = "せせせせせせ";
			writer.write(str);
			//馬たい 越切 舘是稽 石壱 承呪 赤澗 Reader, Writer域伸税
			//什闘顕精 鎧採旋生稽 獄遁研 鎧舌馬壱 赤陥.
			//鎧舌吉 獄覗澗 獄遁亜 亜究 辰趨 霜 凶拭幻 什闘顕聖 搭背
			//鎧左浬陥.flush()澗 獄遁亜 亜究託走 省焼亀 搾酔惟 廃陥.
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (writer!=null)writer.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
