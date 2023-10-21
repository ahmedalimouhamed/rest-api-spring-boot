package com.example.rest.repository;

import com.example.rest.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CloudVendorRepositoryTest {

    private CloudVendorRepository cloudVendorRepository;

    CloudVendor cloudVendor;

    @Autowired
    public CloudVendorRepositoryTest(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @BeforeEach
    void setUp() {
        /*
        CloudVendor cv1 = new CloudVendor("c1", "ahmed", "casablanca", "021151484");
        CloudVendor cv2 = new CloudVendor("c2", "salman", "rabat", "021331484");
        CloudVendor cv3 = new CloudVendor("c3", "ahmed", "safi", "011391484");
        CloudVendor cv4 = new CloudVendor("c4", "samir", "mouhamadia", "022399484");
        CloudVendor cv5 = new CloudVendor("c5", "salman", "casablanca", "025369997");

        this.cloudVendorRepository.save(cv1);
        this.cloudVendorRepository.save(cv2);
        this.cloudVendorRepository.save(cv3);
        this.cloudVendorRepository.save(cv4);
        this.cloudVendorRepository.save(cv5);
        */

        cloudVendor = new CloudVendor("c1", "ahmed", "casablanca", "021151484");
        this.cloudVendorRepository.save(cloudVendor);

        //System.out.println("List of cloud vendors before all");
        System.out.println("----------+++++++++-------\nList of cloud vendors before all : \n----------+++++++++-------\n"+this.cloudVendorRepository.findAll());
    }

    //test case success

    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("ahmed");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorName()).isEqualTo(cloudVendor.getVendorName());
        assertThat(cloudVendorList.get(0).getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }


    //test case failure


    @Test
    void testFindByVendorName_NotFound() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("amazon");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }

    @AfterEach
    void tearDown() {
        cloudVendorRepository.deleteAll();
    }
}