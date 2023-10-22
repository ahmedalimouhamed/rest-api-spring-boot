package com.example.rest.controller;

import com.example.rest.model.CloudVendor;
import com.example.rest.responses.ResponseHandler;
import com.example.rest.services.CloudVendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    public CloudVendorService cloudVendorService;

    @GetMapping
    public List<CloudVendor> getAllCloudVendors(){
        return this.cloudVendorService.getAllCloudVendor();
    }

    @GetMapping("/{vendorId}")
    @ApiOperation(value="Cloud vendor id", notes="Provide cloud vendor details", response=ResponseEntity.class)
    public ResponseEntity<Object> getCloudVendor(@PathVariable String vendorId){
        return ResponseHandler.responseBuilder("Requested vendor details are given here", HttpStatus.OK, this.cloudVendorService.getCloudVendor(vendorId));
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        return this.cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        return this.cloudVendorService.updateCloudVendor(cloudVendor);
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId){
        return this.cloudVendorService.deleteCloudVendor(vendorId);
    }


}
