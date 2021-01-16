package com.scenetec.upf.operation.model.domain.system;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
public class CommonDictionary {

	private Long id;

	private String type;

	private String key;

	private String value;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
