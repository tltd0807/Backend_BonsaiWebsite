/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.service;

import bookweb.model.Selling;
import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface SellingService {

    public List<Selling> getAll();

    public Selling getSellingById(int id);

    public Selling saveSelling(Selling selling);

    public List<Selling> saveListSelling(List<Selling> listSelling);
    public String deleteSelling(int id);

    public Selling updateSelling(Selling selling);

}
