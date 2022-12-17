package io.github.fernandoferreira.observer.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.fernandoferreira.observer.domain.dto.ClientRequest;
import io.github.fernandoferreira.observer.domain.dto.ClientResponse;
import io.github.fernandoferreira.observer.service.impl.ClientServiceImpl;
import io.github.fernandoferreira.observer.util.ClientTestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

@Tag("unit")
@DisplayName("Client Controller Unit Test ")
@WebMvcTest
//@ExtendWith(SpringExtension.class)
//@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientServiceImpl clientService;

    @Test
    @DisplayName("Given valid client request when validate parameters and persist client then return client created")
    public void GivenValidClientRequest_WhenValidateParametersAndPersistClient_ThenReturnClientCreated() throws Exception {
        // Arrange
        ObjectMapper mapper = new ObjectMapper();
        ClientRequest clientRequest = ClientTestUtil.getClientRequestInstance();
        ClientResponse clientResponse = ClientTestUtil.getClientResponseInstance();

        Mockito.when(clientService.save(Mockito.any(ClientRequest.class))).thenReturn(clientResponse);
        String json = mapper.writeValueAsString(clientRequest);

        // Action
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();

        // Assert
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        String content = response.getContentAsString(StandardCharsets.UTF_8);

        ClientResponse clientResult = mapper.readValue(content, ClientResponse.class);
        Assertions.assertEquals(clientResponse, clientResult);
        Mockito.verify(clientService, Mockito.times(1)).save(clientRequest);
    }
}
