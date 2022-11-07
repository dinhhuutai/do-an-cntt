package murach.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import murach.dao.GenericDAO;
import murach.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	
	public Connection getConnection() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			String url = "jdbc:mysql://localhost:3306/project1servlet";
//			String user = "root";
//			String password = "tai31072002";

			Class.forName(resourceBundle.getString("driverName"));

			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			
			
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {

		List<T> results = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {

			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}

			return results;

		} catch (SQLException e) {
			return null;
		} finally {
			try {

				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {

			for (int i = 0; i < parameters.length; i++) {

				Object parameter = parameters[i];

				if (parameter instanceof Long) {
					statement.setLong(i + 1, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(i + 1, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(i + 1, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(i + 1, (Timestamp) parameter);
				}

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {

			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			
			setParameter(statement, parameters);
			
			
			statement.executeUpdate();
			
			connection.commit();
			
		} catch(SQLException e) {
			if (connection != null) {
				try {
					
					connection.rollback();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {

				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		
		try {

			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			setParameter(statement, parameters);
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			
			connection.commit();
			
			return id;
			
		} catch(SQLException e) {
			if (connection != null) {
				try {
					
					connection.rollback();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {

				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}

			return count;

		} catch (SQLException e) {
			return 0;
		} finally {
			try {

				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}

	@Override
	public Long sum(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Long sum = 0L;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				sum = resultSet.getLong(1);
			}

			return sum;

		} catch (SQLException e) {
			return 0L;
		} finally {
			try {

				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0L;
			}
		}
	}

}
