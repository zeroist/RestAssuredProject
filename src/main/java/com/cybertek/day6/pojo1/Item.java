package com.cybertek.day6.pojo1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Item {
private int region_id;
private String region_name;
private List<Link> links;
}
