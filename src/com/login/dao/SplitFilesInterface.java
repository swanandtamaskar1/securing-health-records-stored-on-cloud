package com.login.dao;

import java.util.List;

import com.login.pojo.ImageUplaod;

public interface SplitFilesInterface {
	public boolean saveSplitFiles(ImageUplaod imageUplaod);

	public List<String> getAllsplitFiles(long file_id);

	void deleteFiles(int reportId);

}
