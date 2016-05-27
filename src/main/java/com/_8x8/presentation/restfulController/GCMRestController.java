/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.presentation.restfulController;

import com._8x8.logic.service.IGCMService;
import com._8x8.presentation.model.GCM;
import com._8x8.presentation.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/zPay")
public class GCMRestController {
    
    @Autowired
    IGCMService _gcmService;
    
    @RequestMapping(value = "/gcm/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GCM>> getAllGCM() {
        List<GCM> GCMs = _gcmService.GetGCMs();
                
        if (GCMs.isEmpty()) {
            return new ResponseEntity<List<GCM>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<GCM>>(GCMs, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/gcm/{id}/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateGCMById(@PathVariable("id") String id, @RequestBody GCM gcm, UriComponentsBuilder ucBuilder) {
    
        try {
              _gcmService.UpdateGCMById(gcm);             
             return new ResponseEntity<String>("{'status': 'success'}", HttpStatus.OK);
        }catch (Exception ex) {
             return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        
    }
}
