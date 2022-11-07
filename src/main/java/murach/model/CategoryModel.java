package murach.model;

public class CategoryModel extends AbstractModel<CategoryModel> {
	private String name;
	private String code;
	private int status;
	private int sort;
	private Long parrentId;
	private String metaKeyWords;
	private String metaDescriptions;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Long getParrentId() {
		return parrentId;
	}
	public void setParrentId(Long parrentId) {
		this.parrentId = parrentId;
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
}
