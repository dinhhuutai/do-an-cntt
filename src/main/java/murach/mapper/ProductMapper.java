package murach.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import murach.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet resultSet) {
		try {

			ProductModel product = new ProductModel();
			product.setId(resultSet.getLong("id"));
			product.setName(resultSet.getString("name"));
			product.setCode(resultSet.getString("code"));
			product.setStatus(resultSet.getInt("status"));
			product.setImage(resultSet.getString("image"));
			product.setListImage(resultSet.getString("listimage"));
			product.setPrice(resultSet.getLong("price"));
			product.setDiscount(resultSet.getLong("discount"));
			product.setQuantity(resultSet.getLong("quantity"));
			product.setDescription(resultSet.getString("description"));
			product.setDetail(resultSet.getString("detail"));
			product.setView(resultSet.getLong("view"));
			product.setCategoryId(resultSet.getLong("categoryid"));
			product.setThumbnail_1(resultSet.getString("thumbnail1"));
			product.setThumbnail_2(resultSet.getString("thumbnail2"));
			product.setThumbnail_3(resultSet.getString("thumbnail3"));
			product.setHot(resultSet.getInt("hot"));
			product.setSize(resultSet.getString("size"));
			product.setColorId(resultSet.getLong("colorid"));
			product.setBrandId(resultSet.getLong("brandid"));
			product.setSupplierId(resultSet.getLong("supplierid"));
			product.setCreatedDate(resultSet.getTimestamp("createddate"));
			product.setCreatedBy(resultSet.getString("createdby"));
			product.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			product.setModifiedBy(resultSet.getString("modifiedby"));
			product.setPopularity(resultSet.getLong("popularity"));

			return product;

		} catch (SQLException e) {

			return null;
		}
	}

}
