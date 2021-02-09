package tech.positivethinking.partition;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartitionController {
    public final PartitionService service;

    @GetMapping("/api/partition")
    @ResponseBody
    public List<List<String>> transformList(@RequestParam List<String> paramList, @RequestParam int size) {
        List<List<String>> partition = service.divideList(paramList, size);
        return partition;
    }

    public PartitionController(PartitionService service) {
        this.service = service;
    }
}
