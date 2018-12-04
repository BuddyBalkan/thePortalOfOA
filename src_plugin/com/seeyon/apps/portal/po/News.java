package com.seeyon.apps.portal.po;

import java.io.Serializable;
import java.util.Date;
/*
 * 新闻实体类
 */
public class News implements Serializable {
	private long id;//	新闻主键
	private String titile;//	新闻标题
	private String publishDepartmentld;//发布部门
	private String brief;//新闻摘要
	private String keywords;//	新闻关键字
	private Date createDate;//新闻创建时间
	private String typeName;//新闻所在版块名称
	private Date updateDate;//	新闻最近更新时间
	private String createUserName;//新闻创建人名称
	private int typeId;//新闻所在板块id
	private Date publishDate;//新闻发布时间
	private long imageId;//新闻图片id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getPublishDepartmentld() {
		return publishDepartmentld;
	}
	public void setPublishDepartmentld(String publishDepartmentld) {
		this.publishDepartmentld = publishDepartmentld;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	
	
	

}
