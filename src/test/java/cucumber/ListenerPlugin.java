package cucumber;

import apiEngine.Utilies.DateUtil;
import cucumber.TestRail.TestRailLogHelper;
import com.codepine.api.testrail.model.Field;
import cucumber.TestRail.TestRailApi;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.junit.platform.commons.logging.Logger;


import java.text.Collator;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;


public class ListenerPlugin implements ConcurrentEventListener {
    public String testRailId = "";
    public List<String> steps = new ArrayList<>();
    public boolean isRunCreated = false;

    private void setTestRailTag(List<String> tags) {
        String testRailTag = "";
        for (String tag : tags) {
            if (tag.contains("TestRail")) {
                testRailTag = tag;
                break;
            }
        }
        testRailId = testRailTag.replace("TestRail", "")
                .replace("@", "")
                .replace("(", "")
                .replace(")", "");
    }

    public void onTestRunStarted(TestRunStarted testRunStarted) {
        TestRailLogHelper.getInstance();
        TestRailApi.createTestRailInstance();
        TestRailApi.setProjectSuiteId(34, 740);
        try {
            TestRailApi.createRun();
            isRunCreated = true;
            TestRailLogHelper.getInstance().refreshInstance();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void onTestCaseStarted(TestCaseStarted testCaseStarted) {
        List<String> tags = testCaseStarted.getTestCase().getTags();
        steps.clear();
        setTestRailTag(tags);
        if (!testRailId.isEmpty()) {
            TestRailApi.updateRun(testRailId);
        }
    }


    public void onTestRunFinished(TestRunFinished testRunFinished) {
        if (isRunCreated) {
            TestRailApi.closeRun();
        }
    }


    private  List<Map.Entry<String, String>> getSortedTestLogs() {
        Collator collator = Collator.getInstance(Locale.US);
        collator.setStrength(Collator.PRIMARY); // case insensitive collator

        HashMap<String, String> map = TestRailLogHelper.getInstance().getLog();
        List<Map.Entry<String, String>> result =
                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey(collator))
                        .collect(Collectors.toList());
        return result;
    }

    public void onTestCaseFinished(TestCaseFinished testCaseFinished) {
        boolean iSFailed = Storage.getScenario().isFailed();
        if (!testRailId.isEmpty()) {
            TestRailApi.addResult(getSortedTestLogs().toString(), testRailId);
            TestRailApi.addResult(steps.toString(), testRailId);
            steps.clear();
            if (iSFailed) {
                TestRailApi.addStatusForCase(5, testRailId);
            } else {
                TestRailApi.addStatusForCase(1, testRailId);
            }
        }
        TestRailLogHelper.getInstance().refreshInstance();

    }

    private void saveSteps(String stepName, String stepResult){
        steps.add(stepName + " : " + stepResult);
    }


    public void onStepFinished(TestStepFinished testStepFinished) {
        TestRailLogHelper.getInstance().setLog(DateUtil.generateDateNow() + ":",
                "\n" + " **" + StepDetails.stepName + "** \n ********* " + "\n" );
        boolean status = testStepFinished.getResult().getStatus().isOk();
        if (status){
            saveSteps("\n + " +StepDetails.stepName, "Pass" + "\n");
            
        }
        else {
            saveSteps("\n + " +StepDetails.stepName, "Fail" + "\n");
        }
    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::onTestRunStarted);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onStepFinished);
    }

    public void result(Result result) {
        //Code to create logs or store to a database etc...
        result.getError();
        result.getStatus();
    }

}