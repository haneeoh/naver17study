package mbtireple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class mbtirepleDao {
	MysqlConnect db=new MysqlConnect();
	
	public void insertReple(mbtirepleDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into mbtireple (message,writeday) values (?,now())";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getMessage());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteReple(int idx)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from mbtireple where idx=?";
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public List<mbtirepleDto> getAllReples()
	{
		List<mbtirepleDto> list=new Vector<mbtirepleDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from mbtireple order by idx desc";
		
		conn=db.getNaverCloudConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				mbtirepleDto dto=new mbtirepleDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setMessage(rs.getString("message"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
}













