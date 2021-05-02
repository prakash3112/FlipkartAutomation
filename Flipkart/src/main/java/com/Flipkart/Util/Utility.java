package com.Flipkart.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * The Class Utility.
 */
public class Utility {

	/** The files list in dir. */
	static List<String> filesListInDir = new ArrayList<String>();

	/**
	 * Zip directory.
	 *
	 * @param dir
	 *            the dir
	 * @param zipDirName
	 *            the zip dir name
	 */
	public static void zipDirectory(File dir, String zipDirName) {
		try {
			populateFilesList(dir);
			FileOutputStream fos = new FileOutputStream(zipDirName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (String filePath : filesListInDir) {
				System.out.println("Zipping " + filePath);
				ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Populate files list.
	 *
	 * @param dir
	 *            the dir
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void populateFilesList(File dir) throws IOException {
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile())
					filesListInDir.add(file.getAbsolutePath());
				else
					populateFilesList(file);
			}
		}
	}

}
