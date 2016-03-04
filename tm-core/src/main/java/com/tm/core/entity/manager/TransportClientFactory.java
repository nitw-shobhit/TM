package com.tm.core.entity.manager;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;

public class TransportClientFactory {

	private TransportClientFactory() {
	}
	
	static class TcHelper {
		static Settings settings = Settings.settingsBuilder()
				.put("cluster.name", "tmCluster")
				.put("node.name", "tmNode").build();
		static TransportAddress transportAddress;
		static {
			try {
				transportAddress = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		public static TransportClient tc = TransportClient.builder().settings(settings).build().addTransportAddress(transportAddress);
	}
	
	public static TransportClient createTransportClient() {
		return TcHelper.tc;
	}
}
