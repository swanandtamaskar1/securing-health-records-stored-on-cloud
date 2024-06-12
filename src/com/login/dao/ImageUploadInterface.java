package com.login.dao;

import java.util.List;

import com.login.pojo.ImageUplaod;

public interface ImageUploadInterface {
	public long savepath(ImageUplaod imageUplaodObj, String mappingArray[]);

	public List<ImageUplaod> getAllFiles();

	public List<ImageUplaod> getImageUpload(String uname);

	public ImageUplaod getImage(long exhibitorId);

	public boolean saveLogTable(ImageUplaod imageUplaodObj);

	public List getlLogTableList(ImageUplaod imageUplaodObj);

	public String getAuthor_name(String uploadPath);

}
