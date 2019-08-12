package com.imooc.demo.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/listarea")
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @GetMapping(value = "/getareabyid")
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @PostMapping(value = "/addarea")
    private Map<String, Object> addArea(@RequestBody Area area)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    @PostMapping(value = "/modifyarea")
    private Map<String, Object> modifyArea(@RequestBody Area area)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping(value = "/removearea")
    private Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
