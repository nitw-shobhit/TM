package com.tm.core.entity.manager_nosql;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;

public class TransportClientFactory {

	private TransportClientFactory() {
	}
	
	static class TcHelper {
		static Settings settings = Settings.settingsBuilder().put("cluster.name", "localtestsearch").build();
		public static TransportClient tc = TransportClient.builder().settings(settings).build();
	}
	
	public static TransportClient createTransportClient() {
		return TcHelper.tc;
	}
}
