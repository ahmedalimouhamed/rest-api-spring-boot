package com.example.rest.controller;

import com.example.rest.model.CloudVendor;
import com.example.rest.services.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    private CloudVendorService cloudVendorService;

    @Autowired
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendors(){
        return this.cloudVendorService.getAllCloudVendor();
    }

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendor(@PathVariable String vendorId){
        return this.cloudVendorService.getCloudVendor(vendorId);
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
