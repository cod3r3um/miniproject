package co.tropical.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.tropical.model.Tropical;

public class TropicalDAO implements TropicalAccess {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/tropical.db";
		try {
			conn = DriverManager.getConnection(url);
//			System.out.println("~ CONNECTED ~");
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

	@Override
	public ArrayList<Tropical> selectAll() {
		ArrayList<Tropical> tList = new ArrayList<>();
		connect();
		String sql = "select * from tropical";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Tropical tropical = new Tropical();
				tropical.setGuest_id(rs.getString("guest_id"));
				tropical.setGuest_name(rs.getString("guest_name"));
				tropical.setCheckin(rs.getString("checkin"));
				tropical.setCheckout(rs.getString("checkout"));
				tropical.setRoom(rs.getInt("room"));
				tropical.setNumber(rs.getInt("number"));
				tList.add(tropical);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return tList;
	}

	@Override
	public ArrayList<Tropical> selectBook(String guest_id) {
		ArrayList<Tropical> tList = new ArrayList<>();
		connect();
		String sql = "select * from tropical where guest_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, guest_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Tropical tropical = new Tropical();
				tropical.setGuest_id(rs.getString("guest_id"));
				tropical.setGuest_name(rs.getString("guest_name"));
				tropical.setCheckin(rs.getString("checkin"));
				tropical.setCheckout(rs.getString("checkout"));
				tropical.setRoom(rs.getInt("room"));
				tropical.setNumber(rs.getInt("number"));
				tList.add(tropical);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return tList;
	}

	@Override
	public boolean adLogin(String id, int pw) {
		connect();
		boolean b = false;
		try {
			psmt = conn.prepareStatement("select * from admin where id = ? and pw = ?");
			psmt.setString(1, id);
			psmt.setInt(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return b;
	}

	@Override
	public void book(Tropical tropical) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into tropical(guest_id, checkin, checkout, room, number) values (?, ?, ?, ?, ?)");
			psmt.setString(1, tropical.getGuest_id());
			psmt.setString(2, tropical.getCheckin());
			psmt.setString(3, tropical.getCheckout());
			psmt.setInt(4, tropical.getRoom());
			psmt.setInt(5, tropical.getNumber());
			int r = psmt.executeUpdate();
			System.out.println(r + " reservation is completed.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void adChange(Tropical tropical) {
		connect();
		try {
			psmt = conn.prepareStatement("update tropical set checkin=?, checkout=?, room=?, number=? where guest_id=?");
			psmt.setString(1, tropical.getCheckin());
			psmt.setString(2, tropical.getCheckout());
			psmt.setInt(3, tropical.getRoom());
			psmt.setInt(4, tropical.getNumber());
			psmt.setString(5, tropical.getGuest_id());
			int r = psmt.executeUpdate();
			System.out.println(r + " reservation is changed.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void adCancel(String guest_id) {
		connect();
		try {
			psmt = conn.prepareStatement("delete from tropical where guest_id = ?");
			psmt.setString(1, guest_id);
			int r = psmt.executeUpdate();
			System.out.println(r + " reservation is canceled.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public ArrayList<Tropical> selectYours(String guest_id) {
		ArrayList<Tropical> tList = new ArrayList<>();
		connect();
		String sql = "select * from tropical where guest_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,guest_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Tropical tropical = new Tropical();
				tropical.setGuest_id(rs.getString("guest_id"));
				tropical.setRoom(rs.getInt("room"));
				tropical.setNumber(rs.getInt("number"));
				tropical.setCheckin(rs.getString("checkin"));
				tropical.setCheckout(rs.getString("checkout"));
				tropical.setPrice(rs.getString("price"));
				tList.add(tropical);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return tList;
	}

	@Override
	public void signUp(Tropical tropical) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into guest(guest_id, guest_pw, guest_name) values(?, ?, ?)");
			psmt.setString(1, tropical.getGuest_id());
			psmt.setInt(2, tropical.getGuest_pw());
			psmt.setString(3, tropical.getGuest_name());
			int r = psmt.executeUpdate();
			System.out.println(r + " account has been made.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
	}

	@Override
	public boolean gstLogin(String guest_id, int guest_pw) {
		connect();
		boolean b = false;
		try {
			psmt = conn.prepareStatement("select * from tropical where guest_id = ? and guest_pw = ?");
			psmt.setString(1, guest_id);
			psmt.setInt(2, guest_pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return b;
	}

	@Override
	public Tropical printName(String guest_id) {
		connect();
		String sql = "select guest_name from guest where guest_id = ?";
		Tropical tropical = new Tropical();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, guest_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				tropical.setGuest_name(rs.getString("guest_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return tropical;
	}
	
	public boolean right(String guest_id, int guest_pw) {
		connect();
		boolean b = false;
		try {
			psmt = conn.prepareStatement("select * from guest where guest_id = ? and guest_pw = ?");
			psmt.setString(1, guest_id);
			psmt.setInt(2, guest_pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return b;		
	}

	@Override
	public void gstChange(Tropical tropical) {
		connect();
		try {
			psmt = conn.prepareStatement("update tropical set checkin=?, checkout=?, room=?, number=? where guest_id=?");
			psmt.setString(1, tropical.getCheckin());
			psmt.setString(2, tropical.getCheckout());
			psmt.setInt(3, tropical.getRoom());
			psmt.setInt(4, tropical.getNumber());
			psmt.setString(5, tropical.getGuest_id());
			int r = psmt.executeUpdate();
			System.out.println(r + " reservation is changed.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
	}

	@Override
	public void gstCancel(String guest_id) {
		connect();
		try {
			psmt = conn.prepareStatement("delete from tropical where guest_id = ?");
			psmt.setString(1,guest_id);
			int r = psmt.executeUpdate();
			System.out.println(r + " reservation is canceled.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
	}

}
