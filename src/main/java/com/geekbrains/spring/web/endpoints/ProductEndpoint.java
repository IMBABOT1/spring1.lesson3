package com.geekbrains.spring.web.endpoints;

import com.geekbrains.spring.web.services.ProductsService;
import com.geekbrains.spring.web.soap.GetProductByIdRequest;
import com.geekbrains.spring.web.soap.GetProductByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.imbabot.com/spring/ws/products";
    private final ProductsService productsService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getStudentByName(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setProduct(productsService.findById(request.getId()));
        return response;
    }

    /*
        Пример запроса: POST http://localhost:8080/ws
        Header -> Content-Type: text/xml

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.flamexander.com/spring/ws/students">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllStudentsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getAllStudents(@RequestPayload GetAllStudentsRequest request) {
        GetAllStudentsResponse response = new GetAllStudentsResponse();
        studentService.getAllStudents().forEach(response.getStudents()::add);
        return response;
    }
}

