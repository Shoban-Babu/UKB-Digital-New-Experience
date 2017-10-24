package bgb.CommonProperties;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import oracle.jdbc.pool.OracleDataSource;
import bgb.CommonProperties.PropertyLoader;

public class OnlineDBConnector {

    private final static String FILE_NAME = "BGB/CommonProperties/Dev.properties";
    private static Properties DBConfig = new PropertyLoader(FILE_NAME).load();

    private SimpleJdbcTemplate jdbcTemplate;
    private OracleDataSource dataSource;

    public DataSource getDataSource() {
        if (dataSource != null) {
            return dataSource;
        }
        try {
            Class.forName(DBConfig.getProperty("DATABASE_DRIVER"));
            dataSource = new OracleDataSource();
            dataSource.setURL(DBConfig.getProperty("DATABASE_URL"));
            dataSource.setUser(DBConfig.getProperty("DATABASE_USERNAME"));
            dataSource.setPassword(DBConfig.getProperty("DATABASE_PASSWORD"));
            return dataSource;
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            //Report.updateTestLog("Connection to online database failed", "FAIL");
            e.printStackTrace();
        }
        return null;
    }

    public String[] getAuditEventTypeId(String date,String emailId, String type) {
        jdbcTemplate = new SimpleJdbcTemplate(getDataSource());
        String strQuery = "Select AUDIT_EVENT_TYPE_ID,AUDTI_DATA from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+emailId +"' AND AUDIT_TIMESTAMP > to_Date('"
                + date + "','dd-mm-yy-hh24.mi.ss') and AUDTI_DATA like '%"+type+"%' and rownum=1";
        //String strQuery = "Select EMAIL_ADDRESS from bg_business_ta_audit_details where EMAIL_ADDRESS = '"+ emailId +"' and rownum=1";
        System.out.println(strQuery);
        List<Map<String, Object>> ss=jdbcTemplate.queryForList(strQuery);
        String[] list = new String[2];
        if(!ss.isEmpty()){
            if(ss.get(0).get("AUDIT_EVENT_TYPE_ID")!=null){
                list[0]=ss.get(0).get("AUDIT_EVENT_TYPE_ID").toString();}
            if(ss.get(0).get("AUDTI_DATA")!=null){
                list[1]=ss.get(0).get("AUDTI_DATA").toString();
            }
        }
        return list;

    }

}
