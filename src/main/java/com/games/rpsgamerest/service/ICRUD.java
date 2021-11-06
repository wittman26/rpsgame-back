package com.games.rpsgamerest.service;

import java.util.List;

public interface ICRUD<T>  {
	T save(T t);

	T update(T t);

	void delete(String id);

	T listById(String id);

	List<T> list();
}
