package com.coconet.mit.admin.service;

import com.coconet.mit.commons.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by root on 16/10/17.
 */
public interface ProductManager {
    public Product save(Product product);
    public List<Product> findAll();
    public void deleteById(int id);
    Product findById(int id);
    Product updateById(int id, boolean active);

    void updateWithImages(Product product, MultipartFile[] files);

    void saveUploadedImages(Product product, MultipartFile[] files);
  /*  public List<Event> findByEndDateAfter(Date endDate);
    public Event findById(Integer eventId);*/

}
