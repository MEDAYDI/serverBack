package io.getarrays.server.service.implementation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepo;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServerServiceImplTest {
       
    @Mock
     private ServerRepo serverRepo;
     private ServerServiceImpl serverService;

     @BeforeEach
     void SetUp(){
        serverService = new ServerServiceImpl(serverRepo);
     }

    

    @Test
    void testCreate() {
         // Setup
         Server server = new Server();
         server.setName("Test Server");
         server.setIpAddress("192.168.1.14");
         server.setMemory("30GB");
         server.setType("Huawei");
         server.setImageUrl("http://localhost:8080/server/image/server1.png");
         server.setStatus(Status.SERVER_UP);
 
         // when 
          serverService.create(server);

          //then 
          ArgumentCaptor<Server> sArgumentCaptor =
              ArgumentCaptor.forClass(Server.class);

          verify(serverRepo).save(sArgumentCaptor.capture());

          Server captureServer= sArgumentCaptor.getValue();

          assertThat(captureServer).isEqualTo(server);

    }

   
   

    @Test
    void testList() {
      
        // when 
        serverService.list();

        //then 
        verify(serverRepo).findAll();
         

    }

    

    @Test
    void testUpdate() {
         // Setup
         Server server = new Server();
         server.setName("FTP server");
         server.setIpAddress("192.168.1.14");
         server.setMemory("50GB");
         server.setType("Huawei");
         server.setImageUrl("http://localhost:8080/server/image/server1.png");
         server.setStatus(Status.SERVER_UP);
 
         // when 
          serverService.create(server);

          //then 
          ArgumentCaptor<Server> sArgumentCaptor =
              ArgumentCaptor.forClass(Server.class);

          verify(serverRepo).save(sArgumentCaptor.capture());

          Server captureServer= sArgumentCaptor.getValue();

          assertThat(captureServer).isEqualTo(server);

    }

    @Test
    void testDelete() {

         // when 
         serverService.delete((long) 1);

         //then 
         verify(serverRepo).deleteById((long) 1);

    }

}
