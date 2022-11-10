package com.example.bonsai_backend.service.impl;

import com.example.bonsai_backend.model.*;
import com.example.bonsai_backend.model.dto.LineItemDTO;
import com.example.bonsai_backend.model.dto.base.BaseDTO;
import com.example.bonsai_backend.model.mapper.CartMapper;
import com.example.bonsai_backend.model.mapper.LineItemMapper;
import com.example.bonsai_backend.model.mapper.OrderMapper;
import com.example.bonsai_backend.model.mapper.ProductMapper;
import com.example.bonsai_backend.repository.CartRepository;
import com.example.bonsai_backend.repository.LineItemRepository;
import com.example.bonsai_backend.repository.ProductRepository;
import com.example.bonsai_backend.repository.UserRepository;
import com.example.bonsai_backend.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.util.List;

@Service
public class LineItemServiceImpl implements LineItemService {

    @Autowired
    private LineItemRepository repo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LineItemMapper mapper;

    @Autowired
    private ProductMapper productMapper;


    @Autowired
    private OrderMapper orderMapper;





    @Override
    public LineItem findById(BaseDTO baseDTO) {
        try {
            if (repo.findById(((LineItemDTO) baseDTO).getItemId()).get() != null) {
                return repo.findById(((LineItemDTO) baseDTO).getItemId()).get();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<LineItem> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LineItem create(BaseDTO baseDTO) {
        try {
            Product product = productRepo.findById(((LineItemDTO) baseDTO).getProducts().getProductId()).get();
            if (repo.findLineItemByProducts(product) != null) {
                LineItem lineItem = repo.findById(((LineItemDTO) baseDTO).getItemId()).get();
                lineItem.setQuantity(lineItem.getQuantity() + ((LineItemDTO) baseDTO).getQuantity());
                BigDecimal price = BigDecimal.valueOf(lineItem.getQuantity().doubleValue()*lineItem.getProducts().getProductPrice().doubleValue());
                lineItem.setQuantityPrice(price);
                return repo.save(lineItem);
            } else {
                LineItem lineItem = mapper.mapToEntity((LineItemDTO) baseDTO, LineItem.class);
                User user = userRepo.findUserByAccountName(((LineItemDTO) baseDTO).getCart().getUser().getAccountName());
//                Cart cart = cartRepo.findCartByUser(((LineItemDTO) baseDTO).getCart().getCartId()).get();
                Cart cart = cartRepo.findCartByUser(user);
                lineItem.setProducts(product);
                lineItem.setCart(cart);
                BigDecimal price = BigDecimal.valueOf(lineItem.getQuantity().doubleValue()*lineItem.getProducts().getProductPrice().doubleValue());
                lineItem.setQuantityPrice(price);
                return repo.save(lineItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String delete(BaseDTO baseDTO) {
        try {
            Product product = productRepo.findById(((LineItemDTO) baseDTO).getProducts().getProductId()).get();
            if (product != null) {
                LineItem lineItem = repo.findLineItemByProducts(product);
                if (lineItem.getQuantity() > 1) {
                    lineItem.setQuantity(lineItem.getQuantity() - 1);
                    repo.save(lineItem);
                    return "Decrease";
                } else {
                    repo.delete(lineItem);
                    return "OK";
                }
            } else {
                return "Fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    @Override
    public LineItem update(BaseDTO baseDTO) {
        try {
            Product  product = productRepo.findById(((LineItemDTO) baseDTO).getProducts().getProductId()).get();
            if(product!=null){
                LineItem item  = repo.findLineItemByProducts(product);
                item.setQuantity(item.getQuantity()+1);
                BigDecimal price = BigDecimal.valueOf(item.getQuantity().doubleValue()*item.getProducts().getProductPrice().doubleValue());
                item.setQuantityPrice(price);
                return repo.save(item);
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<LineItem> findByCart(BaseDTO baseDTO) {
        try {
            User user = userRepo.findUserByAccountName(((LineItemDTO) baseDTO).getCart().getUser().getAccountName());
            Cart cart = cartRepo.findCartByUser(user);
            if (repo.findLineItemByCart(cart) != null) {
                return repo.findLineItemByCart(cart);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<LineItem> findByOrder(BaseDTO baseDTO) {
        try {
            Orders order = orderMapper.mapToEntity(((LineItemDTO) baseDTO).getOrders(), Orders.class);
            if (repo.findLineItemByOrders(order) != null) {
                return repo.findLineItemByOrders(order);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LineItem findByProduct(BaseDTO baseDTO) {
        try {
            Product product = productMapper.mapToEntity(((LineItemDTO) baseDTO).getProducts(), Product.class);
            if (repo.findLineItemByProducts(product) != null) {
                return repo.findLineItemByProducts(product);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BigDecimal getToalPriceInCart(BaseDTO baseDTO) {
        try{
            Cart cart = cartRepo.findById(((LineItemDTO) baseDTO).getCart().getCartId()).get();
            double total;
            List<LineItem> listData = repo.findLineItemByCart(cart);
            total = listData.stream().mapToDouble(lineItem -> lineItem.getQuantityPrice().doubleValue()).sum();
            return BigDecimal.valueOf(total);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
