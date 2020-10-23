package com.ye.functiondemo.service;

import com.ye.functiondemo.model.TbXwKyxsRy;

import java.util.List;
import java.util.Map;

public interface SusService {
 List<TbXwKyxsRy> getSelTbXwKyxsRyList();

 List<TbXwKyxsRy> getSelMapTbXwList(Map<String, Object> map1);

 int qrySusCount(Map<String, Object> map1);
}
