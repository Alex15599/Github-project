package com.dt.platform.ops.service.impl.ops;

import java.io.Serializable;
import java.util.HashMap;

public class Machine implements Serializable {

	private static final long serialVersionUID = 1L;

	private String hostname;
	private String username;
	private String password;
	private Integer port;



	private String ct;

	/**
	 * @return the ct
	 */
	public String getCt() {
		return ct;
	}

	/**
	 * @param ct the ct to set
	 */
	public void setCt(String ct) {
		this.ct = ct;
	}

	public Machine() {
		super();
	}

	public Machine(String hostname, String username, String password, Integer port) {
		super();

		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	public void parseKvMap(String str){
		if(str!=null&&str.length()>0){
			String[] arr=str.split("@@");
			for(int i=0;i<arr.length;i++){
				String[] kv=arr[i].split("=");
				if(kv.length==2){
					kvmap.put(kv[0].trim(),kv[1].trim());
				}
			}
		}
	}

	public HashMap<String, String> getKvmap() {
		return kvmap;
	}

	public void setKvmap(HashMap<String, String> kvmap) {
		this.kvmap = kvmap;
	}

	private HashMap<String, String> kvmap = new HashMap<String, String>();

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "[hostname=" + hostname + ", username=" + username + ", port=" + port + ",ct:"
				+ ct + ",kv="+kvmap+"]";
	}

}
