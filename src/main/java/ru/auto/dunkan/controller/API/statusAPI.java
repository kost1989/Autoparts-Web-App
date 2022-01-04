package ru.auto.dunkan.controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.auto.dunkan.model.Status;
import ru.auto.dunkan.repo.StatusRepository;
import ru.auto.dunkan.service.StatusService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class statusAPI {
    StatusService statusService;

    @Autowired
    public statusAPI(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(value = "/api/status/id", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getJSONStatusById(@RequestParam("id") String id) {
        Status status = statusService.get(Long.parseLong(id));
        HashMap<String, String> jsonMap = new HashMap<>();
        jsonMap.put("id", status.getId() + "");
        jsonMap.put("name", status.getName());
        jsonMap.put("color", status.getColor());
        jsonMap.put("enabled", status.getEnabled() + "");
        return jsonMap;
    }

    @RequestMapping(value = "/api/status/all", method = RequestMethod.POST)
    public Map<String, HashMap<String, String>> getJSONAllStatuses() {
        HashMap<String, HashMap<String, String>> outputJSON = new HashMap<>();
        List<Status> statusList = statusService.listAll();

        long count = 0;

        for (Status status : statusList) {
            HashMap<String, String> tempInnerJSON = new HashMap<>();
            tempInnerJSON.put("id", status.getId() + "");
            tempInnerJSON.put("name", status.getName());
            tempInnerJSON.put("color", status.getColor());
            tempInnerJSON.put("enabled", status.getEnabled() + "");
            outputJSON.put(count + "", tempInnerJSON);
            count++;
        }

        return outputJSON;
    }

    @RequestMapping(value = "/api/status/add", method = RequestMethod.POST)
    @ResponseBody
    public void addJSONStatusToDB(@RequestParam("statusName") String statusName,
                                  @RequestParam("statusColor") String statusColor) {
        statusService.save(new Status(statusName, statusColor));
    }

    @RequestMapping(value = "/api/status/enabled", method = RequestMethod.POST)
    @ResponseBody
    public void enabledFalseJSONStatusToDB(@RequestParam("statusName") String statusName,
                                           @RequestParam("statusEnabled") String statusEnabled) {
        if (statusEnabled.equals("true") || statusEnabled.equals("false")) {
            Status status = statusService.getByName(statusName);
            status.setEnabled(Boolean.parseBoolean(statusEnabled));
            statusService.save(status);
        }
    }
}
