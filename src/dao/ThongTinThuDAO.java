package dao;

import model.ThongTinThu;
import util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThongTinThuDAO {
    public ThongTinThuDAO() {
        ConectDatabase.getInstance().connect();
    }

    public void save(ThongTinThu thongTinThu) {
        String sql = null;
        if (thongTinThu.getId() == null) {
            sql = String.format(
                    "insert into thong_tin_thu(giangVienThu,tenHocVien,gioiTinh" +
                            ",ngaySinh,monHoc,ngayThu,diaChi,soTien,soDienThoai,trangThai) " +
                            "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    thongTinThu.getGiangVienThu(),
                    thongTinThu.getTenHocVien(),
                    thongTinThu.getGioiTinh(),
                    Util.formatDate(thongTinThu.getNgaySinh()),
                    thongTinThu.getMonHoc(),
                    Util.formatDate(thongTinThu.getNgayThu()),
                    thongTinThu.getDiaChi(),
                    String.valueOf(thongTinThu.getSoTien()),
                    thongTinThu.getSoDienThoai(),
                    thongTinThu.getTrangThai());
        } else {
            sql = String.format(
                    "update thong_tin_thu set " +
                            "giangVienThu = '%s'" +
                            ",tenHocVien = '%s'" +
                            ",gioiTinh = '%s'" +
                            ",ngaySinh = '%s'" +
                            ",monHoc = '%s'" +
                            ",ngayThu = '%s'" +
                            ",diaChi = '%s'" +
                            ",soTien = '%s'" +
                            ",soDienThoai = '%s'" +
                            ",trangThai = '%s' " +
                            "where id = '%s'",
                    thongTinThu.getGiangVienThu(),
                    thongTinThu.getTenHocVien(),
                    thongTinThu.getGioiTinh(),
                    Util.formatDate(thongTinThu.getNgaySinh()),
                    thongTinThu.getMonHoc(),
                    Util.formatDate(thongTinThu.getNgayThu()),
                    thongTinThu.getDiaChi(),
                    String.valueOf(thongTinThu.getSoTien()),
                    thongTinThu.getSoDienThoai(),
                    thongTinThu.getTrangThai(),
                    thongTinThu.getId());
        }

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<ThongTinThu> getAll() {
        String sql = "Select * from thong_tin_thu";
        List<ThongTinThu> result = new ArrayList<>();

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ThongTinThu thongTinThu = new ThongTinThu();
                thongTinThu.setId(resultSet.getLong(1));
                thongTinThu.setGiangVienThu(resultSet.getString(2));
                thongTinThu.setTenHocVien(resultSet.getString(3));
                thongTinThu.setGioiTinh(resultSet.getString(4));
                thongTinThu.setNgaySinh(Util.toDate(resultSet.getString(5)));
                thongTinThu.setMonHoc(resultSet.getString(6));
                thongTinThu.setNgayThu(Util.toDate(resultSet.getString(7)));
                thongTinThu.setDiaChi(resultSet.getString(8));
                thongTinThu.setSoTien(Long.valueOf(resultSet.getString(9)));
                thongTinThu.setSoDienThoai(resultSet.getString(10));
                thongTinThu.setTrangThai(resultSet.getString(11));
                result.add(thongTinThu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void delete(Long id) {
        String sql = "delete from thong_tin_thu where id = " + id;

        Connection connection = ConectDatabase.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
