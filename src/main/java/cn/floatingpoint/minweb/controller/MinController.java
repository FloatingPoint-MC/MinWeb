package cn.floatingpoint.minweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @projectName: MinWeb
 * @author: vlouboos
 * @date: 2023-07-22 13:37:30
 */
@Controller
@RequestMapping("data")
public class MinController {
    public static final HashMap<String, Long> uuids = new HashMap<>();

    @ResponseBody
    @RequestMapping("put")
    public String putData(@RequestParam("uuid") String uuid) {
        uuids.put(uuid, System.currentTimeMillis());
        return "{\"code\": 0}";
    }

    @ResponseBody
    @RequestMapping("get")
    public String getData(@RequestParam("uuid") String uuid) {
        if (uuids.containsKey(uuid)) {
            return "{\"code\": 0}";
        } else {
            return "{\"code\": -1}";
        }
    }

    @ResponseBody
    @RequestMapping("remove")
    public String RemoveData(@RequestParam("uuid") String uuid) {
        if (uuids.containsKey(uuid)) {
            uuids.remove(uuid);
            return "{\"code\": 0}";
        } else {
            return "{\"code\": -1}";
        }
    }
}
