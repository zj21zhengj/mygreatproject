package com.tencent.mashibing.step010;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectEntity_Helper {

    public SubjectEntity create(ResultSet rs) throws SQLException {
        if (null == rs) {
            return null;
        }
        // 创建新的实体对象
        SubjectEntity ue = new SubjectEntity();

        ue.setId(rs.getInt("ID"));
        ue.setSubCode(rs.getString("SUB_CODE"));
        ue.setSubName(rs.getString("SUB_NAME"));
        ue.setType(rs.getInt("TYPE"));
        return ue;
    }
}
