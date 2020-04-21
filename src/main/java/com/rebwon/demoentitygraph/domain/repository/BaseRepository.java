package com.rebwon.demoentitygraph.domain.repository;

public interface BaseRepository<D, T> {
	D findWithGraph(T id, String graphName);
}
