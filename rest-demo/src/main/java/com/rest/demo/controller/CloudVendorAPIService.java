package com.rest.demo.controller;

import com.rest.demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){
        //return new CloudVendor("C1", "ahmed", "casablanca", "0123456789");
        return cloudVendor;
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud vendor updated successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId){
        this.cloudVendor = null;
        return "Cloud vendor deleted successfully";
    }
}
