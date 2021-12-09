package com.volkruss.iroiro.domain.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volkruss.iroiro.domain.dto.item.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
