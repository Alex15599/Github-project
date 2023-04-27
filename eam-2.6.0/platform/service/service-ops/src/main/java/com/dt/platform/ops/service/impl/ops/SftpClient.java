package com.dt.platform.ops.service.impl.ops;

import ch.ethz.ssh2.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;


import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SftpClient {

	private Connection conn;
	private SFTPv3Client client;
	private Stack<String> catalogs = new Stack<String>();
	private String cutrrentCatalog;
	public Machine machine;

	public SftpClient() {
	}

	public SftpClient(Machine m) {
		super();
		machine=m;
		connect();
	}

	public void close() {
		if (client != null) {
			if (client.isConnected()) {
				client.close();
			}
		}
	}

	public class UsernamePasswordInteractiveCallback implements InteractiveCallback {

		public String[] replyToChallenge(String s, String instruction, int numPrompts, String[] arg3, boolean[] arg4) {
			final String[] result2 = new String[numPrompts];
			Logger.info("numPrompts:" + numPrompts);
			if (numPrompts > 0) {
				Arrays.fill(result2, machine.getPassword());
			}
			return result2;
		}

	}

	public boolean connect() {
		if(client!=null&&client.isConnected()){
			return true;
		}
		boolean result = false;
		try {
			conn = new Connection(machine.getHostname(), machine.getPort());
			conn.connect();
			result = conn.authenticateWithPassword(machine.getUsername(), machine.getPassword());
			if (result) {
				client = new SFTPv3Client(conn);
				initCatalogs(client.canonicalPath("."));
				return result;
			}else{
				Logger.info("authenticateWithPassword failed");
			}
		} catch (IOException e) {
			Logger.info("authenticateWithPassword failed,try to authenticateWithKeyboardInteractive");
		}
		boolean loginSuccess = false;
		Logger.info("try UsernamePasswordInteractiveCallback");
		try{
			UsernamePasswordInteractiveCallback il = new UsernamePasswordInteractiveCallback();
			conn = new Connection(machine.getHostname(), machine.getPort());
			conn.connect();
			loginSuccess = conn.authenticateWithKeyboardInteractive(machine.getUsername(), il);
			if(loginSuccess){
				client = new SFTPv3Client(conn);
				initCatalogs(client.canonicalPath("."));
				return loginSuccess;
			}
		} catch (IOException e) {
			Logger.info("authenticateWithKeyboardInteractive failed.");
		}
		return loginSuccess;
	}

	public boolean isConnected() {
		if (client != null)
			return client.isConnected();
		return false;
	}

	private void initCatalogs(String str) {

		cutrrentCatalog = str;
		catalogs.push("/");

		String[] ss = str.split("/");

		for (String s : ss) {
			if (!"".equals(s))
				catalogs.push(s);
		}
	}

	public String getCurrentCatalog() {
		return cutrrentCatalog;
	}

	public void changeDirectory(String dirName) {

		// if param is a absolute path
		if ("/".equals(dirName.substring(0, 1))) {
			catalogs.clear();
			initCatalogs(dirName);
			cutrrentCatalog = dirName;
			return;
		}

		// parent directory
		if ("..".equals(dirName) && catalogs.size() > 1) {
			// update the catalogs stack
			catalogs.pop();
		}
		// child directory
		else {
			catalogs.push(dirName);
		}
		updateCurrentCatalog();
	}

	private void updateCurrentCatalog() {
		String path = "";
		for (String s : catalogs) {
			if (!"/".equals(s))
				path += "/" + s;
		}
		if (catalogs.size() == 1)
			path = "/";
		cutrrentCatalog = path;
	}

	public SftpBean ls() throws IOException {

		List<SFTPv3DirectoryEntry> list = client.ls(cutrrentCatalog);
		List<SftpFileBean> sftpFiles = new ArrayList<SftpFileBean>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		for (SFTPv3DirectoryEntry entry : list) {

			if (!entry.filename.equals("..") && !entry.filename.equals(".")) {
				SftpFileBean sfile = new SftpFileBean();
				sfile.setFilename(entry.filename);
				sfile.setDirectory(entry.attributes.isDirectory());
				sfile.setIntPermissions(entry.attributes.permissions);
				sfile.setStrPermissions(getStringPermission(entry.attributes.permissions));
				sfile.setOctalPermissions(entry.attributes.getOctalPermissions());
				sfile.setMtime(sdf.format(new Date((long) entry.attributes.mtime * 1000)));
				sfile.setSize(entry.attributes.size);
				sftpFiles.add(sfile);
			}
		}

		Collections.sort(sftpFiles, new Comparator<SftpFileBean>() {

			public int compare(SftpFileBean o1, SftpFileBean o2) {
				return o1.compareTo(o2);
			}
		});

		return new SftpBean(getCurrentCatalog(), sftpFiles);
	}

	private String getStringPermission(Integer p) {
		String temp[] = new String[] { "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx" };
		// is a directory ?
		return (p / 8 / 8 / 8 / 8 % 8 == 04 ? "d" : "-") + temp[p / 8 / 8 % 8] + temp[p / 8 % 8] + temp[p % 8];
	}


	public void uploadFile(File file, String fileName, Map<String, Object> session,String del) {

		if (file == null)
			return;
		FileInputStream fis = null;
		SFTPv3FileHandle handle = null;
		try {
			fis = new FileInputStream(file);

			long totalSize = file.length();
			byte[] b = new byte[1024 * 8];
			long count = 0;

			//client.rm(getCurrentCatalog() + "/" + fileName);
			handle = client.createFile(getCurrentCatalog() + "/" + fileName);
			DecimalFormat df = new DecimalFormat("#.00");

			while (true) {
				int len = fis.read(b);
				if (len == -1)
					break;
				client.write(handle, count, b, 0, len);
				count += len;
				Logger.info("	"+fileName + " {\"percent\":\"" + df.format((double) count / totalSize * 100)
						+ "%\",\"num\":\"" + (int) ((double) count / totalSize) + "\"}");
				if (session != null) {
					session.put("	progress", "{\"percent\":\"" + df.format((double) count / totalSize * 100)
							+ "%\",\"num\":\"" + (int) ((double) count / totalSize) + "\"}");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (handle != null) {
				if (client != null) {
					try {
						client.closeFile(handle);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (fis != null) {

				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Result uploadFile(File file, String fileName, Map<String, Object> session) {

		boolean uploadFlag=true;
		String msg="上传失败";
		Logger.info("start to upload file,file:"+file.getAbsolutePath()+",fileName:"+fileName);
		if (file == null)
			return ErrorDesc.failureMessage("文件为空");
		FileInputStream fis = null;
		SFTPv3FileHandle handle = null;
		try {
			fis = new FileInputStream(file);

			long totalSize = file.length();
			byte[] b = new byte[1024 * 8];
			long count = 0;
			handle = client.createFile(getCurrentCatalog() + "/" + fileName);
			DecimalFormat df = new DecimalFormat("#.00");
			while (true) {
				int len = fis.read(b);
				if (len == -1)
					break;
				client.write(handle, count, b, 0, len);
				count += len;
				Logger.info("	"+fileName + " {\"percent\":\"" + df.format((double) count / totalSize * 100)
						+ "%\",\"num\":\"" + (int) ((double) count / totalSize) + "\"}");
				if (session != null) {
					session.put("	progress", "{\"percent\":\"" + df.format((double) count / totalSize * 100)
							+ "%\",\"num\":\"" + (int) ((double) count / totalSize) + "\"}");
				}
			}
		}
		catch (IOException e) {
			msg=e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (NullPointerException e) {
			msg=e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (handle != null) {
				if (client != null) {
					try {
						client.closeFile(handle);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(uploadFlag){
			return ErrorDesc.success();
		}else{
			return ErrorDesc.failureMessage("file:"+file.getAbsolutePath()+" upload failed,message:"+msg);
		}

	}

	// download file from current catalog
	public InputStream downloadFile(String fileName) {
		SFTPv3FileHandle handle;
		ByteArrayOutputStream baos = null;
		try {
			handle = client.openFileRO(fileName);
			long count = 0;
			byte[] buff = new byte[1024 * 8];
			baos = new ByteArrayOutputStream();
			while (true) {
				int len = client.read(handle, count, buff, 0, 1024 * 8);
				if (len == -1)
					break;
				baos.write(buff, 0, len);
				count += len;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	public void downloadFile(String fileName, String dest) {
		InputStream input = null;
		FileOutputStream downloadFile = null;
		try {
			input = downloadFile(fileName);
			int index;
			byte[] bytes = new byte[1024];
			downloadFile = new FileOutputStream(dest);
			while ((index = input.read(bytes)) != -1) {
				downloadFile.write(bytes, 0, index);
				downloadFile.flush();
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (downloadFile != null) {
				try {
					downloadFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void deleteFile(String fileName) throws IOException {
		client.rm(getCurrentCatalog() + "/" + fileName);
	}

	public void mkDir(String dirName) throws IOException {
		client.mkdir(getCurrentCatalog() + "/" + dirName, 0755);
	}

	public void createFile(String fileName) throws IOException {
		client.createFileTruncate(getCurrentCatalog() + "/" + fileName);
	}

	public void setAttributes(String fileName, Integer permissions) throws IOException {

		SFTPv3FileAttributes attr = client.stat(getCurrentCatalog() + "/" + fileName);

		SFTPv3FileAttributes attr1 = new SFTPv3FileAttributes();
		attr1.permissions = attr.permissions / 8 / 8 / 8 * 8 * 8 * 8 + permissions;
		client.setstat(getCurrentCatalog() + "/" + fileName, attr1);

	}
}
