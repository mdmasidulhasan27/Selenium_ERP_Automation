package main.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchDataFromDatabase {
    /*public static List<GroupInfoListPagingData> getGroupInfoListPagingDatas(String branchCode, String updatedAt, String creationYear) {
        Statement stmt = null;
        List<GroupInfoListPagingData> groupInfoListPagingData = new ArrayList<>();
        List<Long> officeIds = DatabaseUtil.getOfficeIds(branchCode);
        String branchCodes = officeIds.toString().replace("[", "'").replace("]", "'");


        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = null;
            String query = "";
            query = "select gi.group_name               VoName,\n" +
                    "       gi.id                       VoID, \n" +
                    "       gi.group_reference_number   OrgNo,\n" +
                    "       gi.branch_info_id           BranchID,\n" +
                    "       poi.office_code             BranchCode,\n" +
                    "       gi.group_status_id          groupStatusId,\n" +
                    "       vc.name                     UpgGroup,\n" +
                    "       eci.pin_no                  PoPIN,\n" +
                    "       eci.employee_name           PoName,\n" +
                    "       to_char(gi.next_collection_date, 'yyyy-mm-dd') NextCollectionDate,\n" +
                    "       to_char(gi.loan_collection_start_date, 'yyyy-mm-dd') FirstCollectionDate,\n" +
                    "       to_char(gi.last_updated, 'yyyy-mm-dd hh24:mi:ss') UpdatedAt\n" +
                    "FROM vo_category vc\n" +
                    "         INNER JOIN group_info gi\n" +
                    "                    ON ( vc.id = gi.vo_category_id " +
                    "                        and  gi.branch_info_id=  ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))\n" +
                    "                        AND gi.project_info_id = 165\n" +
                    "                        AND year(gi.group_creation_date) = " + creationYear + " and gi.last_updated >= '" + updatedAt + "'\n" +
                    "                        and gi.domain_status_id = 1)\n" +
                    "         INNER JOIN employee_core_info eci ON (eci.id = gi.assignedpo_id)\n" +
                    "         INNER JOIN physical_office_info poi ON (poi.id = gi.branch_info_id and poi.id= ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT)) )\n" +
                    "ORDER BY gi.last_updated ASC limit 1000 offset 0;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                //public GroupInfoListPagingData(String voName, Long voID, String orgNo,
                // Long branchId, String branchCode, Long groupStatusId, String upgGroup,
                // String poPIN, String poName, String nextCollectionDate, String firstCollectionDate,
                // String updatedAt)
                groupInfoListPagingData.add(new GroupInfoListPagingData(rs.getString("VoName"), rs.getLong("VoID"), rs.getString("OrgNo"),
                        rs.getLong("BranchID"), rs.getString("BranchCode"), rs.getLong("groupStatusId"), rs.getString("UpgGroup"),
                        rs.getString("PoPIN"), rs.getString("PoName"), rs.getString("NextCollectionDate"), rs.getString("FirstCollectionDate"),
                        rs.getString("UpdatedAt")));
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return groupInfoListPagingData;
    }

    public static List<MemberInfoListPagingData> getMemberInfoListPagingData(String branchCode, String updatedAt, String creationYear) {
        Statement stmt = null;
        List<MemberInfoListPagingData> memberInfoListPagingData = new ArrayList<>();
        List<Long> officeIds = DatabaseUtil.getOfficeIds(branchCode);
        String branchCodes = officeIds.toString().replace("[", "'").replace("]", "'");

        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = null;
            String query = "";
            query = "SELECT gi.group_name               VoName,\n" +
                    "       gi.id                       VoID,\n" +
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
                    "                         AND gi.branch_info_id =  ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))\n" +
                    "                        AND gi.project_info_id = 165\n" + " AND year(mi.application_date) = " + creationYear + " " +
                    "                        AND mi.last_updated >= '" + updatedAt + "'\n" + "  and mi.domain_status_id = 1)\n" +
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
                memberInfoListPagingData.add(new MemberInfoListPagingData(rs.getString("VoName"), rs.getLong("VoID"), rs.getString("OrgNo"),
                        rs.getString("UpgGroup"), rs.getString("PoPIN"), rs.getLong("MemberId"), rs.getString("OrgMemNo"),
                        rs.getLong("MemberStatusId"), rs.getString("BranchCode"), rs.getLong("BranchID"),
                        rs.getString("MemberName"), rs.getString("UpdatedAt"), rs.getString("ApplicationDate")));


            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return memberInfoListPagingData;
    }


    public static List<CollectionInfoUpgData> getCollectionInfoUpgData(String branchCode, String updatedAt) {
        Statement stmt = null;
        List<CollectionInfoUpgData> collectionInfoUpgData = new ArrayList<>();
        List<Long> officeIds = DatabaseUtil.getOfficeIds(branchCode);
        String branchCodes = officeIds.toString().replace("[", "'").replace("]", "'");

        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = null;
            String query = "";
            query = "SELECT *\n" +
                    "FROM (\n" +
                    "         SELECT innLoanON.member_id                   MemberId,\n" +
                    "                innLoanON.account_no                  LoanNo,\n" +
                    "                innLoanON.disbursed_amount            LoanAmount,\n" +
                    "                lp.approved_grant_amount              GrantAmount,\n" +
                    "                innLoanON.current_installment_no      InstallmentPassed,\n" +
                    "                innLoanON.realized_amount             PaidAmount,\n" +
                    "                innLoanON.outstanding_balance         DueAmount,\n" +
                    "                innLoanON.loan_status_id              Status,\n" +
                    "                poi.id                                BranchID,\n" +
                    "                poi.office_code                       BranchCode,\n" +
                    "                si.scheme_name                        Enterprise,\n" +
                    "                to_char(innLoanON.last_updated, 'yyyy-mm-dd hh24:mi:ss') UpdatedAt\n" +
                    "         FROM scheme_info si\n" +
                    "                  INNER JOIN (SELECT member_id,\n" +
                    "                                     account_no,\n" +
                    "                                     disbursed_amount,\n" +
                    "                                     current_installment_no,\n" +
                    "                                     realized_amount,\n" +
                    "                                     outstanding_balance,\n" +
                    "                                     loan_status_id,\n" +
                    "                                     last_updated,\n" +
                    "                                     scheme_info_id,\n" +
                    "                                     loan_proposal_id,\n" +
                    "                                     office_info_id\n" +
                    "                              FROM loan_account la\n" +
                    "                              WHERE la.office_info_id = ANY\n" +
                    "                                    (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))\n" +
                    "                                AND la.project_info_id = 165\n" +
                    "                                AND la.last_updated >= '" + updatedAt + "' \n" +
                    "         ) innLoanON ON (si.id = innLoanON.scheme_info_id)\n" +
                    "                  INNER JOIN loan_proposal lp ON (lp.id = innLoanON.loan_proposal_id)\n" +
                    "                  INNER JOIN physical_office_info poi ON (poi.id = innLoanON.office_info_id)\n" +
                    "         UNION ALL\n" +
                    "         SELECT innAd.member_id                                         MemberId,\n" +
                    "                0                                                       LoanNo,\n" +
                    "                (innAd.asset_total_amount - innAd.grant_total_amount)   LoanAmount,\n" +
                    "                innAd.grant_total_amount                                GrantAmount,\n" +
                    "                0                                                       InstallmentPassed,\n" +
                    "                0                                                       PaidAmount,\n" +
                    "                0                                                       DueAmount,\n" +
                    "                innAd.status                                            Status,\n" +
                    "                poi.id                                                  BranchID,\n" +
                    "                poi.office_code                                         BranchCode,\n" +
                    "                si.scheme_name                                          Enterprise,\n" +
                    "                to_char(innAd.last_updated, 'yyyy-mm-dd hh24:mi:ss')  UpdatedAt\n" +
                    "         FROM scheme_info si\n" +
                    "                  INNER JOIN (\n" +
                    "             SELECT member_id,asset_total_amount, grant_total_amount, status, last_updated,scheme_id,office_id\n" +
                    "             FROM asset_distribution ad\n" +
                    "             WHERE (\n" +
                    "                               ad.office_id = ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))\n" +
                    "                           AND ad.project_id = 165\n" +
                    "                           AND ad.last_updated >= '" + updatedAt + "' \n" +
                    "                           AND ad.is_grant_full_amount AND ad.status = 2)\n" +
                    "         ) innAd ON (si.id = innAd.scheme_id)\n" +
                    "                  INNER JOIN physical_office_info poi ON (poi.id = innAd.office_id)) as data\n" +
                    "ORDER BY data.UpdatedAt\n" +
                    "LIMIT 1000 OFFSET 0;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                // (Long memberId, Long loanNo, Double loanAmount, Double grantAmount, Long installmentPassed,
                // Double paidAmount, Double dueAmount, Long status, Long branchId, String branchCode, String enterprise, String updatedAt)
                collectionInfoUpgData.add(new CollectionInfoUpgData(rs.getLong("MemberId"), rs.getLong("LoanNo"), rs.getDouble("LoanAmount"),
                        rs.getDouble("GrantAmount"), rs.getLong("InstallmentPassed"), rs.getDouble("PaidAmount"), rs.getDouble("dueAmount"),
                        rs.getLong("Status"), rs.getLong("BranchID"), rs.getString("BranchCode"), rs.getString("Enterprise"), rs.getString("UpdatedAt")));
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return collectionInfoUpgData;
    }


    public static List<SavingsInfoUpgData> getSavingsInfoUpgData(String branchCode, String updatedAt) {
        Statement stmt = null;
        List<SavingsInfoUpgData> savingsInfoUpgData = new ArrayList<>();
        List<Long> officeIds = DatabaseUtil.getOfficeIds(branchCode);
        String branchCodes = officeIds.toString().replace("[", "'").replace("]", "'");

        try {
            stmt = getPostgreSqlConnection().createStatement();
            ResultSet rs = null;
            String query = "";
            query = "SELECT  sat.savings_account_id                             \"sav_account_id\",\n" +
                    "                           sat.member_info_id                                 \"MemberId\",\n" +
                    "                           poi.id                                             \"BranchId\",\n" +
                    "                           poi.office_code                                    \"BranchCode\",\n" +
                    "                           sat.deposit_amount                                 \"DepositAmount\",\n" +
                    "                           sat.withdrawal_amount                              \"WithdrawalAmount\",\n" +
                    "                           sat.savings_balance                                \"SavingsBalance\",\n" +
                    "                           sat.trx_type                                       \"TrxType\",\n" +
                    "                           to_char(sat.transaction_date, 'yyyy-mm-dd')        \"TransactionDate\",\n" +
                    "                           to_char(sat.last_updated, 'yyyy-mm-dd hh24:mi:ss') \"UpdatedAt\"\n" +
                    "                    FROM physical_office_info poi\n" +
                    "                             INNER JOIN savings_account_transaction sat ON (poi.id = sat.office_info_id \n" +
                    "                              AND sat.office_info_id=ANY (SELECT CAST(regexp_split_to_table(" + branchCodes + ", ',') AS BIGINT))   \n" +
                    "                         AND sat.project_info_id =165 and sat.last_updated >= '" + updatedAt + "' \n" +
                    "                        AND (sat.deposit_amount + sat.withdrawal_amount) > 0\n" +
                    "                        AND sat.domain_status_id = 1)\n" +
                    "                    ORDER BY sat.last_updated\n" +
                    " limit 1000 offset 0;";

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                // SavingsInfoUpgData(Long savAccountId, Long memberId, Long branchId,
                // String branchCode, Double depositAmount, Double withdrawalAmount, Double savingsBalance,
                // Integer trxType, String transactionDate, String updatedAt)

                savingsInfoUpgData.add(new SavingsInfoUpgData(rs.getLong("sav_account_id"), rs.getLong("MemberId"), rs.getLong("BranchId"),
                        rs.getString("BranchCode"), rs.getDouble("depositAmount"), rs.getDouble("WithdrawalAmount"), rs.getDouble("SavingsBalance"),
                        rs.getInt("TrxType"), rs.getString("TransactionDate"), rs.getString("UpdatedAt")));
            }
            rs.close();
            stmt.close();
            getPostgreSqlConnection().close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return savingsInfoUpgData;
    }
     */
}
