package dao;


import model.ThongTinChi;
import model.ThongTinThu;
import util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThongTinChiDAO {
    public ThongTinChiDAO() {
        ConectDatabase.getInstance().connect();
    }

    public void save(ThongTinChi thongTinChi) {
        String sql = null;
        if (thongTinChi.getId() == null) {
            sql = String.format(
                    "insert into thong_tin_chi(giangVien,nhanVienChi,gioiTinh" +
                            ",soTien,monGiangDay,ngayChi,soDienThoai) " +
                            "values('%s','%s','%s','%s','%s','%s','%s')",
                    thongTinChi.getGiangVien(),
                    thongTinChi.getNhanVienChi(),
                    thongTinChi.getGioiTinh(),
                    String.valueOf(thongTinChi.getSoTien()),
                    thongTinChi.getMonGiangDay(),
                    Util.formatDate(thongTinChi.getNgayChi()),
                    thongTinChi.getSoDienThoai()
            );
        } else {
            sql = String.format(
                    "update thong_tin_chi set " +
                            "giangVien = '%s'" +
                            ",nhanVienChi = '%s'" +
                            ",gioiTinh = '%s'" +
                            ",soTien = '%s'" +
                            ",monGiangDay = '%s'" +
                            ",ngayChi = '%s'" +
                            ",soDienThoai = '%s' " +
                            "where id = '%s'",
                    thongTinChi.getGiangVien(),
                    thongTinChi.getNhanVienChi(),
                    thongTinChi.getGioiTinh(),
                    String.valueOf(thongTinChi.getSoTien()),
                    thongTinChi.getMonGiangDay(),
                    Util.formatDate(thongTinChi.getNgayChi()),
                    thongTinChi.getSoDienThoai(),
                    thongTinChi.getId());
        }

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<ThongTinChi> getAll() {
        String sql = "Select * from thong_tin_chi";
        List<ThongTinChi> result = new ArrayList<>();

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ThongTinChi thongTinChi = new ThongTinChi();
                thongTinChi.setId(resultSet.getLong(1));
                thongTinChi.setGiangVien(resultSet.getString(2));
                thongTinChi.setNhanVienChi(resultSet.getString(3));
                thongTinChi.setGioiTinh(resultSet.getString(4));
                thongTinChi.setSoTien(Long.valueOf(resultSet.getString(5)));
                thongTinChi.setMonGiangDay(resultSet.getString(6));
                thongTinChi.setNgayChi(Util.toDate(resultSet.getString(7)));
                thongTinChi.setSoDienThoai(resultSet.getString(8));
                result.add(thongTinChi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void delete(Long id) {
        String sql = "delete from thong_tin_chi where id = " + id;

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ThongTinChi> getAllByName(String name) {
        String sql = "Select * from thong_tin_chi where giangVien like '%" + name + "%'";
        List<ThongTinChi> result = new ArrayList<>();

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ThongTinChi thongTinChi = new ThongTinChi();
                thongTinChi.setId(resultSet.getLong(1));
                thongTinChi.setGiangVien(resultSet.getString(2));
                thongTinChi.setNhanVienChi(resultSet.getString(3));
                thongTinChi.setGioiTinh(resultSet.getString(4));
                thongTinChi.setSoTien(Long.valueOf(resultSet.getString(5)));
                thongTinChi.setMonGiangDay(resultSet.getString(6));
                thongTinChi.setNgayChi(Util.toDate(resultSet.getString(7)));
                thongTinChi.setSoDienThoai(resultSet.getString(8));
                result.add(thongTinChi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ThongTinChi> getAllByPhone(String phone) {
        String sql = "Select * from thong_tin_chi where soDienThoai = '" + phone + "'";
        List<ThongTinChi> result = new ArrayList<>();

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ThongTinChi thongTinChi = new ThongTinChi();
                thongTinChi.setId(resultSet.getLong(1));
                thongTinChi.setGiangVien(resultSet.getString(2));
                thongTinChi.setNhanVienChi(resultSet.getString(3));
                thongTinChi.setGioiTinh(resultSet.getString(4));
                thongTinChi.setSoTien(Long.valueOf(resultSet.getString(5)));
                thongTinChi.setMonGiangDay(resultSet.getString(6));
                thongTinChi.setNgayChi(Util.toDate(resultSet.getString(7)));
                thongTinChi.setSoDienThoai(resultSet.getString(8));
                result.add(thongTinChi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
