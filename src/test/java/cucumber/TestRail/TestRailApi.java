package cucumber.TestRail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;


public class TestRailApi {

    private static TestRail testRail;
    private final static String endPoint = "https://yemeksepeti.testrail.com";
    private final static String username = "yahya.kara@yemeksepeti.com";
    private final static String password = "Casper7131";
    private static List<Integer> caseIds = new ArrayList<>();

    public static TestRail createTestRailInstance() {
        if (testRail == null) {
            testRail = TestRail.builder(endPoint, username, password).build();
        }
        return testRail;
    }

    private static int projectId;
    private static int suiteId;

    public static int getProjectId() {
        return projectId;
    }
    public static void setProjectId(int projectId) {
        TestRailApi.projectId = projectId;
    }
    public static int getSuiteId() {
        return suiteId;
    }
    public static void setSuiteId(int suiteId) {
        TestRailApi.suiteId = suiteId;
    }

    // ********* Function to fetch Project id and suite Id ***********
    public static void setProjectSuiteId( int projectId, int suiteId){
        setProjectId(projectId);
        setSuiteId(suiteId);
    }

    // ******* Getter and setter for Run object **************
    public static Run run;
    public static Run getRun() {
        return run;
    }
    public static void setRun(Run run) {
        TestRailApi.run = run;
    }

    public static void createRun() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyy kk:mm:s");
        Date date = new Date();
        String dateString = format.format(date);
        String runName = "Api Test Automation " + dateString;
        try{
            run = new Run();
            run = testRail.runs().add(getProjectId(), run.setSuiteId(getSuiteId()).setName(runName).setIncludeAll(false)).execute();
            setRun(run);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateRun(Object caseIdString){
        try{
            if(null != caseIdString){
                Integer caseId = Integer.parseInt(caseIdString.toString());
                caseIds.add(caseId);
                getRun().setCaseIds(caseIds);
                testRail.runs().update(getRun()).execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void addResult(String comment, String caseId){
        Integer caseIdInt = Integer.parseInt(caseId);
        try{
            if(null != testRail ){
                List<com.codepine.api.testrail.model.ResultField> customResultFields = testRail.resultFields().list().execute();
                testRail.results().addForCase(getRun().getId(), caseIdInt, new Result().setComment(comment),
                        customResultFields).execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void addStatusForCase(int statusId, String caseId){
        String comment = null;
        Integer caseIdInt = Integer.parseInt(caseId);
        try{
            List<com.codepine.api.testrail.model.ResultField> customResultFields = testRail.resultFields().list().execute();

            testRail.results().addForCase(getRun().getId(), caseIdInt, new Result().setStatusId(statusId), customResultFields).execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<Field.Step> getCaseSteps(String caseId){
        Integer caseIdInt = Integer.parseInt(caseId);
        List<CaseField> customCaseFields = testRail.caseFields().list().execute();
        Case testCase = testRail.cases().get(caseIdInt, customCaseFields).execute();
        return testCase.getCustomField("steps_separated");

    }

    public static void closeRun(){
        try{
            testRail.runs().close(getRun().getId()).execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setCaseIds(List<Integer> caseIds) {
        TestRailApi.caseIds = caseIds;
    }
}