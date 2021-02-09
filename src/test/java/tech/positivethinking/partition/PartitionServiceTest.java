package tech.positivethinking.partition;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PartitionServiceTest {
    PartitionService service = new PartitionService();

    @Test
    public void testDivideListByOneShouldReturnAListWithFiveElements() {
        final List<String> inputList = Arrays.asList("1", "2", "3", "4", "5");
        final List<List<String>> result = service.divideList(inputList, 1);
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void testDivideListByTwoShouldReturnAListWithThreeElements() {
        final List<String> inputList = Arrays.asList("1", "2", "3", "4", "5");
        final List<List<String>> result = service.divideList(inputList, 2);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void testDivideListByThreeShouldReturnAListWithTwoElements() {
        final List<String> inputList = Arrays.asList("1", "2", "3", "4", "5");
        final List<List<String>> result = service.divideList(inputList, 3);
        assertThat(result.size()).isEqualTo(2);
    }
}