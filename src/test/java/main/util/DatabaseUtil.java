package main.util;

import main.database.PostgresqlJdbcConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil extends PostgresqlJdbcConnection {
    public static List<Long> getOfficeWiseProgotiMemberIds(String officeCOde) {
        Statement stmt = null;
        List<Long> memberIds = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from member_info where branch_info_id in (select id from physical_office_info where office_code='" + officeCOde + "') and project_info_id=2 and domain_status_id=1 and member_status_id=1 order by id desc limit 1 offset 0;");
           /* ResultSet rs = stmt.executeQuery("select id from member_info where branch_info_id in (select id from physical_office_info where office_code='" + officeCOde + "') " +
                    "and project_info_id=2 and domain_status_id=1 and member_status_id=1 and id not in (select distinct member_id from loan_account where office_info_id=(select id from physical_office_info where office_code='" + officeCOde + "') " +
                    "and loan_status_id !=2 and project_info_id=2) order by id desc limit 1 offset 0;");*/
            while (rs.next()) {
                Long memberId = rs.getLong("id");
                memberIds.add(memberId);
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return memberIds;
    }

    public static List<Long> getOfficeWiseVoIds(String officeCOde) {
        Statement stmt = null;
        List<Long> voIds = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from group_info where branch_info_id in (select id from physical_office_info where office_code='" + officeCOde + "') and domain_status_id=1 and group_category_id=1 and project_info_id=1 order by id desc limit 1 offset 0 ;");
            while (rs.next()) {
                Long voId = rs.getLong("id");
                voIds.add(voId);
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return voIds;
    }

    public static String getOfficeWiseVoCode(String officeCOde, Long voId) {
        Statement stmt = null;
        String voCode = "";
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select group_reference_number from group_info where branch_info_id in (select id from physical_office_info where office_code='" + officeCOde + "') and domain_status_id=1 and group_category_id=1 and project_info_id=1 and id=" + voId + " order by id desc limit 1 offset 0;");
            while (rs.next()) {
                voCode = rs.getString("group_reference_number");
            }

            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return voCode;
    }

    public static List<Long> getOfficeWiseDabiMemberIds(String officeCOde, Long voId) {
        Statement stmt = null;
        List<Long> memberIds = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from member_info where branch_info_id in (select id from physical_office_info where office_code='" + officeCOde + "') and project_info_id=1 and domain_status_id=1 and member_status_id=1  and group_info_id=" + voId + " order by id desc limit 1 offset 0;");
           /* ResultSet rs = stmt.executeQuery("select id from member_info where branch_info_id in (select id from physical_office_info where office_code='" + officeCOde + "') " +
                    "and project_info_id=1 and domain_status_id=1 and member_status_id=1 and id not in (select distinct member_id from loan_account where office_info_id=(select id from physical_office_info where office_code='" + officeCOde + "' and group_info_id=" + voId + ") " +
                    "and loan_status_id !=2 and project_info_id=1) order by id desc limit 1 offset 0;");*/
            while (rs.next()) {
                Long memberId = rs.getLong("id");
                memberIds.add(memberId);
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return memberIds;
    }

    public static String getOfficeWideBusinessDate(String officeCOde) {
        Statement stmt = null;
        String businessDate = "";
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select to_char( business_date, 'YYYY-MM-DD') as business_date from acc_business_date where app_organization_branch_id in (select id from physical_office_info where office_code='" + officeCOde + "')  order by id desc limit 1;");
            while (rs.next()) {
                businessDate = rs.getString("business_date");

            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return businessDate;
    }

    public static Long getOfficeId(String officeCode) {
        Statement stmt = null;
        Long officeId = null;
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from physical_office_info where office_code='" + officeCode + "';");
            while (rs.next()) {
                officeId = rs.getLong("id");

            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return officeId;
    }

    public static List<Long> getOfficeIds(String officeCodes) {
        Statement stmt = null;
        List<Long> OfficeIds = new ArrayList<>();

        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from physical_office_info where office_code in (" + officeCodes + ");");
            while (rs.next()) {
                OfficeIds.add(rs.getLong("id"));

            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println(OfficeIds);
        return OfficeIds;
    }

    public static List<Integer> getSchemeIds(Long loanProductId) {
        Statement stmt = null;
        List<Integer> schemeIds = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from scheme_info si where si.domain_status_id=1 and si.id\n" +
                    "in (select distinct scheme_info_id from loan_product_scheme_mapping where loan_product_id=" + loanProductId + " and domain_status_id=1);");
            while (rs.next()) {
                Integer schemeId = rs.getInt("id");
                schemeIds.add(schemeId);
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return schemeIds;
    }

    public static List<Integer> getSectors(Long loanProductId, int schemeId) {
        Statement stmt = null;
        List<Integer> sectorsIds = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select distinct si.sector_info_id from scheme_info si where si.domain_status_id=1 and si.id\n" +
                    "in (select distinct scheme_info_id from loan_product_scheme_mapping where loan_product_id=" + loanProductId + " and domain_status_id=1 and" +
                    " scheme_info_id=" + schemeId + ");");
            while (rs.next()) {
                sectorsIds.add(rs.getInt("sector_info_id"));
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return sectorsIds;
    }

    public static int getSubSectors(Long loanProductId, int schemeId, int sectorId) {
        Statement stmt = null;
        int sub_sector_info_id = 0;
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select distinct si.sub_sector_info_id from scheme_info si where si.domain_status_id=1 and si.id\n" +
                    "in (select distinct scheme_info_id from loan_product_scheme_mapping where loan_product_id=" + loanProductId + " and domain_status_id=1 and" +
                    " scheme_info_id=" + schemeId + ") and si.sector_info_id=" + sectorId + " limit 1;");
            while (rs.next()) {
                sub_sector_info_id = rs.getInt("sub_sector_info_id");
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return sub_sector_info_id;
    }

    public static Long getMemberNomineeId(Long id) {
        Statement stmt = null;
        Long nomineeId = null;
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select id from nominee_info where member_info_id=" + id + ";");
            while (rs.next()) {
                nomineeId = rs.getLong("id");
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return nomineeId;
    }

    public static List<Integer> getLoanProductFrequencyId(Long loanProductId) {
        Statement stmt = null;
        List<Integer> loanProductFrequencyIds = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select distinct frequency_id from loan_product_details where domain_status_id=1 and  loan_product_id=" + loanProductId + ";");
            while (rs.next()) {
                int loanProductFrequencyId = rs.getInt("frequency_id");
                loanProductFrequencyIds.add(loanProductFrequencyId);
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return loanProductFrequencyIds;
    }

    public static List<Integer> getMonth(Long loanProductId, int frequencyId) {
        Statement stmt = null;
        List<Integer> month = new ArrayList<>();
        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select duration_in_months from loan_product_details where domain_status_id=1 and  loan_product_id=" + loanProductId + " and frequency_id=" + frequencyId + ";");
            while (rs.next()) {
                month.add(rs.getInt("duration_in_months"));
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return month;
    }
}
