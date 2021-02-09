package partition;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.positivethinking.partition.PartitionApplication;
import tech.positivethinking.partition.PartitionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = {PartitionApplication.class}
)
@ContextConfiguration
public class PartitionStep {
    public static final String SEPARATOR = ",";
    private static List<String> inputList;
    private static List<List<String>> outputList;
    @Autowired
    private PartitionService service;

    @cucumber.api.java.en.Given("the following list params")
    public void theFollowingListParams(List<String> listToSplit) {
        inputList = formatList(listToSplit);
    }

    @cucumber.api.java.en.When("I call partition service to split the List by a size of ([0-9])")
    public void iCallPartitionServiceToSplitTheListByASizeOf(Integer size) {
        outputList = service.divideList(inputList, size);
        inputList = null;

    }

    @cucumber.api.java.en.Then("I will get the following sub lists")
    public void iWillGetTheFollowingSubLists(List<List<String>> expected) {
        List<List<String>> expectedPartitions = formatExpectedPartitionsList(expected);
        assertThat(outputList)
                .containsExactlyInAnyOrderElementsOf(expectedPartitions);
        outputList = null;
    }

    private List<List<String>> formatExpectedPartitionsList(List<List<String>> expectedPartitions) {
        List<List<String>> listToReturn = new ArrayList<>();
        for (List<String> list : expectedPartitions) {
            listToReturn.add(formatList(list));
        }
        return listToReturn;
    }

    private List<String> formatList(List<String> listToFormat) {
        return Arrays.asList(listToFormat.get(0).split(SEPARATOR));
    }
}
