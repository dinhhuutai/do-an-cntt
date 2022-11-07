package murach.model;


public class ProductModel extends AbstractModel<ProductModel> {
	private String name;
	private String code;
	private int status;
	private String image;
	private String listImage;
	private Long price;
	private Long discount;
	private Long quantity;
	private String description;
	private String detail;
	private Long view;
	private Long categoryId;
	private String thumbnail_1;
	private String thumbnail_2;
	private String thumbnail_3;
	private int hot;
	private String size;
	private Long colorId;
	private Long brandId;
	private Long supplierId;
	private String metaKeyWords;
	private String metaDescriptions;
	private Long popularity;
	
	private String categoryCode;
	private String colorCode;
	
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getListImage() {
		return listImage;
	}
	public void setListImage(String listImage) {
		this.listImage = listImage;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getView() {
		return view;
	}
	public void setView(Long view) {
		this.view = view;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getThumbnail_1() {
		return thumbnail_1;
	}
	public void setThumbnail_1(String thumbnail_1) {
		this.thumbnail_1 = thumbnail_1;
	}
	public String getThumbnail_2() {
		return thumbnail_2;
	}
	public void setThumbnail_2(String thumbnail_2) {
		this.thumbnail_2 = thumbnail_2;
	}
	public String getThumbnail_3() {
		return thumbnail_3;
	}
	public void setThumbnail_3(String thumbnail_3) {
		this.thumbnail_3 = thumbnail_3;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public Long getColorId() {
		return colorId;
	}
	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getMetaKeyWords() {
		return metaKeyWords;
	}
	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}
	public String getMetaDescriptions() {
		return metaDescriptions;
	}
	public void setMetaDescriptions(String metaDescriptions) {
		this.metaDescriptions = metaDescriptions;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public Long getPopularity() {
		return popularity;
	}
	public void setPopularity(Long popularity) {
		this.popularity = popularity;
	}
	
}
