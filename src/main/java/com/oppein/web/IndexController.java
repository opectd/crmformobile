package com.oppein.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenjianqi
 * @date 2017/4/12
 *
 *
 */

@Controller
@RequestMapping(value = "crm/index")
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(){
        return "index/netSales";
    }

    @ResponseBody
    @RequestMapping(value = "/{productId}/{proid}",method = RequestMethod.GET)
    public HashMap rest(
            @PathVariable Integer productId,@PathVariable Integer proid
    ){
        List<Integer> li = new ArrayList<>();
        li.add(productId);
        li.add(proid);
        HashMap<String,Object> m = new HashMap<>();
        m.put("a",li);
        return m;
    }

    @RequestMapping(value = "/agentindex")
    public String agentIndex(){
        return "index/agent_index";
    }

}
