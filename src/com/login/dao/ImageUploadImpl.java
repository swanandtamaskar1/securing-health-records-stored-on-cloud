package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.login.pojo.ImageUplaod;
import com.login.utility.MyConnection;

public class ImageUploadImpl implements ImageUploadInterface {
	Connection conn = null;

	public long savepath(ImageUplaod imageUplaodObj, String mappingArray[]) {

		conn = MyConnection.getConnectionObj();
		try {
			long file_id = 0;
			PreparedStatement pstm = conn.prepareStatement(
					"insert into image_post_table(PATH,USERNAME,fileSize,upload_date) values(?,?,?,now())");

			pstm.setString(1, imageUplaodObj.getPATH());
			pstm.setString(2, imageUplaodObj.getUSERNAME());
			pstm.setInt(3, imageUplaodObj.getFileSize());
			pstm.executeUpdate();

			PreparedStatement pstm1 = conn
					.prepareStatement("select MAX(image_post_id) as image_post_id from image_post_table");
			ResultSet resultSet = pstm1.executeQuery();
			while (resultSet.next()) {
				file_id = resultSet.getLong("image_post_id");
				System.out.println("file_id" + file_id);
			}

			PreparedStatement pstm2 = conn.prepareStatement("insert into map_table (file_id,role) values(?,?)");
			for (int i = 0; i < mappingArray.length; i++) {
				pstm2.setLong(1, file_id);
				pstm2.setString(2, mappingArray[i]);
				pstm2.executeUpdate();
			}

			return file_id;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return 0;
	}

	public List<ImageUplaod> getImageUpload(String role) {
		conn = MyConnection.getConnectionObj();
		List<ImageUplaod> imageFormList = new ArrayList<ImageUplaod>();
		try {

			PreparedStatement pstm = conn.prepareStatement("select file_id from map_table where role=?");
			pstm.setString(1, role);
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				PreparedStatement pstm1 = conn.prepareStatement("select * from image_post_table where image_post_id=?");
				pstm1.setLong(1, rst.getLong("file_id"));
				ResultSet rs = pstm1.executeQuery();

				while (rs.next()) {
					ImageUplaod imageUploadObj = new ImageUplaod();
					imageUploadObj.setFile_id(rs.getLong("image_post_id"));
					imageUploadObj.setPATH(rs.getString("PATH"));
					imageUploadObj.setUSERNAME(rs.getString("USERNAME"));
					imageUploadObj.setFileSize(rs.getInt("fileSize"));
					imageFormList.add(imageUploadObj);

				}
			}
			return imageFormList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageFormList;

	}

	public ImageUplaod getImage(long exhibitorId) {
		conn = MyConnection.getConnectionObj();
		ImageUplaod ImageUplaodObject = new ImageUplaod();
		try {
			PreparedStatement pstm1 = conn.prepareStatement("select * from image_post_table");
			pstm1.setLong(1, exhibitorId);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next()) {

				ImageUplaodObject.setPATH(rs.getString("PATH"));
				// imageFormList.add(imageUploadObj);

			}
			return ImageUplaodObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ImageUplaodObject;

	}

	@Override
	public boolean saveLogTable(ImageUplaod imageUplaodObj) {
		// TODO Auto-generated method stub
		conn = MyConnection.getConnectionObj();
		try {

			PreparedStatement pstm = conn.prepareStatement(
					"insert into log_table (USERNAME,DATE,TIME,ACTION,FILE_NAME,IP_ADDRESS) values(?,?,?,?,?,?)");

			pstm.setString(1, imageUplaodObj.getUSERNAME());
			pstm.setDate(2, imageUplaodObj.getDATE());
			pstm.setString(3, imageUplaodObj.getTIME());
			pstm.setString(4, imageUplaodObj.getACTION());
			pstm.setString(5, imageUplaodObj.getFILE_NAME());
			pstm.setString(6, imageUplaodObj.getIP_ADDRESS());

			pstm.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public List getlLogTableList(ImageUplaod imageUplaodObj) {
		// TODO Auto-generated method stub
		conn = MyConnection.getConnectionObj();
		List imageFormList = new ArrayList();
		try {
			PreparedStatement pstm1 = conn.prepareStatement("select * from log_table");
			// pstm1.setString(1,uname);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next()) {

				ImageUplaod imageUploadObj = new ImageUplaod();

				imageUploadObj.setUSERNAME(rs.getString("USERNAME"));
				imageUploadObj.setDATE(rs.getDate("DATE"));
				imageUploadObj.setTIME(rs.getString("TIME"));
				imageUploadObj.setACTION(rs.getString("ACTION"));
				imageUploadObj.setFILE_NAME(rs.getString("FILE_NAME"));
				imageUploadObj.setIP_ADDRESS(rs.getString("IP_ADDRESS"));
				imageFormList.add(imageUploadObj);

			}
			return imageFormList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getAuthor_name(String uploadPath) {
		// TODO Auto-generated method stub
		conn = MyConnection.getConnectionObj();
		ImageUplaod ImageUplaodObject = new ImageUplaod();
		try {
			PreparedStatement pstm1 = conn.prepareStatement("select * from image_post_table where PATH=?");
			pstm1.setString(1, uploadPath);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next()) {

				String username = rs.getString("USERNAME");
				// imageFormList.add(imageUploadObj);
				return username;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ImageUplaod getFileDetails(long id) {
		conn = MyConnection.getConnectionObj();
		List imageFormList = new ArrayList();
		try {
			PreparedStatement pstm1 = conn.prepareStatement("select * from image_post_table where image_post_id=?");
			pstm1.setLong(1, id);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next()) {

				ImageUplaod imageUploadObj = new ImageUplaod();
				imageUploadObj.setFile_id(rs.getLong("image_post_id"));
				imageUploadObj.setPATH(rs.getString("PATH"));
				imageUploadObj.setUSERNAME(rs.getString("USERNAME"));
				imageUploadObj.setFileSize(rs.getInt("fileSize"));
				// imageFormList.add(imageUploadObj);
				return imageUploadObj;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<ImageUplaod> getAllFiles() {
		conn = MyConnection.getConnectionObj();
		List<ImageUplaod> imageFormList = new ArrayList<ImageUplaod>();
		try {

			PreparedStatement pstm1 = conn.prepareStatement("select * from image_post_table");
			ResultSet rs = pstm1.executeQuery();
			while (rs.next()) {
				ImageUplaod imageUploadObj = new ImageUplaod();
				imageUploadObj.setFile_id(rs.getLong("image_post_id"));
				imageUploadObj.setPATH(rs.getString("PATH"));
				imageUploadObj.setUSERNAME(rs.getString("USERNAME"));
				imageUploadObj.setFileSize(rs.getInt("fileSize"));
				imageFormList.add(imageUploadObj);

			}

			return imageFormList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageFormList;
	}

}
