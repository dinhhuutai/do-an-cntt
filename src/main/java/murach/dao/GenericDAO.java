package murach.dao;

import java.util.List;

import murach.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	
	void update (String sql, Object... parameters);
	
	Long insert (String sql, Object... parameters);
	
	int count(String sql, Object... parameters);
	
	Long sum(String sql, Object... parameters);
}
