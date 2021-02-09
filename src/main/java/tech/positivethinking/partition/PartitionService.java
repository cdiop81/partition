package tech.positivethinking.partition;

import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PartitionService {
    private static final Logger logger = LoggerFactory.getLogger(PartitionService.class);

    public List<List<String>> divideList(List<String> paramList, int size) {
        Objects.requireNonNull(paramList);
        logger.info("Input List {} and size of split {}", paramList, size);
        List<List<String>> partitions = ListUtils.partition(paramList, size);
        logger.info("Output List {} ", partitions);
        return partitions;
    }
}
