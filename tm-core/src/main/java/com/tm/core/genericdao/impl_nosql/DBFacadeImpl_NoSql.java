package com.tm.core.genericdao.impl_nosql;

import java.util.List;
import java.util.Set;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.tm.core.entity.manager_nosql.TransportClientFactory;
import com.tm.core.query.QueryConstants;
import com.tm.util.db.MultipleQueryBean;
import com.tm.util.db.Param;
import com.tm.util.db.genericdao.DBFacade;

public class DBFacadeImpl_NoSql<T, PK> extends QueryConstants implements DBFacade<T, PK> {

	@Override
	public T persist(T obj, boolean baseFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T persistNoTx(T obj, boolean baseFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T merge(T obj, boolean baseFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T mergeNoTx(T obj, boolean baseFlag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeNoTx(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findByPk(PK obj) {
		Client client = getTransportClient();
		MatchQueryBuilder query = QueryBuilders.matchQuery("test-field1", "test");
		SearchResponse response = client.prepareSearch().setQuery(query)
		        .execute()
		        .actionGet();
		System.out.println(response.getHits().getTotalHits());
		client.close();
		
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByParams(String query, Param[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeNamedQuery(String query, Param[] param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void executeMultipleNamedQueries(Set<MultipleQueryBean> queries) {
		// TODO Auto-generated method stub
		
	}
	
	protected TransportClient getTransportClient() {
		TransportClient tc = TransportClientFactory.createTransportClient();
		return tc;
	}
}
