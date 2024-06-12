package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.pojo.ImageUplaod;
import com.login.utility.MyConnection;

public class SplitFilesImpl implements SplitFilesInterface {
	Connection conn = null;

	@Override
	public boolean saveSplitFiles(ImageUplaod imageUplaod) {
		// TODO Auto-generated method stub

		conn = MyConnection.getConnectionObj();
		try {
			/*
			 * PreparedStatement
			 * pstm3=conn.prepareStatement("delete from image_post_table where PATH=? ");
			 * pstm3.setString(1,imageUplaodObj.getPATH()); pstm3.executeUpdate();
			 */

			PreparedStatement pstm = conn
					.prepareStatement("insert into splitfiles(PATH,USERNAME,report_id) values(?,?,?)");

			pstm.setString(1, imageUplaod.getPATH());
			pstm.setString(2, imageUplaod.getUSERNAME());
			pstm.setLong(3, imageUplaod.getFile_id());

			pstm.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public void deleteFiles(int reportId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("delete  from splitfiles where report_id=? ");
			ps.setInt(1, reportId);
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<String> getAllsplitFiles(long file_id) {
		// TODO Auto-generated method stub
		conn = MyConnection.getConnectionObj();
		List<String> imageFormList = new ArrayList<String>();
		try {
			PreparedStatement pstm1 = conn.prepareStatement("select * from splitfiles where report_id=?");
			pstm1.setLong(1, file_id);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next()) {

				String file_name = rs.getString("PATH");
				imageFormList.add(file_name);

			}
			return imageFormList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
