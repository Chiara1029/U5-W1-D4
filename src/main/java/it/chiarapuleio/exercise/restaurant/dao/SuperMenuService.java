package it.chiarapuleio.exercise.restaurant.dao;

import it.chiarapuleio.exercise.restaurant.abstractClass.SuperMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperMenuService {
    @Autowired
    private SuperMenuDAO smDao;

    public void save(SuperMenu superMenu){
        smDao.save(superMenu);
        System.out.println("Item " + superMenu.getName() + " saved.");
    }

    public SuperMenu findById(Long superMenuId){
        Optional<SuperMenu> found = smDao.findById(superMenuId);
        return found.get();
    }

    public List<SuperMenu> findAll(){
        return smDao.findAll();
    }

    public void findByIdAndUpdate(Long superMenuId, SuperMenu updatedItem){
        SuperMenu found = this.findById(superMenuId);
        found.setKcal(updatedItem.getKcal());
        found.setName(updatedItem.getName());
        found.setPrice(updatedItem.getPrice());

        smDao.save(found);
        System.out.println("Item " + found.getName() + " has been updated.");
    }

    public void findByIdAndDelete(Long superMenuId){
        SuperMenu found = this.findById(superMenuId);
        smDao.delete(found);
        System.out.println("Item " + found.getName() + " has been removed.");
    }
}
