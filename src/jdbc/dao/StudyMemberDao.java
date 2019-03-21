package jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jdbc.dto.StudyMember;

public class StudyMemberDao {
	
	private static String dburl = "jdbc:mysql://localhost/test?characterEncoding=UTF-8&serverTimezone=UTC";
	
	private static String dbUser = "root";
	private static String dbpwd = "0412";
	
	 StudyMember sm = null;
	 Connection conn = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 
	 public StudyMember getId(int id) {//특정 아이디로 데이터 출력
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select id, name, hometown from java_study where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String hometown = rs.getString("hometown");
			
				sm = new StudyMember(id, name, hometown);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
		 return sm;
	 }
	public int addMember(StudyMember sm) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "insert into java_study value(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sm.getId());
			ps.setString(2, sm.getName());
			ps.setString(3, sm.getHometown());
			result = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public int delMember(String name) {
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "delete from java_study where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			result = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public List selectAll() {
		List<StudyMember> list = new ArrayList<>();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
				String sql = "select id, name, hometown from java_study";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {
					
					int id1 = rs.getInt("id");
					String name = rs.getString("name");
					String hometown = rs.getString("hometown");
				
					sm = new StudyMember(id1, name, hometown);
					list.add(sm);
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(ps!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(conn!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			 return list;
	}
}
