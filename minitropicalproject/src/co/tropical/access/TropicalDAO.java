package co.tropical.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TropicalDAO implements TropicalAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/tropical.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("~ CONNECTED ~");
		} catch (SQLException e) {
			System.out.println("~ NOT CONNECTED ~");
		}
	}

	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 아이디 입력 시 이름 출력
	public Guest printName (int gst_id) {
		connect();
		String sql = "select name from tropical where gst_id = ?";
		Guest guest = new Guest();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gst_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Guest.setName(rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return guest;
	}

}
