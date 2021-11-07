package com.gmail.rybachko.anna.taskfourth.mvc;

import com.gmail.rybachko.anna.taskfourth.aop.FuelExceptionHandle;
import com.gmail.rybachko.anna.taskfourth.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EngineController {
    private final Map<String, EngineService> stringEngineServiceMap;

    @Autowired
    public EngineController(@Qualifier("stringEngineServiceMap") Map<String, EngineService> stringEngineServiceMap) {
        this.stringEngineServiceMap = stringEngineServiceMap;
    }

    @FuelExceptionHandle
    @GetMapping("/mvc/fuel/check")
    public String getPetrolService(@RequestParam("type") String type) throws ClassNotFoundException {
        if (stringEngineServiceMap.containsKey(type)) {
            return stringEngineServiceMap.get(type).powerUp();
        } else {
            throw new ClassNotFoundException();
        }
    }
}
