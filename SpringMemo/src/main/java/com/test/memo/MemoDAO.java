package com.test.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemoDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MemoDAO() {
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemoDTO> list() {

		try {
			
			String sql = "select * from tblMemo order by seq desc";
			rs = stat.executeQuery(sql);
			
			List<MemoDTO> list = new ArrayList<>();
			
			while (rs.next()) {
				
				MemoDTO dto = new MemoDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int add(MemoDTO dto) {

		try {
			
			String sql = "insert into tblMemo (seq, name, memo, regdate)"
							+ "values (seqMemo.nextVal, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getMemo());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public MemoDTO get(String seq) {
		
		try {
			
			String sql = "select * from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				MemoDTO dto = new MemoDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int edit(MemoDTO dto) {

		try {
			
			String sql = "update tblMemo set name = ?, memo =? where seq =?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getMemo());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int del(String seq) {
		
		try {
			
			String sql = "delete from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
