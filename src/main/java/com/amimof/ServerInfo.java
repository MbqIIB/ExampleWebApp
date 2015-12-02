package com.amimof;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class ServerInfo {
	
	private Runtime runtime = Runtime.getRuntime();
	
	public String getServerIpAddr() {
		String addr = null;
		try {
			addr = InetAddress.getLocalHost().getHostAddress(); 
		} catch(UnknownHostException e) {
			System.out.println(e);
		}
		return addr;
	}
	
	public String getServerHostName() {
		String host = null;
		try {
			host = InetAddress.getLocalHost().getHostName();
		} catch(UnknownHostException e) {
			System.out.println(e);
		}
		return host;
	}
	
	public long getMaxMem() {
		return runtime.maxMemory();
	}
	
	public long getFreeMem() {
		return runtime.freeMemory();
	}
	
	public long getTotalMem() {
		return runtime.totalMemory();
	}
	
	public int getAvailProcs() {
		return runtime.availableProcessors();
	}

	public List<JVMEntry> getJvmProps() {
		List<JVMEntry> entries = new ArrayList<JVMEntry>();
		Properties p = System.getProperties();
		Enumeration<Object> keys = p.keys();
		while (keys.hasMoreElements()) {
			JVMEntry entry = new JVMEntry();
			String name = (String)keys.nextElement();
			String value = (String)p.get(name);
			entry.setName(name);
			entry.setValue(value);
			entries.add(entry);
		}
		return entries;
	}
	
	public class JVMEntry {
		
		private String name;
		private String value;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		
		
	}
	
}
