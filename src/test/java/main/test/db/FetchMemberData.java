package main.test.db;

import main.database.PostgresqlJdbcConnection;
import main.pojo.MemberInfoData;
import main.util.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchMemberData extends PostgresqlJdbcConnection {
    public static List<MemberInfoData> getVoWiseMemberInfoList(String branchCode, String voCode, Boolean withLoan) {
        Statement stmt = null;
        List<MemberInfoData> memberInfoList = new ArrayList<>();
        List<Long> officeIds = DatabaseUtil.getOfficeIds(branchCode);
        String branchCodes = officeIds.toString().replace("[", "'").replace("]", "'");

        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = null;
            String query = "";
            query = "SELECT gi.id                       VoNo,\n" +
                    "       gi.group_reference_number   OrgNo,\n" +
                    "       vc.name                     UpgGroup,\n" +
                    "       eci.pin_no                  PoPIN,\n" +
                    "       mi.id                       MemberId,\n" +
                    "       mi.reference_no             OrgMemNo,\n" +
                    "       mi.member_status_id         MemberStatusId,\n" +
                    "       poi.office_code             BranchCode,\n" +
                    "       poi.id                      BranchID,\n" +
                    "       mi.member_name              MemberName,\n" +
                    "       to_char(mi.last_updated, 'yyyy-mm-dd hh24:mi:ss') UpdatedAt,\n" +
                    "       to_char(mi.application_date, 'yyyy-mm-dd') ApplicationDate\n" +
                    "FROM group_info gi\n" +
                    "         INNER JOIN member_info mi\n" +
                    "                    ON (gi.branch_info_id = mi.branch_info_id AND gi.id = mi.group_info_id " +
                    "                        AND gi.branch_info_id =  ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))\n" +
                    "                        AND gi.project_info_id = 165\n" +
                    "                        AND mi.domain_status_id = 1)\n" +
                    "         INNER JOIN vo_category vc ON (vc.id = gi.vo_category_id)\n" +
                    "         INNER JOIN employee_core_info eci ON (eci.id = gi.assignedpo_id)\n" +
                    "         INNER JOIN physical_office_info poi ON (poi.id = gi.branch_info_id and \n" +
                    "         poi.id = ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))) \n" +
                    "ORDER BY mi.last_updated ASC limit 1000 offset 0;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                //MemberInfoListPagingData(String voName, Long voID, String orgNo,
                // String upgGroup, String poPIN, Long memberId, String orgMemNo,
                // Long memberStatusId, String branchCode, Long branchId, String memberName, String updatedAt, String applicationDate)
                //memberInfoList.add(new MemberInfoData(rs.getString("VoName"), rs.getLong("VoID"), rs.getString("OrgNo"),
                //        rs.getString("UpgGroup"), rs.getString("PoPIN"), rs.getLong("MemberId"), rs.getString("OrgMemNo"),
                //        rs.getLong("MemberStatusId"), rs.getString("BranchCode"), rs.getLong("BranchID"),
                //        rs.getString("MemberName"), rs.getString("UpdatedAt"), rs.getString("ApplicationDate")));
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return memberInfoList;
    }
}
