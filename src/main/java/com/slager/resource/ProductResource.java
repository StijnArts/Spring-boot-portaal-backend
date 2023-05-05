package com.slager.resource;

import com.slager.dto.*;
import com.slager.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductResource {

    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{companyId}/products")
    @ResponseBody
    public ResponseEntity<ProductsDTO> getProducts(@PathVariable("companyId") int companyID){
        return ResponseEntity.ok(productService.getProducts(companyID));
    }

    @GetMapping("/{companyId}/products/{productId}")
    @ResponseBody
    public ResponseEntity<ProductDetailDTO> getProduct(@PathVariable("companyId") int companyId,@PathVariable("productId") int productId){
        return ResponseEntity.ok(productService.getProduct(companyId,productId));
    }

    @PutMapping("/{companyId}/products")
    @ResponseBody
    public ResponseEntity<ProductDetailDTO> updateProduct(@PathVariable("companyId") int companyId, @RequestBody ProductDetailDTO productDetailDTO){
        return ResponseEntity.ok(productService.updateProduct(companyId, productDetailDTO));
    }
}
