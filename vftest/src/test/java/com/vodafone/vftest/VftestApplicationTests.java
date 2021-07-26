package com.vodafone.vftest;

import com.vodafone.vftest.entity.DeviceCardEntity;
import com.vodafone.vftest.enums.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VftestApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void checkforWFADEvices() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vftest/api/wfa",
                List.class));
    }

    @Test
    void ckeckPutDevice() {
        DeviceCardEntity dev = new DeviceCardEntity();
        dev.setSimId(1);
        dev.setOperatorCode(1);
        dev.setStatus(Status.READY);
        dev.setCountry("Egypt");
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/vftest/api/device", dev, DeviceCardEntity.class));

    }

    @Test
    void checkforAFSDEvices() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vftest/api/afs",
                List.class));
    }
}
