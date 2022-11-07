package murach.dao.impl;

import java.util.List;

import murach.dao.IProductDAO;
import murach.mapper.ProductMapper;
import murach.model.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

	@Override
	public ProductModel findOne(Long id) {
		String sql = "select * from product where id = ? and quantity > 0";
		
		List<ProductModel> product = query(sql, new ProductMapper(), id);
		
		return product.isEmpty() ? null : product.get(0);
	}

	@Override
	public List<ProductModel> findByCategoryId(Long categoryId) {
		String sql = "select * from product where categoryid = ? and quantity > 0";
		
		return query(sql, new ProductMapper(), categoryId);
	}

	@Override
	public Long save(ProductModel productModel) {
		StringBuilder sql = new StringBuilder("insert into product (name, image,");
		sql.append("price, discount, quantity, description, categoryid,");
		sql.append("thumbnail1, thumbnail2, thumbnail3, size, colorid, createddate, createdby) values(?, ?,");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), productModel.getName() == null ? null : productModel.getName(), productModel.getImage() == null ? null : productModel.getImage(),
				productModel.getPrice() == null ? null : productModel.getPrice(), productModel.getDiscount() == null ? null : productModel.getDiscount(), productModel.getQuantity() == null ? null : productModel.getQuantity(),
				productModel.getDescription() == null ? null : productModel.getDescription(), productModel.getCategoryId() == null ? null : productModel.getCategoryId(),
				productModel.getThumbnail_1() == null ? null : productModel.getThumbnail_1(), productModel.getThumbnail_2() == null ? null : productModel.getThumbnail_2(), productModel.getThumbnail_3() == null ? null : productModel.getThumbnail_3(),
				productModel.getSize() == null ? null : productModel.getSize(), productModel.getColorId(), productModel.getCreatedDate(), productModel.getCreatedBy());
	}

	@Override
	public void update(ProductModel updateProduct) {
		StringBuilder sql = new StringBuilder("update product set name = ?, image = ?,");
		sql.append("price = ?, discount = ?, quantity = ?, description = ?, categoryid = ?,");
		sql.append("thumbnail1 = ?, thumbnail2 = ?, thumbnail3 = ?, size = ?, colorid = ?, createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateProduct.getName(), updateProduct.getImage(),
				updateProduct.getPrice(), updateProduct.getDiscount(), updateProduct.getQuantity(),
				updateProduct.getDescription(), updateProduct.getCategoryId(),
				updateProduct.getThumbnail_1(), updateProduct.getThumbnail_2(), updateProduct.getThumbnail_3(),
				updateProduct.getSize(), updateProduct.getColorId(), updateProduct.getCreatedDate() == null ? "null" : updateProduct.getCreatedDate(), 
				updateProduct.getCreatedBy() == null ? "null" : updateProduct.getCreatedBy(), updateProduct.getModifiedDate(), updateProduct.getModifiedBy(), updateProduct.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from product where id = ?";
		
		update(sql, id);
	}

	@Override
	public List<ProductModel> findAll(int index, int itemInPage) {
		String sql = "SELECT * FROM product where quantity > 0 ORDER BY id limit ?, ?";
		
		return query(sql, new ProductMapper(), index, itemInPage);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from product where quantity > 0";
		
		return count(sql);
	}

	@Override
	public List<ProductModel> findAllColor(long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product as p join ncolor as n ");
		sql.append("on p.id = n.productid join color as c on c.id = n.colorid where p.id = ?");
		
		List<ProductModel> product = query(sql.toString(), new ProductMapper(), id);
		
		return product.isEmpty() ? null : product;
		
	}

	@Override
	public List<ProductModel> findProductNew(int itemProductNew) {
		String sql = "SELECT * FROM product where quantity > 0 ORDER BY createddate desc limit 0, ?";
		
		return query(sql, new ProductMapper(), itemProductNew);
	}

	@Override
	public List<ProductModel> getNext20Product(int amount, String category, String sort, String price, String color, String name) {
		int icategory = Integer.parseInt(category);
		int icolor = Integer.parseInt(color);
		
		StringBuilder sql = new StringBuilder("SELECT * FROM product where quantity > 0 and name like ? ");

		if(icategory != 0) {
			sql.append("and categoryid = ? ");
		}
		
		if(!price.equals("all")) {
			if(price.equals("1")) {
				sql.append("and price >= 0 and price <= 200000 ");
			} else if(price.equals("2")) {
				sql.append("and price > 200000 and price <= 500000 ");
			} else if(price.equals("3")) {
				sql.append("and price > 500000 and price <= 1000000 ");
			} else if(price.equals("4")) {
				sql.append("and price > 1000000 ");
			}
		}
		
		if(icolor != 0) {
			sql.append("and colorid = ? ");
		}
		
		if(!sort.equals("all")) {
			if(sort.equals("popularity")) {
				sql.append("ORDER BY popularity desc ");
			} else if(sort.equals("createddate")) {
				sql.append("ORDER BY createddate desc ");
			} else if(sort.equals("low")) {
				sql.append("ORDER BY price asc ");
			} else if(sort.equals("high")) {
				sql.append("ORDER BY price desc ");
			}
		}
		

		sql.append("limit ?, 20");

		if(icategory != 0 &&  icolor == 0) {
			return query(sql.toString(), new ProductMapper(), name, icategory, amount);
		}
		if(icategory != 0 && icolor != 0) {
			return query(sql.toString(), new ProductMapper(), name, icategory, icolor, amount);
		}
		if(icategory == 0 && icolor != 0) {
			return query(sql.toString(), new ProductMapper(), name, icolor, amount);
		}
		
		return query(sql.toString(), new ProductMapper(), name, amount);
	}

	@Override
	public List<ProductModel> getNext20ProductSearch(String category, String sort, String price, String color, String name) {
		
		int icategory = Integer.parseInt(category);
		int icolor = Integer.parseInt(color);
		
		StringBuilder sql = new StringBuilder("SELECT * FROM product where quantity > 0 and name like ? ");
		
		if(icategory != 0) {
			sql.append("and categoryid = ? ");
		}
		
		if(!price.equals("all")) {
			if(price.equals("1")) {
				sql.append("and price >= 0 and price <= 200000 ");
			} else if(price.equals("2")) {
				sql.append("and price > 200000 and price <= 500000 ");
			} else if(price.equals("3")) {
				sql.append("and price > 500000 and price <= 1000000 ");
			} else if(price.equals("4")) {
				sql.append("and price > 1000000 ");
			}
		}
		
		if(icolor != 0) {
			sql.append("and colorid = ? ");
		}
		
		if(!sort.equals("all")) {
			if(sort.equals("popularity")) {
				sql.append("ORDER BY popularity desc ");
			} else if(sort.equals("createddate")) {
				sql.append("ORDER BY createddate desc ");
			} else if(sort.equals("low")) {
				sql.append("ORDER BY price asc ");
			} else if(sort.equals("high")) {
				sql.append("ORDER BY price desc ");
			}
		}
		
		sql.append("limit 0, 20");
		
		if(icategory != 0 &&  icolor == 0) {
			return query(sql.toString(), new ProductMapper(), name, icategory);
		}
		if(icategory != 0 && icolor != 0) {
			return query(sql.toString(), new ProductMapper(), name, icategory, icolor);
		}
		if(icategory == 0 && icolor != 0) {
			return query(sql.toString(), new ProductMapper(), name, icolor);
		}
		
		return query(sql.toString(), new ProductMapper(), name);
	}

	@Override
	public void updatePopularity(Long id, Long popularity) {
		StringBuilder sql = new StringBuilder("update product set popularity = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), popularity, id);
		
	}

	@Override
	public List<ProductModel> findTop10ProductPopularity() {
		String sql = "select * from product order by popularity desc limit 0, 10";
		
		return query(sql, new ProductMapper());
	}

	@Override
	public List<ProductModel> searchProduct(String name) {
		String sql = "SELECT * FROM product WHERE name LIKE ?";
		
		return query(sql, new ProductMapper(), name);
	}

}
