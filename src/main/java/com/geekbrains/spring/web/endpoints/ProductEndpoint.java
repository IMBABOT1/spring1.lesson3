package com.geekbrains.spring.web.endpoints;


import com.geekbrains.spring.web.converters.ProductSoapConverter;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.services.ProductsService;
import com.geekbrains.spring.web.soap.GetAllProductsRequest;
import com.geekbrains.spring.web.soap.GetAllProductsResponse;
import com.geekbrains.spring.web.soap.GetProductByIdRequest;
import com.geekbrains.spring.web.soap.GetProductByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.List;
import java.util.Optional;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.imbabot.com/spring/ws/products";
    private final ProductsService productsService;
    private final ProductSoapConverter productSoapConverter;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        Optional<Product> optional = productsService.findById(request.getId());

        if (optional.isPresent()) {
            response.setProduct(productSoapConverter.entityToDto(optional.get()));
        }
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request,
                                                 @RequestParam(name = "p", defaultValue = "1") Integer page,
                                                 @RequestParam(name = "min_price", required = false) Integer minPrice,
                                                 @RequestParam(name = "max_price", required = false) Integer maxPrice,
                                                 @RequestParam(name = "title_part", required = false) String titlePart,
                                                 @RequestParam(name = "category", required = false) String category


    ) {
        GetAllProductsResponse response = new GetAllProductsResponse();
       // studentService.getAllStudents().forEach(response.getStudents()::add);
        Page<Product> optionals = productsService.findAll(minPrice, maxPrice, titlePart, category, page);
        for (Product p : optionals.toList()){
            response.getProducts().add(productSoapConverter.entityToDto(p));
        }
        return response;
    }


}

