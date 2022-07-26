package com.cybertek.day6.pojo1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Regions {

    private List<Item> items;
    private int limit;
    private int offset;
    private int count;
    private boolean hasMore;
    private List<Link> links;

}
