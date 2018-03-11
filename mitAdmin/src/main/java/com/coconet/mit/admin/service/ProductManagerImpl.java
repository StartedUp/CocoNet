package com.coconet.mit.admin.service;

import com.coconet.mit.appService.service.ProductService;
import com.coconet.mit.commons.model.Product;
import com.coconet.mit.commons.model.ProductImage;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

/**
 * Created by root on 16/10/17.
 */
@Service
@Transactional
public class ProductManagerImpl implements ProductManager {
    @Autowired
    private ProductService productService;

    @Value("${product.images.root.path}")
    private String productImagesRootPath;

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Product> findAll() {
        return productService.products();
    }
    @Override
    public Product save(Product product){
        return productService.save(product);
    }

    public Product findById(int id){
        return productService.findById(id);
    }

    @Override
    public void saveUploadedImages(Product product, MultipartFile[] files) {
        List<ProductImage> productImages = product.getProductImages();
        int index=0;
        for (ProductImage productImage: productImages){
            if (productImage.getId()==0 && index<files.length) {
                String imagePath=productImage.getUrl();
                File imageFile=new File("mitAdmin/src/main/resources/static/"+imagePath);
                File imageFileCustomerPortal=new File("mitCustomerPortal/src/main/resources/static/"+imagePath);
                if (!imageFile.exists()) {
                    imageFile.getParentFile().mkdirs();
                }
                if(!imageFileCustomerPortal.exists()) {
                    imageFileCustomerPortal.getParentFile().mkdirs();
                }
                try {
                    byte[] bytes=files[index++].getBytes();
                    Files.write(imageFile.toPath(),bytes);
                    Files.write(imageFileCustomerPortal.toPath(),bytes);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateWithImages(Product productWithImages, MultipartFile[] files) {
        List<ProductImage> productNewImages = productWithImages.getProductImages();
        Product product = productService.findById(productWithImages.getId());
        productWithImages=productService.findById(productWithImages.getId());
        /*if (productWithImages.getProductImages()!=null) {
            productNewImages.addAll(productWithImages.getProductImages());
        }*/
        productNewImages.forEach(productImage -> productImage.setProduct(product));
        setImageNames(productNewImages, files);
        productNewImages.forEach(productImage -> {
            if (productImage.getId()==0) {
                productImage
                    .setUrl(productImagesRootPath+(product.getProductName().replaceAll(" ","_").toLowerCase())
                            +"/"+productImage.getName());
            }
        });
        product.setProductImages(productNewImages);
        saveUploadedImages(product, files);
        productService.save(product);
    }

    private void setImageNames(List<ProductImage> productImages, MultipartFile[] files) {
        int index=0;
        for (ProductImage productImage: productImages) {
            if (productImage.getId()==0 && index<files.length) {
                String extension = FilenameUtils.getExtension(files[index++].getOriginalFilename());
                String productName = productImages.get(index).getProduct().getProductName().toLowerCase().replaceAll(" ","_");
                long id = new Date().getTime();
                productImage.setName(productName+"_"+id+"."+extension);
            }
        }
    }
}
